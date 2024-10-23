package com.teletext.ecommerce.order.infrastructure.primary;

import java.lang.String;
import javax.annotation.processing.Generated;

@Generated("Jilt-1.6.1")
public class RestAuthorityBuilder {
  private String name;

  public static RestAuthorityBuilder restAuthority() {
    return new RestAuthorityBuilder();
  }

  public RestAuthorityBuilder name(final String name) {
    this.name = name;
    return this;
  }

  public RestAuthority build() {
    return new RestAuthority(name);
  }
}
