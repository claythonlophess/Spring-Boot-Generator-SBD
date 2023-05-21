package generate;

import generate.DadosDoProjeto;

/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */

/**
 *
 * @author Administrator
 */
public class MainApiGerador {

    public static final String PACKAGE = "";
    public static final String CONTEUDO = ""
            + "package "+DadosDoProjeto.PACKAGE_D0_PROJETO+";\n"
            + "\n"
            + "import org.springframework.boot.SpringApplication;\n"
            + "import org.springframework.boot.autoconfigure.SpringBootApplication;\n"
            + "\n"
            + "@SpringBootApplication\n"
            + "public class AlgamoneyApiApplication {\n"
            + "\n"
            + "	public static void main(String[] args) {\n"
            + "		SpringApplication.run(AlgamoneyApiApplication.class, args);\n"
            + "	}\n"
            + "\n"
            + "}";

}
