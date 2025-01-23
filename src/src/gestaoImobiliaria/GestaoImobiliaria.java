package src.gestaoImobiliaria;
import src.classesReutilizaveis.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
                case 7:
                    removerAlojamento(imobiliarios);
                    break;
            }
       }while (menuInput !=8);
    }

    public static void printMenu(){

        System.out.println(
                "1- Criar alojamento\n" +
                "2- Ver alojamentos\n" +
                "3- Fazer check-in \n" +
                "4- Alterar alojamentos \n" +
                "5- Colocar pessoas nos quartos \n" +
                "6- Fazer checkout \n" +
                "7- Remover alojamentos \n"+
                "8- Sair \n"
        );
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


        switch (op){
            case(1)://hotel

                return null;
            case(2)://alojamento local
                int numDeQuartos = 0;
                do {
                    try {
                        System.out.println("Quantos quartos sao?");
                        numDeQuartos = sc.nextInt();
                        sc.nextLine();//clears the next line value of the next int
                    }catch (Exception e){
                        sc.nextLine();//clears the next line value of the next int
                    }
                }while (numDeQuartos<0);
                HashMap<Integer,Quarto> quartos=new HashMap<>();
                for (int n=1; n<=numDeQuartos; n++){
                    quartos.put(n, new Quarto(new ArrayList<>(),TiposDeQuarto.standardRoom));
                }

                System.out.println("Qual a localizacao?");
                String localizacao = sc.nextLine();

                int tipoDeAlojamento = 0;
                do {
                    try {
                        System.out.println(
                                "Qual o tipo de alojamento?\n" +
                                "1- Casa  \n" +
                                "2- Apartamento \n");
                        tipoDeAlojamento = sc.nextInt();
                        sc.nextLine();//clears the next line value of the next int
                    }catch (Exception e){
                        sc.nextLine();//clears the next line value of the next int
                    }
                }while (tipoDeAlojamento!=1 && tipoDeAlojamento!=2);

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
    public static void removerAlojamento(ArrayList <Alojamento> listaAlojamentos){


        if(listaAlojamentos.isEmpty()){
            System.out.println("Ainda nao ha alojamentos");
            return;
        }


        System.out.println("Qual o alojamento que quer remover?");
        for (Alojamento alojamento:listaAlojamentos){
            System.out.println(alojamento.nome);
        }

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
