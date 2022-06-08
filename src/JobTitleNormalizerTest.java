import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class JobTitleNormalizerTest {

    @Test
    void normalizeList() {
        JobTitleNormalizer normalizer = new JobTitleNormalizer();

        List<String> inputs = new ArrayList<>();
        inputs.add("Java engineer");
        inputs.add("C# engineer");
        inputs.add("Accountant");
        inputs.add("Chief Accountant");

        List<String> result = normalizer.normalizeList(inputs);

        Assertions.assertEquals("Software engineer", result.get(0));
        Assertions.assertEquals("Software engineer", result.get(1));
        Assertions.assertEquals("Accountant", result.get(2));
        Assertions.assertEquals("Accountant", result.get(3));
    }
}
