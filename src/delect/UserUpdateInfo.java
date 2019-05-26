package delect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taotao.service.dao.impl.UserServiceimpl;
import org.taotaobook.entiy.Users;
import org.taotaobook.service.dao.UserService;

@WebServlet("/UserUpdateInfo")
public class UserUpdateInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("pid"));
		String name=request.getParameter("pname");
		String phonenumber=request.getParameter("pn");
		String sex=request.getParameter("psex");
		UserService usarservice  = new UserServiceimpl();
		Users user=new Users(id, name, phonenumber, sex, "lz");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		boolean result=usarservice.updateUser(user);
		
		if(result) {
			response.getWriter().println("修改成功！");
			//response.sendRedirect("");//修改完毕后 ，再次重新查询全部的学生 并显示
		}else {
			response.getWriter().println("修改失败！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
