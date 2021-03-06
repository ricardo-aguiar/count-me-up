package tech.experimental.countmeup.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * A candidate that can take part in a competition.
 */
public class Candidate
{
    private final String candidateId;
    private final String name;
    private final long numberOfVotesReceived;

    /**
     * Constructs a new Candidate.
     * @param candidateId The candidate unique identifier or if <code>null</code> it will be generated
     * @param name The candidate name
     * @param numberOfVotesReceived the number of votes received by the cadidante
     */
    @JsonCreator
    public Candidate(@JsonProperty("candidateId") final String candidateId,
                     @JsonProperty("name") final String name,
                     @JsonProperty("numberOfVotesReceived") final long numberOfVotesReceived)
    {
        this.candidateId = candidateId == null ? UUID.randomUUID().toString() : candidateId;
        this.name = name;
        this.numberOfVotesReceived = numberOfVotesReceived;
    }

    public String getCandidateId()
    {
        return candidateId;
    }

    public String getName()
    {
        return name;
    }

    public long getNumberOfVotesReceived()
    {
        return numberOfVotesReceived;
    }

    @Override
    public final boolean equals(final Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof Candidate))
        {
            return false;
        }
        final Candidate candidate = (Candidate) other;
        return numberOfVotesReceived == candidate.numberOfVotesReceived
               && Objects.equals(candidateId, candidate.candidateId)
               && Objects.equals(name, candidate.name);
    }

    @Override
    public final int hashCode()
    {
        return Objects.hash(candidateId, name, numberOfVotesReceived);
    }

    @Override
    public String toString()
    {
        return "Candidate{" +
               "candidateId='" + candidateId + '\'' +
               ", name='" + name + '\'' +
               ", numberOfVotesReceived=" + numberOfVotesReceived +
               '}';
    }
}
