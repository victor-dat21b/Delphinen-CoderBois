import javax.xml.crypto.Data;
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
            System.out.println("""
                    1: Nyt medlem.
                    2: Se økonomi.
                    3: Liste over medlemmer.
                    4: Turnerings svømmetider.
                    5: Trænings svømmetider.
                    6: Top 5 tider.
                    0: Luk program.""");
            System.out.print("Valg: ");
            if (this.in.hasNextInt()){
                int userInput = this.in.nextInt();
                if (userInput == 1) {
                    System.out.println("Opret nyt medlem");

                    //Sendes over i en anden klasse med metode som opretter medlem
                } else if (userInput == 2){
                    System.out.println("Se økonomi");
                }else if (userInput == 3){
                    System.out.println("Motionister");
                    System.out.println(new Database().readExerciserFile());
                }else if (userInput == 4){
                    System.out.println("Konkurrencetider");
                }else if (userInput == 5){
                    System.out.println("Træningstider");
                }else if (userInput == 6){
                    System.out.println("Top 5 i tider");
                }

                else if (userInput == 0) {
                    gameFlag = false;
                    System.out.println("Du har lukket programmet!");
                } else{
                    System.out.println("Forkert input, prøv igen!");
                }
            } else if (in.hasNextLine()){
                System.out.println("Fejl, prøv igen!");
                in.next();
            }

        }
    }
            public void startScreen() {
                System.out.println("""
                        --------------------------------------------------
                                   Velkommen til Svømmeklubben
                                          DELFINEN
                        --------------------------------------------------""");
            }


    }
