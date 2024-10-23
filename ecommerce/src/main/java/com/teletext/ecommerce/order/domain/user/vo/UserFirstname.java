package com.teletext.ecommerce.order.domain.user.vo;

import com.teletext.ecommerce.shared.error.domain.Assert;

public record UserFirstname(String value) {
    public UserFirstname {
        Assert.field("value", value).maxLength(255);
    }
}
