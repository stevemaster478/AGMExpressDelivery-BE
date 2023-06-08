package it.academy.AGMExpress.entity;

import it.academy.AGMExpress.utilities.TrackingCodeGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
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

    @JsonIgnore
    @ManyToMany(mappedBy = "pacchi")
    private List<Consegna> consegne;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_mittente", referencedColumnName = "id", insertable = false, updatable = false)
    private Cliente mittente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_destinatario", referencedColumnName = "id", insertable = false, updatable = false)
    private Cliente destinatario;

    public Pacco() {
        this.trackingCode = TrackingCodeGenerator.generateTrackingCode();
    }
}
