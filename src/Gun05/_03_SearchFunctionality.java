package Gun05;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/*
       Senaryo ;
       1- Siteyi açınız.
       2- mac kelimeini göndererek aratınız.
       3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
       4- aynı işlemi samsung için de yapınız
     */
public class _03_SearchFunctionality extends GenelWebDriver {
@Test
@Parameters("arananKelime")
    void searcFunction(String searchText)

{

    WebElement searchArea = driver.findElement(By.name("search"));
    searchArea.sendKeys(searchText);

    WebElement searchBtn = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
    searchBtn.click();

    List<WebElement> elements=driver.findElements(By.cssSelector("h4>a"));

    for (WebElement macs:elements)
    {
        Assert.assertTrue(macs.getText().toLowerCase().contains(searchText.toLowerCase()));
    }

}
}
