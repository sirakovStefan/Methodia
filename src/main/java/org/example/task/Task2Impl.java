package org.example.task;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.example.Main.COLON;
import static org.example.Main.EMPTY_STRING;
import static org.example.Main.N_NUMBER_OF_WHITESPACES;
import static org.example.Main.SEMICOLON;

public class Task2Impl implements Task2 {

  private static final String PATTERN_FOR_SPECIAL_SYMBOLS = "[^A-Za-z0-9 ]";

  @Override
  public void executeFirstVersion(Scanner scanner) {
    System.out.println(
        "Task 2.1: Please enter a string to count word occurrence or leave empty for default string...");

    String input = scanner.nextLine().isEmpty() ? "Hello, my name is Stefan. I am a software engineer. "
        + "I am a   software engineer. I am a software engineer.  $  #" : scanner.nextLine();

    System.out.println("Task 2.1 output: " + countWordOccurrence(input) + "\n");

  }

  @Override
  public void executeSecondVersion(Scanner scanner) {
    System.out.println("Task 2.2: Please enter a string to count words or leave empty for default string...");

    String input = scanner.nextLine().isEmpty() ? "Hello, my name is Stefan. I am a software   engineer.  # "
        : scanner.nextLine();

    System.out.println("Task 2.2 output: " + countWords(input) + "\n");
  }

  private static String countWordOccurrence(String input) {
    String[] words =
        input.replaceAll(PATTERN_FOR_SPECIAL_SYMBOLS, EMPTY_STRING).split(N_NUMBER_OF_WHITESPACES);

    Map<String, Integer> wordMap =
        Arrays.stream(words).collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

    StringBuilder sb = new StringBuilder();
    wordMap.forEach((key, value) -> sb.append(key).append(COLON).append(value).append(SEMICOLON));

    return sb.delete(sb.length() - 2, sb.length()).toString();
  }

  private static Integer countWords(String input) {
    String[] words =
        input.replaceAll(PATTERN_FOR_SPECIAL_SYMBOLS, EMPTY_STRING).split(N_NUMBER_OF_WHITESPACES);
    final int[] counter = {0};

    Map<Integer, String> wordMap =
        Arrays.stream(words).collect(Collectors.toMap(word -> counter[0]++, word -> word));

    return wordMap.size();
  }
}
