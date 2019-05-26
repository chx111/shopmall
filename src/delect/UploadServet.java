package delect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.taotao.service.dao.impl.ProducesServiceimpl;
import org.taotaobook.entiy.Products;
import org.taotaobook.service.dao.ProducesService;

@WebServlet("/UploadServet")
public class UploadServet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {// 判断前台的form是否有 mutipart属性
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);

				java.util.List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					String fileName = item.getName();// a.txt a.docx a.png
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
					String path = "D:\\Users\\m1708\\eclipse-workspace\\TaoTaoBook\\WebContent\\upload";
					File file = new File(path, fileName);
					item.write(file);// 上传
					//System.out.println(fileName + "上传成功！");
					try (FileReader reader = new FileReader(path + "//" + fileName);
							BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
					) {
						String id = br.readLine();
						String name = br.readLine();
						String writename = br.readLine();
						double price = Double.parseDouble(br.readLine());
						String imgurl = br.readLine();
						String description = br.readLine();
						String type = br.readLine();
						Products products = new Products(id, name, writename, price, imgurl, description, type);
						ProducesService producesService = new ProducesServiceimpl();
						if (producesService.addProduces(products)) {
							System.out.println("成功");
						} else {
							System.out.println("失败");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					return;
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
