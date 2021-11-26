import java.util.ArrayList;

public class Domainhandler {


    public void createMember(String name, int age, boolean active, boolean arrears, ArrayList<double[]> disciplineAndTime){
        if(disciplineAndTime == null){
            //Motionist
            System.out.println("Mos");
        }else{
            System.out.println("Comp");
            //Competitor
        }
    }

}
