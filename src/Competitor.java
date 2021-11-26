import java.util.ArrayList;

public class Competitor extends Member implements Comparable<Competitor>{
    private int amountDiscipline;
    private double crawl;
    private double rygcrawl;
    private double brystsvømning;
    private double butterfly;

    public Competitor(String name, int age, boolean active, boolean arrears, int discipline) {
        super(name, age, active, arrears);
        this.amountDiscipline = discipline;
    }


    public void setDisciplineTime(String discipline, double time){
        //switch der genkender disciplin type ud fra string og sætter tiden ud fra time
    }

    public int getAmountDiscipline(){
        return this.amountDiscipline;
    }

    @Override
    public int compareTo(Competitor otherCompetitor) {
        return 0;
    }
}
