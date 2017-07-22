package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

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
}
