package com.teletext.ecommerce.order.domain.user.vo;

import java.lang.String;
import javax.annotation.processing.Generated;

@Generated("Jilt-1.6.1")
public class UserAddressBuilder {
  private String street;

  private String city;

  private String zipCode;

  private String country;

  public static UserAddressBuilder userAddress() {
    return new UserAddressBuilder();
  }

  public UserAddressBuilder street(final String street) {
    this.street = street;
    return this;
  }

  public UserAddressBuilder city(final String city) {
    this.city = city;
    return this;
  }

  public UserAddressBuilder zipCode(final String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  public UserAddressBuilder country(final String country) {
    this.country = country;
    return this;
  }

  public UserAddress build() {
    return new UserAddress(street, city, zipCode, country);
  }
}
