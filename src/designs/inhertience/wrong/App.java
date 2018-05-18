package designs.inhertience.wrong;

import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    InstrtumentedHashSet<String> instrtumentedHashSet = new InstrtumentedHashSet<>();
    instrtumentedHashSet.addAll(Arrays.asList("Snap","Crackle","Pop"));
    System.out.println(instrtumentedHashSet.getAddCount());
  }
}
