import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class App<T> implements Iterable<T>{

  private Object[] backedDS = null;

  public App(int size) {
    this.backedDS = new Object[size];
  }

  public static void main(String[] args) {
    App<String> x  = new App<>(10);
  }

  @Override
  public Iterator<T> iterator() {
    return new MyIterator<T>();
  }

  private class MyIterator<T> implements Iterator<T> {

    int cursor = 0;

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public T next() {
      return (T) backedDS[cursor++];
    }
  }
}
