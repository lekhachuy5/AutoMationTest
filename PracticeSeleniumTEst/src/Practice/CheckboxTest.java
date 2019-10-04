package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class CheckboxTest extends MethodBasic {
	public String baseurl = "https://chandanachaitanya.github.io/selenium-practice-site/";
	public String driverPath = "E://geckodriver.exe";
	public WebDriver driver;

	@Test(priority = 1)
	public void chkBoxTricycle() {
		System.out.println("tricycle Checkbox Test");
		beroforeTest();
		WebElement listElements = driver.findElement(By.id("twoWheelVehicles"));
		WebElement elementname = driver.findElement(By.id("tricycle-checkbox"));
		chkBoxTest(listElements, elementname);

	}

	@Test(priority = 2)
	public void chkBoxBycicle() {
		beroforeTest();
		System.out.println("bicycle Checkbox Test");
		WebElement listElements = driver.findElement(By.id("twoWheelVehicles"));
		WebElement elementname = driver.findElement(By.id("bicycle-checkbox"));
		chkBoxTest(listElements, elementname);

	}

	@Test(priority = 3)
	public void chkBoxBike() {
		beroforeTest();
		System.out.println("bike Checkbox Test");
		WebElement listElements = driver.findElement(By.id("twoWheelVehicles"));
		WebElement elementname = driver.findElement(By.id("bike-checkbox"));
		chkBoxTest(listElements, elementname);

	}

	@Test(priority = 4)
	public void chkBoxHatchback() {
		beroforeTest();
		System.out.println("Hatchback Checkbox Test");
		WebElement listElements = driver.findElement(By.id("fourWheelVehicles"));
		WebElement elementname = driver.findElement(By.id("hatchback-checkbox"));
		chkBoxTest(listElements, elementname);
	}
	@Test(priority = 5)
	public void chkBoxSedan() {
		beroforeTest();
		System.out.println("sedan Checkbox Test");
		WebElement listElements = driver.findElement(By.id("fourWheelVehicles"));
		WebElement elementname = driver.findElement(By.id("sedan-checkbox"));
		chkBoxTest(listElements, elementname);
	}
	@Test(priority = 6)
	public void chkBoxvan() {
		beroforeTest();
		System.out.println("van Checkbox Test");
		WebElement listElements = driver.findElement(By.id("fourWheelVehicles"));
		WebElement elementname = driver.findElement(By.id("van-checkbox"));
		chkBoxTest(listElements, elementname);
	}
	@Test(priority = 7)
	public void chkBoxsuv() {
		beroforeTest();
		System.out.println("suv Checkbox Test");
		WebElement listElements = driver.findElement(By.id("fourWheelVehicles"));
		WebElement elementname = driver.findElement(By.id("suv-checkbox"));
		chkBoxTest(listElements, elementname);
	}
	@Test(priority = 8)
	public void chkBoxtruck() {
		beroforeTest();
		System.out.println("truck Checkbox Test");
		WebElement listElements = driver.findElement(By.id("fourWheelVehicles"));
		WebElement elementname = driver.findElement(By.id("truck-checkbox"));
		chkBoxTest(listElements, elementname);
	}

	@Override
	public void beroforeTest() {
		System.out.println("Loading firefox...");
		System.setProperty("webdriver.firefox.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseurl);
	}

	@Override
	void CheckboxtestOn(WebElement listElements, WebElement elementname) {
		List<WebElement> childElements = listElements.findElements(By.tagName("input"));
		String eleN = elementname.getAttribute("Value");
		for (int i = 0; i < childElements.size(); i++) {
			if (childElements.get(i).getAttribute("Value").equals(eleN) && !childElements.get(i).isSelected()) {
				childElements.get(i).click();
				System.out.println("toggle on");
				break;
			}
		}

	}

	@Override
	void CheckboxtestOff(WebElement listElements, WebElement elementname) {
		List<WebElement> childElements = listElements.findElements(By.tagName("input"));
		String eleN = elementname.getAttribute("Value");
		for (int i = 0; i < childElements.size(); i++) {
			if (childElements.get(i).getAttribute("Value").equals(eleN) && childElements.get(i).isSelected()) {
				childElements.get(i).click();
				System.out.println("toggle off");
				break;
			}
		}

	}

	@Override
	public boolean isDisableCheckbox(WebElement listElements, WebElement elementname) {
		List<WebElement> childElements = listElements.findElements(By.tagName("input"));
		String eleN = elementname.getAttribute("Value");
		boolean enable = true;
		for (int i = 0; i < childElements.size(); i++) {
			if (childElements.get(i).getAttribute("Value").equals(eleN)) {
				if (enable == childElements.get(i).isEnabled()) {

					enable = true;
				} else {
					enable = false;
					System.out.println(childElements.get(i).getAttribute("Value") + "is disable");
				}

			}
		}
		return enable;
	}

	@Override
	void chkBoxTest(WebElement listElements, WebElement elementname) {
		boolean enalbe = isDisableCheckbox(listElements, elementname);
		if (enalbe == false) {
			AssertJUnit.assertEquals(true, true);
		} else if (enalbe == true) {
			CheckboxtestOn(listElements, elementname);
			AssertJUnit.assertEquals(elementname.isSelected(), true);
			CheckboxtestOff(listElements, elementname);
			AssertJUnit.assertEquals(elementname.isSelected(), false);
		}

		driver.close();
	}

}
