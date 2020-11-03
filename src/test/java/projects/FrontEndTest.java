package projects;

import static Frontend.java.pages.Page.openPage;
import static Frontend.java.pages.Page.searchListAndCategoriesVerification;
import static Frontend.java.pages.Page.searchListAndDeliveryCostVerification;
import static org.testng.Reporter.log;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class FrontEndTest {

  @Test(groups = {"warning"})
  @Description("Website reachability")
  @Severity(SeverityLevel.BLOCKER)
  public void webLinkTest(){
    log("This is main link reachability verification");
    openPage("https://www.lieferando.de/en/");
  }

  @Test(groups = {"pass"})
  @Description("Test case 1")
  @Severity(SeverityLevel.NORMAL)
  public void testCaseOne(){
    log("This is restaurants are filtered as expected by selected option verification");
    searchListAndDeliveryCostVerification("https://www.lieferando.de/en/","Mariendorfer Weg 52");
  }

  @Test(groups = {"pass"})
  @Description("Test case 2")
  @Severity(SeverityLevel.NORMAL)
  public void testCaseTwo(){
    log("This is restaurants are filtered as expected by selected option verification");
    searchListAndCategoriesVerification("https://www.lieferando.de/en/","Mariendorfer Weg 52");
  }
}
