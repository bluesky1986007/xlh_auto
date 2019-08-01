package service.impl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import service.InitialService;

public class InitialServiceImpl implements InitialService{
	
	  private String chuangyeAppPackage;
	  private String chuangyeAppActivity;
	  private String fundAppPackage;
	  private String fundAppActivity;
	  
	  private String platformVersion;
	  private String url;

	@Override
	public AndroidDriver appiumAndroidChuangyeSetUp(AndroidDriver driver, String apkName) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		 File classpathRoot = new File(System.getProperty("user.dir"));
		 File appDir = new File(classpathRoot, "apps");
		 File app = new File(appDir, apkName);
		 
		 DesiredCapabilities capabilities = new DesiredCapabilities();		 
		 capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		 capabilities.setCapability("platformName", "Android");	
		 capabilities.setCapability("deviceName", "Android Emulator");
		 
//		 capabilities.setCapability("deviceName","device");
//		 capabilities.setCapability("automationName","Appium");
		 
	     capabilities.setCapability("unicodeKeyboard" ,"True");

	     capabilities.setCapability("resetKeyboard", "True");

         capabilities.setCapability("noReset", true);   
		 
		 capabilities.setCapability("platformVersion", platformVersion);
//		 capabilities.setCapability("udid", "emulator-5554");
		 
		 capabilities.setCapability("app", app.getAbsolutePath());
		 
		 capabilities.setCapability("appPackage", chuangyeAppPackage);
		 capabilities.setCapability("appActivity", chuangyeAppActivity);

	     capabilities.setCapability("noSign", "True");
		 
		 driver = new AndroidDriver(new URL(url), capabilities);
		
		return driver;
	}
	
	
	@Override
	public AndroidDriver appiumAndroidFundSetUp(AndroidDriver driver,
			String apkName) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		 File classpathRoot = new File(System.getProperty("user.dir"));
		 File appDir = new File(classpathRoot, "apps");
		 File app = new File(appDir, apkName);
		 
		 DesiredCapabilities capabilities = new DesiredCapabilities();		 
		 capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		 capabilities.setCapability("platformName", "Android");	
		 capabilities.setCapability("deviceName", "Android Emulator");
		 
//		 capabilities.setCapability("deviceName","device");
//		 capabilities.setCapability("automationName","Appium");
		 
	     capabilities.setCapability("unicodeKeyboard" ,"True");
	     capabilities.setCapability("resetKeyboard", "True");
		 
	     capabilities.setCapability("noReset", true);  
	     
		 capabilities.setCapability("platformVersion", platformVersion);
//		 capabilities.setCapability("udid", "emulator-5554");
		 
		 capabilities.setCapability("app", app.getAbsolutePath());
		 
		 capabilities.setCapability("appPackage", fundAppPackage);
		 capabilities.setCapability("appActivity", fundAppActivity);

	     capabilities.setCapability("noSign", "True");
		 
		 driver = new AndroidDriver(new URL(url), capabilities);
			
		return driver;
	}
	


	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public String getChuangyeAppPackage() {
		return chuangyeAppPackage;
	}

	public void setChuangyeAppPackage(String chuangyeAppPackage) {
		this.chuangyeAppPackage = chuangyeAppPackage;
	}

	public String getChuangyeAppActivity() {
		return chuangyeAppActivity;
	}

	public void setChuangyeAppActivity(String chuangyeAppActivity) {
		this.chuangyeAppActivity = chuangyeAppActivity;
	}

	public String getFundAppPackage() {
		return fundAppPackage;
	}

	public void setFundAppPackage(String fundAppPackage) {
		this.fundAppPackage = fundAppPackage;
	}

	public String getFundAppActivity() {
		return fundAppActivity;
	}

	public void setFundAppActivity(String fundAppActivity) {
		this.fundAppActivity = fundAppActivity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
