package com.exemplo.crud.domain.product;

import com.exemplo.crud.domain.dto.ResquestProductDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "product")
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price_in_cents;
    private Boolean active;

    public Product(ResquestProductDTO resquestProductDTO){
        this.id = resquestProductDTO.id();
        this.name = resquestProductDTO.name();
        this.price_in_cents = resquestProductDTO.price_in_cents();
        this.active = true;
    }
}


