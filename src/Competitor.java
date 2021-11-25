import java.util.ArrayList;

public class Competitor extends Member implements Comparable<Competitor>{
    ArrayList<int[]> disciplineAndTimes;

    public Competitor(String name, int age, boolean active, boolean arrears, ArrayList<int[]> disciplineAndTime) {
        super(name, age, active, arrears);
        this.disciplineAndTimes = disciplineAndTime;
    }


    @Override
    public int compareTo(Competitor otherCompetitor) {
        return 0;
    }
}
