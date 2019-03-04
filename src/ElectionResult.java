public class ElectionResult {
    double demVotes, gopVotes, totalVotes, perDem, perGop, diff, perPointDiff;
    String stateAbrv, county;
    int combinedFips;

    public ElectionResult(double demVotes, double gopVotes, double totalVotes, double perDem, double perGop, double diff, double perPointDiff, String stateAbrv, String county, int combinedFips){
        this.demVotes = demVotes;
        this.gopVotes = gopVotes;
        this.totalVotes = totalVotes;
        this.perDem = perDem;
        this.perGop = perGop;
        this.diff = diff;
        this.perPointDiff = perPointDiff;
        this.stateAbrv = stateAbrv;
        this.county = county;
        this.combinedFips = combinedFips;
    }

    public double getDemVotes() {
        return demVotes;
    }

    public void setDemVotes(double demVotes) {
        this.demVotes = demVotes;
    }

    public double getGopVotes() {
        return gopVotes;
    }

    public void setGopVotes(double gopVotes) {
        this.gopVotes = gopVotes;
    }

    public double getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(double totalVotes) {
        this.totalVotes = totalVotes;
    }

    public double getPerDem() {
        return perDem;
    }

    public void setPerDem(double perDem) {
        this.perDem = perDem;
    }

    public double getPerGop() {
        return perGop;
    }

    public void setPerGop(double perGop) {
        this.perGop = perGop;
    }

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public double getPerPointDiff() {
        return perPointDiff;
    }

    public void setPerPointDiff(double perPointDiff) {
        this.perPointDiff = perPointDiff;
    }

    public String getStateAbrv() {
        return stateAbrv;
    }

    public void setStateAbrv(String stateAbrv) {
        this.stateAbrv = stateAbrv;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getCombinedFips() {
        return combinedFips;
    }

    public void setCombinedFips(int combinedFips) {
        this.combinedFips = combinedFips;
    }

    public String toString() {
        return demVotes + " " + gopVotes + " " + totalVotes + " " + perDem + " " + perGop + " " + diff + " " + perPointDiff + " " + stateAbrv + " " + county + " " + combinedFips;
    }
}
