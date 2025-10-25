package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
  @Test
  public void testBinarySearchSorted() {
    FuzzyListGenerator generator = new FuzzyListGenerator(1000);
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();

    int index = App.binarySearch(sortedFuzzies);

    assertTrue(index >= 0 && index < sortedFuzzies.size());
    assertEquals("gold", sortedFuzzies.get(index).color);
  }

  @Test
  public void testLinearSearchRandom() {
    FuzzyListGenerator generator = new FuzzyListGenerator(1000);
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

    int index = App.linearSearch(randomFuzzies);

    assertTrue(index >= 0 && index < randomFuzzies.size());
    assertEquals("gold", randomFuzzies.get(index).color);
  }

  @Test
  public void testBinarySearchRandom() {
    FuzzyListGenerator generator = new FuzzyListGenerator(1000);
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

    int index = App.binarySearch(randomFuzzies);

    if (index != -1) {
      assertEquals("gold", randomFuzzies.get(index).color);
    } else {
      assertEquals(-1, index);
    }
  }
}
