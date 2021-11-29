import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Filehandler {

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
        OBS: Vi overwriter for hvert stævne en person har været til. Alle deres gamle stævne tider
        bliver derfor ikke gemt. Hver person har derfor et enkelt "bedste resultat"
        */

        ArrayList<Competitor> myMembers = new ArrayList<>();
        try {
            File myFile = new File("competitors.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String[] data = myReader.nextLine().split(",");
                Competitor myCompetitor = new Competitor(data[0], Integer.parseInt(data[1]), Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                int counterString = 6;
                int counterTime = 7;
                int counterDate = 8;
                for (int i = 0; i != myCompetitor.getAmountTrainingDiscipline(); i++){
                    myCompetitor.setDisciplineTime(data[counterString], data[counterTime], data[counterDate]);
                    counterString = counterString + 3;
                    counterTime = counterTime + 3;
                    counterDate = counterDate + 3;
                }
                if (myCompetitor.getCrawl().size() == 1){
                    myCompetitor.setDisciplineTime("crawl", "00.00", "00-00-0000");
                } else if (myCompetitor.getRygcrawl().size() == 1){
                    myCompetitor.setDisciplineTime("rygcrawl", "00.00", "00-00-0000");
                }else if (myCompetitor.getButterfly().size() == 1){
                    myCompetitor.setDisciplineTime("butterfly", "00.00", "00-00-0000");
                }else if (myCompetitor.getBrystsvømning().size() == 1){
                    myCompetitor.setDisciplineTime("brystsvømning", "00.00", "00-00-0000");
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


    public void writeExerciserFile(){

    }

    public void writeCompetitorFile(){

    }

    public void compareCrawl(){
        //Collections.sort(readCompetitorFile());
    }
}
