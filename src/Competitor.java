import java.util.ArrayList;

public class Competitor extends Member {
    private int amountTrainingDiscipline;
    private boolean booleanTournmanetCheck;
    ArrayList<String> tournamentInformation = new ArrayList<>();
    private double crawlTime = 0.0;
    private double rygCrawlTime = 0.0;
    private double brystsvømningTime = 0.0;
    private double butterflyTime = 0.0;

    private String crawlDate;
    private String rygCrawlDate;
    private String brystsvømningDate;
    private String butterflyDate;

    public Competitor(String name, int age, boolean active, boolean arrears, int trainingDiscipline, boolean booleanTournmanetCheck) {
        super(name, age, active, arrears);
        this.amountTrainingDiscipline = trainingDiscipline;
        this.booleanTournmanetCheck = booleanTournmanetCheck;

    }


    public void setDisciplineTime(String discipline, Double time, String dato) {
        //switch der genkender disciplin type ud fra string og sætter tiden ud fra time
        if (discipline.equalsIgnoreCase("crawl")) {
            this.crawlTime = time;
            this.crawlDate = dato;
        } else if (discipline.equalsIgnoreCase("rygcrawl")) {
            this.rygCrawlTime = time;
            this.rygCrawlDate = dato;
        } else if (discipline.equalsIgnoreCase("brystsvømning")) {
            this.brystsvømningTime = time;
            this.brystsvømningDate = dato;
        } else if (discipline.equalsIgnoreCase("butterfly")) {
            this.butterflyTime = time;
            this.butterflyDate = dato;
        } else {

        }
    }

    public void setTournamentInformation(String info) {
        this.tournamentInformation.add(info);
    }

    public int getAmountTrainingDiscipline() {
        return this.amountTrainingDiscipline;
    }


    public boolean getTournamentCheck() {
        return this.booleanTournmanetCheck;
    }


    public double getCrawlTime() {
        return this.crawlTime;
    }

    public double getRygCrawlTime() {
        return this.rygCrawlTime;
    }

    public double getBrystsvømningTime() {
        return this.brystsvømningTime;
    }

    public double getButterflyTime() {
        return this.butterflyTime;
    }


    @Override
    public String toString() {
        return "Navn = " + super.getName() +
                ". Aktive Discipliner = " + amountTrainingDiscipline +
                ". Antal Turneringer = " + booleanTournmanetCheck +
                ". Crawl = " + this.crawlTime +
                ". Rygcrawl = " + this.rygCrawlTime +
                ". Brystsvømning = " + this.brystsvømningTime +
                ". Butterfly = " + this.butterflyTime + "\n";
    }
}

