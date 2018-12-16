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
    public void addTodoManyTimes(String text, int numberOfTimes){
        setInputFieldManyTimes(text, numberOfTimes);
    }

    @Step
    public void goTo (String link){
        startBrowserWithDimensionAndUrl(link);
    }

    @Step
    public int numberOfTodos(){
        return getNumberOfTodos();
    }

    @Step
    public int numberOfWheelTodos(){
        return getNumberOfWheelTodos();
    }

    @Step
    public void closeBrowser(){
        exitFromBrowser();
    }

    @Step
    public void markDoneCoffeTodo(){
        clickOnCoffeMarkDoneBotton();
    }
    @Step
    public void markDoneThirdWheelTodo(){
        clickOnWheelMarkDoneBotton();
    }

    @Step
    public boolean checkIfDone(){
        return markedAsDone();
    }

    @Step
    public void deleteFirstWheel(){
        moveToFirstofWheelAndDeleteIt();
    }

    @Step
    public void seeActiveElements(){
        clickOnActiveElements();
    }


}
