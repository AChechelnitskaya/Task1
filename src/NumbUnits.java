/**
 * Created by sashachechelnitska on 9/18/17.
 */

import java.io.*;
import java.util.Scanner;

public class NumbUnits {

    public static final String INPUT_PATH = "/Users/sashachechelnitska/INPUT.TXT";
    public static final String OUTPUT_PATH = "/Users/sashachechelnitska/OUTPUT.TXT";

    public static void main(String[] args) throws IOException {
        String data = Scan();
        int count = Count(data);
        String output = Integer.toString(count);
        Write(output);
    }

    public static String Scan() throws FileNotFoundException {
        Scanner in = new Scanner(new File(INPUT_PATH));
        return in.nextLine();
    }

    public static int Count(String line) {
        int k = 0;
        int length = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '1') {
                k++;
            } else {
                if (k > length)
                    length = k;
                k = 0;
            }
        }
        if (k > length)
            return k;
        return length;
    }

    public static void Write(String line) throws IOException {
        try(FileWriter writer = new FileWriter(OUTPUT_PATH, false))
        {
            writer.write(line);
        }
    }
}