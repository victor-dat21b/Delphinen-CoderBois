import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class DolphinDomain {
    ArrayList<Competitor> mySorted = new ArrayList<>();
    FileHandler files = new FileHandler();

    public String creatMemberC(String data) {
        return files.writeCompetitorFileTest(data);
    }

    public String creatMemberE(String data) {
        return files.writeExerciserFileTest(data);
    }


    public int calculateIncome() {
        int incomeCounter = 0;
        ArrayList<Competitor> myCompetitors = files.readCompetitorFile();
        ArrayList<Member> myExercisors = files.readExerciserFile();
        myExercisors.addAll(myCompetitors);
        ArrayList<Member> myMembers = myExercisors; //Redundant but gives visibility to what's happening when reading files and adding them together.
        for (Member member : myMembers) {
            if (member.getActive()) {
                incomeCounter = incomeCounter + 500;
            } else if (member.getAge() < 18) {
                incomeCounter = incomeCounter + 1000;
            } else if (member.getAge() >= 18) {
                if (member.getAge() > 60) {
                    incomeCounter = incomeCounter + 1200;
                } else {
                    incomeCounter = incomeCounter + 1600;
                }
            }
        }
        return incomeCounter;
    }

    public String getArreas() {
        StringBuilder str = new StringBuilder();
        ArrayList<Competitor> myCompetitors = files.readCompetitorFile();
        ArrayList<Member> myExercisors = files.readExerciserFile();
        myExercisors.addAll(myCompetitors);
        ArrayList<Member> myMembers = myExercisors; //Redundant but gives visibility to what's happening when reading files and adding them together.
        for (Member member : myMembers) {
            if (member.getArrears()) {
                str.append(member);
            } else {
            }
        }
        return str.toString();
    }


    public ArrayList<Competitor> sortCompetitorBySenior() { // Lasse
        ArrayList<Competitor> unsortedCompetitor = files.readCompetitorFile();
        ArrayList<Competitor> sortedSenior = new ArrayList<>();
        for (Competitor member : unsortedCompetitor) {
            if (member.getAge() >= 18) {
                sortedSenior.add(member);
            }
        }
        return sortedSenior;
    }

    public ArrayList<Competitor> sortCompetitorByJunior() { // Lasse
        ArrayList<Competitor> unsortedCompetitor = files.readCompetitorFile();
        ArrayList<Competitor> sortedJunior = new ArrayList<>();
        for (Competitor member : unsortedCompetitor) {
            if (member.getAge() < 18) {
                sortedJunior.add(member);
            }
        }
        return sortedJunior;
    }

    public String getJuniorTopFiveCrawl() { // Lasse
        ArrayList<Competitor> juniorSwimmer = sortCompetitorByJunior();
        Collections.sort(juniorSwimmer, new ComparatorCrawl());
        ArrayList<Competitor> topFive = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                topFive.add(juniorSwimmer.get(i));
            }
        } catch (Exception e) {
            return topFive.toString();
        }
        return topFive.toString();
    }

    public String getJuniorTopFiveRygcrawl() { // Lasse
        ArrayList<Competitor> juniorSwimmer = sortCompetitorByJunior();
        Collections.sort(juniorSwimmer, new ComparatorRygcrawl());
        ArrayList<Competitor> topFive = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                topFive.add(juniorSwimmer.get(i));
            }
        } catch (Exception e) {
            return topFive.toString();
        }
        return topFive.toString();
    }

    public String getJuniorTopFiveButterfly() { // Lasse
        ArrayList<Competitor> juniorSwimmer = sortCompetitorByJunior();
        Collections.sort(juniorSwimmer, new ComparatorButterfly());
        ArrayList<Competitor> topFive = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                topFive.add(juniorSwimmer.get(i));
            }
        } catch (Exception e) {
            return topFive.toString();
        }
        return topFive.toString();
    }

    public String getJuniorTopFiveBrystsvømning() { // Lasse
        ArrayList<Competitor> juniorSwimmer = sortCompetitorByJunior();
        Collections.sort(juniorSwimmer, new ComparatorBryst());
        ArrayList<Competitor> topFive = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                topFive.add(juniorSwimmer.get(i));
            }
        } catch (Exception e) {
            return topFive.toString();
        }
        return topFive.toString();
    }

    public String getSeniorTopFiveCrawl() { // Lasse
        ArrayList<Competitor> SeniorSwimmer = sortCompetitorBySenior();
        Collections.sort(SeniorSwimmer, new ComparatorCrawl());
        ArrayList<Competitor> topFive = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                topFive.add(SeniorSwimmer.get(i));
            }
        } catch (Exception e) {
            return topFive.toString();
        }
        return topFive.toString();
    }

    public String getSeniorTopFiveRygcrawl() { // Lasse
        ArrayList<Competitor> SeniorSwimmer = sortCompetitorBySenior();
        Collections.sort(SeniorSwimmer, new ComparatorRygcrawl());
        ArrayList<Competitor> topFive = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                topFive.add(SeniorSwimmer.get(i));
            }
        } catch (Exception e) {
            return topFive.toString();
        }
        return topFive.toString();
    }

    public ArrayList<String> searchForCompetitor(String stringUserInput) {
        ArrayList<Competitor> myArray = files.readCompetitorFile();
        for (Competitor competitor : myArray) {
            if (competitor.getName().toLowerCase(Locale.ROOT).contains(stringUserInput)) {

                this.mySorted.add(competitor);
            } else {
            }
        }
        ArrayList<String> myStringList = new ArrayList<>();
        int myCounter = 0;
        for (Competitor competitor : mySorted) {
            myStringList.add(myCounter + " : " + competitor.toString());
            myCounter++;
        }
        return myStringList;
    }

    public String getSeniorTopFiveButterfly() { // Lasse
        ArrayList<Competitor> SeniorSwimmer = sortCompetitorBySenior();
        Collections.sort(SeniorSwimmer, new ComparatorButterfly());
        ArrayList<Competitor> topFive = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                topFive.add(SeniorSwimmer.get(i));
            }
        } catch (Exception e) {
            return topFive.toString();
        }
        return topFive.toString();
    }

    public String getSeniorTopFiveBrystsvømning() { // Lasse
        ArrayList<Competitor> SeniorSwimmer = sortCompetitorBySenior();
        Collections.sort(SeniorSwimmer, new ComparatorBryst());
        ArrayList<Competitor> topFive = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                topFive.add(SeniorSwimmer.get(i));
            }
        } catch (Exception e) {
            return topFive.toString();
        }
        return topFive.toString();
    }
}





