package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelSelectPage extends BasePage {

  public ModelSelectPage(WebDriver driver) {
    super(driver);
  }

  private WebElement getModelSelectNameplateContainer() {
    return until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fc-nameplate__titleContainer")));
  }

  public List<WebElement> getAllNameplates() {
    return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".fc-nameplate__titleContainer")));
  }

  public boolean isInitialized() {
    return getModelSelectNameplateContainer().isDisplayed();
  }

  // locator for "CHOOSE" button under each nameplate
  //TASK 3
  private List<WebElement> getChooseButtons() {
    return until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.cssSelector(".fc-nameplate__content")
    ));
  }


  // TODO: Add methods in to support interacting with the model selection page.
  //TASK 1
  public void assertNumberOfModelNameplates(int expectedCount) {
    int actualCount = getAllNameplates().size();
    assertEquals(
            expectedCount,
            actualCount,
            "Mismatch in number of vehicle model nameplates displayed"
    );
  }

  //TASK 3
  // Select model by index (0-based)
  public void selectModelByIndex(int index) {
    List<WebElement> models = getChooseButtons();
    models.get(index).click();
  }

}
