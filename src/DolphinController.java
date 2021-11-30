import java.util.ArrayList;

public class DolphinController {
    DolphinDomain domain = new DolphinDomain();

    public void getMemberList(){

    }

    public String createMemberC(String data){
        return domain.creatMemberC(data);
    }

    public String createMemberE(String data){
        return domain.creatMemberE(data);
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
