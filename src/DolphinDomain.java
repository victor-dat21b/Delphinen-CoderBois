import java.util.ArrayList;

public class DolphinDomain {

    FileHandler files = new FileHandler();

    public String creatMemberC(String data){
        return files.writeCompetitorFileTest(data);
    }

    public String creatMemberE(String data){
        return files.writeExerciserFileTest(data);
    }
    /*
    public String createMember(String name, int age, boolean active, boolean arrears, ArrayList<String> disciplineAndTime) {//Troels
        if (disciplineAndTime == null) {
            //Motionist
            Exerciser exerciser = new Exerciser(name, age, active, arrears);
            return files.writeExerciserFile(exerciser);
        } else {

            Competitor competitor = new Competitor(name, age, active, arrears, disciplineAndTime.size());
            return files.writeCompetitorFile(competitor);

        }
    }
*/
}
