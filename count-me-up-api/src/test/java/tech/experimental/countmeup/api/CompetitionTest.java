package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import tech.experimental.countmeup.api.builder.CompetitionBuilder;
import tech.experimental.countmeup.api.utils.JsonTestUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.Assert.fail;

/**
 * Test for {@link Competition}
 */
public class CompetitionTest
{
    @Test
    public void testEqualsAndHashCodeContract()
    {
        EqualsVerifier.forClass(Competition.class).verify();
    }

    @Test
    public void testSerializationRoundTrip()
    {
        // Arrange
        final Competition expected = new CompetitionBuilder().withCandidates(Collections.emptyList())
                                                             .withStartDate(LocalDateTime.now())
                                                             .withEndDate(LocalDateTime.now())
                                                             .buildWithGeneratedId();

        try
        {
            final Competition actual = JsonTestUtils.roundTrip(expected, Competition.class);

            JsonTestUtils.assertEqualButNotSame(actual, expected);
        }
        catch (IOException e)
        {
            fail("Failed to de/serialise object");
        }
    }
}
