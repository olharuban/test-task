package crossover.ATC.test_cases;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by olga on 5/12/16.
 */
public class TestBase {

	public static final String BASE_URL = "https://www.crossover.com/";
	private WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
		}
		return driver;
	}

	@Before
	public void setUp() {
		getDriver();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static class TIMEOUTS {
		public static class SEC {
			public static final int IMPLICITLY = 20;
			public static final int PAGE = 45;
		}
	}



}
