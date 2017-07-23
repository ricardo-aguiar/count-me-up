package tech.experimental.countmeup.service.Integration;

import org.springframework.stereotype.Component;
import tech.experimental.countmeup.api.CompetitionRegistrationRequest;
import tech.experimental.countmeup.api.ResultResponse;
import tech.experimental.countmeup.api.VoteCastRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Shared test date for cucumber steps.
 */
@Component
public class SharedStepData
{

    private CompetitionRegistrationRequest registrationRequest = null;
    private final List<VoteCastRequest> voteCastRequests = new ArrayList<>();
    private final Map<String, Long> actualResultsByCandidate = new HashMap<>();
    private long expectedNumOfVotesReceived;
    private int maxNumberOfVotesPerUser;
    private ResultResponse actualResultResponse = null;

    public void clearTestData()
    {
        this.registrationRequest = null;
        this.voteCastRequests.clear();
        this.actualResultsByCandidate.clear();
        this.maxNumberOfVotesPerUser = 0;
        this.expectedNumOfVotesReceived = 0;
        this.actualResultResponse = null;
    }

    public CompetitionRegistrationRequest getRegistrationRequest()
    {
        return registrationRequest;
    }

    public void setRegistrationRequest(final CompetitionRegistrationRequest registrationRequest)
    {
        this.registrationRequest = registrationRequest;
    }

    public List<VoteCastRequest> getVoteCastRequests()
    {
        return voteCastRequests;
    }

    public Map<String, Long> getActualResultsByCandidate()
    {
        return actualResultsByCandidate;
    }

    public long getExpectedNumOfVotesReceived()
    {
        return expectedNumOfVotesReceived;
    }

    public void setExpectedNumOfVotesReceived(final long expectedNumOfVotesReceived)
    {
        this.expectedNumOfVotesReceived = expectedNumOfVotesReceived;
    }

    public int getMaxNumberOfVotesPerUser()
    {
        return maxNumberOfVotesPerUser;
    }

    public void setMaxNumberOfVotesPerUser(final int maxNumberOfVotesPerUser)
    {
        this.maxNumberOfVotesPerUser = maxNumberOfVotesPerUser;
    }

    public ResultResponse getActualResultResponse()
    {
        return actualResultResponse;
    }

    public void setActualResultResponse(final ResultResponse actualResultResponse)
    {
        this.actualResultResponse = actualResultResponse;
    }
}
