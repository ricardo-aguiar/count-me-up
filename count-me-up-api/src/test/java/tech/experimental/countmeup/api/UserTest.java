package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

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
}
