package br.com.cadastro.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import br.com.cadastro.entity.Pessoa;


/**
 * A classe CadastroDePessoaDao faz parte da camada de persistência, utilizando o
 * padrão DAO (Data Access Object) para isolar a lógica de persistência da
 * lógica de negócios. Ela trabalha diretamente com o banco de dados e é
 * utilizada pelos serviços para realizar as operações de CRUD (Criar, Ler,
 * Atualizar, Excluir).
 * 
 */
@Stateless
public class CadastroDePessoaDao {

	@PersistenceContext
	private EntityManager manager;

	public CadastroDePessoaDao() {
		super();
	}

	/**
	 * Descrição : Persiste um novo objeto Pessoano banco de dados. Entrada : Um
	 * objeto Pessoaa ser salvo. Saída : O objeto Pessoaque foi salvo no banco de
	 * dados. Transação : A transação é iniciada para garantir que a operação de
	 * persistência seja realizada corretamente. salvar os pessoas no banco de dados
	 * 
	 * @param pessoa
	 * @return pessoa
	 */
	@Transactional
	public Pessoa cadastroDePessoa(Pessoa pessoa) {
		manager.persist(pessoa);
		return pessoa;
	}

	/**
	 * Descrição : Retorna uma lista de todas as pessoas cadastradas no banco de
	 * dados. Saída : Uma lista de objetos Pessoa. Transação : A transação garante
	 * que a leitura dos dados seja realizada corretamente. listar os pessoas do
	 * banco de dados
	 * 
	 * @return listaPessoas
	 */
	@Transactional
	public List<Pessoa> listaDadosDosCadastroDePessoa() {
		List<Pessoa> listaPessoas = null;
		listaPessoas = manager.createQuery("select c from Pessoa c", Pessoa.class).getResultList();
		return listaPessoas;
	}

	/**
	 * Descrição : Remover uma pessoa do banco de dados com base no objeto
	 * Pessoafornecido. Entrada : Um objeto Pessoaa ser removido. Saída : O objeto
	 * Pessoaque foi removido. Transação : A transação garante que a exclusão seja
	 * realizada corretamente. Remover os pessoas do banco de dados
	 * 
	 * @param pessoa
	 * @return pessoa
	 */
	@Transactional
	public Pessoa removerCadastroDePessoa(Pessoa pessoa) {
		pessoa = manager.merge(pessoa);
		manager.remove(pessoa);
		return pessoa;
	}

	/**
	 * Descrição : Atualiza as informações de uma pessoa no banco de dados. Entrada
	 * : Um objeto Pessoacom os dados a serem atualizados. Saída : O objeto
	 * Pessoaatualizado. Transação : A transação garante que as alterações sejam
	 * aplicadas corretamente. Editar os pessoas do banco de dados
	 * 
	 * @param pessoa
	 * @return pessoa
	 */
	@Transactional
	public Pessoa editarCadastroDePessoa(Pessoa pessoa) {
		manager.merge(pessoa);
		return pessoa;
	}

}
