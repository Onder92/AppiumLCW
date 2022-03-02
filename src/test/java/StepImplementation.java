import com.google.common.collect.ImmutableMap;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class StepImplementation extends BaseTest{

    Wait wait=new FluentWait(appiumDriver);
    Logger logger= LogManager.getLogger(StepImplementation.class);

    @Step("<time> saniye bekle")
    public void waitForSeconds(int time) throws InterruptedException{
        Thread.sleep(time*1000);
        logger.info("Bekleme yapildi");
    }
    @Step("id'li <id> elemente tıkla")
    public void clickById(String id){

        appiumDriver.findElement(By.id(id)).click();
        logger.info("id'li elemente tiklandi");
    }

    @Step("xpath'li <xpath> elemente tıkla")
    public void clickByXpath(String xpath){

        appiumDriver.findElement(By.xpath(xpath)).click();
        logger.info("xpath'li elemente tiklandi");
    }

    @Step("id'li <id> elementi bul ve <text> değerini yaz")
    public void sendKeysById(String id, String text){

        appiumDriver.findElement(By.id(id)).sendKeys(text);
        logger.info("id'li elemente text degeri yazildi");
    }

    @Step("Android klavyeden arama tuşuna bas")
    public void clickSearchButtonOnAndroid(){
        ((JavascriptExecutor) appiumDriver).executeScript("mobile: performEditorAction", ImmutableMap.of("action","search"));
        logger.info("Android klavyede arama tusuna basildi");
    }

    @Step("xpath'li <xpath> liste içerisinden rastgele seç ve tıkla")
    public void clickRandomXpath(String xpath){
        Random random=new Random();
        List<MobileElement> products=appiumDriver.findElements(By.xpath(xpath));
        int index= random.nextInt(products.size());
        products.get(index).click();
        logger.info("Rastgele tiklama yapildi");
    }

    @Step("id'li <id> elementi bul ve text <text> alanını kontrol et")
    public void textAreaControl(String id, String text){
        Assert.assertTrue("Element degeri dogru",appiumDriver.findElement(By.id(id)).getText().contains(text));
        System.out.println("Sayfa baglantisi dogru");
        logger.info("Baglanti dogru");
    }

    @Step("Sayfayı kaydir <x> <y> <endX> <endY> <duration>")
    public void scrollDown(int startX, int startY, int endX, int endY, int msDuration) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(msDuration)))
                .moveTo(PointOption.point(endX, endY))
                .release();
        touchAction.perform();
        logger.info("Asagi kaydirma yapıldı");
    }
}

