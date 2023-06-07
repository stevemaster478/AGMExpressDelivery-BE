package it.academy.AGMExpress.entity;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "ruolo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ruolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "ruolo")
    private List<Cliente> clienti;
}
