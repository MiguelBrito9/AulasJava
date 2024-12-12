package src;

import java.util.ArrayList;

public class FuncoesAuxiliares {

    public static  <T extends Number> double media(ArrayList<T> numbers){
        double sum=0;
        for (T numero:numbers){
            sum+=numero.doubleValue();
        }
        return sum/ numbers.size();
    }
}
