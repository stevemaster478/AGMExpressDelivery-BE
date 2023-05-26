package it.academy.AGMExpress.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "stato_consegna")
public class StatoConsegna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String avanzamento;

    @Column(nullable = false)
    private String statoConsegna;
    
}
