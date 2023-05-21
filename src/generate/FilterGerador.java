/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
package generate;

import model.Classe;
import static generate.CriandoModelo.PACKAGE;
import generate.DadosDoProjeto;
import util.StringFuncao;

/**
 *
 * @author Administrator
 */
public class FilterGerador {

    public static String programa;
    private final Classe classe;
    public static final String PACKAGE = "resourse.filter";

    public FilterGerador(Classe classe) {
        this.classe = classe;
        if (classe.getTipoClasse().equals("class")) {
            this.programa = ""
                    + "package " + DadosDoProjeto.PACKAGE_D0_PROJETO + "." + PACKAGE + ";\n"
                    + "\n"
                    + "\n"
                    + "import java.time.LocalDate;\n"
                    + "\n"
                    + "import org.springframework.format.annotation.DateTimeFormat;"
                    + "\n"
                    + "public class " + classe.getNomeClasse() + "Filter {\n"
                    + getDeclaracaoDeVariaveis()
                    + getMetodosDaClasse()
                    + "} // fim da classe\n";
        }
    }

    public String getDeclaracaoDeVariaveis() {
        String str = "";

        for (int i = 0; i < classe.getAtributos().size(); i++) {

            String anotacao = classe.getAtributos().get(i).getAnotacao();
            String relacionamento = classe.getAtributos().get(i).getRelacionamento();
            String tipoAtributo = classe.getAtributos().get(i).getTipoAtributo();
            String nomeAtributo = classe.getAtributos().get(i).getNomeAtributo();

            if (tipoAtributo.equals("LocalDate")) {
                str += "	 @DateTimeFormat(pattern = \"yyyy-MM-dd\")\n";
            }

            str += String.format(
                    "	private %s %s;\n", tipoAtributo, nomeAtributo);

        }

        return str;
    } // fim do metodo getDeclaracaoDeVariaveis

    public String getMetodosDaClasse() {
        String str = "";

        for (int i = 0; i < classe.getAtributos().size(); i++) {
            String tipoAtributo = classe.getAtributos().get(i).getTipoAtributo();
            String nomeAtributo = classe.getAtributos().get(i).getNomeAtributo();

            str += String.format(
                    "\n"
                    + "	public %s get%s() {\n"
                    + "     	return %s;\n"
                    + "     }\n",
                    tipoAtributo, StringFuncao.primeiraMaiuscula(nomeAtributo),
                    nomeAtributo);

            str += String.format(
                    "\n"
                    + "	public void set%s(%s %s) {\n"
                    + "     	this.%s = %s;\n"
                    + "     }\n",
                    StringFuncao.primeiraMaiuscula(nomeAtributo), tipoAtributo,
                    nomeAtributo, nomeAtributo, nomeAtributo);
        }
        return str;
    } // fim do metodo getMetodosDaClasse

    public static String getPrograma() {
        return programa;
    }

    public static String getPACKAGE() {
        return PACKAGE;
    }

}
