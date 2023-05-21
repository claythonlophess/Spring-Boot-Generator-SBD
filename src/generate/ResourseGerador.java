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
public class ResourseGerador {

    public static String programa;
    private final Classe classe;
    public static final String PACKAGE = "resourse";

    public ResourseGerador(Classe classe) {
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
                + "	@Autowired\n"
                + "	private ApplicationEventPublisher publisher;\n"
                + "\n"
                + "	@GetMapping\n"
                + "	public List< "+ classe.getNomeClasse() +"> listar() {\n"
                + "		return " + classe.getNomeClasse().toLowerCase() + "Repository.findAll();\n"
                + "	}\n"
                + "\n"
                + "	@PostMapping\n"
                + "	public ResponseEntity<" + classe.getNomeClasse() + "> criar(@Valid @RequestBody " + classe.getNomeClasse() + " " + classe.getNomeClasse().toLowerCase() + ", HttpServletResponse response) {\n"
                + "		" + classe.getNomeClasse() + " " + classe.getNomeClasse().toLowerCase() + "1 = " + classe.getNomeClasse().toLowerCase() + "Repository.save(categoria);\n"
                + "\n"
                + "		publisher.publishEvent(new RecursoCriadoEvent(this, response, " + classe.getNomeClasse().toLowerCase() + "1.getCodigo()));\n"
                + "\n"
                + "		return ResponseEntity.status(HttpStatus.CREATED).body(" + classe.getNomeClasse().toLowerCase() + "1);\n"
                + "	}\n"
                + "\n"
                + "	@GetMapping(\"/{codigo}\")\n"
                + "	public Optional<" + classe.getNomeClasse() + "> buscar(@PathVariable Long codigo) {\n"
                + "		return " + classe.getNomeClasse().toLowerCase() + "Repository.findById(codigo);\n"
                + "	}\n"
                + "\n"
                + "}";

    }

    public static String getPrograma() {
        return programa;
    }

    public static String getPACKAGE() {
        return PACKAGE;
    }

}
