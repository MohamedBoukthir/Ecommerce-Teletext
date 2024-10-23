package com.teletext.ecommerce.order.infrastructure.secondary.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.lang.String;
import javax.annotation.processing.Generated;

@Generated("Jilt-1.6.1")
public class AuthorityEntityBuilder {
  private String name;

  public static AuthorityEntityBuilder authorityEntity() {
    return new AuthorityEntityBuilder();
  }

  public AuthorityEntityBuilder name(@NotNull @Size(max = 50) final String name) {
    this.name = name;
    return this;
  }

  public AuthorityEntity build() {
    return new AuthorityEntity(name);
  }
}
