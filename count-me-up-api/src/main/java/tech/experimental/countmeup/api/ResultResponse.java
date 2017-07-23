package tech.experimental.countmeup.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The response for a results request. It return a list of the candidates including the number of votes received.
 */
public class ResultResponse
{
    private final List<Candidate> candidates;

    /**
     * Contructor
     * @param candidates A list of the candidates with their number of votes received.
     */
    @JsonCreator
    public ResultResponse(@JsonProperty("candidates") final List<Candidate> candidates)
    {
        // Copying the list here and returning an unmodifiable collection in the getter to ensure immutability
        this.candidates = candidates ==null ? Collections.emptyList() : new ArrayList<>(candidates);
    }

    public List<Candidate> getCandidates()
    {
        return Collections.unmodifiableList(candidates);
    }

    @Override
    public final boolean equals(final Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof ResultResponse))
        {
            return false;
        }
        final ResultResponse that = (ResultResponse) other;
        return Objects.equals(candidates, that.candidates);
    }

    @Override
    public final int hashCode()
    {
        return Objects.hash(candidates);
    }

    @Override
    public final String toString()
    {
        return "ResultResponse{" +
               "candidates=" + candidates +
               '}';
    }
}
