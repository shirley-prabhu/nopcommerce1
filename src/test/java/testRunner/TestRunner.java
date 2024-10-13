package testRunner;
/**
 * This class controls the Cucumber setup and tags.
 */


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //This specifies the type and location of your desired reports.
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber/report.html"},
        //This is the location of your Features folder
        features = {"src/test/java/Features"},

        //This is the location of your StepDefs folder
        glue = {"stepDefinitions"},
        //This is an optional flag that lets all tests that match the tags be checked without executing them. Use it to
        //dryRun = true,
        //These are the tags that will be executed if you run this class.
        tags = "@sanity")


public class TestRunner {
        public static int passed = 0;
        public static int failed = 0;

        @AfterClass
        public static void logResults() {

                if (passed == 0) {
                        System.out.println("Test Results: " + failed + " failed.");
                } else if (failed == 0) {
                        System.out.println("Test Results: " + passed + " passed.");
                } else {
                        System.out.println("Test Results: " + passed + " passed and " + failed + " failed.");
                }

        }
}
