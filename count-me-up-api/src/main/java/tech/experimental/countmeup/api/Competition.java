package tech.experimental.countmeup.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.*;

/**
 * A competition that candidates can take part in.
 */
public class Competition
{
    private final String competitionId;
    private final List<Candidate> candidates;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final int maxNumberOfVotesPerUser;

    /**
     * Constructs a new competition
     * @param competitionId The compentition ID, default to a new UUID if it is <code>null</code>.
     * @param candidates A list of candidates taking part in the competition.
     * @param startDate The competition start date
     * @param endDate The competition end date
     * @param maxNumberOfVotesPerUser The maximum number of votes per user allowed.
     */
    @JsonCreator
    public Competition(@JsonProperty("competitionId") final String competitionId,
                       @JsonProperty("candidates") final List<Candidate> candidates,
                       @JsonProperty("startDate") final LocalDateTime startDate,
                       @JsonProperty("endDate") final LocalDateTime endDate,
                       @JsonProperty("maxNumberOfVotesPerUser") final int maxNumberOfVotesPerUser)
    {
        this.competitionId = competitionId == null ? UUID.randomUUID().toString() : competitionId;
        // Copying the list to ensure immutability
        this.candidates = candidates == null ? Collections.emptyList()
                                             : Collections.unmodifiableList(new ArrayList<>(candidates));
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxNumberOfVotesPerUser = maxNumberOfVotesPerUser;
    }

    public String getCompetitionId()
    {
        return competitionId;
    }

    public List<Candidate> getCandidates()
    {
        return candidates;
    }

    public LocalDateTime getStartDate()
    {
        return startDate;
    }

    public LocalDateTime getEndDate()
    {
        return endDate;
    }

    public int getMaxNumberOfVotesPerUser()
    {
        return maxNumberOfVotesPerUser;
    }

    @Override
    public final boolean equals(final Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof Competition))
        {
            return false;
        }
        final Competition that = (Competition) other;
        return maxNumberOfVotesPerUser == that.maxNumberOfVotesPerUser
               && Objects.equals(competitionId, that.competitionId)
               && Objects.equals(startDate, that.startDate)
               && Objects.equals(endDate, that.endDate)
               && Objects.equals(candidates, that.candidates);
    }

    @Override
    public final int hashCode()
    {
        return Objects.hash(competitionId, candidates, startDate, endDate, maxNumberOfVotesPerUser);
    }

    @Override
    public String toString()
    {
        return "Competition{" +
               "competitionId='" + competitionId + '\'' +
               ", candidates=" + candidates + '\'' +
               ", startDate=" + startDate + '\'' +
               ", endDate=" + endDate + '\'' +
               ", maxNumberOfVotesPerUser=" + maxNumberOfVotesPerUser +
               '}';
    }
}
