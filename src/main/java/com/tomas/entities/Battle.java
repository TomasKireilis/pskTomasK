package com.tomas.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BATTLE")
@Builder
@Getter
@NamedQueries({
        @NamedQuery(name = "Battle.findAll", query = "select a from Battle as a")
})
@AllArgsConstructor
@NoArgsConstructor
public class Battle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(targetEntity = Samurai.class)
    List<Samurai> samurais = new ArrayList<>();
}