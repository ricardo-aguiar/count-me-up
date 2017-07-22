package tech.experimental.countmeup.api.builder;

import tech.experimental.countmeup.api.User;

/**
 * Builder for {@link User}
 */
public final class UserBuilder
{
    private String userId;
    private String name;

    public static UserBuilder aUser()
    {
        return new UserBuilder();
    }

    public UserBuilder withUserId(String userId)
    {
        this.userId = userId;
        return this;
    }

    public UserBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public User buildWithGeneratedId()
    {
        return new User(null, name);
    }

    public User build()
    {
        return new User(userId, name);
    }
}
