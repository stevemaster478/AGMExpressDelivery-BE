package it.academy.AGMExpress.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
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

    @OneToMany(mappedBy = "statoConsegna")
    private List<Consegna> consegne;
}
