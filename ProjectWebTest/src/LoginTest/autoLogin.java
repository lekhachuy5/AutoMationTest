package LoginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class autoLogin extends LoginTestMethod {
	public String baseURL = "https://fptplay.vn/";
	String driverPath = "E://geckodriver.exe";
	public WebDriver driver;

	@Override
	void beforeTest() {
		// TODO Auto-generated method stub
		System.out.println("Loading firefox...");
		System.out.println("login Success test");
		System.setProperty("webdriver.firefox.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseURL);
		driver.findElement(By.xpath("//*[@id='dang-nhap']")).click();

	}

	@Test(priority = 1)
	public void verifyLog() {
		beforeTest();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement phone = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[1]/input"));
		phone.sendKeys("0785555772");
		WebElement pass = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[2]/input"));
		pass.sendKeys("154789");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[3]/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/header/nav/div/ul[1]/li[5]/div/div/a/span")).click();

		String actual = driver.findElement(By.xpath("//*[@id='trang-ca-nhan']")).getText();
		String expected = "0785555772";
		AssertJUnit.assertEquals(actual, expected);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/header/nav/div/ul[1]/li[5]/div/ul/li[2]/a")).click();

		driver.close();

	}

	@Test(priority = 2)
	public void verifyLoginFailed1() {
		beforeTest();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[3]/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[2]/div[3]/div/p"))
				.getText();
		String expected = "Xảy ra lỗi trong quá trình đăng nhập!";
		AssertJUnit.assertEquals(actual, expected);
		driver.close();
	}

	@Test(priority = 3)
	public void verifyLoginFailed2() {
		beforeTest();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='phone']")).sendKeys("0785555772");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[3]/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[2]/div[3]/div/p"))
				.getText();
		String expected = "Điện thoại hoặc mật khẩu không đúng!";
		AssertJUnit.assertEquals(actual, expected);
		driver.close();
	}

	@Test(priority = 4)
	public void verifyLoginFailed3() {
		beforeTest();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("154789");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[3]/button"))
				.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[2]/div[3]/div/p"))
				.getText();
		String expected = "Xảy ra lỗi trong quá trình đăng nhập!";
		AssertJUnit.assertEquals(actual, expected);
		driver.close();
	}

	@Test(priority = 5)
	public void verifyLoginFailed4() {
		beforeTest();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("aaaaa");
		driver.findElement(By.xpath("//*[@id='phone']")).sendKeys("00000");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[3]/button"))
				.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[2]/div[3]/div/p"))
				.getText();
		String expected = "Điện thoại hoặc mật khẩu không đúng!";
		AssertJUnit.assertEquals(actual, expected);
		driver.close();
	}

	/*@Test(priority = 6)
	public void verifyAlreadyLogin() {
		beforeTest();
		driver.findElement(By.xpath("//*[@id='dang-nhap']")).click();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://fptplay.vn/dang-nhap";
		AssertJUnit.assertEquals(actualURL, expectedURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement phone = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[1]/input"));
		phone.sendKeys("0785555772");
		WebElement pass = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[2]/input"));
		pass.sendKeys("154789");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div/div[3]/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div/div[2]/div[1]/div/p"))
				.getText();
		String expected = "Tài khoản của bạn đang đăng nhập trên một trình duyệt khác. Vui lòng bấm TIẾP TỤC để đăng xuất trình duyệt cũ và đăng nhập vào trình duyệt mới này.";
		Assert.assertEquals(actual, expected);
		driver.quit();
	}
	*/
}
