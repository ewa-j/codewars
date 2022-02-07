import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertIsbn {

  public static String isbnConverter(String isbn) {

    StringBuffer buffer = new StringBuffer(isbn);
    buffer.deleteCharAt(isbn.length() - 1).insert(0, "978-");
    String toAdd = buffer.toString().replaceAll("-", "");

    List<String> toMultiplyString = List.of(toAdd.split(""));
    List<Integer> toMultiplyInts = toMultiplyString.stream().map(Integer::valueOf).collect(Collectors.toList());
    Integer evenIndexedInts = IntStream.range(0, toMultiplyInts.size()).filter(i -> i % 2 == 0)
        .mapToObj(toMultiplyInts::get).reduce(0, Integer::sum);
    Integer oddIndexedInts = IntStream.range(0, toMultiplyInts.size()).filter(i -> i % 2 != 0)
        .mapToObj(i -> toMultiplyInts.get(i)*3).reduce(0, Integer::sum);
    int remainder = (evenIndexedInts+oddIndexedInts) % 10;
    int lastDigit = 10 - remainder;

    if (remainder == 0) {
      lastDigit = 0;
    }

    return String.valueOf(buffer.append(lastDigit));
  }

}
