import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ChainConsumers {

    public static  void main(String[] args){
      List<String> strings = Arrays.asList("one","two","three","four","five");

      List<String> result = new ArrayList();

      List<String> filtered = new ArrayList();


      Consumer<String> c1 = s -> System.out.println(s);
      Consumer<String> c2 = s -> result.add(s);

      //strings.forEach(c1.andThen(c2));
      //result.forEach(c1);

      Stream<String> stream = strings.stream().filter(item -> item.endsWith("e"));

      stream.forEach(s -> System.out.println(s));

    }
}
