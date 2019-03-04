import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Utils {
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

        for (int i = 12; i < dataArr.length; i += 11) {
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
}
