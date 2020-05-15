package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.endereco.Endereco;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ClienteTest {
    
    private Cliente cliente;
    private LocalDate data;
    private Endereco endereco;
    private Contato contato;
    
    @Before
    public void init() {
        contato = new Contato("12345678", "987654321", "123456789", "email@contato.com.br");
        endereco = new Endereco("01234567", "Rua 1 de Abril", 1, "Bloco 1 Apto 102", "Bairro Um", "São Paulo", "SP", "Brasil");
        data = LocalDate.of(1970,4,6);
        cliente = new Cliente("101", "Ana Maria", data, "12345678909", endereco, contato);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_nulo() {
        cliente.setCodigo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_em_branco() {
        cliente.setCodigo("   ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_vazio() {
        cliente.setCodigo("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_mais_de_cinco_digitos() {
        cliente.setCodigo("100000"); 
    }
        
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_letras() {
        cliente.setCodigo("123a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_caracteres_especiais() {
        cliente.setCodigo("1234@");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_espacos() {
        cliente.setCodigo("12 34");
    }
    
    @Test
    public void deve_aceitar_codigo_nao_nulo_com_ate_5_digitos_numericos() {
        assertEquals("101", cliente.getCodigo());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_nulo() {
        cliente.setNome(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_nome() {
        cliente.setNome(" Ana");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_em_branco() {
        cliente.setNome("  "); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_vazio() {
        cliente.setNome("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_com_numeros() {
        cliente.setNome("Ana 1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_com_caracteres_especiais() {
        cliente.setNome("@Ana");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0; i < 100; i++) {
            maior += "a";
        }
        cliente.setNome(maior);
    }
    
    @Test
    public void deve_aceitar_nome_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() { 
        assertEquals("Ana Maria", cliente.getNome());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_nulo() {
        cliente.setCpf(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_todos_os_digitos_repetidos() {
        String repetido = "";
        for( int i = 0; i < 10; i++) {
            for( int cont = 0; cont < 11; cont++ ) {
            repetido += Integer.toString(i);
        }
        cliente.setCpf(repetido);
        repetido = "";
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_do_cpf_em_branco() {
        cliente.setCpf("           ");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_do_cpf_vazio() {
        cliente.setCpf("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_espacos() {
        cliente.setCpf("12345 67890");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_letras() {
        cliente.setCpf("123456789xy");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_caracteres_especiais() {
        cliente.setCpf("123456789@@");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_menos_de_onze_digitos() {
        cliente.setCpf("1234567890"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_mais_de_onze_digitos() {
        cliente.setCpf("123456789091"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_decimo_digito_invalido() {
        cliente.setCpf("12345678989"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_decimo_primeiro_digito_invalido() {
        cliente.setCpf("12345678901"); 
    }
    
    @Test
    public void deve_aceitar_cpf_valido_somente_com_11_digitos_numericos() {
        assertEquals("12345678909", cliente.getCpf());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_nascimento_nula() {
        cliente.setDataNascimento(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_nascimento_anterior_a_01_01_1900() {
        cliente.setDataNascimento(LocalDate.of(1899,12,31));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_nascimento_posterior_ou_igual_a_data_atual() {
        cliente.setDataNascimento(LocalDate.now().plusDays(1));
    }
    
    @Test
    public void deve_aceitar_data_nascimento_nao_nula_a_partir_de_01_01_1900_ate_data_ontem() {
        assertEquals(data, cliente.getDataNascimento());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_endereco_nulo() {
        cliente.setEndereco(null);
    }
    
    @Test
    public void deve_aceitar_endereco_nao_nulo_de_acordo_com_as_regras_da_classe_endereco() { 
        assertEquals(endereco, cliente.getEndereco());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_contato_nulo() {
        cliente.setContato(null);
    }
    
    @Test
    public void deve_aceitar_contato_nao_nulo_de_acordo_com_as_regras_da_classe_contato() { 
        assertEquals(contato, cliente.getContato());
    }
    
}
