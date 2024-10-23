package com.teletext.ecommerce.shared.authentication.domaine;

import com.teletext.ecommerce.shared.error.domain.Assert;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public record Username(String username) {
    public Username {
        Assert.field("username", username).notBlank().maxLength(100);
    }

    public String get() {
        return username();
    }

    public static Optional<Username> of(String username) {
        return Optional.ofNullable(username).filter(StringUtils::isNotBlank).map(Username::new);
    }
}