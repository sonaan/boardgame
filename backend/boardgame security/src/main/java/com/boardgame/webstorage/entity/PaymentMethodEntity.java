package com.boardgame.webstorage.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "payment_method", schema = "public", catalog = "education")
@Data
public class PaymentMethodEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "method")
    private String method;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethodEntity that = (PaymentMethodEntity) o;
        return id == that.id && Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, method);
    }
}
