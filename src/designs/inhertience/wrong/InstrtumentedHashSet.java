package designs.inhertience.wrong;

import java.util.Collection;
import java.util.HashSet;

public class InstrtumentedHashSet<E> extends HashSet {

  private static final long serialVersionUID = -2883373342977520522L;

  private int addCount = 0;

  public InstrtumentedHashSet() {
  }

  public InstrtumentedHashSet(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor);
  }

  @Override
  public boolean add(Object o) {
    addCount++;
    return super.add(o);
  }

  @Override
  public boolean addAll(Collection c) {
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }
}
