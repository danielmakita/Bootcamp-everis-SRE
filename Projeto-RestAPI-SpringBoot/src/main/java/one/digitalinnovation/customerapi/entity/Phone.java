package one.digitalinnovation.customerapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.customerapi.enums.PhoneType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Entidade do banco de dados
@Data // Automaticamente insere getter e setters
@Builder
@AllArgsConstructor // Insere os contrutores
@NoArgsConstructor
public class Phone {

    @Id // Chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de geracao do ID (ID gerado incremental o BD)
    private Long id;

    @Enumerated(EnumType.STRING) // Tipo Telefone - Home, Mobile ou Comercial
    @Column(nullable = false) // Campo nao nulo e obrigatorio
    private PhoneType type;

    @Column(nullable = false) // Campo nao nulo e obrigatorio
    private String number;


}
