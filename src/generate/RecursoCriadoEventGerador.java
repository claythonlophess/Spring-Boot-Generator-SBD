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
public class RecursoCriadoEventGerador {

    public static final String PACKAGE = "event";
    public static final String CONTEUDO = ""
            + "package " + DadosDoProjeto.PACKAGE_D0_PROJETO + "." + PACKAGE + ";\n"
            + "\n"
            + "import org.springframework.context.ApplicationEvent;\n"
            + "\n"
            + "import jakarta.servlet.http.HttpServletResponse;\n"
            + "\n"
            + "public class RecursoCriadoEvent extends ApplicationEvent {\n"
            + "\n"
            + "	private static final long serialVersionUID = 1L;\n"
            + "	private HttpServletResponse response;\n"
            + "	private Long codigo;\n"
            + "\n"
            + "	public RecursoCriadoEvent(Object source,HttpServletResponse response, Long codigo) {\n"
            + "		super(source);\n"
            + "		this.response=response;\n"
            + "		this.codigo=codigo;\n"
            + "	}\n"
            + "\n"
            + "	public HttpServletResponse getResponse() {\n"
            + "		return response;\n"
            + "	}\n"
            + "\n"
            + "\n"
            + "	public Long getCodigo() {\n"
            + "		return codigo;\n"
            + "	}\n"
            + "}";

}
