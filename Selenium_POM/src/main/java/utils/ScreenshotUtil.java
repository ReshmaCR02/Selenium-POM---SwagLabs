package utils;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) {
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String path = "screenshots/" + testName + "_" + timestamp + ".png";

	    try {
	        File dest = new File(path);
	        File folder = new File("screenshots");
	        if (!folder.exists()) {
	            folder.mkdirs(); // Create folder if not exist
	        }
	        FileUtils.copyFile(src, dest);  
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return path;
	}
}
