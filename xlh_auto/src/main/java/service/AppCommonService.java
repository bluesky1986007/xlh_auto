package service;


import org.openqa.selenium.android.AndroidDriver;


public interface AppCommonService {
	
	/**
	 * app登录
	 * @param driver
	 * @param userName
	 * @param userPassWord
	 * @return
	 */
	public AndroidDriver appLogin(AndroidDriver driver, String userName, String userPassWord); 
}
