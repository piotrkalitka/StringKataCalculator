package pl.piotrkalitka;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KataCalc {

    private final String DEFAULT_DELIMITER = ",";

    public static void main(String[] args) {
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String numbersString;
        if (hasCustomDelimiters(input)) {
            String delimitersString = input.substring(2).split("\n")[0];

            numbersString = input.substring(2).split("\n", 2)[1];
            numbersString = this.unifyDelimiters(numbersString, extractDelimiters(delimitersString));
        } else {
            numbersString = input;
        }

        numbersString = this.replaceNewLinesWithDelimiter(numbersString);
        this.validate(numbersString);

        List<Integer> ints = extractInts(numbersString);

        this.checkNegativeNumbers(ints);
        ints = this.skipGreaterThan1000(ints);

        return this.sum(ints);
    }

    private void validate(String string) {
        String phrase = DEFAULT_DELIMITER + DEFAULT_DELIMITER;
        if (string.contains(phrase)) {
            throw new IllegalArgumentException("Format of given string is invalid");
        }
    }

    private List<String> extractDelimiters(String delimiters) {
        return Arrays.asList(delimiters
                .replace("[", "")
                .replace("]", " ")
                .split(" "));
    }

    private String unifyDelimiters(String numbers, List<String> delimiters) {
        if (delimiters.size() > 0) {
            for (String delimiter : delimiters) {
                numbers = numbers.replace(delimiter, DEFAULT_DELIMITER);
            }
        }
        return numbers;
    }

    private List<Integer> extractInts(String string) {
        return Arrays
                .stream(string.split(DEFAULT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean hasCustomDelimiters(String string) {
        return string.startsWith("//");
    }

    private String replaceNewLinesWithDelimiter(String string) {
        return string.replaceAll("\n", DEFAULT_DELIMITER);
    }

    private void checkNegativeNumbers(List<Integer> numbers) {
        List<Integer> negatives = numbers
                .stream()
                .filter(integer -> integer < 0)
                .toList();

        if (negatives.size() > 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + negatives);
        }
    }

    private List<Integer> skipGreaterThan1000(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(integer -> integer <= 1000)
                .collect(Collectors.toList());
    }

    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

}
