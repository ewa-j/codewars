package SixthKyu;
//https://www.codewars.com/kata/60a54750138eac0031eb98e1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VINChecker {

  static Map<String, Integer> numbers = new HashMap<>();
  static List<Integer> weights = List.of(8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2);
  static List<Integer> multipliedVin = new ArrayList<>();

  public static boolean checkVin(String vin) {

    if (vin.length() != 17 || vin.contains("I") || vin.contains("O") || vin.contains("Q") || !vin.matches("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$")) {
      return false;
    }

    char[] vinArray = vin.toCharArray();
    List<Integer> vinNums = new ArrayList<>();
    populateMap();

    for (char character : vinArray) {
      if (Character.isDigit(character)) {
        vinNums.add(Integer.valueOf(String.valueOf(character)));
      } else if (Character.isLetter(character)) {
        vinNums.add(numbers.get(String.valueOf(character)));
      }
    }

    for (int i = 0; i < weights.size(); i++) {
        multipliedVin.add(weights.get(i) * vinNums.get(i));
    }

    Integer multiplied = multipliedVin.stream().reduce(0, Integer::sum);
    int remainder = multiplied % 11;

    multipliedVin.clear();
    if (remainder == 10 && "X".equals(String.valueOf(vin.charAt(8)))) {
      System.out.println(vin + " should be valid!");
      return true;
    }

    if (String.valueOf(remainder).equals(String.valueOf(vin.charAt(8)))) {
      System.out.println(vin + " should be valid!");
      return true;
    }

    System.out.println(vin + " should be invalid!");
    return false;
  }

  private static void populateMap() {
    numbers.put("A", 1);
    numbers.put("B", 2);
    numbers.put("C", 3);
    numbers.put("D", 4);
    numbers.put("E", 5);
    numbers.put("F", 6);
    numbers.put("G", 7);
    numbers.put("H", 8);
    numbers.put("J", 1);
    numbers.put("K", 2);
    numbers.put("L", 3);
    numbers.put("M", 4);
    numbers.put("N", 5);
    numbers.put("P", 7);
    numbers.put("R", 9);
    numbers.put("S", 2);
    numbers.put("T", 3);
    numbers.put("U", 4);
    numbers.put("V", 5);
    numbers.put("W", 6);
    numbers.put("X", 7);
    numbers.put("Y", 8);
    numbers.put("Z", 9);
  }

}
