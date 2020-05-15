package br.com.contmatic.endereco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EnderecoTest {
    
    private Endereco endereco;
    
    @Before
    public void init () {
        endereco = new Endereco("01234567", "Rua 1 de Abril", 1, "Bloco 1 Apto 102", "Bairro Um", "São Paulo", "SP", "Estados Unidos");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_nulo() {
        endereco.setCep(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_em_branco() {
        endereco.setCep(" ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_vazio() {
        endereco.setCep("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_com_menos_de_oito_digitos() {
        endereco.setCep("123"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_com_mais_de_oito_digitos() {
        endereco.setCep("123456789"); 
    }
        
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_com_letras() {
        endereco.setCep("1234567a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_com_caracteres_especiais() {
        endereco.setCep("1234567@");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_com_espacos() {
        endereco.setCep("1234 678");
    }
    
    @Test
    public void deve_aceitar_cep_somente_com_8_digitos_numericos() {
        assertEquals("01234567", endereco.getCep());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_rua_nulo() {
        endereco.setRua(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_da_rua_em_branco() {
        endereco.setRua("   "); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_rua_vazio() {
        endereco.setRua("");
    }
    
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_rua_com_menos_de_oito_digitos() {
        endereco.setRua("456"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_rua_com_mais_de_100_digitos() {
        String maior = "1";
        for(int i = 0; i < 100; i++) {
            maior += "1";
        }
        endereco.setRua(maior); 
    }
            
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_rua_com_caracteres_especiais() {
        endereco.setRua("Rua Costa & Silva");
    }
    
    @Test
    public void deve_aceitar_rua_nao_nulo_de_1_até_100_caracteres_alfanumericos_e_espacos() {
        assertEquals("Rua 1 de Abril", endereco.getRua());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_maior_que_99999() {
        endereco.setNumero(100000); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_negativo() { 
        endereco.setNumero(-1);
    }
    
    @Test
    public void deve_aceitar_numero_até_99999() {
        assertEquals(1, endereco.getNumero());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_complemento_com_mais_de_50_digitos() {
        String maior = "1";
        for(int i = 0; i < 50; i++) {
            maior += "1";
        }
        endereco.setComplemento(maior); 
    }
            
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_complemento_com_caracteres_especiais() {
        endereco.setRua("Bloco #1 Apto. 102");
    }
    
    @Test
    public void deve_aceitar_complemento_de_1_até_50_caracteres_alfanumericos_e_espacos() {
        assertEquals("Bloco 1 Apto 102", endereco.getComplemento());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_do_bairro_em_branco() {
        endereco.setBairro(" ");  
    }
    
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_com_menos_de_oito_digitos() {
        endereco.setBairro("456"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_nulo() {
        endereco.setBairro(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_vazio() {
        endereco.setBairro("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_com_mais_de_50_digitos() {
        String maior = "1";
        for(int i = 0; i < 50; i++) {
            maior += "1";
        }
        endereco.setBairro(maior); 
    }
            
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_com_caracteres_especiais() {
        endereco.setBairro("Bairro #1");
    }
    
    @Test
    public void deve_aceitar_bairro_nao_nulo_de_1_até_100_caracteres_alfanumericos_e_espacos() {
        assertEquals("Bairro Um", endereco.getBairro());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Cidade_nulo() {
        endereco.setCidade(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cidade_em_branco() {
        endereco.setCidade(" ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Cidade_vazio() {
        endereco.setCidade("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Cidade_com_mais_de_50_digitos() {
        String maior = "1";
        for(int i = 0; i < 50; i++) {
            maior += "1";
        }
        endereco.setCidade(maior); 
    }
            
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Cidade_com_caracteres_especiais() {
        endereco.setCidade("S@o Paulo");
    }
    
    @Test
    public void deve_aceitar_Cidade_nao_nulo_de_1_até_50_caracteres_alfanumericos_e_espacos() {
        assertEquals("São Paulo", endereco.getCidade());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_UF_nulo() {
        endereco.setUf(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_UF_em_branco() {
        endereco.setUf("  ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_UF_vazio() {
        endereco.setUf("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_UF_com_menos_de_dois_digitos() {
        endereco.setUf("S"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_UF_com_mais_de_dois_digitos() {
        endereco.setUf("SPA"); 
    }
        
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_UF_com_numeros() {
        endereco.setUf("S1");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_UF_com_caracteres_especiais() {
        endereco.setUf("S@");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_UF_com_espacos() {
        endereco.setUf(" S");
    }
    
    @Test
    public void deve_aceitar_UF_somente_com_2_digitos_numericos() {
        assertEquals("SP", endereco.getUf());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Pais_nulo() {
        endereco.setPais(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_pais_em_branco() {
        endereco.setPais(" ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Pais_vazio() {
        endereco.setPais("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Pais_com_mais_de_50_digitos() {
        String maior = "1";
        for(int i = 0; i < 50; i++) {
            maior += "1";
        }
        endereco.setPais(maior); 
    }
            
    @Test (expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Pais_com_caracteres_especiais() {
        endereco.setPais("Republica Dominican@");
    }
    
    @Test
    public void deve_aceitar_Pais_nao_nulo_de_1_até_50_caracteres_alfabeticos_e_espacos() {
        assertEquals("Estados Unidos", endereco.getPais());
    }
    
}
