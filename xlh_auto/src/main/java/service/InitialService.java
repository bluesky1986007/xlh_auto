package service;

import java.net.MalformedURLException;

import org.openqa.selenium.android.AndroidDriver;

public interface InitialService {
	
	
	/**
	 * Android 创业者app初始化
	 * @param driver
	 * @param apkName
	 * @return
	 * @throws MalformedURLException
	 */
	public AndroidDriver appiumAndroidChuangyeSetUp(AndroidDriver driver, String apkName) throws MalformedURLException;
	
	/**
	 * Android 机构app初始化
	 * @param driver
	 * @param apkName
	 * @return
	 * @throws MalformedURLException
	 */
	public AndroidDriver appiumAndroidFundSetUp(AndroidDriver driver, String apkName) throws MalformedURLException;

}
