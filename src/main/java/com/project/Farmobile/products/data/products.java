package com.project.Farmobile.products.data;

import com.project.Farmobile.category.data.category;
import com.project.Farmobile.photo.data.photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class products {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idProducts")
    private Long idProducts;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "fullDescription",length = 1000)
    private String fullDescription;
    @Column(name = "productSpecs")
    private String productSpecs;

    @OneToOne
    @JoinColumn(name = "category_idcategory")
    private category category;

    @OneToOne
    @JoinColumn(name="photo_idphoto")
    private photo photo;

}
