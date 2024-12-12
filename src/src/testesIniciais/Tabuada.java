package src.testesIniciais;

import java.util.Scanner;

import static java.lang.System.out;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Tabuada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.println("introduza um número: ");
        int x=sc.nextInt();
        imprimirATabuadoDo(x);
    }

    private static void imprimirATabuadoDo(int y){
        for(int n=1; n<=10; n++){
            out.println(y+"*"+n+"="+y*n);
        }
    }
}