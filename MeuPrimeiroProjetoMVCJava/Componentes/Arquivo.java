
package Componentes;

import Models.Funcionario;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Arquivo
{
    public static void WriteArquivo(Funcionario funcionario)
    {
        String caminho = "/home/igor/NetBeansProjects/MVCSwinger/build/classes/Arquivo/funcionarios.txt";
        String texto = Arquivo.ReadArquivo();
        try
        {
            PrintStream out = new PrintStream(new FileOutputStream(caminho));
            
            texto += funcionario;
        
            out.println(texto);
            out.close();
	}
        
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
    }
    
    private static String ReadArquivo()
    {
        String caminho = "/home/igor/NetBeansProjects/MVCSwinger/build/classes/Arquivo/funcionarios.txt";
        
	Scanner scanner = null;
        String nome = "";
		
        try
        {
            scanner = new Scanner(new FileReader(caminho)).useDelimiter("\n");
			
            while (scanner.hasNext())
            {
		nome += scanner.next() + "\n";
            }
        }
            
        catch (FileNotFoundException e)
        {
            System.out.println("ERRO: O arquivo não pôde ser lido!");
			
            e.printStackTrace();
        }
            
        finally
        {
            scanner.close();
        }
        
        return nome;
    }
}
