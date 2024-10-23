package com.teletext.ecommerce.order.domain.user.vo;

import com.teletext.ecommerce.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public record UserAddressToUpdate(UserPublicId userPublicId, UserAddress userAddress) {
    public UserAddressToUpdate{
        Assert.notNull("value", userPublicId);
        Assert.notNull("value",userPublicId);
    }
}
