package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import tech.experimental.countmeup.api.builder.CandidateBuilder;
import tech.experimental.countmeup.api.utils.JsonTestUtils;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Test for {@link Candidate}
 */
public class CandidateTest
{

    @Test
    public void testEqualsAndHashcodeContract()
    {
        EqualsVerifier.forClass(Candidate.class).verify();;
    }

    @Test
    public void testSerializationRoundTrip()
    {
        final Candidate expected = new CandidateBuilder().withName("NAME")
                                                         .withNumberOfVotesReceived(1)
                                                         .buildWithGeneratedId();
        try
        {
            final Candidate actual = JsonTestUtils.roundTrip(expected, Candidate.class);
            JsonTestUtils.assertEqualButNotSame(actual, expected);
        }
        catch (IOException e)
        {
            fail("Failed to de/serialise object. Reason: " + e);
        }
    }


}
