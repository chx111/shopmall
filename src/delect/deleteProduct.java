package delect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taotao.service.dao.impl.ProducesServiceimpl;
import org.taotaobook.service.dao.ProducesService;

@WebServlet("/deleteProduct")
public class deleteProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProducesService producesService=new ProducesServiceimpl();
		String id=request.getParameter("id");
		ProducesService producesservice=new ProducesServiceimpl();
		
		request.setAttribute("result",producesservice.deleteProduces(id));
		request.getRequestDispatcher("selectAllProductsInfo").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
