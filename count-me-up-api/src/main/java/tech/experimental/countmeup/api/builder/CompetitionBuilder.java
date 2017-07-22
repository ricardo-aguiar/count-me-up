package tech.experimental.countmeup.api.builder;

import tech.experimental.countmeup.api.Candidate;
import tech.experimental.countmeup.api.Competition;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Buidler for {@link Competition}
 */
public final class CompetitionBuilder
{
    private String competitionId;
    private List<Candidate> candidates;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public CompetitionBuilder withCompetitionId(final String competitionId)
    {
        this.competitionId = competitionId;
        return this;
    }

    public CompetitionBuilder withCandidates(final List<Candidate> candidates)
    {
        this.candidates = candidates;
        return this;
    }

    public CompetitionBuilder withStartDate(final LocalDateTime startDate)
    {
        this.startDate = startDate;
        return this;
    }

    public CompetitionBuilder withEndDate(final LocalDateTime endDate)
    {
        this.endDate = endDate;
        return this;
    }

    public Competition buildWithGeneratedId()
    {
        return new Competition(null, candidates, startDate, endDate);
    }

    public Competition build()
    {
        return new Competition(competitionId, candidates, startDate, endDate);
    }
}
