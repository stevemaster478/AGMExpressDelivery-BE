package entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


@Entity
@Table(name = "clienti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    @ManyToOne
    private int id;

    private String nome;

    private String cognome;

    @Column(name="p_iva")
    private long partitaIva;

    @Column(name="n_telefono")
    private int numeroTelefono;


    @OneToMany(mappedBy = "cliente")
    private List<Indirizzo> indirizzi;




}
