package org.example;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarkdownRenderingTest extends BaseTest {

    @BeforeClass
    public static void test1_NavigateToNotificationsPage() throws InterruptedException {
        driver.get("https://github.com/SoftwareTestingGroup/test");
        Thread.sleep(2000);
        System.out.println("Landed on notifications page");
    }

    @Test
    public void test2_CreateReadMe() throws InterruptedException {
        WebElement addBtn = driver.findElement(By.xpath("//*[@id=\":R5b5ab:\"]"));
        addBtn.click();
        WebElement createNewFile = driver.findElement(By.xpath("//*[@id=\":rv:\"]"));
        createNewFile.click();
        System.out.println("created a new file");
        Thread.sleep(2000);

        // Name the file
        WebElement fileName = driver.findElement(By.xpath("//*[@id=\"repo-content-pjax-container\"]/react-app/div/div/div[1]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[1]/div[2]/div[2]/span[2]/input"));
        fileName.click();
        fileName.sendKeys("FitnessGram Pacer Test");
        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"repo-content-pjax-container\"]/react-app/div/div/div[1]/div/div/div[2]/div[2]/div/div[3]/div[2]/div/div[2]/file-attachment/div/div/div[2]/div[2]/div"));
        textBox.click();
        textBox.sendKeys("The FitnessGram Pacer Test is a multistage aerobic capacity test that " +
                "progressively gets more difficult as it continues. The 20 meter pacer test will begin in 30 seconds. " +
                "Line up at the start. The running speed starts slowly but gets faster each minute after you hear" +
                " this signal bodeboop. A sing lap should be completed every time you hear this sound. ding Remember" +
                " to run in a straight line and run as long as possible. The second time you fail to complete a lap" +
                " before the sound, your test is over. The test will begin on the word start. On your mark." +
                " Get ready!… Start. ding\uFEFF");
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"repo-content-pjax-container\"]/react-app/div/div/div[1]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/button"));
        submitBtn.click();
        Thread.sleep(3000);
        WebElement proposeBtn =  driver.findElement(By.xpath("//*[@id=\"__primerPortalRoot__\"]/div/div/div/div[3]/button[2]"));
        proposeBtn.click();
        Thread.sleep(3000);

        // THIS IS WHERE YOU LEFT OFF
        // After submitting this readme, something else had popped up about a pull request
    }

    @Test
    public void test3_EnableNotificationsForRepo() throws InterruptedException {
        WebElement watchBtn = driver.findElement(By.xpath("//*[@id=\"repository-details-container\"]/ul/li[2]/react-partial/div"));
        watchBtn.click();
        WebElement allNotifs = driver.findElement(By.xpath("//*[@id=\":r14:\"]/div/span[3]/div"));
        Thread.sleep(2000);
        allNotifs.click();
        Thread.sleep(2000);
        System.out.println("Enabled all notifications");
    }

    @Test
    public void test4_MarkAllAsRead() throws InterruptedException {
        Thread.sleep(2000);
        WebElement markRead = driver.findElement(By.xpath("//button[contains(text(), 'Mark all as read')]"));
        markRead.click();
        System.out.println("Marked all notifications as read");
        Thread.sleep(2000);
    }

    @Test
    public void test5_UnsubscribeFromThread() throws InterruptedException {
        // This assumes you're already subscribed to a thread
        Thread.sleep(2000);
        WebElement thread = driver.findElement(By.xpath("(//a[contains(@href, '/notifications/threads')])[1]"));
        thread.click();
        Thread.sleep(2000);
        WebElement unsubBtn = driver.findElement(By.xpath("//form[contains(@action, '/unsubscribe')]/button"));
        unsubBtn.click();
        System.out.println("Unsubscribed from thread");
        Thread.sleep(2000);
    }
}
