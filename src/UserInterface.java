import java.util.Scanner;
public class UserInterface {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        new UserInterface().chooseUser();
    }

    public void startGame() {

        Scanner in = new Scanner(System.in);
        startScreen();
        int myInt = chooseUser();
        boolean gameFlag = true;
        while (gameFlag) {
            if (myInt == 1){
                foremanUser();
            } else if (myInt == 2){
                cashierUser();
            } else{
                trainerUser();
            }
            if (in.hasNextInt()){
                int userInput = in.nextInt();
                if (userInput == 1) {
                    System.out.println("Opret nyt medlem");


                } else if (userInput == 2){

                }else if (userInput == 3){

                }else if (userInput == 4){

                }else if (userInput == 5){

                }

                else if (userInput == 0) {
                    gameFlag = false;
                    System.out.println("You exited the game.");
                }
            } else{
                System.out.println("Error, try again.");
                in.nextInt();
            }

        }
    }
            public void startScreen() {
                StringBuilder buildingString = new StringBuilder();
                buildingString.append("-----------------------------------------------");
                buildingString.append(System.getProperty("line.separator"));
                buildingString.append("                  Welcome to:          ");
                buildingString.append(System.getProperty("line.separator"));
                buildingString.append("            Svømmeklubben Delphinen             ");
                buildingString.append(System.getProperty("line.separator"));
                buildingString.append("-----------------------------------------------");
                System.out.println(buildingString);
            }

            public int chooseUser(){

            Menu startMenu = new Menu("Choose user:",
                    "Use numbers.", new String[]{"1 for foreman.", "2 for cashier.", "3 for trainer."});
            startMenu.printMenu();
            int myInt = 0;
                int userInput;
                if(in.hasNextInt()){
                    userInput = in.nextInt();
                    if (userInput == 1){
                        myInt = 1;
                    } else if(userInput == 2){
                        myInt = 2;
                    }else if(userInput == 3){
                        myInt = 3;
                    }
                } else {
                    System.out.println("Try again");
                }
                return myInt;

            }

            public void foremanUser(){

            }
            public void cashierUser(){

            }
            public void trainerUser(){

            }


    }
