package org.taotaobook.servelt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.taotaobook.entiy.Order;
import org.taotaobook.entiy.Orderitem;
import org.taotaobook.entiy.Products;
import org.taotaobook.entiy.Users;
import org.taotaobook.entiy.item;
import org.taotaobook.service.dao.ProducesService;

@WebServlet("/orderServlet")
public class orderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("method");
		Users u = (Users) request.getSession().getAttribute("user");
		if (u == null) {
			request.getRequestDispatcher("UserJsp/UserLogin.jsp").forward(request, response);
		} else {
			if ("add".equals(method)) {
				add(request, response);
			} else if ("select".equals(method)) {
				select(request, response);
			}
		}
	}

	private void select(HttpServletRequest request, HttpServletResponse response) {
		Users user = (Users) request.getSession().getAttribute("user");
		int user_id = user.getId();
		OrderitemDao orderitemDao = new OrderitemDaoImpl();
		List<Link> links = orderitemDao.OrderitemSelectInfo(user_id);
		
		List<Linkitem> lits =new ArrayList<>();
		String lin = null;
		ProducesService producesService = new ProducesServiceimpl();
		List<item> its=new ArrayList<>();
		lin = links.get(0).getId();
		for (int i = 0; i < links.size(); i++) {
			
			if (lin.equals(links.get(i).getId())) {
				double price=producesService.SelectAllProducesInfo(links.get(i).getProduct_id()).getPrice();
				String name = producesService.SelectAllProducesInfo(links.get(i).getProduct_id()).getName();
				int num=links.get(i).getBuynum();
				//System.out.println(name+ price+num);
				item it=new item(name, price, num);
				its.add(it);
				if (i + 1 < links.size()) {
					continue;
				}
			}
			String id=lin;
			int state=links.get(i-1).getPaystate();
			double money=links.get(i-1).getMoney();
			Linkitem lit=new Linkitem(id,state, user_id,its,money);
			lin = links.get(i).getId();
			lits.add(lit);
			if (i != 0 && i + 1 < links.size()) {
				i--;
				its=new ArrayList<>();
			}
				
		}
		
//		for (Linkitem linkitem : lits) {
//			System.out.println(linkitem.getId());
//			for (item item : linkitem.getIt()) {
//				System.out.println(item.getName()+item.getNum()+item.getPrice());
//			}
//		}
		//request.setAttribute("", lits);
		request.setAttribute("lits",lits);
		try {
			request.getRequestDispatcher("Order/SelectOrder.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String address = request.getParameter("receiverinfo");
		Users user = (Users) request.getSession().getAttribute("user");
		int user_id = user.getId();
		String id = (int) (Math.random() * (1100 - 100) + 100) + "";
		String order_id = id;
		double money = 0;
		String product_id = null;
		Orderitem orderitem = null;
		OrderitemDao orderitemDao = new OrderitemDaoImpl();
		Map<Products, Integer> map = (Map<Products, Integer>) request.getSession().getAttribute("cart");
		Iterator<Map.Entry<Products, Integer>> iterator = map.entrySet().iterator();
		Order order = new Order(id, money, user_id, address);
		OrderDao orderDao = new OrderDaoImpl();
		orderDao.orderAdd(order);
		while (iterator.hasNext()) {
			Entry<Products, Integer> entry = iterator.next();
			product_id = entry.getKey().getId();
			int buynum = entry.getValue();
			money += entry.getKey().getPrice() * buynum;
			orderitem = new Orderitem(order_id, product_id, buynum);
			orderitemDao.OrderitemAdd(orderitem);
		}

		if (orderDao.orderUpdete(id, money)) {
			select(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
