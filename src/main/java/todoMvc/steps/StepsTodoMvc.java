package todoMvc.steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import todoMvc.pages.PageTodoMvc;

public class StepsTodoMvc extends PageTodoMvc {

    public StepsTodoMvc(WebDriver driver) {
        super(driver);
    }

    @Step
    public void addTodo(String text){
        setInputField(text);
    }

    @Step
    public void addTodo(String text, int numberOfTimes){
        setInputFieldManyTimes(text, numberOfTimes);
    }

    @Step
    public int numberOfTodos(){
        return getListOfAllNotes().size();
    }

    @Step
    public int numberOfTodos(String inputText){
        return getListOfAllNotesByInputText(inputText).size();
    }

    @Step
    public void markDoneTodo(String inputText){
        findMarkDoneButtonByInputText(inputText).click();
    }
    @Step
    public void markDoneTodo(String inputText, int sequenceNumber){
        findMarkDoneButtonByInputTextAndSequenceNumber(inputText, sequenceNumber).click();
    }

    @Step
    public boolean checkIfDone(String inputText){
        return findCrosedOutNoteByInputText(inputText).isDisplayed();
    }

    @Step
    public void deleteTodo(String inputText, int sequenceNumber){
        moveToTodoAndDeleteIt(inputText, sequenceNumber);
    }

    @Step
    public void seeActiveElements(){
        clickOnActiveElements();
    }

}
