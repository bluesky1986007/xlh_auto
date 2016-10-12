package test.apptest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.android.AndroidDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


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


	@Test(enabled = true, dataProvider = "inquiryProcess",description="问诊流程")
	public void inquiryProcess(Map<String, String> datadriven)throws Exception {

		driver = Initial.appiumAndroidChuangyeSetUp(driver, datadriven.get("changyeApkName"));

		driver = appCommonService.appLogin(driver,datadriven.get("userName"),datadriven.get("userPassWord"));

		driver.quit();

	}

	@DataProvider(name = "inquiryProcess")
	public Iterator<Object[]> data1test() throws IOException {
		return ExcelProviderByEnv(this, "inquiryProcess");
	}

	@AfterClass
	public void afterClass() {

		// driver.quit();
	}

}
