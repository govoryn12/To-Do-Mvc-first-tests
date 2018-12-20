package todoMvc.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PageTodoMvc extends PageObject {

    @FindBy(xpath = "//header/input" )
    WebElementFacade findInputField;



    public WebElementFacade findMarkDoneButtonByInputText(String inputText){
       return $("//div[label[text()="+'"'+inputText+'"'+"]]/input");
    }

    public WebElementFacade findMarkDoneButtonByInputTextAndSequenceNumber(String inputText, int sequenceNumber){
        return $("(//div[label[text()="+'"'+inputText+'"'+"]]/input)["+sequenceNumber+"]");
    }

    public WebElementFacade findDeleteButtonByInputTextAndSequenceNumber(String inputText, int sequenceNumber){
        return $("(//div[label[text()="+'"'+inputText+'"'+"]]/button)["+sequenceNumber+"]");
    }

    public WebElementFacade findNoteByInputTextAndSequenceNumber(String inputText, int sequenceNumber){
        return $("//*[text()="+'"'+inputText+'"'+"]["+sequenceNumber+"]");
    }

    public WebElementFacade findCrosedOutNoteByInputText(String inputText){
        return $("//*[@class=\"todo completed\"]/div/label[text()="+'"'+inputText+'"'+"]");
    }

    public WebElementFacade findActiveElementsButton(){
        return $("//*[text()=\"Active\"]");
    }

    public String findNotesByInputText(String inputText){
        return "//*[text()="+'"'+inputText+'"'+"]";
    }

    public List<WebElementFacade> getListOfAllNotes (){
        return findAll("//*[@class=\"view\"]");
    }

    public List<WebElementFacade> getListOfAllNotesByInputText (String inputText){
        return findAll(findNotesByInputText(inputText));
    }


    public void setInputField (String text){
        findInputField.sendKeys(text);
        findInputField.sendKeys(Keys.ENTER);
    }

    public void setInputFieldManyTimes (String text, int times){
        for (int i = 0; i < times ; i++) {
            setInputField(text);
        }
    }

    public void moveToTodoAndDeleteIt(String inputText, int sequenceNumber){
        WebElementFacade note =  findNoteByInputTextAndSequenceNumber(inputText, sequenceNumber);
        Actions action = new Actions(getDriver());
        action.moveToElement(note).perform();
        findDeleteButtonByInputTextAndSequenceNumber(inputText, sequenceNumber).click();
    }

    public void clickOnActiveElements(){
        findActiveElementsButton().click();
    }

}
