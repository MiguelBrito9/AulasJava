package src.classesReutilizaveis;

import java.util.ArrayList;
import java.util.Map;

public class Hotel extends Alojamento {
    public int numDePiscinas;

    public Hotel(Map<Integer, Quarto> quartosNoAlojamento, String nome, int numDePiscinas) {
        super(quartosNoAlojamento, nome);
        this.numDePiscinas = numDePiscinas;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                ", numDePiscinas=" + numDePiscinas +
                ", listaDeQuartos=" + listaDeQuartos +
                ", nome='" + nome + '\'' +
                '}';
    }
}
