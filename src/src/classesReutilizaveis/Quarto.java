package src.classesReutilizaveis;
import java.util.ArrayList;

public class Quarto {

    public  ArrayList<Pessoa> hospedes = new ArrayList<>();
    public TiposDeQuarto tipoDoQuarto;
    public boolean disponibilidade;

    public Quarto(ArrayList<Pessoa> hospedes, TiposDeQuarto tipoDoQuarto) {
        this.hospedes = hospedes;
        this.tipoDoQuarto = tipoDoQuarto;
        this.disponibilidade = verificardisponibilidade();
    }
    public boolean verificardisponibilidade(){
        if (hospedes.size()==0){
            disponibilidade=true;
            return true;
        }else {
            disponibilidade=false;
            return false;
        }
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "hospedes=" + hospedes +
                ", tipoDoQuarto=" + tipoDoQuarto +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}