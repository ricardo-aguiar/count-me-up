package tech.experimental.countmeup.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request object to cast a vote for a candidate in a competition.
 */
public class VoteCastRequest
{
    private final String voterId;
    private final String candidateId;
    private final String competitionId;

    /**
     * Constructor
     * @param voterId
     * @param candidateId
     * @param competitionId
     */
    @JsonCreator
    public VoteCastRequest(@JsonProperty("voterId") final String voterId,
                           @JsonProperty("candidateId") final String candidateId,
                           @JsonProperty("competitionId") final String competitionId)
    {
        this.voterId = voterId;
        this.candidateId = candidateId;
        this.competitionId = competitionId;
    }

    public String getVoterId()
    {
        return voterId;
    }

    public String getCandidateId()
    {
        return candidateId;
    }

    public String getCompetitionId()
    {
        return competitionId;
    }

    @Override
    public final boolean equals(final Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof VoteCastRequest))
        {
            return false;
        }
        final VoteCastRequest that = (VoteCastRequest) other;
        return Objects.equals(voterId, that.voterId) &&
               Objects.equals(candidateId, that.candidateId) &&
               Objects.equals(competitionId, that.competitionId);
    }

    @Override
    public final int hashCode()
    {
        return Objects.hash(voterId, candidateId, competitionId);
    }

    @Override
    public String toString()
    {
        return "VoteCastRequest{" +
               "voterId=" + voterId +
               ", candidateId='" + candidateId + '\'' +
               ", competitionId='" + competitionId + '\'' +
               '}';
    }
}
