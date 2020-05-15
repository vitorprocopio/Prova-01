package br.com.contmatic.contato;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContatoTest {
    
    private Contato contato;

    @Before
    public void init() {
        contato = new Contato("12345678", "987654321", "123456789", "email@contato.com.br");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_telefone_com_menos_8_dígitos () {
        contato.setTelefone("1234567");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_telefone_com_mais_8_dígitos() {
        contato.setTelefone("123456789");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_telefone_com_letras() {
        contato.setTelefone("1234567a");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_telefone_com_caracteres_especiais() {
        contato.setTelefone("1234567@");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_telefone_com_espacos() {
        contato.setTelefone(" 234 678");
    }
    
    @Test
    public void deve_aceitar_telefone_somente_com_8_digitos_numericos() {
        assertEquals("12345678", contato.getTelefone());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_celular_com_mais_9_dígitos() {
        contato.setCelular("1234567890");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_celular_com_menos_9_dígitos() {
        contato.setCelular("12345678");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_celular_com_letras() {
        contato.setTelefone("1234567a");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_celular_com_caracteres_especiais() {
        contato.setTelefone("12345678@");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_celular_com_espacos() {
        contato.setTelefone(" 234 6789");
    }
    
    @Test
    public void deve_aceitar_celular_somente_com_8_digitos_numericos() {
        assertEquals("987654321", contato.getCelular());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_recado_com_mais_9_dígitos () {
        contato.setRecado("1234567890");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_recado_com_menos_8_dígitos () {
        contato.setRecado("1234567");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_recado_com_letras() {
        contato.setTelefone("1234567a");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_recado_com_caracteres_especiais() {
        contato.setTelefone("12345678@");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_recado_com_espacos() {
        contato.setTelefone(" 234 6789");
    }
    
    @Test
    public void deve_aceitar_recado_somente_com_8_digitos_numericos() {
        assertEquals("123456789", contato.getRecado());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_com_mais_250_caracteres () {
        String letra = "a";
        for(int i = 0; i <250; i++) {
            letra += "a";
        }
        contato.setEmail(letra);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_com_espacos() {
        contato.setEmail("email @contato.com.br");
    }
    
    @Test
    public void deve_aceitar_email_sem_espacos_ate_250_caracteres() {
        assertEquals("email@contato.com.br", contato.getEmail());
    }
    
    
}
