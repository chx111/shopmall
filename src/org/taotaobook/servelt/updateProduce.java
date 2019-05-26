package org.taotaobook.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taotao.service.dao.impl.ProducesServiceimpl;
import org.taotaobook.entiy.Products;
import org.taotaobook.service.dao.ProducesService;


@WebServlet("/updateProduce")
public class updateProduce extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		ProducesService producesservice=new ProducesServiceimpl();
		Products product=producesservice.SelectAllProducesInfo(id);
		request.setAttribute("product",product);//将数据存放到request对象中，用于转发给前台页面使用
		request.getRequestDispatcher("Manager/SelectProductInfo.jsp").forward(request, response);//请求转发
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
