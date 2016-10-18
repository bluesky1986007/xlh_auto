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
	
	/**
	 * 退出app
	 * @param driver
	 * @return
	 */
	public AndroidDriver appLoginout(AndroidDriver driver);
	
	
	/**
	 * 评论并且提交
	 * @param driver
	 * @param comment
	 * @return
	 */
	public AndroidDriver commentSubmit(AndroidDriver driver,String comment);
	
}
