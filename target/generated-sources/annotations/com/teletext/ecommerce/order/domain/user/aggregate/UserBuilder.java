package com.teletext.ecommerce.order.domain.user.aggregate;

import com.teletext.ecommerce.order.domain.user.vo.UserAddress;
import com.teletext.ecommerce.order.domain.user.vo.UserEmail;
import com.teletext.ecommerce.order.domain.user.vo.UserFirstname;
import com.teletext.ecommerce.order.domain.user.vo.UserImageUrl;
import com.teletext.ecommerce.order.domain.user.vo.UserLastname;
import com.teletext.ecommerce.order.domain.user.vo.UserPublicId;
import java.lang.Long;
import java.time.Instant;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("Jilt-1.6.1")
public class UserBuilder {
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

  public static UserBuilder user() {
    return new UserBuilder();
  }

  public UserBuilder userLastname(final UserLastname userLastname) {
    this.userLastname = userLastname;
    return this;
  }

  public UserBuilder userFirstname(final UserFirstname userFirstname) {
    this.userFirstname = userFirstname;
    return this;
  }

  public UserBuilder userEmail(final UserEmail userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  public UserBuilder userPublicId(final UserPublicId userPublicId) {
    this.userPublicId = userPublicId;
    return this;
  }

  public UserBuilder userImageUrl(final UserImageUrl userImageUrl) {
    this.userImageUrl = userImageUrl;
    return this;
  }

  public UserBuilder lastModifiedDate(final Instant lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
    return this;
  }

  public UserBuilder createDate(final Instant createDate) {
    this.createDate = createDate;
    return this;
  }

  public UserBuilder authorities(final Set<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }

  public UserBuilder dbId(final Long dbId) {
    this.dbId = dbId;
    return this;
  }

  public UserBuilder userAddress(final UserAddress userAddress) {
    this.userAddress = userAddress;
    return this;
  }

  public UserBuilder lastSeen(final Instant lastSeen) {
    this.lastSeen = lastSeen;
    return this;
  }

  public User build() {
    return new User(userLastname, userFirstname, userEmail, userPublicId, userImageUrl, lastModifiedDate, createDate, authorities, dbId, userAddress, lastSeen);
  }
}
