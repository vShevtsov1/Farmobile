package com.project.Farmobile.orders.data;

import com.project.Farmobile.category.data.category;
import com.project.Farmobile.users.data.users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class orders {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idOrders")
    private Long idOrders;
    @Column(name = "date")
    private Date date;
    @Column(name = "summ")
    private Double summ;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "adress")
    private String adress;
    @ManyToOne
    @JoinColumn(name = "users_idusers")
    private users users;

    public orders(Date date, Double summ, String phoneNumber, String adress, com.project.Farmobile.users.data.users users) {
        this.date = date;
        this.summ = summ;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.users = users;
    }
}
