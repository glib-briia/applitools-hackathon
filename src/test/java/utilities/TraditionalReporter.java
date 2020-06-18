package utilities;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TraditionalReporter {


    /**
     * A Helper to print the test result in the following format:
     * Task: <Task Number>, Test Name: <Test Name>, DOM Id:: <id>, Browser: <Browser>, Viewport: <Width x Height>, Device<Device type>, Status: <Pass | Fail>
     * <p>
     * Example: Task: 1, Test Name: Search field is displayed, DOM Id: DIV__customsear__41, Browser: Chrome, Viewport: 1200 x 700, Device: Laptop, Status: Pass
     *
     * @param task             int - 1, 2 or 3
     * @param testName         String - Something meaningful. E.g. 1.1 Search field is displayed
     * @param element          WebElement - element under test
     * @param comparisonResult boolean - The result of comparing the "Expected" value and the "Actual" value.
     * @return boolean - returns the same comparison result back so that it can be used for further Assertions in the test code.
     */

    public static boolean hackathonReporter(int task, String testName, ITestContext context, WebElement element, boolean comparisonResult) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Traditional-" + System.getenv("APP_VERSION") + "-TestResults.txt", true))) {
            writer.write("Task: " + task + ", Test Name: " + testName + ", DOM Id: " + element.getAttribute("id") + ", Browser: " + context.getCurrentXmlTest().getParameter(
                    "browser")
                    + ", Viewport: " + context.getCurrentXmlTest().getParameter("viewport") + ", Device: " + context.getCurrentXmlTest().getParameter("device") + ", Status: " + (comparisonResult ? "Pass" : "Fail"));
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error writing to report file");
            e.printStackTrace();
        }
        //returns the result so that it can be used for further Assertions in the test code.
        return comparisonResult;
    }
}
