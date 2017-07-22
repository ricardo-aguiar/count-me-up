package tech.experimental.countmeup.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Competition Registration request for consumers
 */
public class CompetitionRegistrationRequest
{
    private final List<Competition> competitions;

    /**
     * Constructs a new request
     * @param competitions a list of the competitions to register
     */
    @JsonCreator
    public CompetitionRegistrationRequest(@JsonProperty("competitions") final List<Competition> competitions)
    {
        this.competitions = competitions == null ? Collections.emptyList() : new ArrayList<>(competitions);
    }

    /**
     * Gets the list of competitions.
     * @return An unmodifiable list of competitions
     */
    public List<Competition> getCompetitions()
    {
        return Collections.unmodifiableList(competitions);
    }

    @Override
    public final boolean equals(final Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof CompetitionRegistrationRequest))
        {
            return false;
        }
        final CompetitionRegistrationRequest that = (CompetitionRegistrationRequest) other;
        return Objects.equals(competitions, that.competitions);
    }

    @Override
    public final int hashCode()
    {
        return Objects.hash(competitions);
    }

    @Override
    public String toString()
    {
        return "CompetitionRegistrationRequest{" + "competitions=" + competitions + '}';
    }
}
