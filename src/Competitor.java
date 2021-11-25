import java.util.ArrayList;

public class Competitor extends Member implements Comparable<Competitor>{

    ArrayList disciplineAndTimes = new ArrayList<int[]>();


    @Override
    public int compareTo(Competitor otherCompetitor) {
        return 0;
    }
}
