package com.teletext.ecommerce.order.domain.user.vo;

import com.teletext.ecommerce.shared.error.domain.Assert;

public record AuthorityName(String name) {
    public AuthorityName {
        Assert.field("name", name).notNull();
    }
}
