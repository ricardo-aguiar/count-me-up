package tech.experimental.countmeup.api.builder;

import org.junit.Test;
import tech.experimental.countmeup.api.Candidate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link CandidateBuilder}
 */
public class CandidateBuilderTest
{

    @Test
    public void itBuildsACandidate()
    {
        final Candidate expected = new Candidate("ID", "NAME", 1);

        final Candidate actual = new CandidateBuilder().withCandidateId("ID")
                                                       .withName("NAME")
                                                       .withNumberOfVotesReceived(1)
                                                       .build();

        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void itBuildsACandidateWithGeneratedId()
    {
        final Candidate actual = new CandidateBuilder().withName("NAME")
                                                       .withNumberOfVotesReceived(1)
                                                       .buildWithGeneratedId();

        assertThat(actual.getCandidateId()).isNotNull();
        assertThat(actual.getName()).isEqualTo("NAME");
        assertThat(actual.getNumberOfVotesReceived()).isEqualTo(1);
    }
}
