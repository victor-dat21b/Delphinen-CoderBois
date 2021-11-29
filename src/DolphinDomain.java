import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collections;
import java.util.List;

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



    public void comparecompetitors(){
        ComparatorRygcrawl myCompare = new ComparatorRygcrawl();
        ArrayList<Competitor> myArraylist = files.readCompetitorFile();
        for (Competitor competitor){

        }
        System.out.println(myArraylist);

        System.out.println(myArraylist);



    }


    public static void main(String[] args) {
        new DolphinDomain().comparecompetitors();
    }

}
