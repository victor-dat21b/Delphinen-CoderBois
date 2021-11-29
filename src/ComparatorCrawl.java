import java.util.Comparator;



public class ComparatorCrawl implements Comparator<Competitor>  {
    @Override
    public int compare(Competitor o1, Competitor o2) {
        int toReturn = 0;
        if (o1.getCrawlTime() > o2.getCrawlTime()){
            toReturn = -1;
        }else if (o1.getCrawlTime() < o2.getCrawlTime()){
            toReturn = +1;
        }else if (o1.getCrawlTime() == o2.getCrawlTime()){
            toReturn = 0;
        }
        return toReturn;
    }
}




class ComparatorRygcrawl implements Comparator<Competitor> {
    @Override
    public int compare(Competitor o1, Competitor o2) {
        return 0;
    }
}

class ComparatorBryst implements Comparator<Competitor> {
    @Override
    public int compare(Competitor o1, Competitor o2) {
        return 0;
    }
}

class ComparatorButterfly implements Comparator<Competitor> {
    @Override
    public int compare(Competitor o1, Competitor o2) {
        return 0;
    }
}




