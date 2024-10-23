package com.teletext.ecommerce.order.domain.user.vo;

import com.teletext.ecommerce.shared.error.domain.Assert;

public record UserLastname(String value) {
    public UserLastname {
        Assert.field("value",value).maxLength(255);
    }
}
