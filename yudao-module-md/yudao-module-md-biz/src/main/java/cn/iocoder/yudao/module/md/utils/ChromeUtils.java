package cn.iocoder.yudao.module.md.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeUtils {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.5993.89 Safari/537.36");
            options.addArguments("--disable-blink-features=AutomationControlled");
            WebDriver driver = new ChromeDriver(options);
            driver.get("https://hsex.men/video-1027070.htm");


            Thread.sleep(100000);  // Let the user actually see something!
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
