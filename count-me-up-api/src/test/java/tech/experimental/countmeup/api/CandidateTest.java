package tech.experimental.countmeup.api;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

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

}
