package com_orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */
public class Project2 {
    static String browser="Chrome";
    static String baseUrl="https://opensource-demo.orangehrmlive.com/";

    public static void main(String[] args) {
        //Lunch the chrome Browser
        WebDriver driver=new ChromeDriver();
        //Open the URL into Browser
        driver.get(baseUrl);
        //Maximise the Browser
        driver.manage().window().maximize();
        //we give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Get the title of the page.
        String title=driver.getTitle();
        System.out.println("Title of the page:"+title);
        //Get Current Url
        System.out.println("The current Url: "+driver.getCurrentUrl());
        //get page source
        System.out.println(driver.getPageSource());
        // 6. Click on ‘Forgot your password?’ link.
        WebElement forgotPass=driver.findElement(By.cssSelector(".orangehrm-login-forgot-header"));
        forgotPass.click();
        //7.current Url
        System.out.println("The current Url: "+driver.getCurrentUrl());
        //Navigate back to the login page
        driver.navigate().back();
        //referesh the page
        driver.navigate().refresh();

        //Enter the username to username field
        WebElement emailField=driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        //Enter the password to password field
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        //Click on login Button
        WebElement loginButton=driver.findElement(By.cssSelector(".orangehrm-login-button"));
        loginButton.click();
        //close the browser
        driver.quit();
    }
}
