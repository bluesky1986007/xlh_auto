package service.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import service.AppCommonService;

public class AppCommonServiceImpl implements AppCommonService{

	@Override
	public AndroidDriver appLogin(AndroidDriver driver, String userName, String userPassWord) {
		// TODO Auto-generated method stub
		
		  //wait for 30s
//	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      
	      new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("我的"))).click();
	      new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("请点击登录/注册"))).click();
	      
	      new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.id("login_username"))).sendKeys(userName);
	      driver.findElementById("login_password").sendKeys(userPassWord);
	      
	      driver.findElementByName("立即登录").click();
	      
	      new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.id("mine_user_name")));
				
		  return driver;
	}
	


}
