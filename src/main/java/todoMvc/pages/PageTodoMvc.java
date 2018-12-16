package todoMvc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class PageTodoMvc {

    WebDriver driver;

    public PageTodoMvc (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //ELEMETS

    @FindBy(xpath = "//header/input")
    private WebElement inputField;

    @FindBy(xpath = "//div/label[text()=\"coffe\"]/../input")
    private WebElement markDoneCoffe;

    @FindBy(xpath = "//*[@class=\"todo completed\"]/div/label[text()=\"coffe\"]")
    private WebElement crossed_out;

    @FindBy(xpath = "(//*[text()=\"wheel\"])[1]")
    private WebElement firstOfWheel;

    @FindBy(xpath = "(//div/label[text()=\"wheel\"]/../input)[3]")
    private WebElement markDoneThirdWheel;

    @FindBy(xpath = "(//div/label[text()=\"wheel\"]/../button)[1]")
    private WebElement firstDeleteButtonOfWheel;

    @FindBy(xpath = "//*[text()=\"Active\"]")
    private WebElement activeElementsButton;

    //METHODS

    public void setInputField (String text){
        inputField.sendKeys(text);
        inputField.sendKeys(Keys.ENTER);
    }

    public void setInputFieldManyTimes (String text, int times){
        for (int i = 0; i < times ; i++) {
            inputField.sendKeys(text);
            inputField.sendKeys(Keys.ENTER);
        }
    }

    public void startBrowserWithDimensionAndUrl (String url){
        driver.manage().window().setSize(new Dimension(1280,800));//set1280x800
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//what it means?
        driver.get(url);
    }

    public int getNumberOfTodos (){
        int listSize = driver.findElements(By.xpath("//li/div[@class=\"view\"]")).size();
        return listSize;
    }

    public int getNumberOfWheelTodos (){
        int listSize = driver.findElements(By.xpath("//*[text()=\"wheel\"]")).size();
        return listSize;
    }

    public void exitFromBrowser(){
        driver.quit();
    }

    public void clickOnCoffeMarkDoneBotton(){
        markDoneCoffe.click();
    }
    public void clickOnWheelMarkDoneBotton(){
        markDoneThirdWheel.click();
    }

    public boolean markedAsDone(){
        return crossed_out.isDisplayed();
    }

    public void moveToFirstofWheelAndDeleteIt(){
        Actions action = new Actions(driver);
        action.moveToElement(firstOfWheel).perform();
        firstDeleteButtonOfWheel.click();
    }

    public void clickOnActiveElements(){
        activeElementsButton.click();
    }

}
