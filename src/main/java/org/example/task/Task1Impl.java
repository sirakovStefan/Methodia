package org.example.task;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@NoArgsConstructor
public class Task1Impl implements Task1 {

  @Override
  public void execute(Scanner scanner) {
    System.out.println("Task 1: Please enter a string to reverse or leave empty for default string...");

    String defaultString = "Hello world!";
    String input = scanner.nextLine().isEmpty() ? defaultString : scanner.nextLine();

    System.out.println("Task 1 output: " + reverseString(input) + "\n");
  }

  private static String reverseString(String input) {
    StringBuilder reversed = new StringBuilder();

    for (int i = input.length() - 1; i >= 0; i--) {
      reversed.append(input.charAt(i));
    }

    return reversed.toString();
  }

}
