package com.tomas.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SAMURAI")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Samurai.findAll", query = "select a from Samurai as a")
})
public class Samurai implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Long amount;
    private Date creationDate;
    private String description;
    private BigDecimal price;

    @OneToMany(targetEntity = SamuraiQuote.class, cascade=CascadeType.ALL)
    private List<SamuraiQuote> quotes = new ArrayList<>();
}
