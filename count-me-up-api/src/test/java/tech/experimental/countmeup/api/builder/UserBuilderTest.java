package tech.experimental.countmeup.api.builder;

import org.junit.Test;
import tech.experimental.countmeup.api.User;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link UserBuilder}
 */
public class UserBuilderTest
{
    @Test
    public void itBuildsACandidate()
    {
        final User expected = new User("ID", "NAME");

        final User actual = new UserBuilder().withName("NAME")
                                             .withUserId("ID")
                                             .build();

        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void itBuildsAUserWithGeneratedId()
    {
        final User actual = new UserBuilder().withName("NAME")
                                             .withUserId("ID")
                                             .build();

        assertThat(actual.getUserId()).isNotNull();
        assertThat(actual.getName()).isEqualTo("NAME");
    }
}
