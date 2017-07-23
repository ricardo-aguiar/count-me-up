package tech.experimental.countmeup.api.builder;

import org.junit.Test;
import tech.experimental.countmeup.api.Competition;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link CompetitionBuilder}
 */
public class CompetitionBuilderTest
{
    @Test
    public void itBuildsACompetition()
    {
        final Competition expected = new Competition("ID", Collections.emptyList(), LocalDateTime.MAX,
                                                     LocalDateTime.MAX, 3);

        final Competition actual = new CompetitionBuilder().withCandidates(Collections.emptyList())
                                                           .withCompetitionId("ID")
                                                           .withStartDate(LocalDateTime.MAX)
                                                           .withEndDate(LocalDateTime.MAX)
                                                           .withMaxNumberOfVotesPerUser(3)
                                                           .build();

        assertThat(actual).isEqualTo(expected);
    }

}
