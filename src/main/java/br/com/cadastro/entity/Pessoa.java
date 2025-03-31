package br.com.cadastro.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * A classe Pessoa representa uma pessoa no sistema, com diversos atributos
 * relacionados aos dados pessoais. Ela também está associada a um objeto da
 * classe Endereco(relacionamento ManyToOne ), ou seja, cada pessoa tem um
 * endereço. A classe Pessoaestá associada a um endereço, o que significa que
 * cada pessoa tem um único endereço relacionado.
 * O uso de CascadeType.ALL garante que as operações de persistência
 * Pessoa também afetam a entidade Endereco automaticamente.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPessoa")
@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long idPessoa;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String idade;
	private String sexo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco = new Endereco();

}
