package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = testName + "_" + timestamp + ".png";
            String destPath = System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName;

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path dest = new File(destPath).toPath();
            Files.createDirectories(dest.getParent());
            Files.copy(srcFile.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);

            return destPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
