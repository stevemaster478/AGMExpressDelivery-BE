package it.academy.AGMExpress.entity;

import jakarta.persistence.*;


@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvanzamento() {
        return avanzamento;
    }

    public void setAvanzamento(String avanzamento) {
        this.avanzamento = avanzamento;
    }

    public String getStatoConsegna() {
        return statoConsegna;
    }

    public void setStatoConsegna(String statoConsegna) {
        this.statoConsegna = statoConsegna;
    }
}
