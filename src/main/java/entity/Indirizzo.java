package entity;

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
    int id;

    String via;

    int cap;

    @Column(name="nr_civico")
    int numeroCivico;

    String interno;

    String citta;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
