package it.academy.AGMExpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="pacchi")
public class Pacco {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private float peso;
    private double profondita;
    private double larghezza;
    private double altezza;
    private String tipo;
    private String stato;
    private String trackingCode;
}
