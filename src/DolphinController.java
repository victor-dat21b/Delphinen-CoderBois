import java.util.ArrayList;

public class DolphinController {

    Database database = new Database();

    public void getMemberList(){

    }

    public void createMember(String name, int age, boolean active, boolean arrears, ArrayList<double[]> disciplineAndTime){
        database.createMember(name, age, active, arrears, disciplineAndTime);

    }

    public Member pickSwimmerFromList(){
        return null;
    }

    public void setTrainingTime(){

    }

    public void setCompetitiveTime(){

    }

    public void getTopFive(){

    }



}
