package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PersonalisedQuotePage extends BasePage {

  public PersonalisedQuotePage(WebDriver driver) {
    super(driver);
  }

  //TASK 3
  // Change vehicle CTA
  private WebElement getChangeVehicleButton() {
    return until(ExpectedConditions.elementToBeClickable(
            By.cssSelector(".fc-vehicle-change-block__container a")
    ));
  }
  //TASK 4
  // Page header (stable identifier)
  private WebElement getPersonaliseQuoteHeader() {
    return until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h1[contains(text(),'PERSONALISE QUOTE')]")
    ));
  }
  //TASK 5
  // Locator for tool tip button
  private WebElement getFinanceProductTooltipIcon() {
    return until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("i.fc-tooltip-button-icon__tooltipIcon")
    ));
  }
  //TASK 5
  // Locator for tool tip content
  private WebElement getFinanceProductTooltipPopup() {
    return until(ExpectedConditions.visibilityOfElementLocated(
            By.id("switcher-button-PCP")
    ));
  }


  //TASK 3
  public void clickChangeVehicle() {
    getChangeVehicleButton().click();
  }

  //TASK 4
  public boolean isInitialized() {
    return getPersonaliseQuoteHeader().isDisplayed();
  }


  //TASK 4
  public String getSelectedEngine() {
    return until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.id("dropdown__button-engines")
            )
    ).getText().trim();
  }


  //TASK 4
  public void changeEngine() {

    WebElement dropdown = until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.id("dropdown__button-engines")
            )
    );
    // Scroll with offset (important for sticky header)
    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});", dropdown
    );

    // Click using JS to bypass header interception
    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", dropdown
    );

    // Get engine options
    List<WebElement> options = until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.cssSelector("#dropdown__list-engines button[role='option']")
            )
    );
    // Click second engine
    options.get(0).click();
  }

  /*
  public void changeEngine() {

    // Open engine dropdown
    until(ExpectedConditions.elementToBeClickable(
            By.id("dropdown__button-engines")
    )).click();
    // Get engine options
    List<WebElement> options = until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.cssSelector("#dropdown__list-engines button[role='option']")
            )
    );
    // Click second engine (index 1)
    options.get(0).click();
  }*/

  //TASK 4
  public void scrollToEngineDropdown() {
    WebElement engineDropdown = until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.id("dropdown__button-engines")
            )
    );

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", engineDropdown);
  }

  //TASK 5
  //Action Method for Click Tooltip
  public void clickFinanceProductTooltip() {
    getFinanceProductTooltipIcon().click();
  }
  //TASK 5
  //Action Method for information displayed
  public boolean isFinanceProductTooltipDisplayed() {

    return getFinanceProductTooltipPopup().isDisplayed();
  }



}
