package com.project.Farmobile.photo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="photo")
public class photo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idphoto")
    private Long idphoto;

    @Column(name = "link")
    private String link;

    public photo(String link) {
        this.link = link;
    }
}
