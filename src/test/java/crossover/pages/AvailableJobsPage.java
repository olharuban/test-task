package crossover.pages;

import crossover.ATC.test_cases.TestBase;
import crossover.utilities.wrapper.CustomButton;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static crossover.utilities.WebElementExtension.waitForWebElementVisibility;

/**
 * Created by olga on 5/12/16.
 */
public class AvailableJobsPage {

	public static final String URL = TestBase.BASE_URL + "x/#/marketplace/available-jobs";
	public static final String SELECT_CATEGORY_LOCATOR = "//a[contains(@class,'ui-select-choices')]//span[text()=''{0}'']";
	public static final String MENU_TAB_LOCATOR = "//*[text()=''{0}'']";

	public enum AvailableJobsMenuTab {
		TALENT("Talent"),
		SOCIAL_MISSION("Social Mission"),
		COMPANIES("Companies"),
		ABOUT_US("About Us"),
		CONTACT("Contact"),
		LOGIN("Login");

		private String tabName;

		private AvailableJobsMenuTab(String tabName) {
			this.tabName = tabName;
		}

		public String getTabName() {
			return this.tabName;
		}
	}

	public enum JobCategory {
		ALL_JOB_CATEGORIES("All Job Categories"),
		JAVA("Java"),
		//TODO: create values for all categories
		OTHER("Other");

		private String categoryName;

		private JobCategory(String categoryName) {
			this.categoryName = categoryName;
		}

		public String getCategoryName() {
			return this.categoryName;
		}

	}

	@FindBy(xpath = "//button[text()='SEARCH JOBS']")
	CustomButton submitSearch;

	@FindBy(id = "available-jobs")
	WebElement availableJobsTable;

	@FindBy(css = "[placeholder='Job title, keywords']")
	WebElement searchKeywords;

	@FindBy(xpath = "//*[@class='ng-scope lock-overlay-transparent']")
	WebElement blockedTable;

	@FindBy(xpath = "//div[@class='cell title ng-binding']")
	List<WebElement> resultTitles;

	@FindBy(xpath = "//button[text()='RESET']")
	WebElement reset;

	@FindBy(xpath = "//span[contains(@ng-if, 'data.currentFilter.label')]")
	WebElement filterCategory;

	@FindBy(xpath = "//span[@ng-if='data.currentFilter.title']")
	WebElement filterKeywords;

	@FindBy(xpath = ".//job-label-select//span[@class='ng-binding ng-scope']")
	WebElement selectedCategory;

	@FindBy(tagName = "job-label-select")
	WebElement selectCategoryField;

	WebDriver driver;

	public AvailableJobsPage(WebDriver driver) {
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
		this.driver = driver;
	}

	public void open() {
		driver.get(URL);
	}

	public boolean isUrlOpen() {
		return driver.getCurrentUrl().equals(URL);
	}

	public boolean isAvailableJobsTablePresent() {
		return waitForWebElementVisibility(driver, availableJobsTable, true);
	}

	public void typeSearchKeywords(String keywords) {
		searchKeywords.click();
		searchKeywords.sendKeys(keywords);
	}

	public void search() {
		submitSearch.click();
	}

	public ArrayList<String> getResultTitles() {
		ArrayList<String> resultTitlesList = new ArrayList<String>();
		for (WebElement result : resultTitles) {
			resultTitlesList.add(result.getText());
		}
		return resultTitlesList;
	}

	public void resetSearchResult() {
		reset.click();
	}

	public String getFilterByKeywords() {
		return filterKeywords.getText().split("\"")[1];
	}

	public void searchForJobCategory(JobCategory category) {
		selectCategoryField.click();
		final String category_locator = MessageFormat.format(SELECT_CATEGORY_LOCATOR, category.getCategoryName());
		driver.findElement(By.xpath(category_locator)).click();
	}

	public String getFilterByCategory() {
		return filterCategory.getText().split("\"")[1];
	}

	public String getSelectedCategory() {
		return selectedCategory.getText();
	}

	public void selectTab(AvailableJobsMenuTab tab) {
		final String tabLocator = MessageFormat.format(MENU_TAB_LOCATOR, tab.getTabName());
		driver.findElement(By.xpath(tabLocator)).click();
	}
}
