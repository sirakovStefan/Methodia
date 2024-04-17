package org.example.task;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import static org.example.Main.COMMA;

public class Task3Impl implements Task3 {

  @Override
  public void execute(Scanner scanner) {
    List<String> stringList = getInputStringList(scanner);

    System.out.println("Task 3.1 output: " + iterateArrayListUsingWhileLoop(stringList) + "\n");

    System.out.println("Task 3.2 output: " + iterateArrayListUsingForLoop(stringList) + "\n");

  }

  private static List<String> getInputStringList(Scanner scanner) {
    String input;
    System.out.println(
        "Task 3: Please enter a list of strings separated by a comma or leave empty for default list...");

    input = scanner.nextLine().isEmpty() ? "Hello, world, !" : scanner.nextLine();

    List<String> stringList = Arrays.asList(input.split(COMMA));
    return stringList;
  }

  private static String iterateArrayListUsingWhileLoop(List<String> input) {
    ListIterator<String> iterate = input.listIterator();
    StringBuilder sb = new StringBuilder();

    while (iterate.hasNext()) {
      sb.append(iterate.next()).append(COMMA);
    }

    return sb.delete(sb.length() - 2, sb.length()).toString();
  }

  private static String iterateArrayListUsingForLoop(List<String> input) {
    StringBuilder sb = new StringBuilder();

    for (String str : input) {
      sb.append(str).append(COMMA);
    }

    return sb.delete(sb.length() - 2, sb.length()).toString();
  }

}
