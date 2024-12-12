package src.testesIniciais;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;
import static src.FuncoesAuxiliares.*;
public class Media {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Double> numeros = new ArrayList<>();
        double newNumber;
        boolean repeat=true;

        out.println();
        out.println();
        out.println("introduza quantos números quiser, e quando quizer terminar introduza 0");
        out.println();

        while (repeat){
            out.println("introduza o "+(numeros.size() +1)+"º número: ");
            newNumber =sc.nextDouble();

            if (newNumber !=0){
                numeros.add(newNumber);
            }else{
                repeat=false;
                out.println(media(numeros));

            }
        }
    }
  }
