import java.util.ArrayList;
import java.util.List;

public class JobTitleNormalizer {

    private List<String> normalizedJobTitles = new ArrayList<>();

    public JobTitleNormalizer() {
        normalizedJobTitles.add("Architect");
        normalizedJobTitles.add("Software engineer");
        normalizedJobTitles.add("Quantity surveyor");
        normalizedJobTitles.add("Accountant");
    }

    public List<String> getNormalizedJobTitles() {
        return normalizedJobTitles;
    }

    public void setNormalizedJobTitles(List<String> normalizedJobTitles) {
        this.normalizedJobTitles = normalizedJobTitles;
    }

    public List<String> normalizeList(List<String> inputs){
        List<String> result = new ArrayList<>();
        for (String input : inputs){
            result.add(normalizeJobTitle(input));
        }
        return result;
    }

    public String normalizeJobTitle(String input){
        final String inputLowerCase = input.toLowerCase();
        int score = 0;
        int highScore = 0;
        int termIndex = 0;
        int previousMatchingCharacterIndex = Integer.MIN_VALUE;
        String result = "";

        for (String jobTitle : normalizedJobTitles){
            String jobTitleLowerCase = jobTitle.toLowerCase();
            for (int jobTitleIndex = 0 ; jobTitleIndex < jobTitleLowerCase.length() ; jobTitleIndex++){
                final char jobTitleChar = jobTitleLowerCase.charAt(jobTitleIndex);

                boolean termCharacterMatchFound = false;
                for(termIndex = 0 ; termIndex < inputLowerCase.length() && !termCharacterMatchFound ; termIndex++){
                    final char termChar = inputLowerCase.charAt(termIndex);

                    if (jobTitleChar == termChar){
                        score++;

                        if (previousMatchingCharacterIndex + 1 == termIndex){
                            score += 2;
                        }

                        previousMatchingCharacterIndex = termIndex;
                        termCharacterMatchFound = true;
                    }
                }
            }

            if (score > highScore){
                result = jobTitle;
                highScore = score;
            }

            score = 0;
            previousMatchingCharacterIndex = Integer.MIN_VALUE;
        }

        return result;

    }
}
