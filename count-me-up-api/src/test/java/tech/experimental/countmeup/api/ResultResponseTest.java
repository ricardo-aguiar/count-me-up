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
 * Test for {@link ResultResponse}
 */
public class ResultResponseTest
{
    @Test
    public void testEqualsAndHashCodeContract()
    {
        EqualsVerifier.forClass(ResultResponse.class).verify();
    }

    @Test
    public void testSerializationRoundTrip()
    {
        // Arrange
        final ResultResponse expected =  new ResultResponse(Collections.emptyList());

        try
        {
            final ResultResponse actual = JsonTestUtils.roundTrip(expected, ResultResponse.class);

            JsonTestUtils.assertEqualButNotSame(actual, expected);
        }
        catch (IOException e)
        {
            fail("Failed to de/serialise object. Reason: " + e);
        }
    }
}
