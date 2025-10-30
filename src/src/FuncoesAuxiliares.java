package src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class FuncoesAuxiliares {

    public static  <T extends Number> double media(ArrayList<T> numbers){
        double sum=0;
        for (T numero:numbers){
            sum+=numero.doubleValue();
        }
        return sum/ numbers.size();
    }


    public static void executarComando(String comando) {
        try {
            // Verifica se o sistema é Windows ou não
            String sistemaOperacional = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;

            // Usando cmd.exe no Windows, ou bash no Linux/macOS
            if (sistemaOperacional.contains("win")) {
                // No Windows, usamos cmd.exe
                processBuilder = new ProcessBuilder("cmd", "/c", comando);
            } else {
                // Em sistemas Linux/macOS, usamos bash
                processBuilder = new ProcessBuilder("bash", "-c", comando);
            }

            // Inicia o processo
            Process process = processBuilder.start();

            // Captura a saída do comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);  // Exibe o output do comando
            }

            // Aguarda o término do comando
            int exitCode = process.waitFor();
            System.out.println("Comando executado com código de saída: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
