package com.project.Farmobile.dependencyTables.ordersHasProducts.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.project.Farmobile.products.data.products;
import com.project.Farmobile.orders.data.orders;
import com.project.Farmobile.embedded.orderHasProductId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderHasProduct")
public class orderHasProduct {

    @EmbeddedId
    private orderHasProductId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_idProducts")
    private products products;

    @ManyToOne
    @MapsId("ordersId")
    @JoinColumn(name = "orders_idorders")
    private orders order;

    private Integer count;
}

