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
                    1: Opret medlem.
                    2: Se økonomi.
                    3: Liste over medlemmer og træningsinformation for konkurrencesvømmere.
                    4: Sæt turneringsinformation ogfor konkurrencesvømmere.
                    5: Se tourningeringsinformation for konkurrencesvømmere.
                    6: Top 5 tider for konkurrencesvømmere.
                    7: Medlemmer i restance.
                    8. Opdater tid for konkurrencesvømmer.
                    0: Luk program.""");
            System.out.print("Valg: ");
            if (this.in.hasNextInt()) {
                int userInput = this.in.nextInt();
                if (userInput == 1) {

                    option1();

                } else if (userInput == 2) {

                    System.out.println("Den forventede indkomst = " + controller.calculateIncome() + "kr");

                } else if (userInput == 3) {
                    System.out.println("""
                            Vil du printe liste med motionister eller konkurrencesvømmere?
                            1: Motionister.
                            2: konkurrencesvømmere.""");
                    System.out.print("Valg: ");
                    int choice = in.nextInt();
                    if(choice == 1){
                        System.out.println(controller.printExerciserList());
                    }
                    else if(choice == 2){
                        System.out.println(controller.printCompetitorList());
                    }
                    else
                        System.out.println("Forkert input, returnere til hovedmenu.\n");
                } else if (userInput == 4) {

                    System.out.println("Konkurrencetider");
                    option4();

                } else if (userInput == 5) {
                    ArrayList<String> tournamentInfo = controller.readTournamentInfo();
                    for (int i = 0; i < tournamentInfo.size(); i++) {
                        System.out.println(tournamentInfo.get(i));
                    }
                } else if (userInput == 6) { // Lasse
                    System.out.println("""
                            Vælg hvilken aldersgruppe du vil se Top 5 for?
                            1: Junior Svømmere.
                            2: Senior svømmere.""");
                    int choice = in.nextInt();
                    if (choice == 1) {
                        System.out.println("""
                                Hvilken disciplin ønsker du at se for Junior Svømmere?
                                1: Crawl.
                                2: Rygcrawl.
                                3. Butterfly.
                                4. Brystsvømning.""");
                        int choiceTwo = in.nextInt();
                        if (choiceTwo == 1) {
                            System.out.println(controller.getJuniorTopFiveCrawl());
                        } else if (choiceTwo == 2) {
                            System.out.println(controller.getJuniorTopFiveRygcrawl());
                        } else if (choiceTwo == 3) {
                            System.out.println(controller.getJuniorTopFiveButterfly());
                        } else if (choiceTwo == 4) {
                            System.out.println(controller.getJuniorTopFiveBrystsvømning());
                        } else {
                            System.out.println("Forkert input, returnere til menuen.");
                        }
                    } else if (choice == 2) {
                        System.out.println("""
                                Hvilken disciplin ønsker du at se for Senior Svømmere?
                                1: Crawl.
                                2: Rygcrawl.
                                3. Butterfly.
                                4. Brystsvømning.""");
                        int choiceTwo = in.nextInt();
                        if (choiceTwo == 1) {
                            System.out.println(controller.getSeniorTopFiveCrawl());
                        } else if (choiceTwo == 2) {
                            System.out.println(controller.getSeniorTopFiveRygcrawl());
                        } else if (choiceTwo == 3) {
                            System.out.println(controller.getSeniorTopFiveButterfly());
                        } else if (choiceTwo == 4) {
                            System.out.println(controller.getSeniorTopFiveBrystsvømning());
                        } else {
                            System.out.println("Forkert input, returnere til menuen.");
                        }
                    } else {
                        System.out.println("Forkert input, returnere til menu.");
                    }


                } else if (userInput == 7) {
                    System.out.println("Medlemmer i restance:");
                    System.out.println(controller.getArreas());
                } else if (userInput == 8) {
                    updateCompetitorTime();

                } else if (userInput == 0) {

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

    public void option1() {//Troels & Victor
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilderDeci = new StringBuilder();
        StringBuilder tournamentInfo = new StringBuilder();
        String finalString;
        String finalTournamentInfo;
        int numberOfDisciplines = 0;
        boolean beenInTournament = false;
        boolean isActive = false;
        boolean isValid = false;
        boolean isCompetitor = false;

        System.out.println("Opret nyt medlem");
        in.nextLine();
        System.out.println("Indtast navn: (Hvis efternavn tilføjes er formalia = John_Henriksen)");

        stringBuilder.append(in.nextLine()).append(',');
        tournamentInfo.append(stringBuilder);

        int answer;

        System.out.println("Alder:");
        answer = Integer.parseInt(in.nextLine());
        stringBuilder.append(answer).append(',');
        tournamentInfo.append(answer).append(',');


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

            isValid = false;
            int disciplineAnswer;
            List<String> myList = Arrays.asList("crawl", "butterfly", "brystsvømning", "rygcrawl");
            int myCounter = 0;
            while (myCounter != 4) {
                do {
                    System.out.println("Ønsker medlemmet at svømme " + myList.get(myCounter));
                    System.out.println("""
                            1. Ja
                            2. Nej
                            (Brug tal)""");
                    disciplineAnswer = Integer.parseInt(in.nextLine());
                    answer = disciplineAnswer;
                    if (answer == 1) {
                        isValid = true;
                    } else if (answer == 2) {
                        isValid = true;
                    } else {
                        System.out.println("Ikke gyldigt input");
                    }
                } while (!isValid);

                if (disciplineAnswer == 1) {
                    stringBuilderDeci.append(myList.get(myCounter));
                    stringBuilderDeci.append(',');
                    stringBuilderDeci.append("0.0");
                    stringBuilderDeci.append(',');
                    stringBuilderDeci.append("00-00-0000");
                    stringBuilderDeci.append(',');
                    numberOfDisciplines = numberOfDisciplines + 1;
                } else {

                }
                myCounter++;
            }

            stringBuilder.append(String.valueOf(numberOfDisciplines)).append(',');


            isValid = false;
            do {
                System.out.println("Har medlemmet deltaget i tidligere turneringer?");
                System.out.println("""
                        1. Ja
                        2. Nej
                        (Brug tal)""");
                answer = Integer.parseInt(in.nextLine());
                if (answer == 1) {
                    beenInTournament = true;
                    boolean isDone = false;

                    ArrayList<String> deciList = new ArrayList<>();
                    deciList.add("1. crawl");
                    deciList.add("2. butterfly");
                    deciList.add("3. brystsvømning");
                    deciList.add("4. rygcrawl");
                    do {

                        System.out.println("Vælg disciplin");

                        for (int i = 0; i < deciList.size(); i++) {
                            System.out.println(deciList.get(i));
                        }
                        System.out.println("0. Færdig");

                        answer = Integer.parseInt(in.nextLine());


                        switch (answer) {
                            case 1:
                                System.out.println("Indtast sted");
                                tournamentInfo.append(in.nextLine()).append(',');
                                tournamentInfo.append("crawl").append(',');
                                deciList.remove(0);
                                System.out.println("""
                                        eks. 12.23,12-03-2021
                                        Indtast tid og dato""");
                                tournamentInfo.append(in.nextLine()).append(',');
                                System.out.println("Hvilken placering");
                                tournamentInfo.append(in.nextLine()).append(',');
                                break;

                            case 2:
                                System.out.println("Indtast sted");
                                tournamentInfo.append(in.nextLine()).append(',');
                                tournamentInfo.append("butterfly").append(',');
                                deciList.remove(1);
                                System.out.println("""
                                        eks. 12.23,12-03-2021
                                        Indtast tid og dato""");
                                tournamentInfo.append(in.nextLine()).append(',');
                                System.out.println("Hvilken placering");
                                tournamentInfo.append(in.nextLine()).append(',');
                                break;

                            case 3:
                                System.out.println("Indtast sted");
                                tournamentInfo.append(in.nextLine()).append(',');
                                tournamentInfo.append("brystsvømning").append(',');
                                deciList.remove(2);
                                System.out.println("""
                                        eks. 12.23,12-03-2021
                                        Indtast tid og dato""");
                                tournamentInfo.append(in.nextLine()).append(',');
                                System.out.println("Hvilken placering");
                                tournamentInfo.append(in.nextLine()).append(',');
                                break;

                            case 4:
                                System.out.println("Indtast sted");
                                tournamentInfo.append(in.nextLine()).append(',');
                                tournamentInfo.append("rygcrawl").append(',');
                                deciList.remove(3);
                                System.out.println("""
                                        eks. 12.23,12-03-2021
                                        Indtast tid og dato""");
                                tournamentInfo.append(in.nextLine()).append(',');
                                System.out.println("Hvilken placering");
                                tournamentInfo.append(in.nextLine()).append(',');
                                break;
                            case 0:
                                isDone = true;
                                break;

                        }

                    } while (!isDone);


                    isValid = true;
                } else if (answer == 2) {
                    isValid = true;
                } else {
                    System.out.println("Ikke gyldigt input");
                }
            } while (!isValid);

        }

        stringBuilder.append(beenInTournament);
        stringBuilder.append(',');
        stringBuilder.append(stringBuilderDeci);


        tournamentInfo.replace(tournamentInfo.length() - 1, tournamentInfo.length(), " ");
        finalTournamentInfo = tournamentInfo.toString();

        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), " ");

        finalString = stringBuilder.toString();

        if (isCompetitor) {
            System.out.println(controller.createMemberC(finalString));
            System.out.println(controller.createTournamentInfo(finalTournamentInfo));
        } else {
            System.out.println(controller.createMemberE(finalString));
        }

    }

    public void option4() {//Troels
        int answer;
        boolean isValid = false;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder ekstraBuilder = new StringBuilder();
        String text;
        String textAnswer;
        String finalString;
        ArrayList<String> tournamentInfo = controller.readTournamentInfo();
        ArrayList<String> chosenList = new ArrayList<>();
                in.nextLine();
                System.out.println("Hvem har deltaget i en turnering?");
                System.out.println("(Fulde navn)");

                textAnswer = in.nextLine();

                chosenList = (controller.searchForTournament(textAnswer));

                if(!chosenList.isEmpty()) {
                    System.out.println("Insert int for what competitor you wish to choose");
                    int chooseCompetitorInt = in.nextInt();
                    if (chooseCompetitorInt < 1 || chooseCompetitorInt > chosenList.size()) {
                        System.out.println("Error wrong int");
                    } else{

                    System.out.println("Indtast turnerings informationer");
                    System.out.println("Sted,Disciplin,Tid,Dato,Placering");
                    ekstraBuilder.append(',');
                    ekstraBuilder.append(in.nextLine());

                    stringBuilder.append(ekstraBuilder);

                }
                }else{
                    System.out.println("Ingen match på det navn");
                }




                finalString = stringBuilder.toString();

                tournamentInfo.add(finalString);

                for (int i = 0; i < tournamentInfo.size(); i++) {
                    finalString = tournamentInfo.get(i);
                    controller.createTournamentInfo(finalString);
                }


    }

    public void updateCompetitorTime() {//Victor
        in.nextLine();
        System.out.println("Indtast navnet på det medlem du ønsker at opdatere tiden for:");
        String stringUserInput = in.nextLine();
        ArrayList<String> myList = controller.searchForCompetitor(stringUserInput);
        if (!myList.isEmpty()) {
            for (String myString : myList) {
                System.out.println(myString);
            }
            System.out.println("Indtast tallet for den svømmer du ønsker at vælge:");
            if (in.hasNextInt()) {
                int chooseCompetitorInt = this.in.nextInt();
                if (chooseCompetitorInt < 1 || chooseCompetitorInt > myList.size()) {
                    System.out.println("Error wrong int");
                } else {
                    System.out.println("Hvilken disciplin ønsker du at indtaste tid og dato for?");
                    System.out.println("1: crawl, 2: rygcrawl, 3: brystsvømning, 4: butterfly.");
                    if (in.hasNextInt()) {
                        int disciplineInt = this.in.nextInt();
                        if (disciplineInt < 1 || disciplineInt > 4) {
                            System.out.println("Error wrong int");
                        } else {
                            in.nextLine();
                            System.out.println("Indtast tid i format 0.0 eller 0.00");
                            String stringTime = in.nextLine();
                            System.out.println("Indtast dato i format 00-00-0000");
                            String stringDato = in.nextLine();
                            controller.setCompetitiveTime(chooseCompetitorInt, disciplineInt, stringTime, stringDato);

                        }
                    } else if (in.hasNextLine()) {
                        System.out.println("Wrong input, please try again");
                    }
                }
            } else if (in.hasNextLine()) {
                System.out.println("Wrong input, please try again");
            }
        } else {
            System.out.println("Ingen konkurrencesvømmere fundet, prøv igen");
        }
        controller.clearCache();
    }

}