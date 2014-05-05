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

import parse.CandidatoIndicesParse;
import parse.CandidatoParse;

@WebServlet("/carregarParse")
public class CarregarParse extends HttpServlet {

	private static final long serialVersionUID = 5625867877274809499L;
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter saida = response.getWriter();
		
		
		try {
			boolean isMultpart = ServletFileUpload.isMultipartContent(request);			
			if(isMultpart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				List<FileItem> fields = upload.parseRequest(request);
				Iterator<FileItem> it = fields.iterator();
				
				while(it.hasNext()) {
					FileItem fileItem = it.next();
					if(!fileItem.isFormField()) {
						
						String ano = "2004";		
						int linhaInicial = 2;
						int linhaFinal = 10;
						
						CandidatoIndicesParse candidatoIndicesParse;
						candidatoIndicesParse = getCandidatoIndicesParse2004();
						
						CandidatoParse cadastrarCandidatos;
						cadastrarCandidatos = new CandidatoParse(fileItem, candidatoIndicesParse, linhaInicial, linhaFinal);
						cadastrarCandidatos.cadastrar();
					}
				}
			}
			
			
		
		} catch(Exception e) {
			saida.println("ERROR teste upload: " + e.getMessage());
		}
		
		
	}
	
	public static CandidatoIndicesParse getCandidatoIndicesParse2004() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse();
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceCargoPleiteado(1);
		candidatoIndicesParse.setIndicePartido(8);
		candidatoIndicesParse.setIndiceNumero(3);
		candidatoIndicesParse.setAno(2004);
		
		return candidatoIndicesParse;
	}
	
}
