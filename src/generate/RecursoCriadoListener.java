/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
package generate;

import generate.DadosDoProjeto;

/**
 *
 * @author Administrator
 */
public class RecursoCriadoListener {

    public static String PACKAGE = "event.listener";
    public static String CONTEUDO = ""
            + "package " + DadosDoProjeto.PACKAGE_D0_PROJETO + "." + PACKAGE + ";\n"
            + "\n"
            + "import java.net.URI;\n"
            + "\n"
            + "import org.springframework.context.ApplicationListener;\n"
            + "import org.springframework.stereotype.Component;\n"
            + "import org.springframework.web.servlet.support.ServletUriComponentsBuilder;\n"
            + "\n"
            + "import com.algamoney.api.event.RecursoCriadoEvent;\n"
            + "\n"
            + "import jakarta.servlet.http.HttpServletResponse;\n"
            + "\n"
            + "@Component\n"
            + "public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{\n"
            + "\n"
            + "	@Override\n"
            + "	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {\n"
            + "		HttpServletResponse response = recursoCriadoEvent.getResponse();\n"
            + "		Long codigo = recursoCriadoEvent.getCodigo();\n"
            + "\n"
            + "		adicionaHeaderLocation(response,codigo);\n"
            + "		\n"
            + "		\n"
            + "	}\n"
            + "\n"
            + "	private void adicionaHeaderLocation(HttpServletResponse response, Long codigo) {\n"
            + "		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(\"/{codigo)\")\n"
            + "				.buildAndExpand(codigo).toUri();\n"
            + "		response.setHeader(\"Location\", uri.toASCIIString());\n"
            + "		 \n"
            + "	}\n"
            + "\n"
            + "}";

}
