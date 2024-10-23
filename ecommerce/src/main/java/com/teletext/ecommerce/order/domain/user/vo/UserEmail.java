package com.teletext.ecommerce.order.domain.user.vo;

import com.teletext.ecommerce.shared.error.domain.Assert;

public record UserEmail(String value) {
    public UserEmail {
        Assert.field("value", value).maxLength(255);
    }
}
