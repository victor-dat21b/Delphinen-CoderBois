import java.io.File;
import java.util.ArrayList;

public class DolphinDomain {

    Filehandler files = new Filehandler();

    public void createMember(String name, int age, boolean active, boolean arrears, ArrayList<double[]> disciplineAndTime){
        if(disciplineAndTime == null){
            //Motionist
            System.out.println("Mos");
        }else{
            System.out.println("Comp");
            //Competitor
        }
    }



    public int calculateIncome(){
        int incomeCounter = 0;
        ArrayList<Member> myCompetitors = files.readCompetitorFile();
        ArrayList<Member> myExercisors = files.readExerciserFile();
        myExercisors.addAll(myCompetitors);
        ArrayList<Member> myMembers = myExercisors; //Redundant but gives visibility to what's happening when reading files and adding them together.
        for (Member member:myMembers){
            if (member.getActive()){
                incomeCounter = incomeCounter + 500;
            } else if (member.getAge() < 18){
                incomeCounter = incomeCounter + 1000;
            }else if (member.getAge() >= 18){
                if (member.getAge() > 60){
                    incomeCounter = incomeCounter + 1200;
                } else{
                    incomeCounter = incomeCounter + 1600;
                }
            }
        }
        return incomeCounter;
    }

    public String getArreas(){
        StringBuilder str = new StringBuilder();
        ArrayList<Member> myCompetitors = files.readCompetitorFile();
        ArrayList<Member> myExercisors = files.readExerciserFile();
        myExercisors.addAll(myCompetitors);
        ArrayList<Member> myMembers = myExercisors; //Redundant but gives visibility to what's happening when reading files and adding them together.
        for (Member member:myMembers) {
            if (member.getArrears()) {
                str.append(member);
            } else {
            }
        }
        return str.toString();
        }

    }



