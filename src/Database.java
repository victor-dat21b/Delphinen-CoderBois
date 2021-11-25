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
            Scanner myReader = new Scanner(new File("members.csv"));
            while (myReader.hasNextLine()){
                Member myMember = new Exerciser(myReader.next(), myReader.nextInt(), myReader.nextBoolean(), myReader.nextBoolean());
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

    public void createMember(){

    }

    public void calculateIncome(){

    }

    public void calculateArrears(){

    }


}
