import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    public void getMemberList(){

    }

    public void setSwimmerTime(){

    }

    public ArrayList<Member> readFile(){
        ArrayList<Member> myMembers = new ArrayList<>();
        try {
            File myFile = new File("members.csv");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String[] data = myReader.nextLine().split(",");
                Member myMember = new Exerciser(data[0], Integer.getInteger(data[1]), Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[3]));
                myMembers.add(myMember);
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
