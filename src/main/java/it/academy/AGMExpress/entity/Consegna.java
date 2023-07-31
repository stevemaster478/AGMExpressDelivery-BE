package it.academy.AGMExpress.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consegna")
public class Consegna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "inizio_consegna_data", nullable = false)
    private String inizioConsegnaData;

    @Column(name = "fine_consegna_data", nullable = false)
    private String fineConsegnaData;
    @Column(name = "targa", nullable = false)
    private String targa;
    @Column(name = "id_stato_consegna", nullable = false)
    private int idStatoConsegna;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "targa", referencedColumnName = "targa", insertable = false, updatable = false)
    private Furgone furgone;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_stato_consegna", referencedColumnName = "id", insertable = false, updatable = false)
    private StatoConsegna statoConsegna;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pacco_consegna", joinColumns = @JoinColumn(name = "id_consegna"), inverseJoinColumns = @JoinColumn(name = "id_pacco"))
    private List<Pacco> pacchi;



    private int id_cliente;
}
