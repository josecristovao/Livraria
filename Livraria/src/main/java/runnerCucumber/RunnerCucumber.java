package runnerCucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/feature",
glue = {"br.com.step"}, 
tags = "@Livraria and @001")
public class RunnerCucumber {

}
