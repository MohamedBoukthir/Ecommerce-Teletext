package com.teletext.ecommerce.order.domain.user.vo;

import com.teletext.ecommerce.shared.error.domain.Assert;

import java.util.UUID;

public record UserPublicId(UUID value) {
    public UserPublicId {
        Assert.notNull("value", value);
    }
}
