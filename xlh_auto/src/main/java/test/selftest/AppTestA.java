package test.selftest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import common.frame.test.BaseTest;

import service.InitialService;

public class AppTestA extends BaseTest{

	  @Autowired
	  private InitialService Initial;
	  	  
	  public AndroidDriver driver;
	  public String changyeApkNameString="EasyrongChuangye2_1.apk";
	  public String fundApkNameString="EasyrongFund2_1.apk";
	  

  @BeforeClass
  public void beforeClass(){
	  
  }
  
  @Test(enabled=true)
  public void testa(){

	  
  }
  
  @Test(enabled=false)
  public void demo() throws MalformedURLException {
	  
	  this.driver = Initial.appiumAndroidFundSetUp(driver,this.fundApkNameString);
	  
//	  this.driver = Initial.appiumAndroidChuangyeSetUp(driver,changyeApkNameString);
	  
	   //wait for 5s
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
//      WebElement ui = driver.findElementByName("");
//      ui.click();
//      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
//      WebElement ui1 = driver.findElementByName("");
//      ui1.click();
      
      new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("�ҵ�"))).click();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      driver.quit();
 
	  
  }
  

  @AfterClass
  public void afterClass() {
	  
  }


}
