import java.util.Scanner;
public class UserInterface {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        new UserInterface().startProgram();
    }

    public void startProgram() {
        startScreen();
        boolean gameFlag = true;
        while (gameFlag) {
            System.out.println("Please choose an option:\n" + "1 for new member. 2 for economy. 3 to see members. 4 for turnament times.");
            if (this.in.hasNextInt()){
                int userInput = this.in.nextInt();
                if (userInput == 1) {
                    System.out.println("Opret nyt medlem");
                } else if (userInput == 2){
                    System.out.println("Se økonomi");
                }else if (userInput == 3){
                    System.out.println("Se medlemmer");
                }else if (userInput == 4){
                    System.out.println("Konkurrencetider");
                }else if (userInput == 5){
                    System.out.println("Træningstider");
                }else if (userInput == 6){
                    System.out.println("Top 5 i tider");
                }

                else if (userInput == 0) {
                    gameFlag = false;
                    System.out.println("You exited the game.");
                } else{
                    System.out.println("Wrong input, try again.");
                }
            } else if (in.hasNextLine()){
                System.out.println("Error, try again.");
                in.next();
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


    }
