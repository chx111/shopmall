package org.taotaobook.servelt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taotao.service.dao.impl.ProducesServiceimpl;
import org.taotaobook.dao.OrderDao;
import org.taotaobook.dao.OrderitemDao;
import org.taotaobook.dao.impl.OrderDaoImpl;
import org.taotaobook.dao.impl.OrderitemDaoImpl;
import org.taotaobook.entiy.Link;
import org.taotaobook.entiy.Linkitem;
import org.taotaobook.entiy.Manager;
import org.taotaobook.entiy.Order;
import org.taotaobook.entiy.Users;
import org.taotaobook.entiy.item;
import org.taotaobook.service.dao.ProducesService;

@WebServlet("/ManagerOrderServlet")
public class ManagerOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		Manager m = (Manager) request.getSession().getAttribute("manager");
		if (m == null) {
			request.getRequestDispatcher("Manager/ManagerLogin.jsp").forward(request, response);
		} else {
			if ("select".equals(method)) {
				select(request, response);
			} else if ("deal".equals(method)) {
				deal(request, response);
			}
		}
	}

	private void deal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Order order = new Order(id,1);
		OrderDao orderDao = new OrderDaoImpl();
		orderDao.orderUpdete(order);
		request.getRequestDispatcher("ManagerOrderServlet?method=select").forward(request, response);
		return;
	}

	private void select(HttpServletRequest request, HttpServletResponse response) {
		OrderDao orderDao=new OrderDaoImpl();
		List<Link> links = orderDao.orderSelectAllInfo();
		List<item> its=new ArrayList<>();
		List<Linkitem> lits =new ArrayList<>();
		
		String lin = null;
		ProducesService producesService = new ProducesServiceimpl();
		
		lin = links.get(0).getId();
		for (int i = 0; i < links.size(); i++) {
			if (lin.equals(links.get(i).getId())) {
				double price=producesService.SelectAllProducesInfo(links.get(i).getProduct_id()).getPrice();
				String name = producesService.SelectAllProducesInfo(links.get(i).getProduct_id()).getName();
				int num=links.get(i).getBuynum();
				item it=new item(name, price, num);
				its.add(it);
				if (i + 1 < links.size()) {
					continue;
				}
			}
			String id=lin;
			int state=links.get(i-1).getPaystate();
			double money=links.get(i-1).getMoney();
			int user_id=links.get(i-1).getUser_id();
			Linkitem lit=new Linkitem(id,state, user_id,its,money);
			lin = links.get(i).getId();
			lits.add(lit);
			if (i != 0 && i + 1 < links.size()) {
				i--;
				its=new ArrayList<>();
			}
		}

		request.setAttribute("lits",lits);
		
		try {
			request.getRequestDispatcher("Manager/ManagerOrderInfo.jsp").forward(request, response);
			return;
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
