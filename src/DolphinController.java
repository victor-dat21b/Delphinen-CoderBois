import java.util.ArrayList;

public class DolphinController {

    DolphinDomain domain = new DolphinDomain();

    public void getMemberList(){

    }

    public String createMember(String name, int age, boolean active, boolean arrears, ArrayList<double[]> disciplineAndTime){
        return domain.createMember(name, age, active, arrears, disciplineAndTime);

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
