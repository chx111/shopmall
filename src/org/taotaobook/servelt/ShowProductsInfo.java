package org.taotaobook.servelt;

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

@WebServlet("/ShowProductsInfo")
public class ShowProductsInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("internet".equals(method)) {
			internet(request,response);
		}else if("novel".equals(method)) {
			novel(request,response);
		}else if("famous".equals(method)) {
			famous(request,response);
		}else {
			selectAll(request,response);
		}
	}
	private void famous(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProducesService producesService=new ProducesServiceimpl();
		
		List<Products> list=producesService.selectAll("经典名著");//获取数据列表
		request.setAttribute("list",list);//将数据存放到request对象中，用于转发给前台页面使用
		request.getRequestDispatcher("Products/famous.jsp").forward(request, response);
	}
	private void novel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProducesService producesService=new ProducesServiceimpl();
		
		List<Products> list=producesService.selectAll("小说");//获取数据列表
		request.setAttribute("list",list);//将数据存放到request对象中，用于转发给前台页面使用
		request.getRequestDispatcher("Products/novel.jsp").forward(request, response);
	}
	private void internet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProducesService producesService=new ProducesServiceimpl();
		
		List<Products> list=producesService.selectAll("计算机");//获取数据列表
		request.setAttribute("list",list);//将数据存放到request对象中，用于转发给前台页面使用
		request.getRequestDispatcher("Products/internet.jsp").forward(request, response);
	}
	public static void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProducesService producesService=new ProducesServiceimpl();

		List<Products> list=producesService.SelectAllProducesInfo();//获取数据列表
		request.setAttribute("list",list);//将数据存放到request对象中，用于转发给前台页面使用
		request.getRequestDispatcher("Products/product.jsp").forward(request, response);//请求转发
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
