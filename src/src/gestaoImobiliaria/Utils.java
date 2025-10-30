package src.gestaoImobiliaria;

import com.google.gson.Gson;
import src.FuncoesAuxiliares;
import src.classesReutilizaveis.*;
import src.FuncoesAuxiliares.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {

    static Scanner sc= new Scanner(System.in);

    public static void printMenu(){

        System.out.println(
                "1- Criar alojamento\n" +
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
            System.out.println("Ainda não há alojamentos");
            return;
        }

        System.out.println(pergunta);
        for (Alojamento alojamento:listaAlojamentos){
            System.out.println(alojamento.nome);
        }
        //imprime apenas os nomes dos alojamentos

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




    public static HashMap<Integer, Quarto> criarQuartosHotel(int numDeQuartos) {

        HashMap<Integer, Quarto> quartos= new HashMap<>();
        boolean hasRoomService;


        for (int n=1; n<=numDeQuartos; n++){
            int randomIndex = (int) (Math.random()* TiposDeQuarto.values().length);
            if(n%2==0){
                hasRoomService=false;
            }else {
                hasRoomService=true;
            }
            quartos.put(n, new Quarto(TiposDeQuarto.values()[randomIndex]));
            quartos.get(n).roomService=hasRoomService;
        }
        //cria os quartos com as propriedades definidas
        return quartos;
    }

    public static void criarAlojamentoManualmente(ArrayList <Alojamento> listaAlojamentos){


        System.out.println("Qual o nome do alojamento?");
        String nome = sc.nextLine();
        //recebe o nome

        int op = pedirInt("Qual o tipo de alojamento?\n" +
                "1 - Hotel \n" +
                "2 - Alojamento Local\n",2);


        HashMap<Integer, Quarto> quartos=new HashMap<>();

        switch (op){
            case(1)://hotel



                int numDeQuartos = pedirInt("Quantos quartos são?",999);
                quartos=criarQuartosHotel(numDeQuartos);
                //cria a lista de quartos

                int nPiscinas = pedirInt("Quantas piscinas tem o hotel?",99);
                //recebe o num de piscinas

                Hotel hotel = new Hotel(quartos,nome,nPiscinas);
                listaAlojamentos.add(hotel);

            case(2)://alojamento local


                AlojamentoLocal al = null;


                numDeQuartos = pedirInt("Quantos quartos são?",999);
                for (int n=1; n<=numDeQuartos; n++){
                    quartos.put(n, new Quarto(TiposDeQuarto.standardRoom));
                }
                //cria a lista de quartos

                System.out.println("Qual a localização?");
                String localizacao = sc.nextLine();
                //recebe o dado

                int tipoDeAlojamento = pedirInt(
                        "Qual o tipo de alojamento?\n" +
                                "1- Casa  \n" +
                                "2- Apartamento \n",2);


                if(tipoDeAlojamento==1){
                    al = new AlojamentoLocal(quartos,nome,localizacao,TiposDeAlojamentoLocal.casa);

                } else {
                    al = new AlojamentoLocal(quartos,nome,localizacao,TiposDeAlojamentoLocal.apartamento);
                }
                //em ambos os casos cria o alojamento


                listaAlojamentos.add(al);
        }
    }

    public static ArrayList <Alojamento> criarAlojamentoFicheiro(ArrayList <Alojamento> listaAlojamentos){

        System.out.println("Que ficheiro quer acessar?");

        String nomeFicheiro=sc.nextLine();


        try{

            File f = new File("C:/Users/mb/Desktop/AulasJava/src/src/gestaoImobiliaria/ficheiros/"+nomeFicheiro);

            if(nomeFicheiro.endsWith("txt")) {
                Scanner scf = new Scanner(f);
                // acede ao ficheiro e inicializa o primeiro scanner

                while (scf.hasNextLine()) {

                    String linha = scf.nextLine();
                    //acede linha a linha o ficheiro
                    String[] conteudos = linha.split(";");
                    //separa os dados da linha

                    HashMap<Integer, Quarto> quartos = criarQuartosHotel(Integer.parseInt(conteudos[2]));
                    //cria a lista de quartos

                    int nPiscinas = Integer.parseInt(conteudos[1]);
                    Hotel hotel = new Hotel(quartos, conteudos[0], nPiscinas);
                    //cria o hotel

                    listaAlojamentos.add(hotel);
                    //adiciona o hotel à lista de alojamentos

                }
                scf.close();
            } else if (nomeFicheiro.endsWith(".json")) {

                Gson gson = new Gson();

                FileReader reader = new FileReader("C:/Users/mb/Desktop/AulasJava/src/src/gestaoImobiliaria/ficheiros/"+nomeFicheiro);

                // Lê para um array
                Alojamento[] alojamentosArray = gson.fromJson(reader, Alojamento[].class);

                for(Alojamento alojamento:alojamentosArray) {

                    listaAlojamentos.add(alojamento);

                }
            }

        }catch(Exception e){

            System.out.println(e);

            //aka kaput

        }

        return listaAlojamentos;
    }

    public static void atualizarFicheiro(ArrayList <Alojamento> listaAlojamentos){


        File ficheiro = new File("C:/Users/mb/Desktop/AulasJava/src/src/gestaoImobiliaria/ficheiros/output.txt");

        try {
            // Verifica se o ficheiro já existe
            if (!ficheiro.exists()) {
                // Cria o ficheiro se não existir
                ficheiro.createNewFile();

            }

            // Cria um PrintWriter para escrever no ficheiro
            PrintWriter printWriter = new PrintWriter(ficheiro);

            for(Alojamento al:listaAlojamentos){
                printWriter.println(al);
            }

            // Fecha o PrintWriter
            printWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Create the file if it doesn't exist
            File ficheiroJson = new File("C:/Users/mb/Desktop/AulasJava/src/src/gestaoImobiliaria/ficheiros/alojamentos.json");
            if (!ficheiroJson.exists()) {
                ficheiroJson.createNewFile();
            }

            // Create a Gson instance for serialization
            Gson gson = new Gson();

            // Create a FileWriter and BufferedWriter to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(ficheiroJson));


            writer.write(gson.toJson(listaAlojamentos));


            // Close the BufferedWriter
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}


