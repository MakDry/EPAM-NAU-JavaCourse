package ua.univer.Task8.Task8_2;

public class StringsMeter {
    private String longest_1 = "";
    private String longest_2 = "";
    private String longest_3 = "";

    public void getResult(String text) {
        getStringsLength(text);
        String[] arr = new String[3];
        arr[0] = longest_1 + " ==> " + longest_1.length();
        arr[1] = longest_2 + " ==> " + longest_2.length();
        arr[2] = longest_3 + " ==> " + longest_3.length();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private void getStringsLength(String text) {
        String[] words = text.split(" ");
        for (var word : words) {
            if (word.length() > longest_3.length()) {
                if (word.length() > longest_2.length()) {
                    if (word.length() > longest_1.length()) {
                        longest_3 = longest_2;
                        longest_2 = longest_1;
                        longest_1 = word;
                    } else {
                        longest_3 = longest_2;
                        longest_2 = word;
                    }
                } else {
                    longest_3 = word;
                }
            }
        }
    }
}
