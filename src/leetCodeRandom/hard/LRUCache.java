package leetCodeRandom.hard;

import java.util.*;

public class LRUCache {

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
  }

  private int capacity;

  private LinkedHashMap<Integer,Integer> cacheMap;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cacheMap = new LinkedHashMap<Integer,Integer>(capacity);
  }

  public int get(int key) {
    Integer value = cacheMap.get(key);
    if(value==null){
      return -1;
    }else{
      this.set(key,value);
    }
    return value;
  }

  public void set(int key, int value) {
    if(cacheMap.get(key) != null){
      cacheMap.remove(key);
    }else if(capacity == cacheMap.size()){
      Iterator<Integer> itr = cacheMap.keySet().iterator();
      itr.next();
      itr.remove();
    }
    cacheMap.put(key,value);
  }
}
