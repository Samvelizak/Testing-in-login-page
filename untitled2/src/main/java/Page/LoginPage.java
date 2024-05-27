package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userId= By.name("uname");
    private By passId =By.name("pass");

    private By clickName = By.xpath("//*[@id=\"content\"]/div[1]/form/table/tbody/tr[3]/td/input");

    private By logoutName = By.xpath("//*[@id=\"globalNav\"]/table/tbody/tr/td[2]/a");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public String login(String username, String password) {
        find(userId, username);
        find(passId, password);
        click(clickName);


        String title = getTop();
        return title;
    }

}
