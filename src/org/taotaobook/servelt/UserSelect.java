package org.taotaobook.servelt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.taotao.service.dao.impl.UserServiceimpl;
import org.taotaobook.entiy.Users;
import org.taotaobook.service.dao.UserService;

@WebServlet("/UserSelect")
public class UserSelect extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if ("add".equals(method)) {
			add(request, response);
		} else if ("select".equals(method)) {
			select(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		} else if ("login".equals(method)) {
			login(request, response);
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) {

		try {
			int id = Integer.parseInt(request.getParameter("user_id"));
			String passward = request.getParameter("user_pwd");

			UserService userService = new UserServiceimpl();
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			if (userService.selectLogin(id, passward)) {
				Users user = userService.selectAllInfo(id);
				request.getSession().invalidate();
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/ShowProductsInfo");
			} else {
				request.getRequestDispatcher("UserJsp/UserLogin.jsp").forward(request, response);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			Users u = (Users) request.getSession().getAttribute("user");
			String pw=u.getPassword();
			int id = Integer.parseInt(request.getParameter("pid"));
			String name = request.getParameter("pname");
			String phonenumber = request.getParameter("pn");
			String sex = request.getParameter("psex");
			UserService userservice = new UserServiceimpl();
			Users user=new Users(id, phonenumber, sex, name,pw);
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			boolean result = userservice.updateUser(user);
			request.getRequestDispatcher("/UserSelect?method=select").forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void select(HttpServletRequest request, HttpServletResponse response) {
		try {
			Users u = (Users) request.getSession().getAttribute("user");
			if (u == null) {
				request.getRequestDispatcher("UserJsp/UserLogin.jsp").forward(request, response);
			} else {
				UserService userService = new UserServiceimpl();
				Users user = userService.selectAllInfo(u.getId());
				request.setAttribute("user", user);
				//System.out.println(user.getUsername());
				String c = request.getParameter("c");
				if ("1".equals(c)) {
					request.getRequestDispatcher("UserJsp/UserUpdateInfo.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("UserJsp/UserSelectInfo.jsp").forward(request, response);
				}
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("user_id"));
			String phonenumber = request.getParameter("user_phone");
			String sex = request.getParameter("user_sex");
			String username = request.getParameter("real_name");
			String password = request.getParameter("user_pwd");
			Users user = new Users(id, phonenumber, sex, username, password);

			UserService userService = new UserServiceimpl();
			if (userService.addUser(user)) {
				response.sendRedirect("UserJsp/UserLogin.jsp");
			} else {
				request.setAttribute("login.message", "false");
				request.getRequestDispatcher("UserJsp/UserAdd.jsp").forward(request, response);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
