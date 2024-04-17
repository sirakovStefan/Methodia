package org.example.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.Main.APOSTROPHE;
import static org.example.Main.COLON;
import static org.example.Main.EMPTY_STRING;
import static org.example.Main.N_NUMBER_OF_WHITESPACES;
import static org.example.Main.SEMICOLON;

public class Task4Impl implements Task4 {

  @Override
  public void execute(Scanner scanner) {
    System.out.println(
        "Task 4: Please enter a string to find duplicate characters or leave empty for default string...");

    String input = scanner.nextLine().isEmpty() ? "Hello, my name is Stefan. I am a software engineer."
        : scanner.nextLine();

    System.out.println("Task 4 output: " + findDuplicateCharacters(input) + "\n");
  }

  private static String findDuplicateCharacters(String input) {
    Map<Character, Integer> characterCount = new HashMap<>();
    char[] characters = input.replaceAll(N_NUMBER_OF_WHITESPACES, EMPTY_STRING).toCharArray();

    for (char c : characters) {
      characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
    }

    StringBuilder sb = new StringBuilder();
    characterCount.entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .forEach(entry -> sb.append(APOSTROPHE).append(entry.getKey()).append(APOSTROPHE).append(COLON)
            .append(entry.getValue()).append(SEMICOLON));

    return sb.delete(sb.length() - 2, sb.length()).toString();
  }

}
