package algo.prac.string;

public class Space20 {

  public static void converSpaceto20(String str) {
    // This approach solves easily in java but not in C
    // str = str.replace(" ", "%20");
    // System.out.println(str);
    int spaces = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        spaces++;
      }
    }
    int initialLength = str.length();
    str = str.concat(new String(" ").repeat(spaces * 2));
    int newLength = str.length();

    for (int i = initialLength - 1; i > 0; i--) {
      if (str.charAt(i) == ' ') {
        str = str.substring(0, newLength - 3) + "%20" + str.substring(newLength);
        newLength = newLength - 3;
      } else {
        str = str.substring(0, newLength - 1) + str.charAt(i) + str.substring(newLength);
        newLength--;
      }
    }
    System.out.println("Final: " + str);

  }

  public static void main(String[] args) {
    converSpaceto20("hello world, how are you?");
  }

}
