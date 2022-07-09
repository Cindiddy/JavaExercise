package myStream;
import java.util.ArrayList;
import java.util.stream.Stream;
/*
There are two arraylists for female actors and male actors.
I will use stream to filter the two arraylist and then concatenate them.
Then I will print the elements.
 */
public class StreamTest {
    public static void main(String[] args) {
        ArrayList<String> femaleActors=new ArrayList<>();
        femaleActors.add("Drew Barrymore");
        femaleActors.add("Alicia Vikander");
        femaleActors.add("Katharine Hepburn");
        femaleActors.add("Meryl Streep");
        femaleActors.add("Audrey Hepburn");
        femaleActors.add("Jane Fonda");

        ArrayList<String> maleActors=new ArrayList<>();
        maleActors.add("Tom Hanks");
        maleActors.add("Arnold Schwarzenegger");
        maleActors.add("Bruce Willis");
        maleActors.add("Brad Pitt");
        maleActors.add("Owen Wilson");
        maleActors.add("Mel Gibson");

        //get first 4 female actors
        Stream<String> stream1 = femaleActors.stream().limit(4);

        //get male actor whose name starts with letter B
        Stream<String> stream2 = maleActors.stream().filter(s -> s.startsWith("B"));

        //concatenate two streams together
        Stream<String> stream = Stream.concat(stream1, stream2);

        //Construct the actor object with the element after the operation
        // in the previous step as the parameter of the constructor，and then traverse
        stream.map(Actor::new).forEach(a-> System.out.println(a.getName()));

        System.out.println("--------------------------");
        //we can put all previous steps together
        Stream.concat(femaleActors.stream().limit(4),
                maleActors.stream().filter(s -> s.startsWith("B"))).map(Actor::new).
                forEach(a-> System.out.println(a.getName()));
    }
}
