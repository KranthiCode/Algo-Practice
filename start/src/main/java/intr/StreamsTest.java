package intr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsTest {
  public static void main(String[] args) {
    int[] arr = { 2, 5, 6, 7, 8, 9, 5, 2, 7, 8, 9, 9, 9 };
    List<Integer> list = Arrays.stream(arr).boxed().filter(i -> {
      int k = 1;
      try {
        k = i % 2;
      } catch (Exception e) {
        throw new ArithmeticException("some exception");
      }
      return (k == 0);
    }).collect(Collectors.toList());

    // 1
    int sum1 = Arrays.stream(arr).sum();
    // 2
    Integer sum = Arrays.stream(arr).boxed().collect(Collectors.summingInt(Integer::intValue));
    // 3
    Integer sum2 = Arrays.stream(arr).reduce(0, (a, b) -> a + b);
    // 4
    Integer sum3 = Arrays.stream(arr).reduce(0, Integer::sum);
    // 5
    Integer sum4 = Arrays.stream(arr).reduce(0, ArithmaticUtils::add);
    // 6
    Integer sum5 = Arrays.stream(arr).boxed().mapToInt(Integer::intValue).sum();

    List<Book> booksList = new ArrayList<>();
    for (int j = 1; j < 10; j++) {
      booksList.add(new Book("authorSurname" + j, "authorMiddleName" + j, "authorLastName" + j, j,
          j / 2 == 0 ? "Male" : "Female"));
    }

    Map<String, String> a = new HashMap<>();

    // unique surnames in uppercase of the first 15 book authors that are 50 years
    // old or older.
    booksList.stream()
        .filter(book -> book.age >= 50)
        .map(Book::getAuthorSurname)
        .map(String::toUpperCase)
        .distinct()
        .limit(15)
        .collect(Collectors.toList());
    // .forEach(System.out::println);

    // Print out the sum of ages of all female authors younger than 25.
    int k = booksList.stream()
        .filter(book -> (book.gender.equals("Female") && book.age <= 25))
        .map(Book::getAge)
        .reduce(Integer::sum).get();

    Collections.sort(list, (book1, book2) -> book1.compareTo(book2));

    // Only static method can be referenced this way
    Comparator<Book> ageComparator = (b1, b2) -> Integer.compare(b1.age, b2.age);
    Comparator<Book> surnameComparator = (b1, b2) -> b1.getAuthorSurname().compareTo(b2.getAuthorSurname());
    Comparator<Book> ageAndSurnameComparator = ageComparator.thenComparing(surnameComparator);

    Comparator<Book> ageComparator2 = Comparator.comparing(Book::getAge);
    Comparator<Book> ageComparator3 = Comparator.comparing(Book::getAge).reversed();
    Comparator<Book> surnamecComparator2 = Comparator.comparing(Book::getAuthorSurname);
    Comparator<Book> genderComparator = Comparator.comparing(Book::getGender);

    Comparator<Book> ageSurnameGenderComparator = ageComparator2.thenComparing(surnamecComparator2)
        .thenComparing(genderComparator);

    Collections.sort(booksList, ageAndSurnameComparator.reversed());
    Collections.sort(booksList, ageSurnameGenderComparator);

    booksList.sort(ageAndSurnameComparator);

    booksList.sort(
        Comparator.comparing(Book::getAge).thenComparing(Book::getAuthorSurname).thenComparing(Book::getGender));

    booksList.forEach(System.out::println);

    Arrays.sort(arr);
    // This will not work for primitives
    // Arrays.sort(arr, Comparator.reverseOrder());
    Collections.sort(list, Comparator.reverseOrder());

    Comparator.comparingInt(Book::getAge).reversed();

    int max = Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .max(Comparator.comparing(Entry::getValue))
        .get()
        .getKey().intValue();
    System.out.println(max);
  }

  @Override
  public String toString() {
    return "Test []";
  }
}

class ArithmaticUtils {
  public static int add(int a, int b) {
    return a + b;
  }
}

class Book {
  String authorSurname;
  String authorMiddleName;
  String authorLastName;
  int age;
  String gender;

  public Book(String authorSurname, String authorMiddleName, String authorLastName, int age, String gender) {
    this.authorSurname = authorSurname;
    this.authorMiddleName = authorMiddleName;
    this.authorLastName = authorLastName;
    this.age = age;
    this.gender = gender;
  }

  public String getAuthorSurname() {
    return authorSurname;
  }

  public void setAuthorSurname(String authorSurname) {
    this.authorSurname = authorSurname;
  }

  public String getAuthorMiddleName() {
    return authorMiddleName;
  }

  public void setAuthorMiddleName(String authorMiddleName) {
    this.authorMiddleName = authorMiddleName;
  }

  public String getAuthorLastName() {
    return authorLastName;
  }

  public void setAuthorLastName(String authorLastName) {
    this.authorLastName = authorLastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Book [age=" + age + ", authorLastName=" + authorLastName + ", authorMiddleName=" + authorMiddleName
        + ", authorSurname=" + authorSurname + ", gender=" + gender + "]";
  }

}