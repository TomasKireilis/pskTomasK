package com.tomas.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.LockModeType.WRITE;

@Entity
@Table(name = "BATTLE")
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
    @Setter
    @Column(name = "name")
    private String name;
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    @Setter
    private Integer version;
    @Setter
    private Date creationDate;
    @ManyToMany(targetEntity = Samurai.class)
    List<Samurai> samurais = new ArrayList<>();
}