package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import tech.experimental.countmeup.api.builder.CompetitionBuilder;
import tech.experimental.countmeup.api.builder.UserBuilder;
import tech.experimental.countmeup.api.utils.JsonTestUtils;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.fail;

/**
 * Test for {@link User}
 */
public class UserTest
{
    @Test
    public void testUserEqualsAndHashCodeContract()
    {
        EqualsVerifier.forClass(User.class).verify();
    }

    @Test
    public void testSerializationRoundTrip()
    {
        // Arrange
        final User user = new UserBuilder().withName("NAME").buildWithGeneratedId();

        try
        {
            final User actual = JsonTestUtils.roundTrip(user, User.class);
            JsonTestUtils.assertEqualButNotSame(actual, user);
        }
        catch (IOException e)
        {
            fail("Failed to de/serialise object");
        }
    }
}

