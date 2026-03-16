package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FilterByPage extends BasePage {

  public FilterByPage(WebDriver driver) {
    super(driver);
  }

  private WebElement getFilterByToggle() {
    return until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fc-nameplate__titleContainer")));
  }

  public boolean isInitialized() {
    return getFilterByToggle().isDisplayed();
  }

  private WebElement getMonthlyPaymentTab() {
    return until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[text()='MONTHLY PAYMENT']")));
  }

  private WebElement getAcceptAllCookiesButton() {
    return until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[text()='ACCEPT ALL']")));
  }

  private WebElement getMonthlyPaymentSlider() {
    return until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@id='handle_min']")));
  }

  private WebElement getDepositInput() {
    return until(ExpectedConditions.visibilityOfElementLocated(
            By.id("deposit")));
  }

  private WebElement getAcceptValuesButton() {
    return until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[text()='ACCEPT VALUES & CALCULATE']")));
  }

  private List<WebElement> getResultNameplates() {
    return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
            By.cssSelector(".fc-nameplate__titleContainer")));
  }

  public void selectMonthlyPaymentTab() {

    getMonthlyPaymentTab().click();
  }

  public void acceptCookiesIfPresent() {
    try {
      getAcceptAllCookiesButton().click();
    } catch (Exception ignored) {
      // Cookie banner not present
    }
  }

  public void setMonthlyPaymentTo750(int targetAmount) {
    WebElement slider = getMonthlyPaymentSlider();

    // 1. Ensure slider is focused
    slider.click();

    // Slider starts around £250, each arrow = ~£50
    int steps = (targetAmount - 250) / 50;

    for (int i = 0; i < steps; i++) {
      slider.sendKeys(Keys.ARROW_RIGHT);
    }
  }

  public void setDepositAmount(String amount) {
    WebElement deposit = getDepositInput();
    deposit.clear();
    deposit.sendKeys(amount);
  }

  public void acceptValuesAndCalculate() {
    getAcceptValuesButton().click();
      // Wait until results are displayed (up to 90 seconds)
      until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
              By.cssSelector(".fc-nameplate__titleContainer")
      ));
  }

  public void assertResultsDisplayed() {
    List<WebElement> results = getResultNameplates();

    assertTrue(
            results.size() > 0,
            "Expected at least one finance calculator result to be displayed"
    );
  }

}