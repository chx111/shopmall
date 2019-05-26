package org.taotaobook.servelt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.taotao.service.dao.impl.ProducesServiceimpl;
import org.taotaobook.entiy.Manager;
import org.taotaobook.entiy.Products;
import org.taotaobook.service.dao.ProducesService;

@WebServlet("/ProductsServelt")
public class ProductsServelt extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		Manager m = (Manager) request.getSession().getAttribute("manager");
		if (m == null) {
			request.getRequestDispatcher("Manager/ManagerLogin.jsp").forward(request, response);
		} else {
			if ("add".equals(method)) {
				add(request, response);
			} else if ("delect".equals(method)) {
				delect(request, response);
			} else if ("select".equals(method)) {
				select(request, response);
			} else if ("update".equals(method)) {
				update(request, response);
			}
		}
	}

	private void select(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			ProducesService producesService = new ProducesServiceimpl();
			List<Products> list = producesService.SelectAllProducesInfo();// 获取数据列表
			request.setAttribute("list", list);// 将数据存放到request对象中，用于转发给前台页面使用
			request.getRequestDispatcher("Manager/ManagerAddProducts.jsp").forward(request, response);// 请求转发
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			String imgurl = null;
			String id = null;
			String name = null;
			double price = 0;
			String writename = null;
			String description = null;
			String type = null;

			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {// 判断前台的form是否有 mutipart属性
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				java.util.List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				String fileName = null;
				while (iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();
					if (item.isFormField()) {
						if (itemName.equals("id")) {// 根据name属性 判断item是sno sname 还是spicture?
							id = item.getString("UTF-8");
						} else if (itemName.equals("name")) {
							name = item.getString("UTF-8");
						} else if (itemName.equals("price")) {
							price = Double.parseDouble(item.getString("UTF-8"));
						} else if (itemName.equals("writename")) {
							writename = item.getString("UTF-8");
						} else if (itemName.equals("description")) {
							description = item.getString("UTF-8");
						} else if (itemName.equals("type")) {
							type = item.getString("UTF-8");
						}
					} else {
						fileName = item.getName();// a.txt a.docx a.png
						
						String ext = fileName.substring(fileName.indexOf(".") + 1);
						if (!(ext.equals("png") || ext.equals("gif") || ext.equals("jpg"))) {
							System.out.println("图片类型有误！格式只能是 png gif  jpg");
							return;// 终止
						}
						fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
						String path = "D:\\Users\\m1708\\eclipse-workspace\\TaoTaoBook"+"\\WebContent\\Image";
						File file = new File(path, fileName);
						item.write(file);// 上传
						//System.out.println(fileName + "上传成功！");
					}
					imgurl = "Image/" + fileName;
				}
				//System.out.println(imgurl);
				Products products = new Products(id, name, writename, price, imgurl, description, type);
				ProducesService producesService = new ProducesServiceimpl();
				if (producesService.addProduces(products)) {
					//System.out.println("成功");
					select(request, response);
				} else {
					//System.out.println("失败");
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void delect(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			ProducesService producesService = new ProducesServiceimpl();
			String id = request.getParameter("id");
			ProducesService producesservice = new ProducesServiceimpl();

			request.setAttribute("result", producesservice.deleteProduces(id));
			request.getRequestDispatcher("ProductsServelt?method=select").forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String writename = request.getParameter("pwritename");
		double price = Double.parseDouble(request.getParameter("pprice"));
		String imgurl = request.getParameter("pimgurl");
		String description = request.getParameter("pdescription");
		String type = request.getParameter("ptype");
		Products product = new Products(id, name, writename, price, imgurl, description, type);

		ProducesService producesService = new ProducesServiceimpl();
		Boolean result = producesService.updateProduces(product);

		//request.setAttribute("result", result);
		select(request, response);
		//	request.getRequestDispatcher("selectAllProductsInfo").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
