package it.academy.AGMExpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clienti")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "p_iva", nullable = false)
    private long partitaIva;

    @Column(name = "cognome", nullable = false, length = 30)
    private String cognome;

    @Column(name = "n_telefono", nullable = false, length = 15)
    private String numeroTelefono;

    @JsonIgnore
    @OneToMany(mappedBy = "mittente")
    private List<Pacco> pacchiInviati;

    @JsonIgnore
    @OneToMany(mappedBy = "destinatario")
    private List<Pacco> pacchiRicevuti;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ruolo_id", nullable = false)
    private Ruolo ruolo;

}
