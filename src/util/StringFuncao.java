/*
 * J Planet - Programa para Criar Programas Java
 * 
 * http://ateoriadadesevolucao.blogspot.com/p/software-j-planet.html
 */

/*
 * StringFuncao.java
 */
package util;

/**
 *
 * @author Andreia
 */
public class StringFuncao {

    public static String fcase(String palavra) {
        if (palavra != null) {
            int len = palavra.length();
            String out = "";
            out += palavra.substring(0, 1).toUpperCase();
            out += palavra.substring(1, len).toLowerCase();
            return out;
        }
        return palavra;
    }

    public static String formataClasse(String value) {
        return removeAcentos(removeNumeroInicio(value).replace("%", "").replace(
                "!", "").replace("+", "").replace("(", "").replace(
                ")", "").replace("°", "").replace("´", "").replace(
                "`", "").replace("'", "").replace("\"", "").replace(
                "?", "").replace("|", "").replace(":", "").replace(
                "/", "").replace("\\", "").replace("²", "").replace(
                "@", "").replace("#", "").replace("³", "").replace(
                "¨", "").replace("&", "").replace("{", "").replace(
                "}", "").replace("¬", "").replace("=", "").replace(
                "-", "").replace("^", "").replace("~", ""));
    }

    public static boolean palavrasReservadas(String value) {
        if (value.equals("abstract") || value.equals("continue")
                || value.equals("for") || value.equals("new")
                || value.equals("assert") || value.equals("default")
                || value.equals("goto") || value.equals("package")
                || value.equals("boolean") || value.equals("do")
                || value.equals("if") || value.equals("private")
                || value.equals("break") || value.equals("double")
                || value.equals("implements") || value.equals("protected")
                || value.equals("byte") || value.equals("else")
                || value.equals("import") || value.equals("public")
                || value.equals("case") || value.equals("enum")
                || value.equals("instanceof") || value.equals("return")
                || value.equals("catch") || value.equals("extends")
                || value.equals("int") || value.equals("short")
                || value.equals("char") || value.equals("final")
                || value.equals("interface") || value.equals("static")
                || value.equals("class") || value.equals("finally")
                || value.equals("long") || value.equals("strictfp")
                || value.equals("const") || value.equals("float")
                || value.equals("native") || value.equals("super")
                || value.equals("true") || value.equals("false")
                || value.equals("null")) {
            return true;
        }
        return false;
    }

    public static String removeNumeroInicio(String value) {
        while (comecaComNumero(value)) {
            try {
                value = value.substring(1);
            } catch (IndexOutOfBoundsException ex) {
                return value;
            }
        }

        return value;
    }

    public static boolean comecaComNumero(String value) {
        try {
            if (value.length() > 0) {
                Integer.parseInt(value.substring(0, 1));
            }

            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static String removeAcentos(String value) {
        return value.replace("á", "a").replace("à", "a").replace(
                "ã", "a").replace("ä", "a").replace("â", "a").replace(
                "Á", "A").replace("À", "A").replace("Ã", "A").replace(
                "Ä", "A").replace("Â", "A").replace("é", "e").replace(
                "è", "e").replace("ë", "e").replace("ê", "e").replace(
                "É", "E").replace("È", "E").replace("Ë", "E").replace(
                "Ê", "E").replace("í", "i").replace("ì", "i").replace(
                "ï", "i").replace("î", "i").replace("Í", "I").replace(
                "Ì", "I").replace("Ï", "I").replace("Î", "I").replace(
                "ó", "o").replace("ò", "o").replace("õ", "o").replace(
                "ö", "o").replace("ô", "o").replace("Ó", "O").replace(
                "Ò", "O").replace("Õ", "O").replace("Ö", "O").replace(
                "Ô", "O").replace("ú", "u").replace("ù", "u").replace(
                "ü", "u").replace("û", "u").replace("ý", "y").replace(
                "ÿ", "y").replace("ñ", "n").replace("ç", "c").replace(
                "Ú", "U").replace("Ù", "U").replace("Ü", "U").replace(
                "Û", "U").replace("Ý", "Y").replace("Ñ", "N").replace("Ç", "C");
    }

    public static String capitalizaTudo(String value) {
        String result = "";

        try {
            String[] nomes = value.replace("_", " ").replace(",", " ").replace(".", " ").replace(
                    ";", " ").replace("-", " ").split(" ");

            for (int i = 0; i < nomes.length; i++) {
                result = result + nomes[i].replaceFirst(
                        nomes[i].substring(0, 1), nomes[i].substring(
                        0, 1).toUpperCase());
                if (i < nomes.length - 1) {
                    result += " ";
                }
            }

        } catch (StringIndexOutOfBoundsException ex) {
            result = value;
        }

        return result;
    }

    public static String capitalizaClasse(String value) {
        return capitalizaTudo(value).replace(" ", "").replace(",", "").replace(
                ".", "").replace(";", "").replace("-", "").trim();
    }

    public static String formatoDB(String palavra) {

        return palavra.toLowerCase().replace(",", " ").replace(".", " ").replace(";", " ").replace("-", " ").trim().replace(" ", "_").replace("'", "").replace(",", "").replace("__", "_");
    }

    public static String primeiraMaiuscula(String palavra) {
        try {
            if (!palavra.trim().isEmpty()) {
                return palavra.replaceFirst(palavra.substring(0, 1),
                        palavra.substring(0, 1).toUpperCase());
            }
        } catch (StringIndexOutOfBoundsException ex) {
        }
        return palavra;
    }

    public static String primeiraMinuscula(String palavra) {
        try {
            if (!palavra.trim().isEmpty()) {
                return palavra.replaceFirst(palavra.substring(0, 1), palavra.substring(0, 1).toLowerCase());
            }
        } catch (StringIndexOutOfBoundsException ex) {
        }
        return palavra;
    }

    public static String removerEspacosAntes(String palavra) {
        String novaPalavra = palavra;
        try {
            if (!novaPalavra.trim().isEmpty()) {
                while (novaPalavra.startsWith(" ")) {
                    novaPalavra = novaPalavra.replaceFirst(" ", "");
                }
            }

            return novaPalavra;
        } catch (StringIndexOutOfBoundsException ex) {
        }
        return palavra;
    }

    public static String removeEspacosAntesDepois(String palavra) {
        return removerEspacosDepois(removerEspacosAntes(palavra));
    }

    public static String removerEspacosDepois(String palavra) {
        String novaPalavra = palavra;
        if (novaPalavra.contains(" ")) {
          novaPalavra =  novaPalavra.replace(" ", "");
        }
        try {
            if (!novaPalavra.trim().isEmpty()) {
                while (novaPalavra.endsWith(" ")) {
                    novaPalavra = novaPalavra.substring(0, novaPalavra.length() - 1);
                }
            }

            return novaPalavra;
        } catch (StringIndexOutOfBoundsException ex) {
        }
        return palavra;
    }
} // fim da classe StringFuncao

