import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        JobTitleNormalizer normalizer = new JobTitleNormalizer();

        List<String> inputs = new ArrayList<>();
        inputs.add("Java engineer");
        inputs.add("C# engineer");
        inputs.add("Accountant");
        inputs.add("Chief Accountant");

        List<String> result = normalizer.normalizeList(inputs);

        System.out.println(result);

    }

}
