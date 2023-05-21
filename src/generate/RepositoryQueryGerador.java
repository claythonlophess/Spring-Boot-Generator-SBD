/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
package generate;

import model.Classe;
import generate.DadosDoProjeto;

/**
 *
 * @author Administrator
 */
public class RepositoryQueryGerador {

    private final String programa;
    private final Classe classe;
    public static String PACKAGE = "repository";

    public RepositoryQueryGerador(Classe classe) {
        this.classe = classe;
        PACKAGE = "repository." + classe.getNomeClasse().toLowerCase();
        this.programa = ""
                + "package " + DadosDoProjeto.PACKAGE_D0_PROJETO + "." + PACKAGE + ";\n"
                + "import org.springframework.data.domain.Page;\n"
                + "import org.springframework.data.domain.Pageable;"
                + "\n"
                + "import " + DadosDoProjeto.PACKAGE_D0_PROJETO + ".model." + classe.getNomeClasse() + ";\n"
                + "import " + DadosDoProjeto.PACKAGE_D0_PROJETO + ".resourse.filter." + classe.getNomeClasse() + "Filter;\n"
                + "\n"
                + "public interface " + classe.getNomeClasse() + "RepositoryQuery {"
                + "     public Page<" + classe.getNomeClasse() + "> filtrar(" + classe.getNomeClasse() + "Filter " + classe.getNomeClasse().toLowerCase() + "Filter, Pageable pageable);\n"
                + "\n"
                + "}";
    }

    public String getPrograma() {
        return programa;
    }

    public static String getPACKAGE() {
        return PACKAGE;
    }

}
