import java.util.ArrayList;

/***
 * Main class for Data Parser
 * @author: Marc Corfmat
 */

public class Main {
    public static void main(String[] args) {
        String dataEducation = Utils.readFileAsString("data/Education.csv");
        String dataEmploy = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String dataElect = Utils.readFileAsString("data/Unemployment.csv");

//        ArrayList<ElectionResult> results = Utils.parseElection2016Results(data);
//        System.out.println(results.toString());

        ArrayList<Election2016> resultElection = Utils.parseElection2016(dataElect);
        ArrayList<Employment2016> resultEmployment = Utils.parseEmployment2016(dataEmploy);
        ArrayList<Education2016> resultEducation = Utils.parseEducation2016(dataEducation);
        ArrayList<Integer> fips = Utils.getFips();
        ArrayList<String> names = Utils.getCountyNames();

        ArrayList<County> counties = Utils.sortResultsCounty(names, fips, resultElection, resultEducation, resultEmployment);

        ArrayList<State> states = Utils.setStates(counties);

        DataManager allData = new DataManager(states);
    }
}
