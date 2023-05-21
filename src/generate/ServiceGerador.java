/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
package generate;

import model.Classe;
import generate.DadosDoProjeto;
import util.StringFuncao;
import view.Main;

/**
 *
 * @author Administrator
 */
public class ServiceGerador {

    public static String programa;
    private final Classe classe;
    public static final String PACKAGE = "resourse";

    public ServiceGerador(Classe classe) {
        this.classe = classe;
        this.programa = ""
                + "package " + DadosDoProjeto.PACKAGE_D0_PROJETO + "." + PACKAGE + ";\n"
                + "\n"
                + "import java.util.List;\n"
                + "import java.util.Optional;\n"
                + "\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import org.springframework.context.ApplicationEventPublisher;\n"
                + "import org.springframework.http.HttpStatus;\n"
                + "import org.springframework.http.ResponseEntity;\n"
                + "import org.springframework.web.bind.annotation.GetMapping;\n"
                + "import org.springframework.web.bind.annotation.PathVariable;\n"
                + "import org.springframework.web.bind.annotation.PostMapping;\n"
                + "import org.springframework.web.bind.annotation.RequestBody;\n"
                + "import org.springframework.web.bind.annotation.RequestMapping;\n"
                + "import org.springframework.web.bind.annotation.RestController;\n"
                + "\n"
                + "import " + DadosDoProjeto.PACKAGE_D0_PROJETO + ".event.RecursoCriadoEvent;\n"
                + "import " + DadosDoProjeto.PACKAGE_D0_PROJETO + ".model." + classe.getNomeClasse() + ";\n"
                + "import " + DadosDoProjeto.PACKAGE_D0_PROJETO + ".repository." + classe.getNomeClasse() + "Repository;\n"
                + "\n"
                + "import jakarta.servlet.http.HttpServletResponse;\n"
                + "import jakarta.validation.Valid;\n"
                + "\n"
                + "@RestController\n"
                + "@RequestMapping(\"/" + classe.getNomeClasse().toLowerCase() + "s\")\n"
                + "public class " + classe.getNomeClasse() + "Resourse {\n"
                + "\n"
                + "	@Autowired\n"
                + "	private " + classe.getNomeClasse() + "Repository " + classe.getNomeClasse().toLowerCase() + "Repository;\n"
                + "\n"
                + "public " + classe.getNomeClasse() + " atualizar(Long codigo, " + classe.getNomeClasse() + " " + classe.getNomeClasse().toLowerCase() + ") {\n"
                + "		" + classe.getNomeClasse() + " " + classe.getNomeClasse().toLowerCase() + "1 = buscarPeloCodigo(codigo);\n"
                + "\n"
                + "		BeanUtils.copyProperties(" + classe.getNomeClasse().toLowerCase() + ", " + classe.getNomeClasse().toLowerCase() + "1, \"codigo\");\n"
                + "		return " + classe.getNomeClasse().toLowerCase() + "Repository.save(" + classe.getNomeClasse().toLowerCase() + "1);\n"
                + "	}"
                + "\n"
                +classesExternas()
                + probriedadesBooleanas()
                + "public " + classe.getNomeClasse() + " buscarPeloCodigo(Long codigo) {\n"
                + "		" + classe.getNomeClasse() + " " + classe.getNomeClasse().toLowerCase() + "1 = " + classe.getNomeClasse().toLowerCase() + "1Repository.getReferenceById(codigo);\n"
                + "		if (" + classe.getNomeClasse().toLowerCase() + "1 == null) {\n"
                + "			throw new EmptyResultDataAccessException(1);\n"
                + "		}\n"
                + "		return pessoaRepository.save(" + classe.getNomeClasse().toLowerCase() + "1);\n"
                + "	}"
                + "}";

    }

    public String probriedadesBooleanas() {
        String str = "";

        for (int i = 0; i < classe.getAtributos().size(); i++) {

            String tipoAtributo = classe.getAtributos().get(i).getTipoAtributo();
            String nomeAtributo = classe.getAtributos().get(i).getNomeAtributo();
            if (tipoAtributo.equals("boolean")) {
                str = "public void atualizarPropriedade" + StringFuncao.primeiraMaiuscula(nomeAtributo) + "(Long codigo, boolean " + nomeAtributo + "){\n"
                        + "		" + classe.getNomeClasse() + " " + classe.getNomeClasse().toLowerCase() + "1 = buscarPeloCodigo(codigo);\n"
                        + "		" + classe.getNomeClasse().toLowerCase() + "1.set" + StringFuncao.primeiraMaiuscula(nomeAtributo) + "(" + nomeAtributo + ");\n"
                        + "		" + classe.getNomeClasse().toLowerCase() + "Repository.save(" + classe.getNomeClasse().toLowerCase() + "1);\n"
                        + "	}";
            }

        }

        return str;
    } // fim do metodo probriedadesBooleanas

    public String classesExternas() {
        String str = "";

        for (int i = 0; i < classe.getAtributos().size(); i++) {
            String tipoAtributo = classe.getAtributos().get(i).getTipoAtributo();

            for (String nomeClasse : Main.ListaAtributos.listaNomeClasse) {
                if (tipoAtributo.equals(nomeClasse)) {
                    str = "public " + classe.getNomeClasse() + " salvar(" + classe.getNomeClasse() + " " + classe.getNomeClasse().toLowerCase() + ") {\n"
                            + "		Pessoa pessoa = pessoaRepository.getReferenceById(" + classe.getNomeClasse().toLowerCase() + ".getPessoa().getCodigo());\n"
                            + "		if (" + nomeClasse + " == null) {\n"
                            + "			throw new NullPointerException( \" "+nomeClasse +" nao encontrada...\");\n"
                            + "		}\n"
                            + "\n"
                            + "		return " + classe.getNomeClasse().toLowerCase() + "Repository.save(" + classe.getNomeClasse().toLowerCase() + ");\n"
                            + "	}";
                }
                
            }

        }

        return str;
    } // fim do metodo probriedadesBooleanas

    public static String getPrograma() {
        return programa;
    }

    public static String getPACKAGE() {
        return PACKAGE;
    }

}
