package src.snake;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class SnakeGame {

    static Random randomCoordinate=new Random();//a random value
    static Scanner sc = new Scanner(System.in);//user input

    static ArrayList<Coordinates> body = new ArrayList<>();//contains all body segments
    static int gridSize =5;//grid size does NOT include walls
    static int snakeLength =1;//does NOT include the head
    static Coordinates head = new Coordinates(1,0,"H");//makes the head
    static Coordinates apple = new Coordinates(20,20,"A");
    //makes the apple (values are absurd since they will be randomized shortly after)


    public static void main(String[] args) {

        String direction;
        body.add(new Coordinates(0,0,"o"));//first body segment
        NewAppleCoordinates();//make the first apple

        PrintGrid();//first image

        while (true) {

            do {
                direction = sc.nextLine();
                ChangeHeadCoordinate(direction);
            }while(!direction.equals("s") && !direction.equals("a")  && !direction.equals("w") && !direction.equals("d"));
            //asks for a new direction in case the first as invalid

            CheckCollisions();
            PrintGrid();
        }
    }




    public static void ChangeHeadCoordinate(String direction){

        //adds a body segment to where the head was and the moves it
        switch (direction) {
            case "d":
                body.add(new Coordinates(head.x,head.y,"o"));
                head.x++;
                break;
            case "a":
                body.add(new Coordinates(head.x,head.y,"o"));
                head.x--;
                break;
            case "s":
                body.add(new Coordinates(head.x,head.y,"o"));
                head.y++;
                break;
            case "w":
                body.add(new Coordinates(head.x,head.y,"o"));
                head.y--;
                break;
            default:
                System.out.println("error: direction not expected, please choose \"w, a, s, d\"");
                //in case of error
        }
    }




    public static void CheckCollisions(){

        if (head.x==-1){
            System.out.println("game over");
            gameOver();
        } else if (head.x==gridSize) {
            System.out.println("game over");
            gameOver();
        } else if (head.y==-1){
            System.out.println("game over");
            gameOver();
        } else if (head.y==gridSize) {
            System.out.println("game over");
            gameOver();
        }//making sure the head isn't hitting any wall

         if (colliding(head,apple)){
            snakeLength++;

             if(snakeLength ==gridSize*gridSize-1){
                 //this is true if the src.snake fills the whole grid
                 System.out.println("");
                 System.out.println("");
                 System.out.println("");
                 System.out.println("Congratulations you won!!!");
                 System.exit(0);
             }else{
                NewAppleCoordinates();//makes a new apple
             }
        }else {
             body.removeFirst();//if it didn't collide removes the tail
         }

         for (Coordinates segment:body){
             if(colliding(segment,head)) {
                 gameOver();
                 //triggers if the head collides with the body
             }
         }


    }



    public static void NewAppleCoordinates(){



        boolean AppleCoordinateInvalid=true;
        boolean noBodyCollidingWithApple = true;
        while(AppleCoordinateInvalid){//tries random spots for the apple until it finds a valid one
            apple.setX(randomCoordinate.nextInt(gridSize));
            apple.setY(randomCoordinate.nextInt(gridSize));

            for (Coordinates segment:body){
                if(colliding(segment,apple)){
                    noBodyCollidingWithApple =false;
                    //becomes false if the apple would be on top of a body segment
                    break;
                }
            }

            if (noBodyCollidingWithApple && !colliding(apple,head)){
                AppleCoordinateInvalid=false;
                //means that the apple is in a valid spot and ends the loop
            }else {
                noBodyCollidingWithApple = true;
                //resets and goes back to the while
            }
        }
    }



    public static void PrintGrid(){//probably spaghetti but I don't know how to do better

        clearConsole();

        ArrayList<String> grid = new ArrayList<>();
        for(int n=0; n<gridSize*gridSize;n++){
            grid.add("-");//fill the grid with empty spaces
        }
        for (Coordinates segment:body){
            grid.set(segment.y*gridSize+segment.x,"o");
        }//make the body
        grid.set(head.y*gridSize+ head.x,"H");//then the head

        grid.set(apple.y*gridSize+apple.x,"A");//and the apple
        //then stat printing
        String printLine = "";
        for(int walls=0;walls<gridSize+2;walls++){
            printLine += "W";
        }
        System.out.println(printLine);
        printLine = "";
        //print initial walls
        for (int line=0;line<gridSize;line++){//print current line

            for (int colum = 0; colum <gridSize; colum++) {

                printLine += grid.get(line * gridSize + colum);


            }
            System.out.println("W"+ printLine +"W");
            printLine ="";
        }
        for(int walls=0;walls<gridSize+2;walls++){
            printLine +="W";
        }
        System.out.println(printLine);//print bottom lines


    }



    public static void clearConsole() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }//brute force method for cleaning the screen
    }



    private static boolean colliding(Coordinates a, Coordinates b){
        return a.x == b.x && a.y == b.y;//returns true if they have both the same x and y values
    }
    public static void gameOver(){

        clearConsole();
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("|  O   O  |");
        System.out.println("|         |");
        System.out.println("|   ___   |");
        System.out.println(" \\_______/");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Game Over");
        System.exit(0);
    }
}
