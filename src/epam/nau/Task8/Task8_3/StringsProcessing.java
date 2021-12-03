package epam.nau.Task8.Task8_3;

import java.util.Locale;

public class StringsProcessing {
    private String duplicate_1 = null;
    private String duplicate_2 = null;
    private String duplicate_3 = null;

    public void getResult(String text) {
        findDuplicate(text);
        System.out.println(duplicate_1.toUpperCase() + "\n" + duplicate_2.toUpperCase() + "\n" + duplicate_3.toUpperCase());
    }

    private void findDuplicate(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            int j = 0;
            for (int i = j; i < words.length; i++) {
                if (word == words[i]) {
                    if (duplicate_1 == null) {
                        duplicate_1 = word;
                    } else if (duplicate_1 != null & duplicate_2 == null) {
                        duplicate_2 = word;
                    } else if (duplicate_2 != null & duplicate_3 == null) {
                        duplicate_3 = word;
                        return;
                    }
                }
                j++;
            }
        }
    }
}
