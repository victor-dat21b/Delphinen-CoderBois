import java.util.ArrayList;

public class DolphinController {
    private DolphinDomain domain = new DolphinDomain();



    public void getMemberList(){

    }

    public void createMember(String name, int age, boolean active, boolean arrears, ArrayList<double[]> disciplineAndTime){
        domain.createMember(name, age, active, arrears, disciplineAndTime);
    }

    public Member pickSwimmerFromList(){
        return null;
    }

    public void setTrainingTime(){

    }

    public void setCompetitiveTime(){
    }

    public int calculateIncome(){
        return domain.calculateIncome();
    }



    public String getTopFive(){
        return domain.getTopFive();
    }

    public String getArreas(){
        return domain.getArreas();
    }



}
