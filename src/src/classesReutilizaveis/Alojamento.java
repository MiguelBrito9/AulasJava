package src.classesReutilizaveis;

import java.util.Map;
import java.util.HashMap;

public class Alojamento {

    public Map <Integer,Quarto> listaDeQuartos = new HashMap<>();
    public String nome="";

    public Alojamento(Map<Integer, Quarto> quartosNoAlojamento, String nome) {
        this.listaDeQuartos = quartosNoAlojamento;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Alojamento{" +
                "listaDeQuartos=" + listaDeQuartos +
                ", nome='" + nome + '\'' +
                '}';
    }
}
