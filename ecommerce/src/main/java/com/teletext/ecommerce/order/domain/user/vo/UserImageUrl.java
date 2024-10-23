package com.teletext.ecommerce.order.domain.user.vo;

import com.teletext.ecommerce.shared.error.domain.Assert;

public record UserImageUrl(String value) {
   public UserImageUrl {
        Assert.field("value", value).maxLength(1000);
    }
}
