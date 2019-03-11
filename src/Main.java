import java.util.ArrayList;

/***
 * Main class for Data Parser
 * @author: Marc Corfmat
 */

public class Main {
    public static void main(String[] args) {
        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");

        ArrayList<ElectionResult> results = Utils.parseElection2016Results(data);
        System.out.println(results.toString());


    }
}
