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
public class ExceptionhandlerGerador {

    public static String PACKAGE= "exceptionhandler";
    public static String CONTEUDO = ""
            + "package "+DadosDoProjeto.PACKAGE_D0_PROJETO+"."+PACKAGE+";\n"
            + "\n"
            + "import java.util.ArrayList;\n"
            + "import java.util.Arrays;\n"
            + "import java.util.Iterator;\n"
            + "import java.util.List;\n"
            + "\n"
            + "import org.springframework.beans.factory.annotation.Autowired;\n"
            + "import org.springframework.context.MessageSource;\n"
            + "import org.springframework.context.i18n.LocaleContextHolder;\n"
            + "import org.springframework.http.HttpHeaders;\n"
            + "import org.springframework.http.HttpStatus;\n"
            + "import org.springframework.http.HttpStatusCode;\n"
            + "import org.springframework.http.ResponseEntity;\n"
            + "import org.springframework.http.converter.HttpMessageNotReadableException;\n"
            + "import org.springframework.validation.BindingResult;\n"
            + "import org.springframework.validation.FieldError;\n"
            + "import org.springframework.web.bind.MethodArgumentNotValidException;\n"
            + "import org.springframework.web.bind.annotation.ControllerAdvice;\n"
            + "import org.springframework.web.context.request.WebRequest;\n"
            + "import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;\n"
            + "\n"
            + "\n"
            + "@ControllerAdvice\n"
            + "public class "+DadosDoProjeto.NOME_D0_PROJETO+"ExceptionHandler extends ResponseEntityExceptionHandler {\n"
            + "\n"
            + "	@Autowired\n"
            + "	private MessageSource messageSource;\n"
            + "\n"
            + "	@Override\n"
            + "	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,HttpHeaders headers, HttpStatusCode status, WebRequest request) {\n"
            + "\n"
            + "		String messageUser = messageSource.getMessage(\"mensagem.invalida\", null,LocaleContextHolder.getLocale());\n"
            + "		String messageDev = ex.getCause().toString();\n"
            + "		List<Erro> erros = Arrays.asList(new Erro(messageUser, messageDev));\n"
            + "		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);\n"
            + "	}\n"
            + "	\n"
            + "	@Override\n"
            + "	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,\n"
            + "			HttpHeaders headers, HttpStatusCode status, WebRequest request) {\n"
            + "		List<Erro> erros = criarListaDeErros(ex.getBindingResult());\n"
            + "		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);\n"
            + "	}\n"
            + "	\n"
            + "	 private List<Erro> criarListaDeErros(BindingResult bindingResult) {\n"
            + "		List<Erro> erros = new ArrayList<>();\n"
            + "		for (FieldError fieldError : bindingResult.getFieldErrors()) {\n"
            + "			String messageUser = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());\n"
            + "			String messageDev = fieldError.toString();\n"
            + "			erros.add(new Erro(messageUser, messageDev));\n"
            + "		}\n"
            + "		return erros;\n"
            + "	}\n"
            + "\n"
            + "	public static class Erro{\n"
            + "		 \n"
            + "		 private String menssagemUsuario;\n"
            + "		 private String menssagemDesenvolvedor;		 \n"
            + "		 \n"
            + "		public Erro(String menssagemUsuario, String menssagemDesenvolvedor) {\n"
            + "			this.menssagemUsuario = menssagemUsuario;\n"
            + "			this.menssagemDesenvolvedor = menssagemDesenvolvedor;\n"
            + "		}\n"
            + "		\n"
            + "		public String getMenssagemUsuario() {\n"
            + "			return menssagemUsuario;\n"
            + "		}\n"
            + "		\n"
            + "		public String getMenssagemDesenvolvedor() {\n"
            + "			return menssagemDesenvolvedor;\n"
            + "		}\n"
            + "		 \n"
            + "		 \n"
            + "	 }\n"
            + "}";

}
