package com.project.Farmobile.dependencyTables.ordersHasProducts.data.DTO;

import com.project.Farmobile.orders.data.orders;
import com.project.Farmobile.products.data.products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderHasProductDTO {
    private orders order;
    private Map<products,Integer> products;
}
