package com.tomas.rest.contracts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class BattleDto {
    private Long id;
    private String name;
    private Date creationDate;
}
