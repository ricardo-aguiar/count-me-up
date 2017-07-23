package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import tech.experimental.countmeup.api.builder.UserBuilder;
import tech.experimental.countmeup.api.utils.JsonTestUtils;

import java.io.IOException;

import static org.junit.Assert.fail;

/**
 * Test for {@link VoteCastRequest}
 */
public class VoteCastRequestTest
{
    @Test
    public void testEqualAndHashCodeContract()
    {
        EqualsVerifier.forClass(VoteCastRequest.class).verify();
    }

    @Test
    public void testSerializationRoundTrip()
    {
        // Arrange
        final VoteCastRequest request = new VoteCastRequest("VOTER", "CANDIDATE", "COMP_ID");

        try
        {
            final VoteCastRequest actual = JsonTestUtils.roundTrip(request, VoteCastRequest.class);
            JsonTestUtils.assertEqualButNotSame(actual, request);
        }
        catch (IOException e)
        {
            fail("Failed to de/serialise object. Reason: " + e);
        }
    }
}
