package intr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test<T> {
  private void printDuplicates(List<T> li) {

    // li.stream().collect(Collectors.toMap(Function.identity(),
    // Collectors.groupingBy())
    Map<T, Integer> freqMap = new HashMap<>();
    for (T item : li) {
      if (freqMap.get(item) == null) {
        freqMap.put(item, 1);
      } else {
        freqMap.put(item, freqMap.get(item) + 1);
      }
    }

    for (Map.Entry<T, Integer> item : freqMap.entrySet()) {
      if (item.getValue().intValue() > 1) {
        System.out.println(item.getKey());
      }
    }
  }

  public static void main(String[] args) {
    // {
    //   List<String> al = ArrayList<String>();
      
    //   al = al.stream().map(i->i.toUppercase()).collect(Collectors.toList());
    //   }
      
    //   How to test the array index out of bound exception
    //   public void method(){
    //     al= Arraylist<>();
    //   }
      
    //   void_method_indexOUtofBound(){
        
    //   }
    
    
    
    Test t = new Test();
    List<String> strList = new ArrayList<>();
    strList.add("kranthi");
    strList.add("kranthi");
    strList.add("Mohit");
    strList.add("Mohit");
    // t.printDuplicates(strList);

    int[] intArr = { 1, 2, 3, 1, 4, 3 };
    t.printDuplicates(Arrays.stream(intArr).boxed().collect(Collectors.toList()));

    String[] strArr = { "ab", "de", "cd", "ab", "cd" };
    t.printDuplicates(Arrays.stream(strArr).collect(Collectors.toList()));
  }
}