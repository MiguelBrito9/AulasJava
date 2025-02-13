package src.gestaoImobiliaria;
import src.classesReutilizaveis.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static src.gestaoImobiliaria.Utils.*;

public class GestaoImobiliaria {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        ArrayList imobiliarios= new ArrayList<Alojamento>();

        int menuInput;

        do{
            printMenu();
            menuInput = sc.nextInt();
            sc.nextLine();//clears the next line value of the next int
            switch (menuInput){
                case 1:
                    imobiliarios.add(criarAlojamento());
                    break;
                case 2:
                    verAlojamentos(imobiliarios);
                    break;
                case 3:
                    fazerCheckIn(imobiliarios);
                    break;
                case 4:
                    alterarAlojamentos(imobiliarios);
                    break;
                case 5:
                    fazerCheckOut(imobiliarios);
                    break;
                case 6:
                    removerAlojamento(imobiliarios);
                    break;
            }
       }while (menuInput !=7);
    }






    public static Alojamento criarAlojamento(){

        AlojamentoLocal al = null;
        int op=0;

        System.out.println("Qual o nome do alojamento?");

        String nome = sc.nextLine();

        do {
            System.out.println(
                    "1 - Hotel \n" +
                    "2 - Alojamento Local\n");
            try{
                op = sc.nextInt();
                sc.nextLine();//clears the next line value of the next int
            }catch (Exception e){
                sc.nextLine();//clears the next line value of the next int
            }
        }while(op!=1 && op!=2);

        int numDeQuartos=0;
        HashMap<Integer,Quarto> quartos=new HashMap<>();

        switch (op){
            case(1)://hotel



                numDeQuartos = pedirInt("Quantos quartos são?",999);


                boolean hasRoomService;

                for (int n=1; n<=numDeQuartos; n++){
                    int randomIndex = (int) (Math.random()*TiposDeQuarto.values().length);
                    if(n%2==0){
                      hasRoomService=false;
                    }else {
                        hasRoomService=true;
                    }
                    quartos.put(n, new Quarto(TiposDeQuarto.values()[randomIndex]));
                    quartos.get(n).roomService=hasRoomService;
                }

                int nPiscinas = pedirInt("Quantas piscinas tem o hotel?",99);

                Hotel hotel = new Hotel(quartos,nome,nPiscinas);

                return hotel;
            case(2)://alojamento local
                numDeQuartos = pedirInt("Quantos quartos são?",999);


                for (int n=1; n<=numDeQuartos; n++){
                    quartos.put(n, new Quarto(TiposDeQuarto.standardRoom));
                }


                System.out.println("Qual a localização?");
                String localizacao = sc.nextLine();

                int tipoDeAlojamento = pedirInt(
                        "Qual o tipo de alojamento?\n" +
                        "1- Casa  \n" +
                        "2- Apartamento \n",2);


                if(tipoDeAlojamento==1){
                    al = new AlojamentoLocal(quartos,nome,localizacao,TiposDeAlojamentoLocal.casa);

                } else {
                    al = new AlojamentoLocal(quartos,nome,localizacao,TiposDeAlojamentoLocal.apartamento);
                }
        }
        return al;
    }

    public static void verAlojamentos(ArrayList <Alojamento> listaAlojamentos){

        for(Alojamento alojamento:listaAlojamentos){
            System.out.println(alojamento);
        }
    }



    public static void fazerCheckIn(ArrayList <Alojamento> listaAlojamentos){

        ArrayList pessoasNovas= new ArrayList<Pessoa>();

        verNomeAlojamentos(listaAlojamentos,"Qual o alojamento em que quer fazer check-in?");

        String nomeAlojamento=sc.nextLine();

        for (Alojamento alojamento:listaAlojamentos){

            if(nomeAlojamento.equals(alojamento.nome)) {

                for( Map.Entry<Integer, Quarto> quarto:alojamento.listaDeQuartos.entrySet()){

                    if(quarto.getValue().verificardisponibilidade()){


                        int numDePessoas=pedirInt("Quantos pessoas são?",999);


                        for (int pessoa=1; pessoa<=numDePessoas; pessoa++){

                            System.out.println("Qual é o nome da pessoa "+pessoa+"?");
                            String nome = sc.nextLine();

                            int idade = pedirInt("Qual a idade?",128);

                            pessoasNovas.add(new Pessoa(nome,idade));


                        }

                        quarto.getValue().hospedes=pessoasNovas;
                        System.out.println("O check-in foi feito com sucesso");
                        return;
                    }
                }

                System.out.println("O check-in não foi feito com sucesso, pois o hotel não tem vagas");
                return;
            }
        }
        System.out.println("Nenhum check-in foi feito");
    }


    public static void alterarAlojamentos(ArrayList <Alojamento> listaAlojamentos){

        verNomeAlojamentos(listaAlojamentos,"Qual o alojamento que quer alterar?");

        String nomeAlojamento=sc.nextLine();

        for (Alojamento alojamento:listaAlojamentos){
            if(nomeAlojamento.equals(alojamento.nome)) {

                if(alojamento instanceof AlojamentoLocal){

                    System.out.println("Qual a nova localização do alojamento?");
                    ((AlojamentoLocal) alojamento).localizacao = sc.nextLine();

                } else if (alojamento instanceof Hotel) {



                    switch (pedirInt("Quer alterar o número de piscinas?\n" +
                            "1-sim\n" +
                            "2-não",2)) {

                        case (1):


                            ((Hotel) alojamento).numDePiscinas = pedirInt("Quantas piscinas vai ter o hotel?",99);
                            break;
                    }

                    switch (pedirInt("Quer alterar o room service?\n" +
                            "1-sim\n" +
                            "2-não",2)) {

                        case (1):

                            System.out.println("Qual o quarto que quer alterar?");
                            System.out.println(alojamento);
                            int numDeQuarto = pedirInt("",alojamento.listaDeQuartos.size())-1;
                            alojamento.listaDeQuartos.get(numDeQuarto).roomService =!alojamento.listaDeQuartos.get(numDeQuarto).roomService;
                            break;
                    }
                }


                System.out.println("O alojamento foi alterado com sucesso");
                return;
            }
        }
        System.out.println("Nenhum alojamento foi alterado");
        return;
    }

    public static void fazerCheckOut(ArrayList <Alojamento> listaAlojamentos){


        verNomeAlojamentos(listaAlojamentos,"Qual o alojamento em que quer fazer check-out?");

        String nomeDoAlojamento=sc.nextLine();

        for (Alojamento alojamento:listaAlojamentos){

            if (alojamento.nome.equals(nomeDoAlojamento)){

                System.out.println("Em que quarto quer fazer o check-out?");
                System.out.println(alojamento.listaDeQuartos);
                int nDoQuarto = pedirInt("",alojamento.listaDeQuartos.size());

                alojamento.listaDeQuartos.get(nDoQuarto).hospedes.clear();
                System.out.println("O check-out foi feito com sucesso");
                return;

            }
        }

        System.out.println("Nenhum check-out foi feito");
        return;
    }


    public static void removerAlojamento(ArrayList <Alojamento> listaAlojamentos){


        verNomeAlojamentos(listaAlojamentos,"Qual o alojamento que quer remover?");

        String nomeAlojamento=sc.nextLine();
        for (Alojamento alojamento:listaAlojamentos){
            if(nomeAlojamento.equals(alojamento.nome)) {
                listaAlojamentos.remove(alojamento);
                System.out.println("O alojamento foi removido com sucesso");
                return;
            }
        }
        System.out.println("Nenhum alojamento foi removido");
    }
}
