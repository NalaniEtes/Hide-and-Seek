package org.example;

import java.util.ArrayList;

public class App {

  public static int linearSearch(ArrayList<Fuzzy> fuzzies) {
    for (int i = 0; i < fuzzies.size(); i++) {
      if (fuzzies.get(i).color.equals("gold")) {
        return i;
      }
    }
    return -1;
  }

  public static int binarySearch(ArrayList<Fuzzy> fuzzies) {
    int left = 0;
    int right = fuzzies.size() -1;

    while (left <= right) {
      int mid = (left + right) / 2;
      String midColor = fuzzies.get(mid).color;

      if (midColor.equals("gold")) {
        return mid;
      } else if (midColor.compareTo("gold") < 0) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    FuzzyListGenerator generator = new FuzzyListGenerator(1000);
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

    int testOne = linearSearch(sortedFuzzies);
    int testTwo = binarySearch(sortedFuzzies);
    int testThree = linearSearch(randomFuzzies);
    int testFour = binarySearch(randomFuzzies);

    System.out.println("Linear Search on sorted list: " + testOne);
    System.out.println("Binary Search on sorted list: " + testTwo);
    System.out.println("Linear Search on random list: " + testThree);
    System.out.println("Binary Search on random list: " + testFour);
  }
}
