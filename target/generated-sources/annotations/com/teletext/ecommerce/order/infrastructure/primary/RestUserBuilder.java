package com.teletext.ecommerce.order.infrastructure.primary;

import java.lang.String;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated("Jilt-1.6.1")
public class RestUserBuilder {
  private UUID publicId;

  private String firstName;

  private String lastName;

  private String email;

  private String imageUrl;

  private Set<String> authorities;

  public static RestUserBuilder restUser() {
    return new RestUserBuilder();
  }

  public RestUserBuilder publicId(final UUID publicId) {
    this.publicId = publicId;
    return this;
  }

  public RestUserBuilder firstName(final String firstName) {
    this.firstName = firstName;
    return this;
  }

  public RestUserBuilder lastName(final String lastName) {
    this.lastName = lastName;
    return this;
  }

  public RestUserBuilder email(final String email) {
    this.email = email;
    return this;
  }

  public RestUserBuilder imageUrl(final String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public RestUserBuilder authorities(final Set<String> authorities) {
    this.authorities = authorities;
    return this;
  }

  public RestUser build() {
    return new RestUser(publicId, firstName, lastName, email, imageUrl, authorities);
  }
}
