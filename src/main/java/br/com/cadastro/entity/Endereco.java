package br.com.cadastro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * A classe Endereco representa um endereço no sistema e é mapeada como uma
 * entidade JPA. Ela contém os campos relacionados a um endereço, como rua,
 * bairro, cidade, estado, número e CEP. A classe CadastroDePessoaDaoé
 * responsável pelas operações de persistência de dados no banco de dados para
 * uma entidade Pessoa. Utilize o JPA (Java Persistence API) para interagir com
 * a base de dados.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idEndereco")
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long idEndereco;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String numero;
	private String cep;

}
