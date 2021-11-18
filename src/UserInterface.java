import java.util.Scanner;
public class UserInterface {

    public void startGame() {
        Scanner in = new Scanner(System.in);
        System.out.println("You were out hiking with some friends, when you suddenly fell down a hole.");
        boolean gameFlag = true;
        while (gameFlag) {
            System.out.println("What do you wish to do?");
            String userInput = in.nextLine();
            if (userInput.equals("east") || (userInput.equals("go east")) || (userInput.equals("west")
                    || (userInput.equals("go west"))) || (userInput.equals("south") || (userInput.equals("go south"))
                    || (userInput.equals("north") || (userInput.equals("go north"))))) {


            } else if (userInput.equals("exit")) {
                gameFlag = false;
                System.out.println("You exited the game.");
            }
        }
    }
            public void startScreen() {
                StringBuilder buildingString = new StringBuilder();
                buildingString.append("-----------------------------------------------");
                buildingString.append(System.getProperty("line.separator"));
                buildingString.append("                  Welcome to:          ");
                buildingString.append(System.getProperty("line.separator"));
                buildingString.append("            The caves of Darknezz!               ");
                buildingString.append(System.getProperty("line.separator"));
                buildingString.append("-----------------------------------------------");
                System.out.println(buildingString);
            }


    }
