package com.teletext.ecommerce.order.infrastructure.secondary.entity;

import annotations.com.teletext.ecommerce.order.domain.user.aggregate.UserBuilder;
import annotations.com.teletext.ecommerce.order.domain.user.vo.UserAddressBuilder;
import annotations.com.teletext.ecommerce.order.infrastructure.secondary.entity.UserEntityBuilder;
import com.teletext.ecommerce.order.domain.user.aggregate.User;
import com.teletext.ecommerce.order.domain.user.vo.UserEmail;
import com.teletext.ecommerce.order.domain.user.vo.UserImageUrl;
import com.teletext.ecommerce.order.domain.user.vo.UserLastname;
import com.teletext.ecommerce.order.domain.user.vo.UserPublicId;
import com.teletext.ecommerce.shared.jpa.AbstractAuditingEntity;
import jakarta.persistence.*;
import org.jilt.Builder;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "teletext_user")
@Builder
public class UserEntity extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequenceGenerator")
    @SequenceGenerator(name = "userSequenceGenerator", sequenceName = "user_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "public_id")
    private UUID publicId;

    @Column(name = "address_street")
    private String addressStreet;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_zip_code")
    private String addressZipCode;

    @Column(name = "address_country")
    private String addressCountry;

    @Column(name = "last_seen")
    private Instant lastSeen;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")}
    )
    private Set<AuthorityEntity> authorities = new HashSet<>();

    public UserEntity() {
    }

    public UserEntity(Long id, String lastname, String firstname, String email, String imageUrl, UUID publicId, String addressStreet, String addressCity, String addressZipCode, String addressCountry, Instant lastSeen, Set<AuthorityEntity> authorities) {
        this.id = id;
        this.lastName = lastname;
        this.firstName = firstname;
        this.email = email;
        this.imageUrl = imageUrl;
        this.publicId = publicId;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressZipCode = addressZipCode;
        this.addressCountry = addressCountry;
        this.lastSeen = lastSeen;
        this.authorities = authorities;
    }

    public void updateFromUser(User user) {
        this.email = user.getUserEmail().value();
        this.lastName = user.getUserLastname().value();
        this.firstName = user.getUserFirstname().value();
        this.imageUrl = user.getUserImageUrl().value();
        this.lastSeen = user.getLastSeen();
    }

    public static UserEntity from(User user) {
        UserEntityBuilder userEntityBuilder = UserEntityBuilder.userEntity();

        if (user.getUserImageUrl() != null) {
            userEntityBuilder.imageUrl(user.getUserImageUrl().value());
        }
        if (user.getUserPublicId() != null) {
            userEntityBuilder.publicId(user.getUserPublicId().value());
        }
        if (user.getUserAddress() != null) {
            userEntityBuilder.addressCity(user.getUserAddress().city());
            userEntityBuilder.addressCountry(user.getUserAddress().country());
            userEntityBuilder.addressZipCode(user.getUserAddress().zipCode());
            userEntityBuilder.addressStreet(user.getUserAddress().street());
        }
        return userEntityBuilder
                .authorities(AuthorityEntity.from(user.getAuthorities()))
                .email(user.getUserEmail().value())
                .firstname(user.getUserFirstname().value())
                .lastname(user.getUserLastname().value())
                .lastSeen(user.getLastSeen())
                .id(user.getDbId())
                .build();
    }

    public static User toDomain(UserEntity userEntity) {
        UserBuilder userBuilder = UserBuilder.user();

        if (userEntity.getImageUrl() != null) {
            userBuilder.userImageUrl(new UserImageUrl(userEntity.getImageUrl()));
        }
        if (userEntity.getAddressStreet() != null) {
            userBuilder.userAddress(
                    UserAddressBuilder.userAddress()
                            .city(userEntity.getAddressCity())
                            .country(userEntity.getAddressCountry())
                            .zipCode(userEntity.getAddressZipCode())
                            .street(userEntity.getAddressStreet())
                            .build());
        }
        return userBuilder
                .userEmail(new UserEmail(userEntity.getEmail()))
                .userLastname(new UserLastname(userEntity.getLastName()))
                .authorities(AuthorityEntity.toDomain(userEntity.getAuthorities()))
                .userPublicId(new UserPublicId(userEntity.getPublicId()))
                .lastModifiedDate(userEntity.getLastModifiedDate())
                .createDate(userEntity.getCreatedDate())
                .dbId(userEntity.getId())
                .build();
    }

    public static Set<UserEntity> from(List<User> users) {
        return users.stream().map(UserEntity::from).collect(Collectors.toSet());
    }

    public static Set<User> toDomain(List<UserEntity> users) {
        return users.stream().map(UserEntity::toDomain).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public Instant getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Instant lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Set<AuthorityEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity that)) return false;
        return Objects.equals(publicId, that.publicId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(publicId);
    }
}
