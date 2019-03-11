import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Utils {
    private static final int START_INDEX = 12;
    private static final int INDECES_PER_OBJECT = 11;
    private static final int START_INDEX_EMPLOYMENT = 42;
    private static final int INDECES_PER_OBJECT_EMPLOYMENT = 52;
    private static final int START_INDEX_EDUCATION = 71;
    private static final int INDECES_PER_OBJECT_EDUCATION = 88;
    private static final int START_INDEX_ELECTION = 12;
    private static final int INDECES_PER_OBJECT_ELECTION = 12;

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResult> parseElection2016Results(String data) {
        ArrayList<ElectionResult> results = new ArrayList<>();

        String[] dataArr = splitData(data);

        for (int i = START_INDEX; i < dataArr.length; i += INDECES_PER_OBJECT) {
            double demVotes = Double.parseDouble(dataArr[i]);
            double gopVotes = Double.parseDouble(dataArr[i + 1]);
            double totalVotes = Double.parseDouble(dataArr[i + 2]);
            double perDem = Double.parseDouble(dataArr[i + 3]);
            double perGop = Double.parseDouble(dataArr[i + 4]);
            double diff = Double.parseDouble(dataArr[i + 5]);
            double perPointDiff = Double.parseDouble(dataArr[i + 6]);
            String stateAbrv = dataArr[i + 7];
            String county = dataArr[i + 8];
            int combinedFips = Integer.parseInt(dataArr[i + 9]);

            ElectionResult result = new ElectionResult(demVotes, gopVotes, totalVotes, perDem, perGop, diff, perPointDiff, stateAbrv, county, combinedFips);

            results.add(result);
        }

        return results;
    }

    private static String[] splitData(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (data.substring(i, i + 1).equals("\"")) {
                do {
                    i++;
                    if (data.substring(i, i + 1).equals(",")) {
                        data = data.substring(0, i) + data.substring(i + 1);
                    }
                    if (data.substring(i, i + 1).equals("%")) {
                        data = data.substring(0, i) + data.substring(i + 1);
                    }
                } while (!data.substring(i, i + 1).equals("\""));
                i++;
            }
            if (data.substring(i, i + 1).equals("%")) {
                data = data.substring(0, i) + data.substring(i + 1);
            }
            if (data.substring(i, i + 1).equals("\n")) {
                data = data.substring(0, i) + "," + data.substring(i + 1);
            }
        }

        for (int i = 0; i < data.length(); i++) {
            if (data.substring(i, i + 1).equals("\"")) {
                data = data.substring(0, i) + data.substring(i + 1);
            }
        }

        //System.out.println(data);

        return data.split(",");
    }


    public static ArrayList<Education2016> parseEducation2016(String data) {
        ArrayList<Education2016> results = new ArrayList<>();

        String[] dataArr = splitData(data);

        for (int i = START_INDEX_EDUCATION; i < dataArr.length; i += INDECES_PER_OBJECT_EDUCATION) {
            double noHighSchool = Double.parseDouble(dataArr[i]);
            double onlyHighSchool = Double.parseDouble(dataArr[i + 1]);
            double someCollege = Double.parseDouble(dataArr[i + 2]);
            double bachelorsOrMore = Double.parseDouble(dataArr[i + 3]);

            Education2016 result = new Education2016(noHighSchool, onlyHighSchool, someCollege, bachelorsOrMore);


            results.add(result);
        }

        return results;

    }

    public static ArrayList<Election2016> parseElection2016(String data) {
        ArrayList<Election2016> results = new ArrayList<>();

        String[] dataArr = splitData(data);

        for (int i = START_INDEX_ELECTION; i < dataArr.length; i += INDECES_PER_OBJECT_ELECTION) {
            double demVotes = Double.parseDouble(dataArr[i]);
            double gopVotes = Double.parseDouble(dataArr[i + 1]);
            double totalVotes = Double.parseDouble(dataArr[i + 2]);

            Election2016 result = new Election2016(demVotes, gopVotes, totalVotes);

            results.add(result);
        }

        return results;
    }

    public static ArrayList<Employment2016> parseEmployment2016(String data) {
        ArrayList<Employment2016> results = new ArrayList<>();

        String[] dataArr = splitData(data);

        for (int i = START_INDEX_EMPLOYMENT; i < dataArr.length; i += INDECES_PER_OBJECT_EMPLOYMENT) {
            int totalLaborForce = Integer.parseInt(dataArr[i]);
            int emplyedLaborForce = Integer.parseInt(dataArr[i + 1]);
            int unemployedLaborForce = Integer.parseInt(dataArr[i + 2]);
            double unemployedPercent = Double.parseDouble(dataArr[i + 3]);

            Employment2016 result = new Employment2016(totalLaborForce, emplyedLaborForce, unemployedLaborForce, unemployedPercent);

            results.add(result);
        }
        return results;
    }



}
