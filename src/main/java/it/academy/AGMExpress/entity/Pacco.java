package it.academy.AGMExpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "pacchi")
public class Pacco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int id_mittente;

    @Column(nullable = false)
    
    private int id_destinatario;

    @Column(nullable = false)
    private float peso;

    @Column(nullable = false)
    private double profondita;

    @Column(nullable = false)
    private double larghezza;

    @Column(nullable = false)
    private double altezza;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String stato;

    @Column(nullable = false)
    private String trackingCode;

    @ManyToMany(mappedBy = "pacchi")
    private List<Consegna> consegne;

    @ManyToOne
    @JoinColumn(name = "id_mittente", referencedColumnName = "id", insertable = false, updatable = false)
    private Cliente mittente;

    @ManyToOne
    @JoinColumn(name = "id_destinatario", referencedColumnName = "id", insertable = false, updatable = false)
    private Cliente destinatario;
}
