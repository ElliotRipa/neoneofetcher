import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String asciiSource;

        if(args.length < 1) {

            asciiSource = getAsciiSource();

        } else if(args.length == 1) {

            asciiSource = args[0];

        } else {

            System.out.println("Too many arguments!");
            throw new IllegalArgumentException();

        }

        File[] files = getFiles(asciiSource);
        for(File file : files) {
            ArrayList<String> fileText = readFile(file);

            for (String line : fileText) {
                System.out.println(line);
            }

        }

    }


    public static String getAsciiSource() {
        System.out.println("Where is the ASCII source? ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static File[] getFiles(String source) {
        File currentDir = new File(source);
        return currentDir.listFiles();
    }


    public static ArrayList<String> readFile(File file) {

        try {

            ArrayList<String> output = new ArrayList<>();
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                output.add(reader.nextLine());
            }
            reader.close();
            return output;

        } catch (FileNotFoundException e) {
            System.out.println("No such file exists!");
            e.printStackTrace();
            return null;
        }

    }

}