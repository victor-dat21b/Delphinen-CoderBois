import java.util.ArrayList;

public class DolphinController {

    DolphinDomain domain = new DolphinDomain();


    public String createMemberC(String data){
        return domain.creatMemberC(data);
    }

    public String createMemberE(String data){
        return domain.creatMemberE(data);
    }

    public String createTournamentInfo(String data){
        return domain.writeTournamentInfo(data);
    }

    public ArrayList<String> readTournamentInfo(){
        return domain.readTournamentInfo();
    }

    public Member pickSwimmerFromList(){
        return null;
    }

    public void setTrainingTime(){
    }

    public void clearCache(){
        domain.clearCache();
    }

    public void setCompetitiveTime(int chooseCompetitorInt, int disciplineInt, String stringTime, String stringDato){
        domain.setCompetitorTime(chooseCompetitorInt, disciplineInt, stringTime, stringDato);
    }

    public int calculateIncome(){
        return domain.calculateIncome();
    }

    public String getJuniorTopFiveCrawl(){ // Lasse
        return domain.getJuniorTopFiveCrawl();
    }

    public String getJuniorTopFiveRygcrawl(){ // Lasse
        return domain.getJuniorTopFiveRygcrawl();
    }

    public String getJuniorTopFiveButterfly(){ // Lasse
        return domain.getJuniorTopFiveButterfly();
    }

    public String getJuniorTopFiveBrystsvømning(){ // Lasse
        return domain.getJuniorTopFiveBrystsvømning();
    }

    public String getSeniorTopFiveCrawl(){ // Lasse
        return domain.getSeniorTopFiveCrawl();
    }


    public String getArreas(){
        return domain.getArreas();
    }

    public ArrayList<String> searchForCompetitor(String stringUserInput){
        return domain.searchForCompetitor(stringUserInput);
    }


    public String getSeniorTopFiveRygcrawl(){ // Lasse
        return domain.getSeniorTopFiveRygcrawl();
    }

    public String getSeniorTopFiveButterfly(){ // Lasse
        return domain.getSeniorTopFiveButterfly();
    }

    public String getSeniorTopFiveBrystsvømning(){ // Lasse
        return domain.getSeniorTopFiveBrystsvømning();
    }

}
