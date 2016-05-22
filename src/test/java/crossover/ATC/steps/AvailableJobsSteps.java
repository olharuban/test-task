package crossover.ATC.steps;

import crossover.ATC.ErrorMessages;
import crossover.pages.AvailableJobsPage;
import org.openqa.selenium.WebDriver;

import java.text.MessageFormat;

import static crossover.ATC.ErrorMessages.*;
import static org.junit.Assert.*;

/**
 * Created by olga on 5/13/16.
 */
public class AvailableJobsSteps {

	private AvailableJobsPage availableJobsPage;

	public AvailableJobsSteps(WebDriver driver) {
		availableJobsPage = new AvailableJobsPage(driver);
	}

	public void verifyPageOpen() {
		assertTrue(PAGE_SHOULD_BE_OPEN + availableJobsPage.getClass().getSimpleName(), availableJobsPage.isUrlOpen());
		assertTrue(AVAILABLE_JOBS_TABLE_SHOULD_BE_PRESENT, availableJobsPage.isAvailableJobsTablePresent());
	}

	public void searchForKeyword(String keyword) {
		availableJobsPage.typeSearchKeywords(keyword);
		availableJobsPage.search();
	}

	public void verifyJobTitlesContainsKeywords(String keywords) {
		for (String title : availableJobsPage.getResultTitles()) {
			if (!title.contains(keywords)) {
				fail(MessageFormat.format(ErrorMessages.SEARCH_RESULT_SHOULD_CONTAIN_KEYWORDS, title, keywords));
			}
		}
	}

	public void verifySearchFilterByKeywords(String keywords) {
		assertEquals(WRONG_FILTER_FOR_KEYWORDS, keywords, availableJobsPage.getFilterByKeywords());
	}

	public void resetSearchResult() {
		availableJobsPage.resetSearchResult();
	}

	public void searchForJobCategory(AvailableJobsPage.JobCategory category) {
		availableJobsPage.searchForJobCategory(category);
	}

	public void verifyCategoryIsSelected(String category) {
		assertEquals(WRONG_SELECTED_CATEGORY, category, availableJobsPage.getSelectedCategory());
		assertEquals(WRONG_FILTER_FOR_CATEGORY, category, availableJobsPage.getFilterByCategory());
	}

	public void selectMenuTab(AvailableJobsPage.AvailableJobsMenuTab menuTab) {
		availableJobsPage.selectTab(menuTab);
	}
}
