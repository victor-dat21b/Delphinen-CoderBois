import java.util.Scanner;
public class UserInterface {

    public static void main(String[] args) {
        new UserInterface().startGame();
    }

    public void startGame() {
        Scanner in = new Scanner(System.in);
        startScreen();
        boolean gameFlag = true;
        while (gameFlag) {
            System.out.println("What do you wish to do?");
            if (in.hasNextInt()){
                int userInput = in.nextInt();
                if (userInput == 1) {


                } else if (userInput == 0) {
                    gameFlag = false;
                    System.out.println("You exited the game.");
                }
            } else{
                System.out.println("Error, try again.");
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
