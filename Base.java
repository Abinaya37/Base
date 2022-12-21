package com.Base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Lenovo\\eclipse-workspace\\Project\\Driver\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Lenovo\\eclipse-workspace\\Project\\Driver\\chromedriver.exe");

			driver = new FirefoxDriver();

		}
		return driver;
	}

	public static void url(String url) {

		driver.get(url);

	}

	public static String title() {

		String value = driver.getTitle();
		return value;
	}

	public static String currentUrl() {

		String current_Url = driver.getCurrentUrl();
		return current_Url;

	}

	public static void popup(String types) {

		if (types.equalsIgnoreCase("accept")) {

			driver.switchTo().alert().accept();

		} else if (types.equalsIgnoreCase("dismiss")) {

			driver.switchTo().alert().dismiss();

		}

	}

	public static void prompt(String types, String values, WebElement element) {

		element.sendKeys(values);

		if (types.equalsIgnoreCase("accept")) {

			driver.switchTo().alert().accept();
		} else if (types.equalsIgnoreCase("dismiss")) {

			driver.switchTo().alert().dismiss();
		}
	}

	public static void navigate_Url(String navTo) {

		driver.navigate().to(navTo);
	}

	public static void navigate(String values) {

		if (values.equalsIgnoreCase("back")) {

			driver.navigate().back();

		} else if (values.equalsIgnoreCase("forward")) {

			driver.navigate().forward();
		} else if (values.equalsIgnoreCase("refresh")) {

			driver.navigate().refresh();
		}

	}

	public static void manage(String values) {

		if (values.equalsIgnoreCase("maximize")) {

			driver.manage().window().maximize();
		} else if (values.equalsIgnoreCase("minimize")) {

			driver.manage().window().minimize();
		} else if (values.equalsIgnoreCase("fullscreen")) {

			driver.manage().window().fullscreen();
		}

	}

	public static void close() {

		driver.close();
	}

	public static void quit() {

		driver.quit();
	}

	public static void sendValues(WebElement element, String value) {

		element.sendKeys(value);

	}

	public static void click(WebElement element) {

		element.click();

	}

	public static void clear(WebElement element) {

		element.clear();
	}

	public static String get_Text(WebElement element) {

		String text = element.getText();
		return text;

	}

	public static boolean status;

	public static boolean display(WebElement element, String check) {

		if (check.equalsIgnoreCase("isDisplayed")) {

			status = element.isDisplayed();
		} else if (check.equalsIgnoreCase("isEnabled")) {

			status = element.isEnabled();
		} else if (check.equalsIgnoreCase("isSelected")) {

			status = element.isSelected();
		}
		return status;
	}

	public static String get_Cssvalue(WebElement element, String value) {

		String cssValue = element.getCssValue(value);
		return cssValue;

	}

	public static void screenshot(String path) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);

	}

	public static void dropdown_Index(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static void dropdown_Value(WebElement element, String name) {
		Select s = new Select(element);
		s.selectByValue(name);
	}

	public static void dropdown_Text(WebElement element, String text) {

		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void frame_Index(int index) {

		driver.switchTo().frame(index);

	}

	public static void frame_Value(String value) {

		driver.switchTo().frame(value);
	}

	public static void frame_Element(WebElement element) {

		driver.switchTo().frame(element);
	}

	public static void default_Content() {

		driver.switchTo().defaultContent();
	}

	public static void parent_Frame() {

		driver.switchTo().parentFrame();
	}

}
