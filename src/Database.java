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
        ArrayList<Member> myMembers = new ArrayList<>();
        try {
            File myFile = new File("Competitor.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String[] data = myReader.nextLine().split(",");
                Competitor myCompetitor = new Competitor(data[0], Integer.parseInt(data[1]), Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[3]), Integer.parseInt(data[4]));
                if (myCompetitor.getAmountDiscipline() == 1){

                }else if(myCompetitor.getAmountDiscipline() == 2){

                }else if(myCompetitor.getAmountDiscipline() == 3){

                }else if(myCompetitor.getAmountDiscipline() == 4){

                }
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
