import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
//        ArrayList<ElectionResult> results = new ArrayList<>();
//
//        String[] dataArr = splitData(data);
//
//        for (int i = 11; i < data.length())
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
        }

        for (int i = 0; i < data.length(); i++) {
            if (data.substring(i, i + 1).equals("\"")) {
                data = data.substring(0, i) + data.substring(i + 1);
            }
        }

        return data.split(",");
    }
}
