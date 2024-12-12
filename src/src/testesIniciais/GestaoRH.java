package src.testesIniciais;

import src.classesReutilizaveis.Aluno;
import src.classesReutilizaveis.Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class GestaoRH {
    public static void main(String[] args) {
        Pessoa miguel = new Pessoa("miguel", 16);
        out.println(miguel.getNome());
        miguel.setTelefone(912345678);



        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        listaPessoas.add(miguel);
        listaPessoas.add(new Pessoa("jose", 34));
        listaPessoas.add(new Pessoa("ze", 4));

        Aluno  alfredo = new Aluno("Alfredo",67,956189329,15);

        for (Pessoa p:listaPessoas){
            if(p.getNome().equals("jose")&&p.getIdade()==34){
                p.setTelefone(7623746);
            }
            out.println(p);
        }
        out.println();

        out.println(alfredo);
    }
}
