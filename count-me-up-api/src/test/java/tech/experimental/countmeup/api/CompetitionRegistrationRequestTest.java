package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import tech.experimental.countmeup.api.builder.CompetitionBuilder;
import tech.experimental.countmeup.api.utils.JsonTestUtils;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.fail;

/**
 * Test for {@link CompetitionRegistrationRequest}
 */
public class CompetitionRegistrationRequestTest
{
    @Test
    public void testEqualAndHashCodeContract()
    {
        EqualsVerifier.forClass(CompetitionRegistrationRequest.class).verify();
    }

    @Test
    public void testSerializationRoundTrip()
    {
        // Arrange
        final Competition competition = new CompetitionBuilder().buildWithGeneratedId();
        final CompetitionRegistrationRequest expected =
                new CompetitionRegistrationRequest(Collections.singletonList(competition));

        try
        {
            final CompetitionRegistrationRequest actual =
                    JsonTestUtils.roundTrip(expected, CompetitionRegistrationRequest.class);
            JsonTestUtils.assertEqualButNotSame(actual, expected);
        }
        catch (IOException e)
        {
            fail("Failed to de/serialise object. Reason: " + e);
        }
    }
}
