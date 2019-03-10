public class Election2016 {
    private double demVotes;
    private double gopVotes;
    private double totalVotes;
    private String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");

    public Election2016(double demVotes, double gopVotes, double totalVotes){
        this.demVotes = demVotes;
        this.gopVotes = gopVotes;
        this.totalVotes = totalVotes;
    }
}
