package src.gestaoImobiliaria;

import src.classesReutilizaveis.Alojamento;

import java.util.ArrayList;

import java.util.Scanner;

public class Utils {

    public static void printMenu(){

        System.out.println(
                "1- Criar alojamento\n" +//faltam hoteis
                        "2- Ver alojamentos\n" +
                        "3- Fazer check-in \n" +
                        "4- Alterar alojamentos \n" +
                        "5- Fazer checkout \n" +
                        "6- Remover alojamentos \n"+
                        "7- Sair \n"
        );
    }



    public static void verNomeAlojamentos(ArrayList<Alojamento> listaAlojamentos, String pergunta){

        if(listaAlojamentos.isEmpty()){
            System.out.println("Ainda nao ha alojamentos");
            return;
        }

        System.out.println(pergunta);
        for (Alojamento alojamento:listaAlojamentos){
            System.out.println(alojamento.nome);
        }

    }


    public static int pedirInt(String pergunta, Integer max){


        Scanner sc= new Scanner(System.in);
        int i=0;
            do {
                try {
                    System.out.println(pergunta);
                    i = sc.nextInt();
                    sc.nextLine();//clears the next line value of the next int
                } catch (Exception e) {
                    sc.nextLine();//clears the next line value of the next int
                }
            } while (i < 0 || i> max);
            return i;
        }
    }