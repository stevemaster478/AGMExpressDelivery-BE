package it.academy.AGMExpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "indirizzi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(nullable = false)
    private String via;

    @Column(nullable = false)
    private int cap;

    @Column(name="nr_civico", nullable = false)
    private int numeroCivico;

    @Column(nullable = false)
    private String interno;

    @Column(nullable = false)
    private String citta;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
