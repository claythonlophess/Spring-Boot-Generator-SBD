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
public class RepositoryGerador {

    private final String programa;
    private final Classe classe;
    public static final String PACKAGE = "repository";

    public RepositoryGerador(Classe classe) {
        this.classe = classe;
        this.programa = ""
                + "package " + DadosDoProjeto.PACKAGE_D0_PROJETO + "." + PACKAGE + ";\n"
                + "import org.springframework.data.jpa.repository.JpaRepository;\n"
                + "\n"
                + "import " + DadosDoProjeto.PACKAGE_D0_PROJETO + ".model." + classe.getNomeClasse() + ";\n"
                + "import " + DadosDoProjeto.PACKAGE_D0_PROJETO + ".repository.lancamento." + classe.getNomeClasse() + "RepositoryQuery;\n"
                + "\n"
                + "public interface " + classe.getNomeClasse() + "Repository extends JpaRepository<" + classe.getNomeClasse() + ", Long>, " + classe.getNomeClasse() + "RepositoryQuery {{\n"
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
