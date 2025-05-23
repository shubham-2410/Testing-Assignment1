package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CourseraTest {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver manually
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Coursera
            driver.get("https://www.coursera.org/");
            driver.manage().window().maximize();

            // Wait for page elements to load
            Thread.sleep(5000);

            // --- Search Box ---
            WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));

            System.out.println("=== Search Box Attributes ===");
            System.out.println("ID: " + searchBox.getAttribute("id"));
            System.out.println("Name: " + searchBox.getAttribute("name"));
            System.out.println("Class: " + searchBox.getAttribute("class"));
            System.out.println("Tag Name: " + searchBox.getTagName());
            System.out.println("Font Size (CSS): " + searchBox.getCssValue("font-size"));

            // --- Log In Link ---
            WebElement loginLink = driver.findElement(By.linkText("Log In"));

            System.out.println("\n=== Log In Link ===");
            System.out.println("Text: " + loginLink.getText());

            WebElement loginPartial = driver.findElement(By.partialLinkText("Log"));
            System.out.println("Partial Link Found: " + (loginPartial != null));

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
