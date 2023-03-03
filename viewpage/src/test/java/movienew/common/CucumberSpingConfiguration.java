package movienew.common;


import movienew.ViewpageApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ViewpageApplication.class })
public class CucumberSpingConfiguration {
    
}
