package src.recursosHumanos;

import src.adapters.LocalDateAdapter;
import src.classesReutilizaveis.Pessoa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class GestaoDeHorarios {

    public static void main(String[] args) {

        Pessoa miguel = new Pessoa("Miguel",37, LocalDate.of(3010,10,10));
        miguel.alarmes.add(LocalDateTime.of(2025,10,14,16,0,0,0));
        System.out.println(miguel);

    }
}
