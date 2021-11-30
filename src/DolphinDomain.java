import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DolphinDomain {

    FileHandler files = new FileHandler();

    public String creatMemberC(String data){
        return files.writeCompetitorFileTest(data);
    }

    public String creatMemberE(String data){
        return files.writeExerciserFileTest(data);
    }



    public int calculateIncome(){
        int incomeCounter = 0;
        ArrayList<Competitor> myCompetitors = files.readCompetitorFile();
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
        ArrayList<Competitor> myCompetitors = files.readCompetitorFile();
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


    public String getTopFive(){
        ArrayList<Competitor> myCompetitors = files.readCompetitorFile();
        System.out.println(myCompetitors);
        Collections.sort(myCompetitors, new ComparatorBryst());
        System.out.println(myCompetitors);
        return "hey";
    }

    }





