package designs.initialization_on_demand;

//https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
public class Something {

  private Something(){}

  private static class LazyHolder{
    static {
      System.out.println("Getting init");
    }

    static final Something INSTANCE = new Something();
  }

  public static Something getSomething(){
      return LazyHolder.INSTANCE;
  }
}
