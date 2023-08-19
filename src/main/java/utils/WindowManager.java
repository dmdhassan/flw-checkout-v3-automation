package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }
    public void goBack() {
        navigate.back();
    }
    public void goForward() {
        navigate.forward();
    }
    public void refreshPage() {
        navigate.refresh();
    }
    public void goTo(String uri) {
        navigate.to(uri);
    }
    public void switchToTab(String tabTitle) {
        var windows = driver.getWindowHandles();
        System.out.println("Number of window tabs " + windows.size());

        System.out.println("Window handles");
        windows.forEach(System.out::println);

        for (String window : windows) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);
            String currentWindow = driver.getTitle();
            System.out.println("Current window title: " + currentWindow);

            if (currentWindow.contains(tabTitle)) {
                break;
            }
        }
    }



    public void switchToNewTab() {
        var windows = driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }

}
