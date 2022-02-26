package br.com.cadastroemailsenha.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TB_CADASTRO")
@GenericGenerator(
        name="SEQ_CADASTRO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value="SEQ_CADASTRO"),
                @Parameter(name = "initial_value",value="1"),
                @Parameter(name = "increment_size",value="1")
        }
)
public class CadastroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_CADASTRO")
    @Column(name="ID_CADASTRO")
    private Long numeroCadastro;

    @Column(name="DS_NOME")
    private String nome;

    @Column(name="DS_EMAIL")
    private String email;

    @Column(name="DS_SENHA")
    private String senha;

    private String erro;

}
