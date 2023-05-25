package it.academy.AGMExpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
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

    @Column(name = "id_pacchi", nullable = false)
    private int idPacchi;

    @Column(name = "id_stato_consegne", nullable = false)
    private int idStatoConsegne;

    @ManyToOne
    @JoinColumn(name = "targa", referencedColumnName = "targa")
    private Furgone furgone;

    @ManyToMany
    @JoinColumn(name = "id_pacchi", referencedColumnName = "id")
    private Pacco pacco;

    @ManyToOne
    @JoinColumn(name = "id_stato_consegn", referencedColumnName = "id")
    private StatoConsegna statoConsegna;

}
