import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    Scanner in = new Scanner(System.in);
    DolphinController controller = new DolphinController();
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
                    7: Medlemmer i restance
                    0: Luk program.""");
            System.out.print("Valg: ");
            if (this.in.hasNextInt()){
                int userInput = this.in.nextInt();
                if (userInput == 1) {
                    option1();

                    //Sendes over i en anden klasse med metode som opretter medlem
                } else if (userInput == 2){
                    System.out.println("The expected income is = " + controller.calculateIncome());
                }else if (userInput == 3){
                    System.out.println("Motionister");
                    System.out.println(new Filehandler().readCompetitorFile());
                }else if (userInput == 4){
                    System.out.println("Konkurrencetider");

                }else if (userInput == 5){
                    System.out.println("Træningstider");
                }else if (userInput == 6){
                    System.out.println("Top 5 i tider");
                }else if (userInput == 7){
                    System.out.println("Medlemmer i restance:");
                    System.out.println(controller.getArreas());
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

            public void option1(){


                System.out.println("Opret nyt medlem");
                in.nextLine();
                System.out.println("Navn:");
                String name = in.nextLine();

                System.out.println("Alder:");
                int age = Integer.parseInt(in.nextLine());

                System.out.println("Er medlemmet aktivt?");
                Boolean isActive = null;
                String answer = in.nextLine();
                isActive = answer.equalsIgnoreCase("ja");

                if(!isActive){
                    System.out.println("Medlem oprettet!");
                    controller.createMember(name, age, isActive, false, null);
                    new UserInterface().startProgram();
                }

                System.out.println("Ønsker medlemmet at være konkurrence svømmer?");
                answer = in.nextLine();
                if(answer.equalsIgnoreCase("ja")){
                    controller.createMember(name, age, isActive, false, new ArrayList<double[]>());
                }else{
                    controller.createMember(name, age, isActive, false, null);
                }

                System.out.println("Medlem oprettet!");


            }


    }
