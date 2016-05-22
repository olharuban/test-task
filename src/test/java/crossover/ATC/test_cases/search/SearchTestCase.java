package crossover.ATC.test_cases.search;


import crossover.ATC.steps.AvailableJobsSteps;
import crossover.ATC.steps.HomePageSteps;
import crossover.ATC.test_cases.TestBase;
import crossover.pages.HomePage;
import org.junit.Test;

import static crossover.pages.AvailableJobsPage.AvailableJobsMenuTab;
import static crossover.pages.AvailableJobsPage.JobCategory;

/**
 * Created by olga on 5/12/16.
 */
public class SearchTestCase extends TestBase {

	private AvailableJobsSteps availableJobsSteps = new AvailableJobsSteps(getDriver());
	private HomePageSteps homePageSteps = new HomePageSteps(getDriver());

	@Test()
	public void generalTestCase() {
		final String searchKeyword = "Chief";

		homePageSteps.openHomePage();
		homePageSteps.verifyPageOpen();
		homePageSteps.selectMenuTab(HomePage.MenuTab.JOBS);
		availableJobsSteps.verifyPageOpen();

		availableJobsSteps.searchForKeyword(searchKeyword);
		availableJobsSteps.verifySearchFilterByKeywords(searchKeyword);
		availableJobsSteps.verifyJobTitlesContainsKeywords(searchKeyword);
		availableJobsSteps.resetSearchResult();
		availableJobsSteps.verifyPageOpen();

		availableJobsSteps.searchForJobCategory(JobCategory.JAVA);
		availableJobsSteps.verifyCategoryIsSelected(JobCategory.JAVA.getCategoryName());
		availableJobsSteps.verifyJobTitlesContainsKeywords(JobCategory.JAVA.getCategoryName());
		availableJobsSteps.resetSearchResult();
		availableJobsSteps.verifyPageOpen();

		availableJobsSteps.selectMenuTab(AvailableJobsMenuTab.COMPANIES);
		homePageSteps.verifyPageOpen();
	}

}
