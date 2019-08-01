package test.apptest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;


import service.AppCommonService;
import service.InitialService;

import common.frame.test.BaseTest;

public class AndroidApk2_3_1 extends BaseTest {

	@Autowired
	private InitialService Initial;
	@Autowired
	private AppCommonService appCommonService;

	private AndroidDriver driver;

	@BeforeClass
	public void beforeClass() {
	}


	@Test(enabled = true, dataProvider = ""+"testData",description="约谈流程")
	public void interviewProcess(Map<String, String> datadriven)throws Exception {

//		driver = Initial.appiumAndroidChuangyeSetUp(driver, datadriven.get("changyeApkName"));
//
//		driver = appCommonService.appLogin(driver,datadriven.get("changyeUserName"),datadriven.get("chuangyePassword"));
		
		//启动投资者app并且登录
		driver = Initial.appiumAndroidFundSetUp(driver, datadriven.get("fundApkName"));
		driver = appCommonService.appLogin(driver,datadriven.get("fundUserName"),datadriven.get("fundPassword"));
		
		//点击进入约谈项目列表
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("一融"))).click();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("更多"))).click();
		
		//选择约谈项目并立即约谈
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name(datadriven.get("interviewProject")))).click();		
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("立即约谈"))).click();
		
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("前往【我的】"))).click();
//		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.id("enter_mine"))).click();		
		driver.quit();
		
		//启动创业者包并且登录
		driver = Initial.appiumAndroidChuangyeSetUp(driver, datadriven.get("changyeApkName"));
		driver = appCommonService.appLogin(driver,datadriven.get("changyeUserName"),datadriven.get("chuangyePassword"));
		
		//接受邀约
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("收到的邀约"))).click();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("接受邀约"))).click();
		
		//确认见过	
		driver.findElement(By.name("待约见")).click();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("确认见过"))).click();
		
		//评价后提交
		appCommonService.commentSubmit(driver, datadriven.get("interviewComments"));
		
		//去创业者app约谈成功页面进行检查
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("已成功"))).click();
		this.checkOfinterviewOrder(driver, datadriven.get("checkDate"));
		
		//检查完毕，返回并退出app
		driver.findElement(By.id("title_back_img")).click();
		appCommonService.appLoginout(driver);
		driver.quit();
		
		
		//再次启动投资者app
		driver = Initial.appiumAndroidFundSetUp(driver, datadriven.get("fundApkName"));
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("我的"))).click();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("我的约谈"))).click();
		
		//去投资者约谈成功页面检查
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.name("已成功"))).click();
		this.checkOfinterviewOrder(driver, datadriven.get("checkDate"));
		
		//评论并且提交
		driver.findElement(By.name("评价")).click();
		appCommonService.commentSubmit(driver, datadriven.get("interviewComments"));
		
		//返回并退出app
		driver.findElement(By.id("title_back_img")).click();
		appCommonService.appLoginout(driver);
		driver.quit();		
		
//		List<WebElement> textFieldsList = driver.findElementsById("yue_tan_start_view");		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	
	/**
	 * 通过当天日期检查是否有约谈成功的订单
	 * @param checkDate
	 */
	public void checkOfinterviewOrder(AndroidDriver driver, String checkDate) {		
		
		String dateString = new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.name(checkDate))).getText();		
		Assert.assertTrue(true, dateString);		
		
	}


	@DataProvider(name = "testData")
	public Iterator<Object[]> data1test() throws IOException {
		return ExcelProviderByEnv(this, "testData");
	}

	@AfterClass
	public void afterClass() {

	}

}
