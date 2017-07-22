package tech.experimental.countmeup.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * An user of the system. Users can vote in a competition for candidates.
 */
public class User
{
    private final String userId;
    private final String name;

    /**
     * Constructs a new User
     * @param userId The user unique id or if <code>null</code> an UUID will be generated.
     * @param name The user name
     */
    @JsonCreator
    public User(@JsonProperty("userId") final String userId,
                @JsonProperty("name") final String name)
    {
        this.userId = userId == null ? UUID.randomUUID().toString() : userId;
        this.name = name;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public final boolean equals(final Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof User))
        {
            return false;
        }
        final User user = (User) other;
        return Objects.equals(userId, user.userId)
               && Objects.equals(name, user.name);
    }

    @Override
    public final int hashCode()
    {
        return Objects.hash(userId, name);
    }

    @Override
    public String toString()
    {
        return "User{" + "userId='" + userId + '\'' + ", name='" + name + '\'' + '}';
    }
}
