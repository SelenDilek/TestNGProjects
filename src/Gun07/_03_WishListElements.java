package Gun07;

import Utility.BaseDriver;
import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class _03_WishListElements extends BaseDriver {
    public _03_WishListElements() {

        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    public List<WebElement> wishButtons;

    @FindBy(xpath = "//div[@class='caption']//h4")
    public List<WebElement> productList;

    @FindBy(linkText = "Wish List")
    public WebElement wishListLink;


    @FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md' and text()='Add to Cart']")
    public List<WebElement> addToChart;

    @FindBy(linkText="Shopping Cart")
    public WebElement shoppingCart;
    @FindBy(xpath = "//td[@class='text-left']/a")
    public List<WebElement> wishList;


}
