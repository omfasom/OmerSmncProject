package Frontend.java.pages;

import static Frontend.java.utils.CustomFunctions.chromeDriverProperty;

import java.util.List;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Page {

  public static String openPage(String url) {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\Somunoem\\Downloads\\chromedriver_win32\\chromedriver (2).exe");
    WebDriver driver = new ChromeDriver();
    driver.get(url);
    return url;
  }

  @SneakyThrows
  public static String searchListAndDeliveryCostVerification(String url, String searchTerm) {
    chromeDriverProperty();
    WebDriver driver = new ChromeDriver();
    driver.get(url);
    WebElement searchField = driver.findElement(By.xpath("//input[@id='imysearchstring']"));
    searchField.click();
    searchField.clear();
    searchField.sendKeys(searchTerm);
    Thread.sleep(3000);
    searchField.sendKeys(Keys.ENTER);
    List<WebElement> linkElements = driver.findElements(By.xpath("//div[@id='irestaurantlist']"));
    System.out.println("The number of links under URL is: " + linkElements.size());
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/label[1]/a[3]")));
    WebElement element = driver.findElement(
        By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/label[1]/a[3]"));
    Actions actions = new Actions(driver);
    actions.click(element);
    String selectedDelivery = element.getAttribute("data-value");
    Assert.assertTrue(selectedDelivery.equalsIgnoreCase("[0,1]"));
    System.out.println(selectedDelivery);
    String deliveryCost = driver.findElement(
        By.xpath("//body/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[3]"))
        .getText();
    if (deliveryCost.matches("FREE|0,50 €|1,00 €")){
      System.out.println("Delivery is in expected range! ");
    } else{
      System.out.println("Delivery is not in right range! ");
    }
    return searchTerm;
  }

  @SneakyThrows
  public static String searchListAndCategoriesVerification(String url, String searchTerm) {
    chromeDriverProperty();
    WebDriver driver = new ChromeDriver();
    driver.get(url);
    WebElement searchField = driver.findElement(By.xpath("//input[@id='imysearchstring']"));
    searchField.click();
    searchField.clear();
    searchField.sendKeys(searchTerm);
    Thread.sleep(3000);
    searchField.sendKeys(Keys.ENTER);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/a[8]/span[1]")));
    driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/a[8]/span[1]")).click();
    driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[4]/div[1]/div[36]/div[2]/div[2]/span[1]")).getText().startsWith("Italian");
    return  searchTerm;
  }



}
