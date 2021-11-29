import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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

    public ArrayList<Member> readCompetitorFile() {
        /*
        OBS: Vi overwriter for hver stævne en person har været til. Alle deres gamle stævne tider
        bliver derfor ikke gemt. Vi gemmer kun ét stævne.
        */

        ArrayList<Member> myMembers = new ArrayList<>();
        try {
            File myFile = new File("competitors.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                Competitor myCompetitor = new Competitor(data[0], Integer.parseInt(data[1]), Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[3]), Integer.parseInt(data[4]));
                int counterString = 6;
                int counterTime = 7;
                int counterDate = 8;
                for (int i = 0; i != myCompetitor.getAmountTrainingDiscipline(); i++) {
                    myCompetitor.setDisciplineTime(data[counterString], data[counterTime], data[counterDate]);
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


    public String writeExerciserFile(Exerciser exerciser) {//Troels

        try {
            FileWriter fileWriter = new FileWriter("Exerciser.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String stringInfo = exerciser.getName() +
                    ',' +
                    exerciser.getAge() +
                    ',' +
                    exerciser.getActive() +
                    ',' +
                    exerciser.getArrears() +
                    '\n';


            try {

                bufferedWriter.write(stringInfo);
                bufferedWriter.close();

            } catch (Exception e) {
                System.out.println("Ingen filer tilgængelige");
            }

        } catch (Exception e) {
            System.out.println("Noget gik galt...");
        }

        return "Medlem bliv oprettet!";
    }


    public String writeCompetitorFileTest(String data){

        try{
            FileWriter fileWriter = new FileWriter("competitors.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);
            bufferedWriter.close();

        }catch (Exception e){
            System.out.println("Noget gik galt....");
        }



        return "Medlem oprettet!";
    }

    public String writeCompetitorFile(Competitor competitor) {

        try {
            FileWriter fileWriter = new FileWriter("competitors.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String stringInfo = competitor.getName() +
                    ',' +
                    competitor.getAge() +
                    ',' +
                    competitor.getActive() +
                    ',' +
                    competitor.getArrears() +
                    ',' +
                    competitor.getAmountTrainingDiscipline() +
                    ',' +
                    competitor.getAmountOfTournaments() +
                    '\n';


            try {
                bufferedWriter.write(stringInfo);
                bufferedWriter.close();

            } catch (Exception e) {
                System.out.println("Ingen filer tilgængelige");
            }

        } catch (Exception e) {
            System.out.println("Noget gik galt...");
        }

        return "Medlem bliv oprettet!";
    }


}