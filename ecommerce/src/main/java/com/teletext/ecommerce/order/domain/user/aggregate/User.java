package com.teletext.ecommerce.order.domain.user.aggregate;


import annotations.com.teletext.ecommerce.order.domain.user.aggregate.AuthorityBuilder;
import annotations.com.teletext.ecommerce.order.domain.user.aggregate.UserBuilder;
import com.teletext.ecommerce.order.domain.user.vo.*;
import com.teletext.ecommerce.shared.error.domain.Assert;
import org.jilt.Builder;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
public class User {

    private UserLastname userLastname;
    private UserFirstname userFirstname;
    private UserEmail userEmail;
    private UserPublicId userPublicId;
    private UserImageUrl userImageUrl;
    private Instant lastModifiedDate;
    private Instant createDate;
    private Set<Authority> authorities;
    private Long dbId;
    private UserAddress userAddress;
    private Instant lastSeen;

    public User(UserLastname userLastname, UserFirstname userFirstname, UserEmail userEmail, UserPublicId userPublicId, UserImageUrl userImageUrl, Instant lastModifiedDate, Instant createDate, Set<Authority> authorities, Long dbId, UserAddress userAddress, Instant lastSeen) {
        this.userLastname = userLastname;
        this.userFirstname = userFirstname;
        this.userEmail = userEmail;
        this.userPublicId = userPublicId;
        this.userImageUrl = userImageUrl;
        this.lastModifiedDate = lastModifiedDate;
        this.createDate = createDate;
        this.authorities = authorities;
        this.dbId = dbId;
        this.userAddress = userAddress;
        this.lastSeen = lastSeen;
    }

    public void assertMandatoryFields() {
        Assert.notNull("lastname", userLastname);
        Assert.notNull("firstname", userFirstname);
        Assert.notNull("email", userEmail);
        Assert.notNull("authorities", authorities);
    }

    public void updateFromUser(User user) {
        this.userEmail = user.userEmail;
        this.userImageUrl = user.userImageUrl;
        this.userFirstname = user.userFirstname;
        this.userLastname = user.userLastname;
    }

    public void initFieldForSignup() {
        this.userPublicId = new UserPublicId(UUID.randomUUID());
    }

    public static User fromTokenAttributes(Map<String, Object> attributes, List<String> rolesFromAccessToken) {
        UserBuilder userBuilder = UserBuilder.user();

        if(attributes.containsKey("preferred_email")) {
            userBuilder.userEmail(new UserEmail(attributes.get("preferred_email").toString()));
        }
        if(attributes.containsKey("last_name")) {
            userBuilder.userLastname(new UserLastname(attributes.get("last_name").toString()));
        }
        if(attributes.containsKey("first_name")) {
            userBuilder.userFirstname(new UserFirstname(attributes.get("first_name").toString()));
        }
        if(attributes.containsKey("picture")) {
            userBuilder.userImageUrl(new UserImageUrl(attributes.get("picture").toString()));
        }
        if(attributes.containsKey("last_signed_in")) {
            userBuilder.lastSeen(Instant.parse(attributes.get("last_signed_in").toString()));
        }

        Set<Authority> authorities = rolesFromAccessToken
                .stream()
                .map(authority -> AuthorityBuilder.authority().name(new AuthorityName(authority)).build())
                .collect(Collectors.toSet());
        userBuilder.authorities(authorities);

        return userBuilder.build();

    }

    public UserLastname getUserLastname() {
        return userLastname;
    }

    public UserFirstname getUserFirstname() {
        return userFirstname;
    }

    public UserEmail getUserEmail() {
        return userEmail;
    }

    public UserPublicId getUserPublicId() {
        return userPublicId;
    }

    public UserImageUrl getUserImageUrl() {
        return userImageUrl;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Long getDbId() {
        return dbId;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public Instant getLastSeen() {
        return lastSeen;
    }
}
