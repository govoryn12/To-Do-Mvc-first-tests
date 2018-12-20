package todoMvc.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import todoMvc.pages.PageTodoMvc;

public class StepsTodoMvc extends ScenarioSteps {

    PageTodoMvc pageTodoMvc;

    @Step
    public void addTodo(String text){
        pageTodoMvc.setInputField(text);
    }

    @Step
    public void addTodo(String text, int numberOfTimes){
        pageTodoMvc.setInputFieldManyTimes(text, numberOfTimes);
    }

    @Step
    public int numberOfTodos(){
        return pageTodoMvc.getListOfAllNotes().size();
    }

    @Step
    public int numberOfTodos(String inputText){
        return pageTodoMvc.getListOfAllNotesByInputText(inputText).size();
    }

    @Step
    public void markDoneTodo(String inputText){
        pageTodoMvc.findMarkDoneButtonByInputText(inputText).click();
    }
    @Step
    public void markDoneTodo(String inputText, int sequenceNumber){
        pageTodoMvc.findMarkDoneButtonByInputTextAndSequenceNumber(inputText, sequenceNumber).click();
    }

    @Step
    public boolean checkIfDone(String inputText){
        return pageTodoMvc.findCrosedOutNoteByInputText(inputText).isDisplayed();
    }

    @Step
    public void deleteTodo(String inputText, int sequenceNumber){
        pageTodoMvc.moveToTodoAndDeleteIt(inputText, sequenceNumber);
    }

    @Step
    public void seeActiveElements(){
        pageTodoMvc.clickOnActiveElements();
    }

}
