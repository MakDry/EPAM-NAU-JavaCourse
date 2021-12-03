package epam.nau.Task8.Task8_1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsProcessing {

    private String fileString;
    private String firstName = null;
    private String secondName = null;
    private String thirdName = null;
    private int firstMatch = 2;
    private int secondMatch = 1;
    private int thirdMatch = 0;
    private String birdPattern = "bird";
    private String applePattern = "apple";
    private String snowPattern = "snow";
    private String summerPattern = "summer";
    private String sunPattern = "sun";
    private String hopePattern = "hope";

    public StringsProcessing(String fileString) {
        this.fileString = fileString;
    }

    public void processing(){
        matchWordSummer();
        matchWordSnow();
        matchWordSun();
        matchWordHope();
        matchWordBird();
        matchWordApple();

        String[] arr = new String[3];
        arr[0] = firstName + " ==> " + firstMatch;
        arr[1] = secondName + " ==> " + secondMatch;
        arr[2] = thirdName + " ==> " + thirdMatch;
        Arrays.sort(arr);
        for (int i = 2; i > -1; i--) {
            System.out.println(arr[i]);
        }
    }

    private void setPlace(String word, int match){
        if (match > thirdMatch){
            if (match > secondMatch){
                if (match > firstMatch){
                    thirdMatch = secondMatch;
                    thirdName = secondName;
                    secondMatch = firstMatch;
                    secondName = firstName;
                    firstMatch = match;
                    firstName = word;
                } else {
                    thirdMatch = secondMatch;
                    thirdName = secondName;
                    secondMatch = match;
                    secondName = word;
                }
            } else {
                thirdMatch = match;
                thirdName = word;
            }
        }
    }

    private void matchWordHope() {
        Matcher matcher = Pattern.compile(hopePattern).matcher(fileString);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        setPlace("Hope", matches);
    }

    private void matchWordSun() {
        Matcher matcher = Pattern.compile(sunPattern).matcher(fileString);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        setPlace("Sun", matches);
    }

    private void matchWordSnow() {
        Matcher matcher = Pattern.compile(snowPattern).matcher(fileString);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        setPlace("Snow", matches);
    }

    private void matchWordApple() {
        Matcher matcher = Pattern.compile(applePattern).matcher(fileString);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        setPlace("Apple", matches);
    }

    private void matchWordBird() {
        Matcher matcher = Pattern.compile(birdPattern).matcher(fileString);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        setPlace("Bird", matches);
    }

    private void matchWordSummer() {
        Matcher matcher = Pattern.compile(summerPattern).matcher(fileString);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        setPlace("Summer", matches);
    }
}
