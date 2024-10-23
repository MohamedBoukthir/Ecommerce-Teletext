package com.teletext.ecommerce.order.domain.user.vo;

import javax.annotation.processing.Generated;

@Generated("Jilt-1.6.1")
public class UserAddressToUpdateBuilder {
  private UserPublicId userPublicId;

  private UserAddress userAddress;

  public static UserAddressToUpdateBuilder userAddressToUpdate() {
    return new UserAddressToUpdateBuilder();
  }

  public UserAddressToUpdateBuilder userPublicId(final UserPublicId userPublicId) {
    this.userPublicId = userPublicId;
    return this;
  }

  public UserAddressToUpdateBuilder userAddress(final UserAddress userAddress) {
    this.userAddress = userAddress;
    return this;
  }

  public UserAddressToUpdate build() {
    return new UserAddressToUpdate(userPublicId, userAddress);
  }
}
