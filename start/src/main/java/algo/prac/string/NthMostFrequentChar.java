package algo.prac.string;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NthMostFrequentChar {
  public static void main(String[] args) {
    String s = "aabbb";
    int inputMax = 3;

    Map<Integer, Long> charFreq = s.chars().boxed()
        .collect(Collectors.groupingBy(Function.identity(),
            Collectors.counting()));

    int maxCounter = 1;

    List<Entry<Integer, Long>> l = charFreq.entrySet().stream()
        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList());

    int max = l.get(0).getValue().intValue();

    for (Entry<Integer, Long> entry2 : l) {
      if (entry2.getValue() < max) {
        maxCounter++;
      }
      if (maxCounter == inputMax) {
        System.out.println((char) entry2.getKey().intValue());
        break;
      }
    }

    // s.chars().boxed()
    // .collect(Collectors.groupingBy(Function.identity(),
    // Collectors.counting())).entrySet().stream()
    // .sorted((e1, e2) ->
    // e2.getValue().compareTo(e1.getValue())).distinct().limit(inputMax).skip(inputMax
    // - 1)
    // .forEach(entry -> System.out.println((char) entry.getKey().intValue() + ":" +
    // entry.getValue()));

    // Stream.of(s.chars())
    // .collect(Collectors.groupingBy(Function.identity(),
    // Collectors.counting())).entrySet()
    // .stream().sorted((e1, e2) ->
    // e2.getValue().compareTo(e1.getValue())).distinct().limit(inputMax)
    // .skip(inputMax - 1).findFirst().get().getKey();

    // for (int i = 0; i < s.length(); i++) {
    // if(charFreq.containsKey(s.charAt(i))){
    // charFreq.put(s.charAt(i), charFreq.get(s.charAt(i)+1));
    // }else{
    // charFreq.put(s.charAt(i), 1);
    // }
    // }
    // List<Integer> l = new ArrayList<>();

    // for (Entry entry : charFreq.entrySet()) {
    // l.add((Integer) entry.getValue());
    // }

    // Collections.sort(l);
  }
}
