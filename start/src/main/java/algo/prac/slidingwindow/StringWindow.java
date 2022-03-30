package algo.prac.slidingwindow;

//*This is not working */
public class StringWindow {

  // Given two strings, one big string and one small string,
  // find the smallest window in the big string that contains all
  // characters of the small string
  // window can have additional characters than required.
  // if small string has duplicates, then those duplicates must
  // be present with the smae or higher count in window

  public static void main(String[] args) {
    // This is not working, implement it later
    smallestWindow("hello", "elk");

  }

  public static void smallestWindow(String s, String p) {
    // Array as a freq map
    int[] fp = new int[256];
    int[] fs = new int[256];

    for (char c : s.toCharArray()) {
      fp[c]++;
    }

    // sliding window algo
    int cnt = 0;
    int start = 0; // left contraction
    int start_idx = -1; // start_idx for best window
    int min_so_far = Integer.MAX_VALUE;
    int window_size;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      fs[ch]++;

      // count how many characters have been matched till now (string and pattern)
      if (fp[ch] != 0 && fs[ch] <= fp[ch]) {
        cnt += 1;
      }

      // if all characters of the pattern are found in the current window then you can
      // start contracting
      if (cnt == p.length()) {
        // start contracting from left to remove unwanted characters - not present in
        // pattern or freq is higher than required
        while (fp[s.charAt(start)] == 0 || fs[s.charAt(start)] > fp[s.charAt(start)]) {
          fs[s.charAt(start)]--;
          start++;
        }

        // note the window size
        window_size = i - start + 1;
        if (window_size < min_so_far) {
          min_so_far = window_size;
          start_idx = start;
        }
      }
    }
    if (start_idx == -1) {
      System.out.println("No window found");
    } else {
      System.out.println(s.substring(start_idx + 1, start_idx + min_so_far + 1 + 1));
    }
  }

}
