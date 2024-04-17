package org.example;

import org.example.task.Task1;
import org.example.task.Task1Impl;
import org.example.task.Task2;
import org.example.task.Task2Impl;
import org.example.task.Task3;
import org.example.task.Task3Impl;
import org.example.task.Task4;
import org.example.task.Task4Impl;
import org.example.task.Task5;
import org.example.task.Task5Impl;

import java.util.Scanner;

public class Main {

  public static final String N_NUMBER_OF_WHITESPACES = "\\s+";
  public static final String COMMA = ", ";
  public static final String EMPTY_STRING = "";
  public static final String SEMICOLON = "; ";
  public static final String COLON = ": ";
  public static final String APOSTROPHE = "'";

  private static final Task1 task1 = new Task1Impl();
  private static final Task2 task2 = new Task2Impl();
  private static final Task3 task3 = new Task3Impl();
  private static final Task4 task4 = new Task4Impl();
  private static final Task5 task5 = new Task5Impl();

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    task1.execute(scanner);

    task2.executeFirstVersion(scanner);

    task2.executeSecondVersion(scanner);

    task3.execute(scanner);

    task4.execute(scanner);

    task5.execute(scanner);

  }

}
