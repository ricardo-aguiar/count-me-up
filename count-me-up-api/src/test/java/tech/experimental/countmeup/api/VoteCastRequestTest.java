package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

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
}
