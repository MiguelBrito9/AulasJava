package src.classesReutilizaveis;
import java.util.ArrayList;

public class Quarto {

    public  ArrayList<Pessoa> hospedes;
    public TiposDeQuarto tipoDoQuarto;
    public boolean roomService = false;

    public Quarto(TiposDeQuarto tipoDoQuarto) {
        this.hospedes = new ArrayList<Pessoa>();
        this.tipoDoQuarto = tipoDoQuarto;
    }



    public boolean verificardisponibilidade(){
        if (hospedes.isEmpty()){

            return true;
        }else {

            return false;
        }
    }

    @Override
    public String toString() {
        String temRoomService;
        if (roomService==true){
            temRoomService="tem room service";
        }else {
            temRoomService="";
        }
        return "Quarto{" +
                "hospedes=" + hospedes +
                ", tipoDoQuarto=" + tipoDoQuarto +
                " "+ temRoomService +
                '}';
    }
}