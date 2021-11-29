import java.util.ArrayList;

public class DolphinController {

    DolphinDomain domain = new DolphinDomain();

    public void getMemberList(){

    }

    public String createMember(String name, int age, boolean active, boolean arrears, ArrayList<String> disciplineAndTime){
        return domain.createMember(name, age, active, arrears, disciplineAndTime);

    }

    public String createMember(String data){
        return domain.creatMember(data);
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
