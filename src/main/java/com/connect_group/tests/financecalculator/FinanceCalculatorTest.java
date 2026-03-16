package com.connect_group.tests.financecalculator;

import com.connect_group.pages.financecalculator.FilterByPage;
import com.connect_group.pages.financecalculator.ModelSelectPage;
import com.connect_group.pages.financecalculator.PersonalisedQuotePage;
import com.connect_group.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FinanceCalculatorTest extends BaseTest {

  private ModelSelectPage modelSelectPage;
  private FilterByPage filterByPage;
  private PersonalisedQuotePage personalisedQuotePage;

  @BeforeEach
  void setupAndNavigateToUrl() {
    modelSelectPage = new ModelSelectPage(driver);
    filterByPage = new FilterByPage(driver);
    personalisedQuotePage = new PersonalisedQuotePage(driver);

    open("https://www.landrover.co.uk/offers-and-finance/finance-calculator.html");
    
  }



  // TODO: Complete the each of the tests under the "Tasks to Complete" section of the README.md
  @Test
  void financeCalculatorModelSelectTest() {

    // Verify Model Select page is loaded
    assertTrue(modelSelectPage.isInitialized());
    filterByPage.acceptCookiesIfPresent();
    // Assert number of vehicle model nameplates displayed
    modelSelectPage.assertNumberOfModelNameplates(9);
  }

  @Test
  void financeCalculatorMonthlyPaymentFlowTest() {

    // Verify Model Select page
    assertTrue(modelSelectPage.isInitialized());
    // Accept Cookies if Present
    filterByPage.acceptCookiesIfPresent();
    // Switch to Monthly Payment tab
    filterByPage.selectMonthlyPaymentTab();
    // Set Monthly Payment to £750
    filterByPage.setMonthlyPaymentTo750(750);

    // Set Deposit to £20,000
    filterByPage.setDepositAmount("20000");

    // Accept values & calculate
    filterByPage.acceptValuesAndCalculate();

    // Verify results page is displayed
    filterByPage.assertResultsDisplayed();
  }

  @Test
  void financeCalculatorChangeVehicleFlowTest() {

    // Step 1: Model select page loaded
    assertTrue(modelSelectPage.isInitialized());
    filterByPage.acceptCookiesIfPresent();
    // Step 2: Select first model
    modelSelectPage.selectModelByIndex(0);
    // Verify Personalised Quote page loaded
    personalisedQuotePage.isInitialized();
    // Step 3: Click Change vehicle
    personalisedQuotePage.clickChangeVehicle();
    // Step 4: Back to Model Select page
    assertTrue(modelSelectPage.isInitialized());
    // Step 5: Select a different model
    modelSelectPage.selectModelByIndex(0);
  }

  @Test
  void changeEngineTest() {

    assertTrue(modelSelectPage.isInitialized());
    modelSelectPage.selectModelByIndex(0);
    filterByPage.acceptCookiesIfPresent();

    assertTrue(personalisedQuotePage.isInitialized());

    // Scroll engine dropdown into view
    personalisedQuotePage.scrollToEngineDropdown();
    // Step 1: Get current engine
    String beforeEngine = personalisedQuotePage.getSelectedEngine();

    // Step 2: Change engine
    personalisedQuotePage.changeEngine();

    // Step 3: Get engine after change
    String afterEngine = personalisedQuotePage.getSelectedEngine();

    // Step 4: Verify engine changed
    assertNotEquals(beforeEngine, afterEngine,
            "Engine should change after selection");
  }

  @Test
  void financeProductTooltipTest() {
    assertTrue(modelSelectPage.isInitialized());
    modelSelectPage.selectModelByIndex(0);
    filterByPage.acceptCookiesIfPresent();
    // Page already navigated via model selection
    assertTrue(personalisedQuotePage.isInitialized());
    // Step 1: Click tooltip icon
    personalisedQuotePage.clickFinanceProductTooltip();
    // Step 2: Verify info popup is shown
    assertTrue(
            personalisedQuotePage.isFinanceProductTooltipDisplayed(),
            "Finance product tooltip popup should be displayed"
    );

  }


}