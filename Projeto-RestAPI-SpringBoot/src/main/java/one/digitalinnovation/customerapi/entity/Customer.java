package one.digitalinnovation.customerapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity // Entidade
@Data // Automaticamente insere getter e setters
@Builder
@AllArgsConstructor // Insere os contrutores
@NoArgsConstructor
public class Customer {

    @Id // Chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de geracao do ID (ID gerado incremental o BD)
    private Long id;

    @Column(nullable = false) // Campo nao nulo e obrigatorio
    private String firstName;

    @Column(nullable = false) // Campo nao nulo e obrigatorio
    private String lastName;

    @Column(nullable = false, unique = true) // Campo nao nulo e campo unico (CPF)
    private String cpf;

    @Column(nullable = false)
    private String rua;

    private LocalDate birthDate;

    // Pessoa tem muitos telefones
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
