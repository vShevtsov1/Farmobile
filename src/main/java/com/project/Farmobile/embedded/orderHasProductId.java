package com.project.Farmobile.embedded;

import com.project.Farmobile.orders.data.orders;
import com.project.Farmobile.products.data.products;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class orderHasProductId implements Serializable {

    @Column(name = "product_idProducts")
    private Long productId;

    @Column(name = "order_idorders")
    private UUID ordersId;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        orderHasProductId that = (orderHasProductId) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(ordersId, that.ordersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, ordersId);
    }
}
