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




@WebServlet("/selectUserInfo")
public class selectUserInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserService userService=new UserServiceimpl();
		Users user=userService.selectAllInfo(123489);
		request.setAttribute("user",user);
		request.getRequestDispatcher("UserJsp/UserSelectInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
