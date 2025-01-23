package src.classesReutilizaveis;

import java.util.ArrayList;
import java.util.Map;

public class Hotel extends Alojamento {
    public boolean roomService;
    public int numDePiscinas;

    public Hotel(Map<Integer, Quarto> quartosNoAlojamento, String nome, boolean roomService, int numDePiscinas) {
        super(quartosNoAlojamento, nome);
        this.roomService = roomService;
        this.numDePiscinas = numDePiscinas;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "roomService=" + roomService +
                ", numDePiscinas=" + numDePiscinas +
                ", listaDeQuartos=" + listaDeQuartos +
                ", nome='" + nome + '\'' +
                '}';
    }
}
