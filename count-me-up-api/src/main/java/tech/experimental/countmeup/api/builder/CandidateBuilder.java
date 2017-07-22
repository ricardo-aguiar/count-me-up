package tech.experimental.countmeup.api.builder;

import tech.experimental.countmeup.api.Candidate;

/**
 * A builder for {@link Candidate}
 */
public final class CandidateBuilder
{
    private String candidateId;
    private String name;
    private long numberOfVotesReceived;

    public CandidateBuilder withCandidateId(final String candidateId)
    {
        this.candidateId = candidateId;
        return this;
    }

    public CandidateBuilder withName(final String name)
    {
        this.name = name;
        return this;
    }

    public CandidateBuilder withNumberOfVotesReceived(long numberOfVotesReceived)
    {
        this.numberOfVotesReceived = numberOfVotesReceived;
        return this;
    }

    public Candidate buildWithGeneratedId()
    {
        return new Candidate(null, name, numberOfVotesReceived);
    }

    public Candidate build()
    {
        return new Candidate(candidateId, name, numberOfVotesReceived);
    }
}
