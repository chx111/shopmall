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

@WebServlet("/UserAddServelt")
public class UserAddServelt extends HttpServlet {
	/*
	 * user_id
	 * user_phone
	 * role_id
	 * real_name
	 * user_pwd
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("user_id"));
		String phonenumber=request.getParameter("user_phone");
		String sex=request.getParameter("role_id");
		String username=request.getParameter("real_name");
		String password=request.getParameter("user_pwd");
		Users user=new Users(id, phonenumber, sex, username, password);
		
		UserService userService=new UserServiceimpl();
		if(userService.addUser(user)) {
			response.sendRedirect("UserJsp/UserLogin.jsp");
			//System.out.println("�ɹ���");
		}else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
