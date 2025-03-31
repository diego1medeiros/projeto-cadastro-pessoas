package br.com.cadastro.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.cadastro.bean.CadastroBean;
import br.com.cadastro.entity.Pessoa;
import br.com.cadastro.service.CadastroDePessoaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CadastroBeanTest {

    @InjectMocks
    private CadastroBean cadastroBean;

    @Mock
    private CadastroDePessoaServiceImpl cadastroDePessoaServiceImpl;

    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        pessoa = new Pessoa();
        pessoa.setIdPessoa(1L);
        pessoa.setNome("João Silva");
    }

    @Test
    void testCadastrarPessoa_NovoCadastro() {
        when(cadastroDePessoaServiceImpl.cadastroDePessoa(any(Pessoa.class))).thenReturn(pessoa);

        String resultado = cadastroBean.cadastrarPessoa();

        assertNull(resultado); 
        verify(cadastroDePessoaServiceImpl, times(1)).cadastroDePessoa(any(Pessoa.class));
    }

    @Test
    void testCadastrarPessoa_Atualizacao() {
        pessoa.setIdPessoa(1L);
        cadastroBean.setPessoa(pessoa);

        String resultado = cadastroBean.cadastrarPessoa();

        assertNull(resultado);
        verify(cadastroDePessoaServiceImpl, times(1)).editarCadastroDePessoa(pessoa);
    }

    @Test
    void testListaDadosDosPessoasCadastrada() {
        List<Pessoa> pessoasMockadas = Arrays.asList(pessoa);
        when(cadastroDePessoaServiceImpl.listaDadosDosCadastroDePessoa()).thenReturn(pessoasMockadas);

        cadastroBean.listaDadosDosPessoasCadastrada();

        assertFalse(cadastroBean.getListaPessoas().isEmpty());
        assertEquals(1, cadastroBean.getListaPessoas().size());
        verify(cadastroDePessoaServiceImpl, times(1)).listaDadosDosCadastroDePessoa();
    }

    @Test
    void testExcluirCadastroDePessoa() {

        cadastroBean.excluirCadastroDePessoa(pessoa);

        verify(cadastroDePessoaServiceImpl, times(1)).removerCadastroDePessoa(any(Pessoa.class));
    }

    @Test
    void testLimpar() {
        cadastroBean.setPessoa(pessoa);
        cadastroBean.limpar();
        assertNotNull(cadastroBean.getPessoa());
        assertNull(cadastroBean.getPessoa().getIdPessoa());
    }
}
