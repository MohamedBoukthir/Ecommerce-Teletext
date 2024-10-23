package com.teletext.ecommerce.order.infrastructure.secondary.entity;

import java.lang.Long;
import java.lang.String;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated("Jilt-1.6.1")
public class UserEntityBuilder {
  private Long id;

  private String lastName;

  private String firstName;

  private String email;

  private String imageUrl;

  private UUID publicId;

  private String addressStreet;

  private String addressCity;

  private String addressZipCode;

  private String addressCountry;

  private Instant lastSeen;

  private Set<AuthorityEntity> authorities;

  public static UserEntityBuilder userEntity() {
    return new UserEntityBuilder();
  }

  public UserEntityBuilder id(final Long id) {
    this.id = id;
    return this;
  }

  public UserEntityBuilder lastName(final String lastName) {
    this.lastName = lastName;
    return this;
  }

  public UserEntityBuilder firstName(final String firstName) {
    this.firstName = firstName;
    return this;
  }

  public UserEntityBuilder email(final String email) {
    this.email = email;
    return this;
  }

  public UserEntityBuilder imageUrl(final String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public UserEntityBuilder publicId(final UUID publicId) {
    this.publicId = publicId;
    return this;
  }

  public UserEntityBuilder addressStreet(final String addressStreet) {
    this.addressStreet = addressStreet;
    return this;
  }

  public UserEntityBuilder addressCity(final String addressCity) {
    this.addressCity = addressCity;
    return this;
  }

  public UserEntityBuilder addressZipCode(final String addressZipCode) {
    this.addressZipCode = addressZipCode;
    return this;
  }

  public UserEntityBuilder addressCountry(final String addressCountry) {
    this.addressCountry = addressCountry;
    return this;
  }

  public UserEntityBuilder lastSeen(final Instant lastSeen) {
    this.lastSeen = lastSeen;
    return this;
  }

  public UserEntityBuilder authorities(final Set<AuthorityEntity> authorities) {
    this.authorities = authorities;
    return this;
  }

  public UserEntity build() {
    return new UserEntity(id, lastName, firstName, email, imageUrl, publicId, addressStreet, addressCity, addressZipCode, addressCountry, lastSeen, authorities);
  }
}
