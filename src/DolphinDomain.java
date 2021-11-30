import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class DolphinDomain {
    ArrayList<Competitor> mySorted = new ArrayList<>();
    FileHandler files = new FileHandler();

    public String creatMemberC(String data){//Troels
        return files.writeCompetitorFileTest(data);
    }

    public String creatMemberE(String data){//Troels
        return files.writeExerciserFileTest(data);
    }



    public int calculateIncome(){//Victor
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

    public String getArreas(){//Victor
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


    public String getTopFive(){//Victor & Lasse
        ArrayList<Competitor> myCompetitors = files.readCompetitorFile();
        System.out.println(myCompetitors);
        Collections.sort(myCompetitors, new ComparatorBryst());
        System.out.println(myCompetitors);
        return "hey";
    }

    public ArrayList<String> searchForCompetitor(String stringUserInput){
        ArrayList<Competitor>  myArray = files.readCompetitorFile();
        for (Competitor competitor:myArray) {
            if (competitor.getName().toLowerCase(Locale.ROOT).contains(stringUserInput)) {
                this.mySorted.add(competitor);
            } else {
            }
        }
        ArrayList<String> myStringList = new ArrayList<>();
        int myCounter = 0;
        for (Competitor competitor:mySorted){
            myStringList.add(myCounter + " : " + competitor.toString());
            myCounter++;
        }
        return myStringList;
    }

}





