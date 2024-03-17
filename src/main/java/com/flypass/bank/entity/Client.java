package com.flypass.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IdentificationType status = IdentificationType.CC;

    @Column(name = "identification_number", nullable = false)
    private String identificationNumer;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Instant birthday;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    protected Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    protected Instant lastModifiedDate = Instant.now();

    @LastModifiedDate
    @Column(name = "deleted_date")
    @JsonIgnore
    protected Instant deletedDate = Instant.now();
}
