package Gun06;

import Utils.GenelWebDriver;
import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Daha önceki derslerde yaptğımız Search fonksiyonunu
 * Mac,ipod ve samsung için Dataprovider ile yapınız.
 */
public class _04_Task_1 extends GenelWebDriver {

    @Test(dataProvider = "getData")
    void searcFunction(String searchText) {

        WebElement searchArea = driver.findElement(By.name("search"));
        searchArea.clear();
        searchArea.sendKeys(searchText);

        WebElement searchBtn = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchBtn.click();

        List<WebElement> elements = driver.findElements(By.cssSelector("h4>a"));

        for (WebElement macs : elements) {
            Assert.assertTrue(macs.getText().toLowerCase().contains(searchText.toLowerCase()));
        }

    }

    @DataProvider
    public Object[] getData() {

        Object[] data = {"Mac", "ipod", "samsung"};

        return data;
    }

}
