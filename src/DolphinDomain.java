import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class DolphinDomain {

    Filehandler files = new Filehandler();
    Member competitor = new Competitor();

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
