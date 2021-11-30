import java.util.Comparator;


public class ComparatorCrawl implements Comparator<Competitor> {
    @Override
    public int compare(Competitor o1, Competitor o2) {
        int toReturn = 0;
        if (o1.getCrawlTime() == 0.0) {
            return 1;
        } else if (o2.getCrawlTime() == 0.0) {
            return -1;
        } else if (o1.getCrawlTime() == 0.0 && o2.getCrawlTime() == 0.0) {
            return 0;
        } else if (o1.getCrawlTime() > o2.getCrawlTime()) {
            toReturn = +1;
        } else if (o1.getCrawlTime() < o2.getCrawlTime()) {
            toReturn = -1;
        } else if (o1.getCrawlTime() == o2.getCrawlTime()) {
            toReturn = 0;
        }
        return toReturn;
    }
}


class ComparatorRygcrawl implements Comparator<Competitor> {
    @Override
    public int compare(Competitor o1, Competitor o2) {
        int toReturn = 0;
        if (o1.getRygCrawlTime() == 0.0) {
            return 1;
        } else if (o2.getRygCrawlTime() == 0.0) {
            return -1;
        } else if (o1.getRygCrawlTime() == 0.0 && o2.getRygCrawlTime() == 0.0) {
            return 0;
        } else if (o1.getRygCrawlTime() > o2.getRygCrawlTime()) {
            toReturn = +1;
        } else if (o1.getRygCrawlTime() < o2.getRygCrawlTime()) {
            toReturn = -1;
        } else if (o1.getRygCrawlTime() == o2.getRygCrawlTime()) {
            toReturn = 0;
        }
        return toReturn;
    }
}

class ComparatorBryst implements Comparator<Competitor> {
    @Override
    public int compare(Competitor o1, Competitor o2) {
        int toReturn = 0;
        if (o1.getBrystsvømningTime() == 0.0) {
            return 1;
        } else if (o2.getBrystsvømningTime() == 0.0) {
            return -1;
        } else if (o1.getBrystsvømningTime() == 0.0 && o2.getBrystsvømningTime() == 0.0) {
            return 0;
        }
        if (o1.getBrystsvømningTime() > o2.getBrystsvømningTime()) {
            toReturn = +1;
        } else if (o1.getBrystsvømningTime() < o2.getBrystsvømningTime()) {
            toReturn = -1;
        } else if (o1.getBrystsvømningTime() == o2.getBrystsvømningTime()) {
            toReturn = 0;
        }
        return toReturn;
    }
}

class ComparatorButterfly implements Comparator<Competitor> {
    @Override
    public int compare(Competitor o1, Competitor o2) {
        int toReturn = 0;
        if (o1.getButterflyTime() == 0.0) {
            return 1;
        } else if (o2.getButterflyTime() == 0.0) {
            return -1;
        } else if (o1.getButterflyTime() == 0.0 && o2.getButterflyTime() == 0.0) {
            return 0;
        }
        if (o1.getButterflyTime() > o2.getButterflyTime()) {
            toReturn = +1;
        } else if (o1.getButterflyTime() < o2.getButterflyTime()) {
            toReturn = -1;
        } else if (o1.getButterflyTime() == o2.getButterflyTime()) {
            toReturn = 0;
        }
        return toReturn;
    }
}




