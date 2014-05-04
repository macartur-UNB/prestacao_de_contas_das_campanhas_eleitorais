package parse.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/carregarParse")
public class CarregarParse extends HttpServlet {

	private static final long serialVersionUID = 5625867877274809499L;
	
	private String filePath;
	
	@Override
	public void init() throws ServletException {
		super.init();
		filePath = getServletContext().getInitParameter("file-upload"); 
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter saida = response.getWriter();
		
		
		try {
			boolean isMultpart = ServletFileUpload.isMultipartContent(request);
			saida.println("isMultpart: " + isMultpart);
			
			if(isMultpart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				List<FileItem> fields = upload.parseRequest(request);
				Iterator<FileItem> it = fields.iterator();
				
				while(it.hasNext()) {
					FileItem fileItem = it.next();
					saida.println("FileItem: " + fileItem.getName());
				}
			}
		
		} catch(Exception e) {
			saida.println("ERROR teste upload: " + e.getMessage());
		}
		
		
	}
	
}
