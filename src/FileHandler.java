import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public ArrayList<Member> readExerciserFile(){
        ArrayList<Member> myMembers = new ArrayList<>();
        try {
            File myFile = new File("Exerciser.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String[] data = myReader.nextLine().split(",");
                Member myMember = new Exerciser(data[0], Integer.parseInt(data[1]), Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[3]));
                myMembers.add(myMember);
            }
        }
        catch (Exception e){
            System.out.println("Error");
            myMembers = null;
        }
        return myMembers;
    }

    public ArrayList<Competitor> readCompetitorFile(){
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
        }
        catch (Exception e){
            System.out.println("Error");
            myMembers = null;
        }
        return myMembers;
    }


    public String writeExerciserFileTest(String data){

        try{
            FileWriter fileWriter = new FileWriter("Exerciser.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine();
            bufferedWriter.write(data);
            bufferedWriter.close();

        }catch (Exception e){
            System.out.println("Noget gik galt....");
        }

        return "Medlem oprettet!";
    }

    public String writeCompetitorFileTest(String data){

        try{
            FileWriter fileWriter = new FileWriter("competitors.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine();
            bufferedWriter.write(data);
            bufferedWriter.close();

        }catch (Exception e){
            System.out.println("Noget gik galt....");
        }

        return "Medlem oprettet!";
    }

}
