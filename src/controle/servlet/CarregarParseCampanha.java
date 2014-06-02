package controle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import parse.Parse;
import parse.ParseCandidato;

@WebServlet("/carregarParseCampanha")
public class CarregarParseCampanha extends HttpServlet {

	private static final long serialVersionUID = 5625867877274809499L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter saida = response.getWriter();

		Part part = request.getPart("arquivo_linha_inicial");
		if(part != null) {
			Scanner scanner = new Scanner(part.getInputStream());
			saida.println("linha inicial: " + scanner.nextLine());
			scanner.close();
		}

		try {
			boolean isMultpart = ServletFileUpload.isMultipartContent(request);			
			if(isMultpart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> fields = upload.parseRequest(request);

				FileItem arquivo = null;
				int linhaInicial = 1;


				for(FileItem fileItem : fields) {
					if(!fileItem.isFormField()) {
						arquivo = fileItem;
					} else {
						if(fileItem.getFieldName().equals("arquivo_tipo")) {
						} else if(fileItem.getFieldName().equals("arquivo_linha_inicial")) {
							linhaInicial = Integer.parseInt(fileItem.getString());
						} 
						
					}
				}

				String divisao = ";";
				Parse parse = new ParseCandidato();
				parse.executarParse(arquivo, divisao, linhaInicial);


				saida.println("Parse Realizado com Sucesso!");
			}

		} catch(Exception e) {
			saida.println("ERROR teste upload: " + e.getMessage());
		}
	
	}
}

