package tests;

import org.testng.annotations.Test;
import utilities.KeywordEngine;

public class KeywordDrivenTest {
    @Test
    public void runKeywordTest() throws Exception {
        String csvPath = "src/test/resources/testdata/KeywordTestCase.csv";
        KeywordEngine engine = new KeywordEngine();
        engine.executeTest(csvPath);
    }
}
