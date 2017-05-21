package spbstu.telematika.webtest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by maxfromperek on 16.05.17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resourses/features"},
        glue = {"spbstu.telematika.webtest.stepdefs"}
)
public class CucumberRunner {

}