import java.util.ArrayList;

public class Competitor extends Member implements Comparable<Competitor>{
    private int amountTrainingDiscipline;
    private int amountOfTournaments;
    private ArrayList<String> crawl = new ArrayList<>();
    private ArrayList<String> rygcrawl = new ArrayList<>();
    private ArrayList<String> brystsvømning = new ArrayList<>();
    private ArrayList<String> butterfly = new ArrayList<>();

    public Competitor(String name, int age, boolean active, boolean arrears, int trainingDiscipline, int amountOfTournaments) {
        super(name, age, active, arrears);
        this.amountTrainingDiscipline = trainingDiscipline;
        this.amountOfTournaments = amountOfTournaments;
        crawl.add("crawl");
        rygcrawl.add("rygcrawl");
        brystsvømning.add("brystsvømning");
        butterfly.add("butterfly");
    }


    public void setDisciplineTime(String discipline, String time, String dato){
        //switch der genkender disciplin type ud fra string og sætter tiden ud fra time
        if (discipline.equals(crawl.get(0))){
            crawl.add(time);
            crawl.add(dato);
        } else if (discipline.equals(rygcrawl.get(0))){
            rygcrawl.add(time);
            rygcrawl.add(dato);
        }else if (discipline.equals(brystsvømning.get(0))){
            brystsvømning.add(time);
            brystsvømning.add(dato);
        }else if (discipline.equals(butterfly.get(0))){
            butterfly.add(time);
            butterfly.add(dato);
        } else{

        }
    }

    public int getAmountTrainingDiscipline(){
        return this.amountTrainingDiscipline;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "amountTrainingDiscipline=" + amountTrainingDiscipline +
                ", amountOfTournaments=" + amountOfTournaments +
                ", crawl=" + crawl +
                ", rygcrawl=" + rygcrawl +
                ", brystsvømning=" + brystsvømning +
                ", butterfly=" + butterfly +
                '}';
    }

    @Override
    public int compareTo(Competitor otherCompetitor) {
        return 0;
    }
}
