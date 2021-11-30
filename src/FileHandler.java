import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {

    public ArrayList<Member> readExerciserFile() {
        ArrayList<Member> myMembers = new ArrayList<>();
        try {
            File myFile = new File("Exerciser.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                Member myMember = new Exerciser(data[0], Integer.parseInt(data[1]), Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[3]));
                myMembers.add(myMember);
            }
        } catch (Exception e) {
            System.out.println("Error");
            myMembers = null;
        }
        return myMembers;
    }

    public ArrayList<Competitor> readCompetitorFile() {
        /*
        OBS: Vi overwriter for hver stævne en person har været til. Alle deres gamle stævne tider
        bliver derfor ikke gemt. Vi gemmer kun ét stævne.
        */

        ArrayList<Competitor> myMembers = new ArrayList<>();
        try {
            File myFile = new File("competitors.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                Competitor myCompetitor = new Competitor(data[0], Integer.parseInt(data[1]), Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[3]), Integer.parseInt(data[4]), Boolean.parseBoolean(data[5]));
                int counterString = 6;
                int counterTime = 7;
                int counterDate = 8;
                for (int i = 0; i != myCompetitor.getAmountTrainingDiscipline(); i++) {
                    myCompetitor.setDisciplineTime(data[counterString], Double.parseDouble(data[counterTime]), data[counterDate]);
                    counterString = counterString + 3;
                    counterTime = counterTime + 3;
                    counterDate = counterDate + 3;
                }
                if (myCompetitor.getTournamentCheck()) {
                    int startPlace = counterDate + 1;
                    for (int j = startPlace; j != data.length; j++) {
                        myCompetitor.setTournamentInformation(data[j]); //add information
                    }
                } else {

                }
                myMembers.add(myCompetitor);
            }
        } catch (Exception e) {
            System.out.println("Error");
            myMembers = null;
        }
        return myMembers;
    }

    public ArrayList<String> readTournamentInfo(){
        String[] data = new String[0];
        ArrayList<String> tournamentInfo = new ArrayList<>();
        try{
            File myFile = new File("TournamentInfo.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                data = myReader.nextLine().split(",");
                tournamentInfo.add(Arrays.toString(data));
            }


        }catch (Exception e){
            System.out.println("Noget gik galt");
        }

        return tournamentInfo;
    }


    public String writeExerciserFile(String data) {

        try {
            FileWriter fileWriter = new FileWriter("Exerciser.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine();
            bufferedWriter.write(data);
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Noget gik galt....");
        }

        return "Medlem oprettet!";
    }

    public String writeCompetitorFile(String data) {

        try {
            FileWriter fileWriter = new FileWriter("competitors.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine();
            bufferedWriter.write(data);
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Noget gik galt....");
        }

        return "Medlem oprettet!";
    }



    public void editCompetitorFile(Competitor myCompetitor, String myDiscipline, String stringTime, String stringDato){
        StringBuilder myBuilder = new StringBuilder();
            try {
                File myFile = new File("competitors.csv");
                Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().split(",");
                    if (data[0].equals(myCompetitor.getName()) && Integer.parseInt(data[1]) == myCompetitor.getAge()) {
                        int amountOfDisciplines = myCompetitor.getAmountTrainingDiscipline();
                        int myCounter = 6;
                        boolean changedFlag = false;
                        for (int i = 0; i != amountOfDisciplines; i++) {
                            if (data[myCounter].equals(myDiscipline)) {
                                data[(myCounter+1)] = stringTime;
                                data[(myCounter+2)] = stringDato;
                                myCounter = myCounter +3;
                                changedFlag = true;
                            }else {
                                myCounter = myCounter + 3;
                            }
                            if (!changedFlag) {
                                myBuilder.append(Arrays.toString(data));
                                myBuilder.append(",");
                                myBuilder.append(myDiscipline).append(",").append(stringTime).append(",").append(stringDato);
                                myBuilder.append("\n");
                            }else {
                                myBuilder.append(Arrays.toString(data));
                                myBuilder.append("\n");
                            }

                        }
                    }else {
                        myBuilder.append(Arrays.toString(data));
                        myBuilder.append("\n");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error");
            }

        System.out.println(myBuilder);
        try {
            FileWriter fileWriter = new FileWriter("competitors.csv", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(String.valueOf(myBuilder));


        } catch (Exception e) {
            System.out.println("Noget gik galt....");
        }


        }
    public String writeTournamentInfo(String data){

        try {
            FileWriter fileWriter = new FileWriter("TournamentInfo.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine();
            bufferedWriter.write(data);
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Noget gik galt....");
        }

        return "Fil opdateret!";
    }

}




    }



