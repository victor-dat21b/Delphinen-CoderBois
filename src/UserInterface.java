import java.util.*;

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
                    4: Turnerings information og svømmetider for konkurrencesvømmere.
                    5: Træningsresultater for konkurrencesvømmere.
                    6: Top 5 tider for konkurrencesvømmere.
                    7: Medlemmer i restance.
                    8. Opdater tid for konkurrencesvømmer.
                    0: Luk program.""");
            System.out.print("Valg: ");
            if (this.in.hasNextInt()) {
                int userInput = this.in.nextInt();
                if (userInput == 1) {

                    option1();

                    //Sendes over i en anden klasse med metode som opretter medlem
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
                }else if (userInput == 8){


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

    public void option1() {//Troels
        String[] diciplins = {"crawl", "rygcrawl", "brystsvømning", "butterfly"};
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilderDeci = new StringBuilder();
        String finalString = "";
        int numberOfDiciplins = 0;
        boolean isCompetitor = false;

        System.out.println("Opret nyt medlem");
        in.nextLine();
        System.out.println("Navn:");

        stringBuilder.append(in.nextLine()).append(',');


        System.out.println("Alder:");
        stringBuilder.append(in.nextLine());
        stringBuilder.append(',');
        boolean isActive = false;
        boolean isValid = false;
        int answer = 0;

        do {
            System.out.println("Er medlemmet aktivt?");
            System.out.println("""
                    1. Ja
                    2. Nej
                    (Brug tal)""");
            answer = Integer.parseInt(in.nextLine());
            if (answer == 1) {
                isActive = true;
                isValid = true;
            } else if (answer == 2) {
                isValid = true;
            } else {
                System.out.println("Ikke gyldigt input");
            }
        } while (!isValid);


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

        do {
            System.out.println("Ønsker medlemmet at være konkurrence svømmer?");
            System.out.println("""
                    1. Ja
                    2. Nej
                    (Brug tal)""");
            isValid = false;
            answer = Integer.parseInt(in.nextLine());


            if (answer == 1) {
                isCompetitor = true;
                isValid = true;
            } else if (answer == 2) {
                isValid = true;
            } else {
                System.out.println("Ikke gyldigt input");
            }
        } while (!isValid);


        if (answer == 1) {
            //ArrayList<String> myList = new ArrayList<>();
            // myList.add("crawl"); myList.add("butterfly"); myList.add("brystsvømning");myList.add("rygcrawl");
            isValid = false;
            int diciplinAnswer = 0;
            List<String> myList = Arrays.asList("crawl", "butterfly", "brystsvømning", "rygcrawl");
            int myCounter = 0;
            while (myCounter != 4) {
                do {
                    System.out.println("Ønsker medlemmet at svømme " + myList.get(myCounter));
                    System.out.println("""
                            1. Ja
                            2. Nej
                            (Brug tal)""");
                    diciplinAnswer = Integer.parseInt(in.nextLine());
                    answer = diciplinAnswer;
                    if (answer == 1) {
                        isValid = true;
                    } else if (answer == 2) {
                        isValid = true;
                    } else {
                        System.out.println("Ikke gyldigt input");
                    }
                } while (!isValid);

                if (diciplinAnswer == 1) {
                    stringBuilderDeci.append(myList.get(myCounter));
                    stringBuilderDeci.append(',');
                    stringBuilderDeci.append("0.0");
                    stringBuilderDeci.append(',');
                    stringBuilderDeci.append("00-00-0000");
                    stringBuilderDeci.append(',');
                    numberOfDiciplins = numberOfDiciplins + 1;
                } else {

            }
            myCounter++;
            }

            stringBuilder.append(String.valueOf(numberOfDiciplins));
            stringBuilder.append(',');
            stringBuilder.append("0");
            stringBuilder.append(',');
            stringBuilder.append(stringBuilderDeci);
        }

        stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), " ");

        finalString = stringBuilder.toString();

        if (isCompetitor) {
            System.out.println(controller.createMemberC(finalString));
        } else {
            System.out.println(controller.createMemberE(finalString));
        }

    }


    public void updateCompetitorTime(){
        in.nextLine();
        System.out.println("Indtast navnet på det medlem du ønsker at opdatere tiden for:");
        String stringUserInput = in.nextLine();
        ArrayList<String> myList = controller.searchForCompetitor(stringUserInput);
        for (String myString:myList){
            System.out.println(myString);
        }
        if (in.hasNextInt()){
            int userInt = this.in.nextInt();
        } else if (in.hasNextLine()){
            System.out.println("Wrong input, please try again");
        }
    }

}
