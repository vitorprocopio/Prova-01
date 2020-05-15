package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.endereco.Endereco;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmpresaTest {
    
    private Empresa empresa;
    private Endereco endereco;
    
    @Before 
    public void init () {
        endereco = new Endereco ("03315000", "Rua Padre Estevão Pernet", 215, null, "Tatuapé", "São Paulo", "SP", "Brasil");
        empresa = new Empresa("303", "58119371000177", "Contmatic", "Softmatic Ltda.", endereco);        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_nulo() {
        empresa.setCodigo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_em_branco() {
        empresa.setCodigo("   ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_vazio() {
        empresa.setCodigo("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_mais_de_cinco_digitos() {
        empresa.setCodigo("100000"); 
    }
        
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_letras() {
        empresa.setCodigo("123a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_caracteres_especiais() {
        empresa.setCodigo("1234@");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_espacos() {
        empresa.setCodigo("12 34");
    }
    
    @Test
    public void deve_aceitar_codigo_nao_nulo_com_ate_5_digitos_numericos() {
        assertEquals("303", empresa.getCodigo());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_nulo() {
        empresa.setCnpj(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_todos_os_digitos_repetidos() {
        String repetido = "";
        for( int i = 0; i < 10; i++) {
            for( int cont = 0; cont < 14; cont++ ) {
            repetido += Integer.toString(i);
        }
        empresa.setCnpj(repetido);
        repetido = "";
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_do_cnpj_em_branco() {
        empresa.setCnpj("              ");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_do_cnpj_vazio() {
        empresa.setCnpj("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_espacos() {
        empresa.setCnpj("5811937 000177");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_letras() {
        empresa.setCnpj("5811937100017a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_caracteres_especiais() {
        empresa.setCnpj("5811937100017@");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_menos_de_onze_digitos() {
        empresa.setCnpj("5811937100017"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_mais_de_onze_digitos() {
        empresa.setCnpj("581193710001777"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_decimo_terceiro_digito_invalido() {
        empresa.setCnpj("58119371000167"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_decimo_quarto_digito_invalido() {
        empresa.setCnpj("58119371000178"); 
    }
    
    @Test
    public void deve_aceitar_cnpj_valido() { 
        assertEquals("58119371000177", empresa.getCnpj());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_fantasia_nulo() {
        empresa.setNomeFantasia(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_fantasia() {
        empresa.setNomeFantasia(" Contmatic");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_fantasia_em_branco() {
        empresa.setNomeFantasia("  "); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_fantasia_vazio() {
        empresa.setNomeFantasia("");
    }
    
   @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_fantasia_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0; i < 100; i++) {
            maior += "a";
        }
        empresa.setNomeFantasia(maior);
    }
    
    @Test
    public void deve_aceitar_nome_fantasia_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() { 
        assertEquals("Contmatic", empresa.getNomeFantasia());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razao_social_nulo() {
        empresa.setRazaoSocial(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_razao_social() {
        empresa.setRazaoSocial(" Softmatic Ltda.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razao_social_em_branco() {
        empresa.setRazaoSocial("  "); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razao_social_vazio() {
        empresa.setRazaoSocial("");
    }
    
   @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razao_social_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0; i < 100; i++) {
            maior += "a";
        }
        empresa.setRazaoSocial(maior);
    }
    
    @Test
    public void deve_aceitar_razao_social_nao_nulo_de_1_até_100_caracteres() { 
        assertEquals("Softmatic Ltda.", empresa.getRazaoSocial());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_endereco_nulo() {
        empresa.setEndereco(null);
    }
    
    @Test
    public void deve_aceitar_endereco_nao_nulo_de_acordo_com_as_regras_da_classe_endereco() { 
        assertEquals(endereco, empresa.getEndereco());
    }
    
}
