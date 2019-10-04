package listTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutoListTest extends listTEstMethod {
	public String baseURL = "https://fptplay.vn/";
	String driverPath = "E://geckodriver.exe";
	public WebDriver driver;

	@Override
	void beforeTest() {
		// TODO Auto-generated method stub
		System.out.println("Loading firefox...");
		System.setProperty("webdriver.firefox.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseURL);

	}

	@Test
	public void phimListTest() {
		beforeTest();
		System.out.println("count phim list");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/header/nav/div/ul[2]/li[4]/a")).click();
		WebElement listPhimElements = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/header/nav/div/ul[2]/li[4]/div/ul"));
		listCount(listPhimElements, 4);
		System.out.println("count hbo list");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/header/nav/div/ul[2]/li[3]/a")).click();
		WebElement listHboElements = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/header/nav/div/ul[2]/li[3]/div/ul"));
		listCount(listHboElements, 6);
		driver.close();
	}
	

	@Override
	int listCount(WebElement listElements, int expected) {
		List<WebElement> childElements = listElements.findElements(By.cssSelector("li"));
		System.out.println("number of list Elements: " + childElements.size());
		int count = childElements.size();
		assertEquals(count, expected);
		return count;
	}

	@Override
	void listActiveNameCheck(WebElement listElements, String elementname) {
		// TODO Auto-generated method stub
		List<WebElement> childElements = listElements.findElements(By.cssSelector("li"));
		for (int i = 0; i < childElements.size(); i++) {
			if (childElements.get(i).getText().equals(elementname) && !childElements.get(i).isSelected()) {
				childElements.get(i).click();
				break;
			}
		}
	}
}
