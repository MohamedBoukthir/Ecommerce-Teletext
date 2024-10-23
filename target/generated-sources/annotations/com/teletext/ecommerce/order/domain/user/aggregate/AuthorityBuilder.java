package com.teletext.ecommerce.order.domain.user.aggregate;

import com.teletext.ecommerce.order.domain.user.vo.AuthorityName;
import javax.annotation.processing.Generated;

@Generated("Jilt-1.6.1")
public class AuthorityBuilder {
  private AuthorityName name;

  public static AuthorityBuilder authority() {
    return new AuthorityBuilder();
  }

  public AuthorityBuilder name(final AuthorityName name) {
    this.name = name;
    return this;
  }

  public Authority build() {
    return new Authority(name);
  }
}
