package com.bukalapak;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bukalapak.com/");


        // step 1
        // ...
        // ...
        // step n


        // get transaction ID that displayed in the UI
        String trxId = driver.findElement(By.id('transaction-id')).getText();

        // input transaction ID to a method for retrieving the record in database
        // transaction ID validation is inside the method
        Map<String,String > trans_data = GetTransactionLog.getTransactionLogById(trxId);

        //compare other element that relate with transaction ID with database data
        String sellerName = driver.findElement(By.id('selelr-name')).getText();
        assert sellerName.equals(trans_data.get("SELLER_NAME"))

        String deliveryService = driver.findElement(By.id("delivery-service")).getText();
        assert deliveryService.equals(trans_data.get("DELIVERY_SERVICE"));

        String dateOrdered = driver.findElement(By.id("date-ordered")).getText();
        assert dateOrdered.equals(trans_data.get("DATE_ORDERED"));

        String address = driver.findElement(By.id("address-shipement")).getText();
        assert address.equals(trans_data.get("ADDRESS_SIP"))


    }





}
