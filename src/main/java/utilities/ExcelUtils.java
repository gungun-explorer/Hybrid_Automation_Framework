package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelUtils {

    private static InputStream getTestDataStream() {
        InputStream is = ExcelUtils.class.getClassLoader().getResourceAsStream("testdata/LoginData.xlsx");
        if (is != null) return is;

        try {
            File f = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/LoginData.xlsx");
            if (!f.exists()) throw new RuntimeException("Test data file not found: " + f.getAbsolutePath());
            return new FileInputStream(f);
        } catch (Exception e) {
            throw new RuntimeException("Failed to open test data file", e);
        }
    }
}