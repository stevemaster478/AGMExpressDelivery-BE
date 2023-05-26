package it.academy.AGMExpress.entity;

import java.util.List;

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
@Table(name="furgone")
public class Furgone {
    @Id
    @Column(name = "targa", length=10, nullable = false)
    private String targa;

    @Column(nullable = false)
    private Float capacita;

    @Column(nullable = false)
    private String modello;

    @OneToMany(mappedBy = "furgone")
    private List<Consegna> consegne;

}
