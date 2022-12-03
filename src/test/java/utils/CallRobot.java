package utils;

import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CallRobot {

    static Robot robot;
    static boolean notStartedRobot = true;

    private static void startRobot() throws AWTException {
        robot = new Robot();
        notStartedRobot = false;
    }

    public static void clearAll() throws AWTException {
        if (notStartedRobot)
            startRobot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static void write(WebElement webElement, String string){
        webElement.sendKeys("");
        for(int i=0; i<string.length(); i++) {
            robot.keyPress('q');
        }
    }


}
