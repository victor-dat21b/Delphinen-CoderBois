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
            if (this.in.hasNextInt()) {
                int userInput = this.in.nextInt();
                if (userInput == 1) {

                    option1();

                } else if (userInput == 2){

                    System.out.println("The expected income is = " + controller.calculateIncome());

                }else if (userInput == 3){

                    System.out.println(new FileHandler().readExerciserFile());
                    System.out.println(new FileHandler().readCompetitorFile());

                }else if (userInput == 4){

                    System.out.println("Konkurrencetider");

                } else if (userInput == 5) {

                    System.out.println("Træningstider");
                }else if (userInput == 6){

                    System.out.println(controller.getTopFive());
                }else if (userInput == 7){

                    System.out.println("Medlemmer i restance:");
                    System.out.println(controller.getArreas());
                }

                else if (userInput == 0) {

                    gameFlag = false;

                    System.out.println("Du har lukket programmet!");
                } else {

                    System.out.println("Forkert input, prøv igen!");
                }
            } else if (in.hasNextLine()) {

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

    public void option1(){//Troels

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilderDeci = new StringBuilder();
        String finalString = "";
        int numberOfDiciplins = 0;

        System.out.println("Opret nyt medlem");
        in.nextLine();
        System.out.println("Navn:");

        stringBuilder.append(in.nextLine()).append(',');


        System.out.println("Alder:");
        stringBuilder.append(in.nextLine());
        stringBuilder.append(',');

        System.out.println("Er medlemmet aktivt?");
        boolean isActive;
        String answer = in.nextLine();
        isActive = answer.equalsIgnoreCase("ja");

        if (!isActive) {
            stringBuilder.append("false");
            stringBuilder.append(',');
            stringBuilder.append("false");
            finalString = stringBuilder.toString();
            System.out.println(controller.createMemberE(finalString));

            new UserInterface().startProgram();
        }
        stringBuilder.append("true");
        stringBuilder.append(',');
        stringBuilder.append("false");
        stringBuilder.append(',');

        System.out.println("Ønsker medlemmet at være konkurrence svømmer?");
        answer = in.nextLine();

        if (answer.equalsIgnoreCase("ja")) {

            System.out.println("Ønsker medlemmet at svømme Crawl?");
            String diciplinAnswer = in.nextLine();
            if(diciplinAnswer.equalsIgnoreCase("ja")){
                stringBuilderDeci.append("crawl");
                stringBuilderDeci.append(',');
                stringBuilderDeci.append("0.0");
                stringBuilderDeci.append(',');
                stringBuilderDeci.append("00-00-0000");
                stringBuilderDeci.append(',');
                numberOfDiciplins = numberOfDiciplins +1;
            }

            System.out.println("Ønsker medlemmet at svømme Ryg Crawl?");
            diciplinAnswer = in.nextLine();
            if(diciplinAnswer.equalsIgnoreCase("ja")){
                stringBuilderDeci.append("rygcrawl");
                stringBuilderDeci.append(',');
                stringBuilderDeci.append("0.0");
                stringBuilderDeci.append(',');
                stringBuilderDeci.append("00-00-0000");
                stringBuilder.append(',');
                numberOfDiciplins = numberOfDiciplins +1;
            }

            System.out.println("Ønsker medlemmet at svømme Brystsvømning?");
            diciplinAnswer = in.nextLine();
            if(diciplinAnswer.equalsIgnoreCase("ja")){
                stringBuilderDeci.append("brystsvømning");
                stringBuilderDeci.append(',');
                stringBuilderDeci.append("0.0");
                stringBuilderDeci.append(',');
                stringBuilderDeci.append("00-00-0000");
                stringBuilder.append(',');
                numberOfDiciplins = numberOfDiciplins +1;
            }

            System.out.println("Ønsker medlemmet at svømme Butterfly?");
            diciplinAnswer = in.nextLine();
            if(diciplinAnswer.equalsIgnoreCase("ja")){
                stringBuilderDeci.append("butterfly");
                stringBuilderDeci.append(',');
                stringBuilderDeci.append("0.0");
                stringBuilderDeci.append(',');
                stringBuilderDeci.append("00-00-0000");
                stringBuilder.append(',');
                numberOfDiciplins = numberOfDiciplins +1;
            }


            stringBuilder.append(String.valueOf(numberOfDiciplins));
            stringBuilder.append(',');
            stringBuilder.append("0");
            stringBuilder.append(',');
            stringBuilder.append(stringBuilderDeci);
        }

        stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), " ");

        finalString = stringBuilder.toString();

        if (answer.equalsIgnoreCase("ja")) {
            System.out.println(controller.createMemberC(finalString));
        } else {
            System.out.println(controller.createMemberE(finalString));
        }

    }

}
