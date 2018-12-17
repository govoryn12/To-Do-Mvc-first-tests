package todoMvc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class PageTodoMvc {

    WebDriver driver;

    public PageTodoMvc (WebDriver driver){
        this.driver = driver;
    }


    public WebElement findInputField(){
        return driver.findElement(By.xpath("//header/input"));
    }

    public WebElement findMarkDoneButtonByInputText(String inputText){
        return driver.findElement(By.xpath("//div[label[text()="+'"'+inputText+'"'+"]]/input"));
    }

    public WebElement findMarkDoneButtonByInputTextAndSequenceNumber(String inputText, int sequenceNumber){
        return driver.findElement(By.xpath("(//div[label[text()="+'"'+inputText+'"'+"]]/input)["+sequenceNumber+"]"));
    }

    public WebElement findDeleteButtonByInputTextAndSequenceNumber(String inputText, int sequenceNumber){
        return driver.findElement(By.xpath("(//div[label[text()="+'"'+inputText+'"'+"]]/button)["+sequenceNumber+"]"));
    }

    public WebElement findNoteByInputTextAndSequenceNumber(String inputText, int sequenceNumber){
        return driver.findElement(By.xpath("//*[text()="+'"'+inputText+'"'+"]["+sequenceNumber+"]"));
    }

    public WebElement findCrosedOutNoteByInputText(String inputText){
        return driver.findElement(By.xpath("//*[@class=\"todo completed\"]/div/label[text()="+'"'+inputText+'"'+"]"));
    }

    public WebElement findActiveElementsButton(){
        return driver.findElement(By.xpath("//*[text()=\"Active\"]"));
    }

    public String findNotesByInputText(String inputText){
        return "//*[text()="+'"'+inputText+'"'+"]";
    }

    public List<WebElement> getListOfAllNotes (){
        return driver.findElements(By.className("view"));
    }

    public List<WebElement> getListOfAllNotesByInputText (String inputText){
        return driver.findElements(By.xpath(findNotesByInputText(inputText)));
    }


    public void setInputField (String text){
        findInputField().sendKeys(text);
        findInputField().sendKeys(Keys.ENTER);
    }

    public void setInputFieldManyTimes (String text, int times){
        for (int i = 0; i < times ; i++) {
            setInputField(text);
        }
    }

    public void moveToTodoAndDeleteIt(String inputText, int sequenceNumber){
        WebElement note =  findNoteByInputTextAndSequenceNumber(inputText, sequenceNumber);
        Actions action = new Actions(driver);
        action.moveToElement(note).perform();
        findDeleteButtonByInputTextAndSequenceNumber(inputText, sequenceNumber).click();
    }

    public void clickOnActiveElements(){
        findActiveElementsButton().click();
    }

}
