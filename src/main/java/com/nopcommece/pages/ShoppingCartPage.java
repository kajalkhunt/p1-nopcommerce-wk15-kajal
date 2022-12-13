package com.nopcommece.pages;

import com.nopcommece.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.Random;

public class ShoppingCartPage extends Utility {

    @FindBy(xpath = "//a[@href='/computers']")
    WebElement clickComputer;

    @FindBy(xpath="//a[@title='Show products in category Desktops']")
    WebElement clickDesktop;
   @FindBy(id="products-orderby")
   WebElement sort;

    @FindBy (xpath="(//button[contains(text(),'to cart')])[1]")
    WebElement clickCart;

    @FindBy(name="product_attribute_1")
    WebElement selctComputer;


    public void clickOnComputerAndDesktop() {
        Reporter.log("click on computer "+ clickComputer.getText());
        clickOnElement(clickComputer);
        Reporter.log("click on computer "+ clickDesktop.getText());
        clickOnElement(clickDesktop);
    }

    public void sortComputerDesktopsToAtoZ(String value) {
        Reporter.log("sort computerdesktops to AtoZ"+sort.getText());
        selectByValueFromDropDown(sort, value);
    }

    public void clickOnShoppingCart() throws InterruptedException {
        Reporter.log("click on shopping cart"+ clickCart.getText());
        Thread.sleep(5000);
        clickOnElement(clickCart);
    }


    public void selectPentiumComputer(String name) {
        Reporter.log("select Pentium Computer"+ selctComputer.getText());
        selectByVisibleTextFromDropDown(selctComputer, name);
    }
    public void selectByDropDown(String message, By by, String name) {

        selectByVisibleTextFromDropDown(by, name);
    }


    public String exptectedTextMessage(String expected) {
        System.out.println("Expected Text or Message is : " + expected);
        return expected;
    }

    public String actualTextToVerify(By by) {
        String actual = driver.findElement(by).getText();
        System.out.println("Actual Text or Message is : " + actual);
        Reporter.log("Actual Text or Message is" + actual);
        return actual;
    }


    public void selectMemory8GB(String name) {
        Reporter.log(" Select 8gb memory" + name);
        selectByVisibleTextFromDropDown(By.name("product_attribute_2"), name);

    }

    public void selectingHDD400GB() {
        Reporter.log(" select HDD 400gb");
        clickOnElement(By.id("product_attribute_3_7"));
    }


    public void selectRadioButton(String message, By by) {
        Reporter.log(" Select Radio Button " + by );
        clickOnElement(by);
    }

    public void selectCheckBox(String message, By by) {
        Reporter.log(" Select check box " + by);
        clickOnElement(by);
    }

    public void selectPressButton(String message, By by) {
        Reporter.log(" Select press button" + by);
        clickOnElement(by);
    }

    public void mouseHoveronShoppingCartAndClickOnGoToCart() {
        Reporter.log("Shopping cart and click on go");
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        goToCart.click();

    }

    public void changeTheQuantityTo2AndClickOnUpdateShoppingCart() {
        clearContent(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.id("updatecart"));
    }

    public void fillingMandatoryFields(String message, String sendText, By by) {
        Reporter.log(" filling mandatory fields" + sendText);
        sendTextToElement(by, sendText);
    }

    public void randomEmailGeneratorAndSendText(By by, String firstName, String lastName) {
        Random randomGenerator = new Random();
        int emailNum = randomGenerator.nextInt(9999);
        String email = firstName + "." + lastName + emailNum + "@email.com";
        sendTextToElement(by, email);
    }
    }

