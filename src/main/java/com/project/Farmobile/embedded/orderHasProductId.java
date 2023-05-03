package com.project.Farmobile.embedded;

import com.project.Farmobile.orders.data.orders;
import com.project.Farmobile.products.data.products;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

public class orderHasProductId implements Serializable {

    @Column(name = "product_idProducts")
    private Long productId;

    @Column(name = "order_idorders")
    private UUID ordersId;
}
