package br.com.cadastro.service;

import java.util.List;

import javax.ejb.Local;

import br.com.cadastro.entity.Pessoa;

/**
 * A interface CadastroDePessoaServicedefine os métodos que devem ser
 * implementados por qualquer classe de serviço responsável pela manipulação dos
 * dados das pessoas. Ela utiliza o padrão de injeção de dependências e é
 * marcada como um EJB (Enterprise JavaBean) local , permitindo que os métodos
 * sejam invocados dentrolocal, permitindo que os métodos sejam invocados dentro
 * do mesmo módulo de aplicação.
 */
@Local
public interface CadastroDePessoaService {

	/**
	 * Descrição : Este método é responsável por cadastrar uma nova pessoa no
	 * sistema. Parâmetros : pessoa : Objeto do tipo Pessoaque contém os dados da
	 * pessoa a ser cadastrada.
	 * 
	 * Retorno : retorna o objeto Pessoacom os dados cadastrados (incluindo o
	 * idPessoagerado automaticamente).
	 * 
	 * @param pessoa
	 * @return
	 */
	public Pessoa cadastroDePessoa(Pessoa pessoa);

	/**
	 * Descrição : Este método é responsável por listar todas as pessoas cadastradas
	 * no sistema. Retorno.: Retorna uma lista de objetos Pessoa
	 * @param pessoa
	 * @return pessoa
	 */
	public List<Pessoa> listaDadosDosCadastroDePessoa();

	
	/**
	 * Descrição : Este método é responsável por listar todas as pessoas cadastradas
	 * no sistema. Retorno.: Retorna uma lista de objetos Pessoa.
	 * @param pessoa
	 * @return pessoa
	 */
	public Pessoa removerCadastroDePessoa(Pessoa pessoa);

	
	/**
	 * Descrição : Este método é responsável por editar os dados de uma pessoa já
	 * cadastrada no sistema. pessoa : Objeto do tipo Pessoacontendo os dados a
	 * serem atualizados. Retorno : Retorna o objeto Pessoacom os dados atualizados.
	 * 
	 * @param pessoa
	 * @return
	 */
	public Pessoa editarCadastroDePessoa(Pessoa pessoa);

}
