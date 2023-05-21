/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
package util;

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

/**
 *
 * @author Administrator
 */
public class SaveClass {
   public static void gravar(String package1,String classe,String nomeClasse,String extenssao) {
        try {
            Path ph = Paths.get(package1);
            Files.createDirectories(ph);

            File bancoDados = new File(ph.toString(), nomeClasse+"."+extenssao);

            BufferedWriter saida;
            saida = new BufferedWriter(new FileWriter(bancoDados));
            saida.write(classe);
            saida.flush();
            saida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
