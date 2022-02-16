package SixthKyu;
// https://www.codewars.com/kata/5254bd1357d59fbbe90001ec

public class Sequence {

  public static long getScore(long n) {

    long score = 0;

    if (n == 1) {
      score = 50;
    } else {
      score = (50 + 25*(n-1)) * n;
    }
    return score;
  }
}
