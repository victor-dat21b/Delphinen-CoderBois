import java.util.ArrayList;

public class DolphinDomain {

    FileHandler files = new FileHandler();

    public String createMember(String name, int age, boolean active, boolean arrears, ArrayList<double[]> disciplineAndTime){//Troels
        if(disciplineAndTime == null){
            //Motionist
            Exerciser exerciser = new Exerciser(name, age, active, arrears);
            return files.writeExerciserFile(exerciser);
        }else{
            System.out.println("Comp");
            //Competitor
        }
        return "Intet medlem blev sendt over";
    }

}
