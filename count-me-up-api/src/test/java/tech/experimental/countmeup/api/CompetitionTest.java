package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * Test for {@link Competition}
 */
public class CompetitionTest
{
    @Test
    public void testEqualsAndHashCodeContract()
    {
        EqualsVerifier.forClass(Candidate.class).verify();
    }
}
