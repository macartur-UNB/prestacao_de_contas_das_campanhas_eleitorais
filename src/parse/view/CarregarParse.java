package parse.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import parse.CandidatoIndicesParse;
import parse.CandidatoParse;

@WebServlet("/carregarParse")
public class CarregarParse extends HttpServlet {

	private static final long serialVersionUID = 5625867877274809499L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter saida = response.getWriter();
		
		String jspPath = getServletConfig().getServletContext().getRealPath("/");
		String arquivo = request.getParameter("arquivo");
		String caminhoArquivo = jspPath;
		if(caminhoArquivo.charAt(caminhoArquivo.length()-1) != java.io.File.separatorChar) {
			caminhoArquivo += java.io.File.separator;
		}
		caminhoArquivo += arquivo;
		
		String tipoArquivo;
		
		if(request.getParameter("arquivo_tipo").equals("despesa")) {
			tipoArquivo = "despesa";
		} else {
			tipoArquivo = "receita";
		}
		

		saida.println("jspPath: " + jspPath);
		saida.println("Arquivo: " + arquivo);
		saida.println("caminhoArquivo: " + caminhoArquivo);
		saida.println("Tipo do Arquivo: " + tipoArquivo);
		
		
		String linhaInicial = request.getParameter("arquivo_linha_inicial");
		String linhaFinal = request.getParameter("arquivo_linha_final");
		
		String indiceNome = request.getParameter("indice_candidato_nome");
		String indicePartido = request.getParameter("indice_candidato_partido");
		String indiceCargoPleiteado = request.getParameter("indice_candidato_cargo");
		String indiceNumero = request.getParameter("indice_candidato_numero");
		String ano = request.getParameter("indice_dado_ano");
		
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse();
		candidatoIndicesParse.setIndiceNome(Integer.parseInt(indiceNome));
		candidatoIndicesParse.setIndicePartido(Integer.parseInt(indicePartido));
		candidatoIndicesParse.setIndiceCargoPleiteado(Integer.parseInt(indiceCargoPleiteado));
		candidatoIndicesParse.setIndiceNumero(Integer.parseInt(indiceNumero));
		candidatoIndicesParse.setAno(Integer.parseInt(ano));
		
		try {
			CandidatoParse candidatoParse = new CandidatoParse(caminhoArquivo, candidatoIndicesParse, 
					Integer.parseInt(linhaInicial), Integer.parseInt(linhaFinal));
			
			//candidatoParse.cadastrar();
			
			saida.println("Arquivo Carregado!");
			
		} catch (Exception e) {
			saida.println("ERROR CarregarParse: " + e.getMessage());
		}
		
		
		
		
		try {
			//Testes UPLOAD
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			FileItemIterator items = upload.getItemIterator(request);
			
			while(items.hasNext()) {
				FileItemStream item = items.next();
				System.out.println("item: " + item.getName());
//				if(!item.isFormField()) {
//					InputStream inputStream = item.openStream();
//				}
			}
		
		} catch(Exception e) {
			saida.println("ERROR teste upload: " + e.getMessage());
		}
		
		
		
		
	}
	
}
