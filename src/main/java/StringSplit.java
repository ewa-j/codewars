import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class StringSplit {
  public static String[] solution(String s) {

    String[] empty = new String[0];
    if (Objects.equals(s, "")) {
      return empty;
    }
    
    List<String> newList = new ArrayList<>();

    String[] strings = s.split("(?<=\\G.{2})");
    for (String string : strings) {
      if (string.length() != 2) {
        string += "_";
      }
      newList.add(string);
    }

    String[] arr = new String[0];
    return newList.toArray(arr);
  }
}