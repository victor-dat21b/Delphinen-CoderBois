import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class DolphinDomain {
    ArrayList<Competitor> mySorted = new ArrayList<>();
    ArrayList<String> stringSorted = new ArrayList<>();
    FileHandler files = new FileHandler();

    public String creatMemberC(String data) {//Troels
        return files.writeCompetitorFile(data);
    }

    public String creatMemberE(String data) {//Troels
        return files.writeExerciserFile(data);
    }

    public String createTournamentInfo(String data) {//Troels
        return files.createTournamentInfo(data);
    }


    public ArrayList<String> readTournamentInfo() {//Troels
        return files.readTournamentInfo();
    }


    public int calculateIncome() { //Victor
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


    public ArrayList<String> searchForCompetitor(String stringUserInput) { //Victor
        ArrayList<Competitor> myArray = files.readCompetitorFile();
        for (Competitor competitor : myArray) {
            if (competitor.getName().toLowerCase(Locale.ROOT).contains(stringUserInput)) {

                this.mySorted.add(competitor);
            } else {
            }
        }
        ArrayList<String> myStringList = new ArrayList<>();
        int myCounter = 1;
        for (Competitor competitor : mySorted) {
            myStringList.add(myCounter + " : " + competitor.toString());
            myCounter++;
        }
        return myStringList;
    }

    public ArrayList<String> searchForTournament(String stringUserInput) { //Victor
        ArrayList<String> myArray = files.readTournamentInfo();
        for (String string : myArray) {
            if (string.toLowerCase(Locale.ROOT).contains(stringUserInput)) {

                this.stringSorted.add(string);
            } else {
            }
        }
        ArrayList<String> myStringList = new ArrayList<>();
        int myCounter = 1;
        for (String string : stringSorted) {
            myStringList.add(myCounter + " : " + string);
            myCounter++;
        }
        return myStringList;
    }


    public void setCompetitorTime(int chooseCompetitorInt, int disciplineInt, String stringTime, String stringDato) {
        chooseCompetitorInt = chooseCompetitorInt - 1;
        Competitor myCompetitor = this.mySorted.get(chooseCompetitorInt);
        String[] dicipline = {"crawl", "rygcrawl", "brystsv??mning", "butterfly"};
        String myDiscipline = dicipline[(disciplineInt - 1)];
        files.editCompetitorFile(myCompetitor, myDiscipline, stringTime, stringDato);
    }

    public void setTournamentInformation(int chosenInt, String dataToWrite) {
        StringBuilder myBuilder = new StringBuilder();
        String myCompetitor = this.stringSorted.get((chosenInt-1));
        myCompetitor = myCompetitor.substring(1, myCompetitor.length() - 1);
        myCompetitor = myCompetitor.replaceAll(" ", "");
        String[] myCompetitorData = myCompetitor.split(",");
        myBuilder.append(myCompetitorData[0]);
        myBuilder.append(",");
        myBuilder.append(myCompetitorData[1]);
        myBuilder.append(",");
        myBuilder.append(dataToWrite);
        files.setTournamentInfo(myBuilder.toString());
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


    public String getArreas() { //Victor
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

    public String getJuniorTopFiveBrystsv??mning() { // Lasse
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

    public String getSeniorTopFiveBrystsv??mning() { // Lasse
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


    public void clearCache() {
        this.mySorted.clear();
    }

    public void clearCacheTrainingInfo() {
        this.stringSorted.clear();
    }


    public String printExerciserList() { // Lasse
        ArrayList<Member> unsortedExerciser = files.readExerciserFile();
        ArrayList<Member> juniorExerciser = new ArrayList<>();
        ArrayList<Member> seniorExerciser = new ArrayList<>();
        for (Member member : unsortedExerciser)
            if (member.getAge() < 18)
                juniorExerciser.add(member);
            else if (member.getAge() >= 18)
                seniorExerciser.add(member);
        return "Junior Motionist Hold:\n" +
                juniorExerciser +
                "\nSenior Motionist Hold:\n" +
                seniorExerciser;
    }

    public String printCompetitorList() { // Lasse
        ArrayList<Competitor> unsortedCompetitor = files.readCompetitorFile();
        ArrayList<Competitor> juniorCompetitor = new ArrayList<>();
        ArrayList<Competitor> seniorCompetitor = new ArrayList<>();
        for (Competitor member : unsortedCompetitor)
            if (member.getAge() < 18)
                juniorCompetitor.add(member);
            else if (member.getAge() >= 18)
                seniorCompetitor.add(member);
        return "Junior Konkurrencesv??mmer Hold:\n" +
                juniorCompetitor +
                "\nSenior Konkurrencesv??mmer Hold:\n" +
                seniorCompetitor;
    }


}