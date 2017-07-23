package tech.experimental.countmeup.service.Integration.steps;

import com.jayway.restassured.RestAssured;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import tech.experimental.countmeup.api.ResultResponse;
import tech.experimental.countmeup.service.Integration.SharedStepData;
import tech.experimental.countmeup.service.Integration.config.TestContext;

import static com.jayway.restassured.RestAssured.get;

/**
 * Collects all the When steps for the cucumber tests.
 */
@ContextConfiguration(classes = TestContext.class)
public class WhenSteps
{
    @Autowired
    private SharedStepData sharedStepData;
    private static final String TARGET_URL = System.getProperty("targetUrl", "http://localhost:8080");

    @When("CountMeUp is asked for the results")
    public void aRequestForResultsIsRequested()
    {
        RestAssured.baseURI = TARGET_URL;

        final ResultResponse response = get("results?competitionId=test_competition").as(ResultResponse.class);
        sharedStepData.setActualResultResponse(response);
    }
}
