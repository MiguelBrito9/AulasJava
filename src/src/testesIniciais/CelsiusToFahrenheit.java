package src.testesIniciais;

import org.apache.commons.lang.StringUtils;

import java.util.Scanner;

import static java.lang.System.out;
public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String x = null;
        do{
            try{
                out.println("introduza os graus em Celsius: ");
                x=sc.nextLine();
                out.println(Integer.parseInt(x)*1.8+32);
            }catch (Exception e){
                out.println("Por favor inpute um número: "+e.getClass().getName());
            }
        }while(!StringUtils.isNumeric(x));
    }
}
