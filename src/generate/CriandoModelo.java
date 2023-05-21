package generate;

import model.Classe;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.StringFuncao;

public final class CriandoModelo {

    private String programa;
    private final Classe classe;
    public static final String PACKAGE = "model";

    private int x = 0;

    public String getPrograma() {
        return programa;
    }

    public CriandoModelo(Classe classe) {
        this.classe = classe;
        programa = null;
        programa = "";
        if (classe.getTipoClasse().equals("class")) {
            programa += "package " + DadosDoProjeto.PACKAGE_D0_PROJETO + "." + PACKAGE + ";\n"
                    + "\n"
                    + "\n"
                    + "import java.util.Objects;\n"
                    + "\n"
                    + "import jakarta.persistence.Entity;\n"
                    + "import jakarta.persistence.GeneratedValue;\n"
                    + "import jakarta.persistence.GenerationType;\n"
                    + "import jakarta.persistence.Id;\n"
                    + "import jakarta.persistence.Table;\n"
                    + importacoes()
                    + "@Entity\n"
                    + "@Table(name = " + classe.getNomeClasse().toLowerCase() + ")\n"
                    + "public class " + classe.getNomeClasse() + "{\n"
                    + "     @Id\n"
                    + "	@GeneratedValue(strategy = GenerationType.IDENTITY)\n"
                    + "	private Long codigo;\n"
                    + getDeclaracaoDeVariaveis()
                    + "     public Long getCodigo() {\n"
                    + "		return codigo;\n"
                    + "	}\n"
                    + "	public void setCodigo(Long codigo) {\n"
                    + "		this.codigo = codigo;\n"
                    + "	}"
                    + getMetodosDaClasse()
                    + "     @Override\n"
                    + "	public int hashCode() {\n"
                    + "		return Objects.hash(codigo);\n"
                    + "	}\n"
                    + "	@Override\n"
                    + "	public boolean equals(Object obj) {\n"
                    + "		if (this == obj)\n"
                    + "			return true;\n"
                    + "		if (obj == null)\n"
                    + "			return false;\n"
                    + "		if (getClass() != obj.getClass())\n"
                    + "			return false;\n"
                    + "		" + classe.getNomeClasse() + " other = (" + classe.getNomeClasse() + ") obj;\n"
                    + "		return Objects.equals(codigo, other.codigo);\n"
                    + "	}"
                    + "} // fim da classe\n";
        } else if (classe.getTipoClasse().equals("enum")) {
            programa += "package " + DadosDoProjeto.PACKAGE_D0_PROJETO + "." + PACKAGE + ";\n"
                    + "\n"
                    + "\n"
                    + "public enum " + classe.getNomeClasse() + "{\n"
                    + getDeclaracaoDeVariaveisEnum()
                    + "} // fim da classe\n";
        } else if (classe.getTipoClasse().equals("Embeddable")) {
            programa += "package " + DadosDoProjeto.PACKAGE_D0_PROJETO + "." + PACKAGE + ";\n"
                    + "\n"
                    + "\n"
                    + "public class " + classe.getNomeClasse() + "{\n"
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
            
            
            if (!relacionamento.equals("nenhum")) {
               str += "	 "+relacionamento+"\n";  
            }
            if (!anotacao.equals("nenhum")) {
               str += "	 "+anotacao+"\n";
            }
           
            str += String.format(
                    "	private %s %s;\n", tipoAtributo, nomeAtributo);

        }

        return str;
    } // fim do metodo getDeclaracaoDeVariaveis

    public String getDeclaracaoDeVariaveisEnum() {
        String str = "";

        for (int i = 0; i < classe.getAtributos().size(); i++) {
            String nomeAtributo = classe.getAtributos().get(i).getNomeAtributo();

            str += String.format(
                    "     %s,\n", nomeAtributo.toUpperCase());
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

    public void gravar(String caminho, String conteudo) {

        try {

            Path ph = Paths.get(caminho);
            Files.createDirectories(ph);

            File bancoDados = new File(ph.toString(), classe.getNomeClasse() + ".java");

            BufferedWriter saida;
            saida = new BufferedWriter(new FileWriter(bancoDados));
            saida.write(conteudo);

            saida.flush();
            saida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CriandoModelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CriandoModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getPACKAGE() {
        return PACKAGE;
    }

    private String importacoes() {
        String str = "";
        int x=0;
        int y=0;
        for (int i = 0; i < classe.getAtributos().size(); i++) {
            String tipoAtributo = classe.getAtributos().get(i).getTipoAtributo();
            if (tipoAtributo.equals("LocalDate")) {
                if (x==1) {
                    continue;
                }
                str += "import java.time.LocalDate;";
                x++;
            }else
            if (tipoAtributo.equals("BigDecimal")) {
                if (y==1) {
                    continue;
                }
                str += "import java.math.BigDecimal;";
                   y++;
            }
        }
        return str;
    }

}
