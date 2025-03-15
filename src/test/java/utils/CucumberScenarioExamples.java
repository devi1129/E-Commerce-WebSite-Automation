package utils;
import java.util.List;
import java.util.Map;

public class CucumberScenarioExamples {

    private static List<Map<String, String>> dynamicExamples;

    public static void setExamples(List<Map<String, String>> examples) {
        dynamicExamples = examples;
    }

    public static List<Map<String, String>> getExamples() {
        return dynamicExamples;
    }
}
