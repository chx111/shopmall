package delect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taotao.service.dao.impl.UserServiceimpl;
import org.taotaobook.service.dao.UserService;



@WebServlet("/UserLoginServelt")
public class UserLoginServelt extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     request.setCharacterEncoding("utf-8");
	     int id=Integer.parseInt(request.getParameter("user_id"));
	     String passward=request.getParameter("user_pwd");
	     
	     UserService userService=new UserServiceimpl();
	     response.setContentType("text/html; charset=UTF-8");
		 response.setCharacterEncoding("utf-8");
	     if(userService.selectLogin(id, passward)) {
	    	 System.out.println("�ɹ�");
	     }else {
	    	// response.sendRedirect("UserJsp/UserLogin.jsp");
	    	 System.out.println("ʧ��");
	     }
	     
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
