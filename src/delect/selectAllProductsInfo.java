package delect;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taotao.service.dao.impl.ProducesServiceimpl;
import org.taotaobook.entiy.Products;
import org.taotaobook.service.dao.ProducesService;

@WebServlet("/selectAllProductsInfo")
public class selectAllProductsInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProducesService producesService=new ProducesServiceimpl();
	
		List<Products> list=producesService.SelectAllProducesInfo();//获取数据列表
		request.setAttribute("list",list);//将数据存放到request对象中，用于转发给前台页面使用
		request.getRequestDispatcher("Manager/ManagerAddProducts.jsp").forward(request, response);//请求转发
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
