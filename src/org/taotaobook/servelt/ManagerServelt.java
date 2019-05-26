package org.taotaobook.servelt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taotao.service.dao.impl.ManagerServiceimpl;
import org.taotaobook.entiy.Manager;
import org.taotaobook.service.dao.ManagerService;

@WebServlet("/ManagerServelt")
public class ManagerServelt extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if ("add".equals(method)) {
			add(request, response);
		} else if ("login".equals(method)) {
			login(request, response);
		} else if ("select".equals(method)) {
			select(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			Manager m = (Manager) request.getSession().getAttribute("manager");
			String pw = m.getMpassword();
			String idcard = request.getParameter("pid");
			String mname = request.getParameter("pname");
			String mphonenumber = request.getParameter("pn");
			String msex = request.getParameter("psex");
			ManagerService managerService = new ManagerServiceimpl();
			Manager manager = new Manager(idcard, mphonenumber, msex, mname, pw);
			managerService.updateManager(manager);
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			request.getRequestDispatcher("/ManagerServelt?method=select").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void select(HttpServletRequest request, HttpServletResponse response) {
		try {
			Manager m = (Manager) request.getSession().getAttribute("manager");
			if (m == null) {
				request.getRequestDispatcher("Manager/ManagerLogin.jsp").forward(request, response);
			} else {
				ManagerService managerService = new ManagerServiceimpl();
				Manager manager = managerService.selectAllInfo(m.getIdcard());
				request.setAttribute("manager", manager);
				String c = request.getParameter("c");
				if ("1".equals(c)) {
					request.getRequestDispatcher("Manager/ManagerUpdateInfo.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("Manager/ManagerSelectInfo.jsp").forward(request, response);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {

			String idcard = request.getParameter("idcard");
			String mpassword = request.getParameter("mpassword");

			ManagerService managerService = new ManagerServiceimpl();
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("utf-8");

			if (managerService.selectLogin(idcard, mpassword)) {
				Manager manager = managerService.selectAllInfo(idcard);
				request.getSession().invalidate();
				request.getSession().setAttribute("manager", manager);
				response.sendRedirect(request.getContextPath() + "/ProductsServelt?method=select");
			} else {
				// request.setAttribute("result", "false");
				request.getRequestDispatcher("Manager/ManagerLogin.jsp").forward(request, response);
			}
		} catch (UnsupportedEncodingException e) {
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
			String idcard = request.getParameter("idcard");
			String mphonenumber = request.getParameter("mphonenumber");
			String msex = request.getParameter("msex");
			String mname = request.getParameter("mname");
			String mpassword = request.getParameter("mpassword");
			Manager manager = new Manager(idcard, mphonenumber, msex, mname, mpassword);

			ManagerService managerService = new ManagerServiceimpl();
			if (managerService.addManager(manager)) {
				response.sendRedirect("Manager/ManagerLogin.jsp");
			} else {
				request.setAttribute("login.message", "false");
				request.getRequestDispatcher("Manager/addManager.jsp").forward(request, response);
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
