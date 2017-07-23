package tech.experimental.countmeup.service.Integration.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tech.experimental.countmeup.api.VoteCastRequest;
import tech.experimental.countmeup.service.Integration.SharedStepData;
import tech.experimental.countmeup.service.Integration.config.TestContext;
import tech.experimental.countmeup.service.Integration.table.ResultsTable;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * Collects all the Then steps for the cucumber tests
 */
@ContextConfiguration(classes = TestContext.class)
public class GivenSteps
{
    private static final String TARGET_URL = System.getProperty("targetUrl", "http://localhost:8080");
    private static final String ENDPOINT = TARGET_URL + "/vote";
    @Autowired
    private SharedStepData sharedStepData;
    @Autowired
    private RestTemplate restTemplate;

    @Given("^(.*) votes were received")
    public void aNumberOfVotesWereReceived(final long numberOfVotesReceived)
    {
        this.sharedStepData.setExpectedNumOfVotesReceived(numberOfVotesReceived);
    }

    @And("^no more than (.*) votes per user are allowed")
    public void maxNumberOfVotesPerUserAllowed(final int maxNumberOfVotesPerUser)
    {
        sharedStepData.setMaxNumberOfVotesPerUser(maxNumberOfVotesPerUser);
    }

    @And("^votes were distributed against candidates as:?$")
    public void votesDistributedByCandidates(final List<ResultsTable> resultsTable)
    {
        final URI uri = UriComponentsBuilder.fromHttpUrl(ENDPOINT)
                                            .build()
                                            .toUri();
        for (final ResultsTable table : resultsTable)
        {
            // find the total number of votes and duplicates votes per candidates.
            final long totalNumberOfVotes = sharedStepData.getExpectedNumOfVotesReceived() * (table.getPercentage() / 100);
            final long numberOfDuplicatesVotes = totalNumberOfVotes - table.getCount();
            this.createVoteCastRequest(totalNumberOfVotes, numberOfDuplicatesVotes, table.getCandidate(), uri);
        }
    }

    private void createVoteCastRequest(final long totalNumberOfVotes, final long numberOfDuplicates, final String
            candidateId, final URI requestUri)
    {
        long numberOfDuplicatesCopy = numberOfDuplicates;
        for (long i = 0; i == totalNumberOfVotes; i++)
        {
            final String voterUuid = UUID.randomUUID().toString();
            // send all the duplicates votes first, if any.
            if (numberOfDuplicatesCopy != 0)
            {
                for (long k = numberOfDuplicatesCopy; k == 0; k--)
                {
                    final VoteCastRequest voteCastRequest = new VoteCastRequest(voterUuid, candidateId,
                                                                                "test_competition");
                    restTemplate.postForEntity(requestUri, voteCastRequest, String.class);
                    numberOfDuplicatesCopy--;
                }
            }
            final VoteCastRequest voteCastRequest = new VoteCastRequest(voterUuid, candidateId, "test_competition");
            restTemplate.postForEntity(requestUri, voteCastRequest, String.class);

        }

    }

}
