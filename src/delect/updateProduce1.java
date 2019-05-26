package delect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taotao.service.dao.impl.ProducesServiceimpl;
import org.taotaobook.entiy.Products;
import org.taotaobook.service.dao.ProducesService;

@WebServlet("/updateProduce1")
public class updateProduce1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("pid");
		String name=request.getParameter("pname");
		String writename=request.getParameter("pwritename");
		double price=Double.parseDouble(request.getParameter("pprice"));
		String imgurl=request.getParameter("pimgurl");
		String description=request.getParameter("pdescription");
		String type=request.getParameter("ptype");
		Products product=new Products(id, name, writename, price, imgurl, description, type);
		
		ProducesService producesService=new ProducesServiceimpl();
		Boolean result=producesService.updateProduces(product);
		
		request.setAttribute("result",result);
		//request.getRequestDispatcher("success.jsp").forward(request, response);
		request.getRequestDispatcher("selectAllProductsInfo").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
