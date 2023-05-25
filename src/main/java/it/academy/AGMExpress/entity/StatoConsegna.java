package it.academy.AGMExpress.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "stato_consegne")
public class StatoConsegna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String avanzamento;
    @NotNull
    private String stato;
}
