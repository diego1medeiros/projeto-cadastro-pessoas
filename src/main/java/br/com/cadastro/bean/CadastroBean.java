package br.com.cadastro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadastro.entity.Pessoa;
import br.com.cadastro.enumeradores.TipoSexo;
import br.com.cadastro.service.CadastroDePessoaServiceImpl;
import br.com.cadastro.util.BuscaCep;
import br.com.cadastro.util.Message;
import lombok.Getter;
import lombok.Setter;

/**
 * /*
 * A classe CadastroBean é um Managed Bean responsável pela interação entre a
 * interface do usuário (JSF) e a camada de serviço. O projeto segue boas
 * práticas de desenvolvimento, como separação de responsabilidades e uso de
 * padrões como CDI e Managed Beans. Para melhorar, pode-se adicionar logs para
 * capturar exceções e melhorar a tratativa de erros..
 */
@Getter
@Setter
@Named("cadastrobean")
@RequestScoped
public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Pessoa> listaPessoas = new ArrayList<>();

	private Pessoa pessoa = new Pessoa();

	@Inject
	private CadastroDePessoaServiceImpl cadastroDePessoaServiceImpl;

	// Retorna a lista de tipos de sexo disponíveis.

	public List<String> getTipoSexo() {
		return Arrays.asList(TipoSexo.getSexoComboBox());
	}

	/**
	 * Cadastra ou atualiza uma pessoa no banco de dados. Insere uma nova pessoa no
	 * banco de dados ou atualiza uma existente.
	 */
	public String cadastrarPessoa() {
		try {
			if (pessoa.getIdPessoa() == null) {
				Pessoa cadastroDePessoa = cadastroDePessoaServiceImpl.cadastroDePessoa(pessoa);
				limpar();
				Message.info("Cadastro", "Pessoa " + cadastroDePessoa.getNome() + " cadastrado com Sucesso!!!");
			} else {
				cadastroDePessoaServiceImpl.editarCadastroDePessoa(pessoa);
				Message.info("Atualização", "Pessoa " + pessoa.getNome() + " atualizado com sucesso!!!");
			}
			listaDadosDosPessoasCadastrada();
			limpar();
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Lista todas as pessoas cadastradas no banco de dados. Obtém a lista de
	 * pessoas cadastradas na base de dados. Executado automaticamente após a
	 * criação do bean (@PostConstruct).
	 */
	@PostConstruct
	public void listaDadosDosPessoasCadastrada() {
		setListaPessoas(cadastroDePessoaServiceImpl.listaDadosDosCadastroDePessoa());
	}

	/**
	 * Exclui uma pessoa do banco de dados. Remove um registro do banco de dados e
	 * atualiza a lista exibida na tela.
	 */
	public void excluirCadastroDePessoa(Pessoa pessoa) {
		try {
			cadastroDePessoaServiceImpl.removerCadastroDePessoa(pessoa);
			listaDadosDosPessoasCadastrada();
			limpar();
			Message.info("Excluir", "Pessoa " + pessoa.getNome() + " Excluido com sucesso!!!");
		} catch (Exception e) {
		}
	}

	/**
	 * Busca informações do endereço pelo CEP. Utiliza a classe BuscaCep para
	 * preencher automaticamente os campos de endereço. Caso o CEP não seja
	 * encontrado, exibe uma mensagem de erro.
	 */
	public void encontraCEP() {
		BuscaCep buscaCep = new BuscaCep(pessoa.getEndereco().getCep());
		if (buscaCep.getResultado() == 1) {
			pessoa.getEndereco().setRua(buscaCep.getTipoLogradouro() + " " + buscaCep.getLogradouro());
			pessoa.getEndereco().setEstado(buscaCep.getEstado());
			pessoa.getEndereco().setCidade(buscaCep.getCidade());
			pessoa.getEndereco().setBairro(buscaCep.getBairro());
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "CEP não foi encontrado", "CEP não foi encontrado"));
		}
	}

	/**
	 * Limpa os campos do formulário. Reseta os dados da tela após uma operação.
	 */
	public void limpar() {
		pessoa = new Pessoa();
	}
}
