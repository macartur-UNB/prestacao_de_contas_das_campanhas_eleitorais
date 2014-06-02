package parse.view;

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
import parse.ParsePartido;
import parse.cadastro.receita_despesa.PartidoCadastroParseDespesaReceita;

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
				String tipoArquivo = "";
				String ano = "";
				int linhaInicial = 1;


				for(FileItem fileItem : fields) {
					if(!fileItem.isFormField()) {
						arquivo = fileItem;
					} else {
						if(fileItem.getFieldName().equals("arquivo_tipo")) {
							if(fileItem.getString().equals("despesa")) {
								tipoArquivo = PartidoCadastroParseDespesaReceita.DESPESA;
							} else {
								tipoArquivo = PartidoCadastroParseDespesaReceita.RECEITA;
							}
						} else if(fileItem.getFieldName().equals("arquivo_linha_inicial")) {
							linhaInicial = Integer.parseInt(fileItem.getString());
						} else if(fileItem.getFieldName().equals("arquivo_ano")) {
							switch (fileItem.getString()) {
							case "2002":
								ano = PartidoCadastroParseDespesaReceita.ANO_2002;
								break;

							case "2004":
								ano = PartidoCadastroParseDespesaReceita.ANO_2004;
								break;

							case "2006":
								ano = PartidoCadastroParseDespesaReceita.ANO_2006;
								break;

							case "2008":
								ano = PartidoCadastroParseDespesaReceita.ANO_2008;
								break;

							default:
								break;
							}
						}
					}
				}

				String divisao = ";";
				Parse parse = new ParseCandidato(tipoArquivo, ano);
				parse.executarParse(arquivo, divisao, linhaInicial);


				saida.println("Parse Realizado com Sucesso!");
			}

		} catch(Exception e) {
			saida.println("ERROR teste upload: " + e.getMessage());
		}
	
	}
}

