import java.util.ArrayList;

public class DolphinDomain {

    FileHandler files = new FileHandler();

    public String creatMemberC(String data){
        return files.writeCompetitorFileTest(data);
    }

    public String creatMemberE(String data){
        return files.writeExerciserFileTest(data);
    }

}
