package org.taotaobook.servelt;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.taotao.service.dao.impl.ProducesServiceimpl;
import org.taotaobook.entiy.Products;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("add".equals(method)) {
			add(request, response);
		} else if ("remove".equals(method)) {
			remove(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int count = Integer.parseInt(request.getParameter("count"));

		Products p = new ProducesServiceimpl().SelectAllProducesInfo(id);
		Map<Products, Integer> cart = (Map<Products, Integer>) request
				.getSession().getAttribute("cart");	
		if (count == 0) {
			cart.remove(p); // 将商品从购物车中移除
		} else {
			cart.put(p,count);
		}
		request.getSession().setAttribute("cart", cart);

		response.sendRedirect(request.getContextPath() + "/Order/ShowCar.jsp");
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		Products product = new ProducesServiceimpl().SelectAllProducesInfo(id);

		// 得到购物车
		Map<Products, Integer> cart = (Map<Products, Integer>) request.getSession().getAttribute("cart");
		cart.remove(product);
		// 如果购物车无东西，则删除购物车
		if (cart.size() == 0) {
			request.getSession().removeAttribute("cart");
		}
		response.sendRedirect(request.getContextPath() + "/Order/ShowCar.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		try {
			Products product = new ProducesServiceimpl().SelectAllProducesInfo(id);
			HttpSession session = request.getSession();

			Map<Products, Integer> cart = (Map<Products, Integer>) session.getAttribute("cart");
			// 如果cart不存在，说明是第一次购物
			if (cart == null) {
				cart = new HashMap<Products, Integer>();
			}
			// 判断购物车中是否有要添加商品
			Integer count = cart.put(product, 1);
			if (count != null) {
				cart.put(product, count + 1);
			}
			// 保存到session中
			session.setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath() + "/ShowProductsInfo");
		} catch (Exception e) {
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
