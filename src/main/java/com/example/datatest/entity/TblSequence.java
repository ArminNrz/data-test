package com.example.datatest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TblSequence {

    @Id
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    private Long id;

    private String name;

    private Long code;
}
