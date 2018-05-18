package designs.inhertience.composition;

import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E> {
  private int addCount = 0;

  public InstrumentedSet(Set<E> set) {
    super(set);
  }
}
