import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    public void getMemberList(){

    }

    public void setSwimmerTime(){

    }

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

    public ArrayList<Member> readCompetitorFile(){
        //OBS: Vi overwriter for hver stævne en person har været til. Alle deres gamle stævne tider
        //bliver derfor ikke gemt. Vi gemmer kun ét stævne.
        ArrayList<Member> myMembers = new ArrayList<>();
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
                    counterString = counterString + 2;
                    counterTime = counterTime + 2;
                    counterDate = counterDate + 2;
                }
                System.out.println(myCompetitor);
            }
        }
        catch (Exception e){
            System.out.println("Error");
            myMembers = null;
        }
        return myMembers;
    }

    public void writeFile(){

    }

    public void getTopFive(){

    }

    public void saveMember(Member member){

    }

    public void createMember(String name, int age, boolean active, boolean arrears, ArrayList<int[]> disciplineAndTime){
        if(disciplineAndTime == null){
            //Motionist
        }else{
            //Competitor
        }
    }

    public void calculateIncome(){

    }

    public void calculateArrears(){

    }


}
