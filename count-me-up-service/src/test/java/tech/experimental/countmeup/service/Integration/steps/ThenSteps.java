package tech.experimental.countmeup.service.Integration.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import tech.experimental.countmeup.api.Candidate;
import tech.experimental.countmeup.service.Integration.SharedStepData;
import tech.experimental.countmeup.service.Integration.config.TestContext;
import tech.experimental.countmeup.service.Integration.table.ResultsTable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.fail;

/**
 * Collects all the Then steps for the cucumber tests
 */
@ContextConfiguration(classes = TestContext.class)
public class ThenSteps
{
    @Autowired
    private SharedStepData sharedStepData;

    @Then("it responds in under (.*) seconds")
    public void aResponseIsReturnedInUnderXSeconds(final long numberOfSeconds)
    {
        given().parameters("competitionId", "test_competition").
                       when().
                       get("results").
                       then().time(lessThan(numberOfSeconds), TimeUnit.SECONDS);
    }

    @And("^the final counts are:?$")
    public void theFinalResultCounts(final List<ResultsTable> resultCountsTable)
    {
        final Map<String, Long> actualResultByCandidates =
                sharedStepData.getActualResultResponse()
                              .getCandidates()
                              .stream()
                              .collect(Collectors.toMap(Candidate::getName, Candidate::getNumberOfVotesReceived));

        sharedStepData.getActualResultsByCandidate().putAll(actualResultByCandidates);
        resultCountsTable.forEach(this::assertResultsCounts);
    }

    private void assertResultsCounts(final ResultsTable expectedResult)
    {
        final Long actualCount = sharedStepData.getActualResultsByCandidate().get(expectedResult.getCandidate());
        if (actualCount == null)
        {
            fail("Actual Candidate results not found in the response for candidate " + expectedResult.getCandidate());
        }
        assertThat(actualCount).isEqualTo(expectedResult.getCount());

    }


}
