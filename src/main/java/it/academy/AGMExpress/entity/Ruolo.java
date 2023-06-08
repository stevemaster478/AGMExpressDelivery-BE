package it.academy.AGMExpress.entity;

import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @OneToMany(mappedBy = "ruolo")
    private List<Cliente> clienti;
}
