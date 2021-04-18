package com.tomas.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "SamuraiQuote.findAll", query = "select t from SamuraiQuote as t")
})
@Table(name = "SAMURAIQUOTE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SamuraiQuote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long samuraiId;

    private String name;

    @Lob
    private byte[] quote;
}
