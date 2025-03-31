package br.com.cadastro.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.cadastro.dao.CadastroDePessoaDao;
import br.com.cadastro.entity.Pessoa;

/**
 * Ela utiliza uma A classe CadastroDePessoaServiceImplé responsável por
 * implementar os métodos definidos na interface CadastroDePessoaService. Ela
 * utiliza uma classe CadastroDePessoaDaopara interagir com o banco de dados e
 * executar operações como cadastrar, listar, editar e remover pessoas.
 */
@RequestScoped
public class CadastroDePessoaServiceImpl implements CadastroDePessoaService {

	@Inject
	private CadastroDePessoaDao cadastroDePessoaDao;

	/**
	 * Descrição : Salva uma nova pessoa no banco de dados chamando o método
	 * cadastrarcadastraradastroDePessoa(pessoa)do DAO. Retorno : Retorna o objeto
	 * Pessoacadastrado.
	 */
	@Override
	public Pessoa cadastroDePessoa(Pessoa pessoa) {
		return cadastroDePessoaDao.cadastroDePessoa(pessoa);
	}

	/**
	 * Descrição : Obtenha uma lista de todas as pessoas cadastradas que chamam
	 * listaDadosDosCadastroDePessoa()do DAO. 
	 * Retorno : Retorna uma List<Pessoa>com os registros.
	 */
	@Override
	public List<Pessoa> listaDadosDosCadastroDePessoa() {
		return cadastroDePessoaDao.listaDadosDosCadastroDePessoa();
	}

	/**
	 * Descrição : Remove uma pessoa do banco de dados chamando
	 * removerCadastroDePessoa(pessoa)no DAO.
	 * Retorno : Retorna a pessoa que foi removida
	 */
	@Override
	public Pessoa removerCadastroDePessoa(Pessoa pessoa) {
		return cadastroDePessoaDao.removerCadastroDePessoa(pessoa);
	}

	/**
	 * Descrição : Atualiza os dados de uma pessoa chamando
	 * editarCadastroDePessoa(pessoa)no DAO.
	 * Retorno : Retorno ao objeto Pessoaatualizado
	 */
	@Override
	public Pessoa editarCadastroDePessoa(Pessoa pessoa) {
		return cadastroDePessoaDao.editarCadastroDePessoa(pessoa);
	}

}
