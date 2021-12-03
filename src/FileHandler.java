import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {

    public ArrayList<Member> readExerciserFile() {//Victor
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

    public ArrayList<Competitor> readCompetitorFile() {//Victor
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
                myMembers.add(myCompetitor);
            }
        } catch (Exception e) {
            System.out.println("Error");
            myMembers = null;
        }
        return myMembers;
    }


    public void editCompetitorFile(Competitor myCompetitor, String myDiscipline, String stringTime, String stringDato){ //Victor
        ArrayList<String> myStrings = new ArrayList<>();
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
                    }
                    if (!changedFlag) {
                        int myAmountOfDescipline = (Integer.parseInt(data[4])+1);
                        data[4] = String.valueOf(myAmountOfDescipline);
                        myStrings.add((Arrays.toString(data)) + "," + myDiscipline + "," + stringTime + "," + stringDato + "]");

                    }else {
                        myStrings.add(Arrays.toString(data));

                    }
                }else {
                    myStrings.add(Arrays.toString(data));
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Error");
        }

        System.out.println(myStrings);
        try {
            FileWriter fileWriter = new FileWriter("competitors.csv", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String i:myStrings) {
                i = i.substring(1, i.length() - 1);
                i = i.replaceAll(" ", "");
                i = i.replaceAll("]", "");
                bufferedWriter.write(i);
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Noget gik galt....");
        }


    }


    public String writeExerciserFile(String data) {//Troels

        try {
            FileWriter fileWriter = new FileWriter("Exerciser.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Noget gik galt....");
        }

        return "Medlem oprettet!";
    }

    public String writeCompetitorFile(String data) {//Troels

        try {
            FileWriter fileWriter = new FileWriter("competitors.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Noget gik galt....");
        }

        return "Medlem oprettet!";
    }


    public ArrayList<String> readTournamentInfo(){//Troels
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


    public void setTournamentInfo(String myCompetitor){//Victor
        ArrayList<String> toWriteCompetitors = new ArrayList<>();
        try {
            String[] myCompetitorData = myCompetitor.split(",");
            File myFile = new File("TournamentInfo.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                if (data[0].equals(myCompetitorData[0]) && (data[1]).equals(myCompetitorData[1])) {
                    toWriteCompetitors.add("[" + myCompetitor);
                }else {
                    toWriteCompetitors.add(Arrays.toString(data));
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }

        try {

            FileWriter fileWriter = new FileWriter("TournamentInfo.csv", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String i:toWriteCompetitors) {
                i = i.substring(1, i.length() - 1);
                i = i.replaceAll(" ", "");
                bufferedWriter.write(i);
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Noget gik galt....");
        }

    }


    public String createTournamentInfo(String data){//Troels

        try {
            FileWriter fileWriter = new FileWriter("TournamentInfo.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Noget gik galt....");
        }

        return "Fil opdateret!";
    }

}