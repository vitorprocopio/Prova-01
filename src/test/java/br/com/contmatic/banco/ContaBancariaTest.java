package br.com.contmatic.banco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContaBancariaTest {
    
    private ContaBancaria conta;
    
    @Before
    public void init() {
        conta = new ContaBancaria("José Silva","123","4567");
    }
    
    @Test(timeout = 500, expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_nulo() {
        conta.setTitular(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_do_titular() {
        conta.setTitular(" José");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_do_titular_em_branco() {
        conta.setTitular("  ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_vazio() {
        conta.setTitular("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_com_numeros() {
        conta.setTitular("Jose 1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_com_caracteres_especiais() {
        conta.setTitular("@José");
    }
    
    @Test
    public void deve_aceitar_titular_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() { 
        assertEquals("José Silva", conta.getTitular());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0; i < 100; i++) {
            maior += "a";
        }
        conta.setTitular(maior);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_nulo_ao_instanciar_novo_objeto() {
        new ContaBancaria(null, "123", "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_do_titular_ao_instanciar_novo_objeto() {
        new ContaBancaria(" José", "123", "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_do_titular_em_branco_ao_instanciar_novo_objeto() {
        new ContaBancaria(" ", "123", "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_vazio_ao_instanciar_novo_objeto() {
        new ContaBancaria("", "123", "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_com_numeros_ao_instanciar_novo_objeto() {
        new ContaBancaria("José 1", "123", "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_com_caracteres_especiais_ao_instanciar_novo_objeto() {
        new ContaBancaria("@José", "123", "4567");
    }
    
    @Test
    public void deve_aceitar_titular_somente_com_letras_e_espacos_ao_instanciar_novo_objeto() {
        new ContaBancaria("José Silva", "123", "4567");
        assertEquals("José Silva", conta.getTitular());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_titular_maior_que_cem_caracteres_ao_instanciar_novo_objeto() {
        String maior = "a";
        for(int i = 0; i < 100; i++) {
            maior += "a";
        }
        new ContaBancaria(maior, "123", "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_nulo() {
        conta.setNumero(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_nulo_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", null, "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_numero_da_conta() {
        conta.setNumero(" 123");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_numero_da_conta_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", " 123", "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_em_branco() {
        conta.setNumero("  ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_em_branco_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", "  ", "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_vazio() {
        conta.setNumero("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_vazio_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", null, "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_maior_que_vinte_caracteres() {
        String maior = "1";
        for(int i = 0; i < 20; i++) {
            maior += "1";
        }
        conta.setNumero(maior);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_maior_que_vinte_caracteres_ao_instanciar_novo_objeto() {
        String maior = "1";
        for(int i = 0; i < 20; i++) {
            maior += "1";
        }
        new ContaBancaria("José", maior, "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_com_letras() {
        conta.setNumero("123a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_com_letras_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", "123a", "4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_com_caracteres_especiais() {
        conta.setNumero("#123");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_conta_com_caracteres_especiais_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", "#123", "4567");
    }
    
    @Test
    public void deve_aceitar_somente_numero_da_conta_nao_nulo_com_até_20_digitos_numericos() {
        conta.setNumero("123");
        assertEquals("123", conta.getNumero());
    }
    
    @Test
    public void deve_aceitar_somente_numero_da_conta_nao_nulo_com_até_20_digitos_numericos_ao_instanciar_novo_objeto() {
        assertEquals("123" , conta.getNumero());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_nulo() {
        conta.setAgencia(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_nulo_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", "123", null);
    }    
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_numero_da_agencia() {
        conta.setAgencia(" 4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_numero_da_agencia_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", "123", " 4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_agencia_em_branco() {
        conta.setAgencia("  ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_agencia_em_branco_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", "123", "      ");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_agencia_vazio() {
        conta.setAgencia("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_da_agencia_vazio_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", "123", "");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_letras() {
        conta.setAgencia("456a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_caracteres_especiais() {
        conta.setAgencia("456%");
    }
    
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_numero_negativo() { //faz sentido esse teste?
        conta.setAgencia("-4567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_letras_ao_instanciar_novo_objeto() {
        new ContaBancaria("José","123","456a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_caracteres_especiais_ao_instanciar_novo_objeto() {
        new ContaBancaria("José","123","456%");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_numero_negativo_ao_instanciar_novo_objeto() {
        new ContaBancaria("José","123","-4567");
    }
    
    @Test
    public void deve_aceitar_agencia_nao_nula_somente_com_quatro_digitos_numericos() {
        conta.setAgencia("4567");
        assertEquals("4567", conta.getAgencia());
    }
    
    @Test
    public void deve_aceitar_agencia_nao_nula_somente_com_quatro_digitos_numericos_ao_instanciar_novo_objeto() {
        assertEquals("4567" , conta.getAgencia());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_menos_de_quatro_digitos() {
        conta.setAgencia("456"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_mais_de_quatro_digitos() {
        conta.setAgencia("45678"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_mais_de_quatro_digitos_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", "123", "45678");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_agencia_com_menos_de_quatro_digitos_ao_instanciar_novo_objeto() {
        new ContaBancaria("José", "123", "456");
    }
    
    @Test
    public void testa_propriedade_reflexiva_equals() {
        assertEquals(conta, conta);
    }
    
    @Test
    public void testa_propriedade_simetrica_equals() {
        ContaBancaria conta1 = new ContaBancaria("José","123","4567"); 
        assertEquals(conta, conta1);
        assertEquals(conta1, conta);
    }
    
    @Test
    public void testa_propriedade_transitiva_equals() {
        ContaBancaria conta1 = new ContaBancaria("José","123","4567"); 
        ContaBancaria conta2 = new ContaBancaria("José","123","4567");
        assertEquals(conta, conta1);
        assertEquals(conta1, conta2);
        assertEquals(conta, conta2);
    }
    
    @Test
    public void testa_consistencia_null_equals() {
        assertFalse(conta.equals(null));
    }
       
    @Test
    public void equals_deve_retornar_false_se_titular_igual_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José","321","7654");
        assertNotEquals(conta, conta1);
    }
    
    @Test
    public void equals_deve_retornar_false_se_titular_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("Joao","321","7654");
        assertNotEquals(conta, conta1);
    }
    
    @Test
    public void equals_deve_retornar_false_se_titular_e_numero_igual_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José","123","7654");
        assertNotEquals(conta, conta1);
    }
    
    @Test
    public void equals_deve_retornar_false_se_titular_e_agencia_igual_e_numero_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José","321","4567");
        assertNotEquals(conta, conta1);
    }
    
    @Test
    public void equals_deve_retornar_false_se_titular_e_agencia_diferentes_e_numero_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao","123","7654");
        assertNotEquals(conta, conta1);
    }
    
    @Test
    public void equals_deve_retornar_false_se_titular_e_numero_diferentes_e_agencia_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao","321","4567");
        assertNotEquals(conta, conta1);
    }
    
    @Test
    public void equals_deve_retornar_true_se_numero_e_agencia_iguais_e_titular_diferente() {
        ContaBancaria conta1 = new ContaBancaria("Joao","123","4567");
        assertEquals(conta, conta1);
    }
    
    @Test
    public void equals_deve_retornar_true_se_numero_agencia_e_titular_iguais() {
        ContaBancaria conta1 = new ContaBancaria("José","123","4567");
        assertEquals(conta, conta1);
    }
    
    @Test
    public void hashcode_deve_ser_diferente_se_titular_igual_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José","321","7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }
    
    @Test
    public void hashcode_deve_ser_diferente_se_titular_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("Joao","321","7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }
    
    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_numero_igual_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José","123","7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }
    
    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_agencia_igual_e_numero_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José","321","4567");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }
    
    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_agencia_diferentes_e_numero_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao","123","7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }
    
    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_numero_diferentes_e_agencia_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao","321","4567");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }
    
    @Test
    public void hashcode_deve_ser_igual_se_numero_e_agencia_iguais_e_titular_diferente() {
        ContaBancaria conta1 = new ContaBancaria("Joao","123","4567");
        assertEquals(conta.hashCode(), conta1.hashCode());
    }
    
    @Test
    public void hashcode_deve_ser_igual_se_numero_agencia_e_titular_iguais() {
        ContaBancaria conta1 = new ContaBancaria("José","123","4567");
        assertEquals(conta.hashCode(), conta1.hashCode());
    }
    
    @Test
    public void deve_conter_o_valor_do_numero_da_conta_na_string_gerada() {
        String toStringConta = conta.toString();
        assertTrue(toStringConta.contains(conta.getNumero()));
    }
    
    @Test
    public void deve_conter_o_valor_do_numero_da_agencia_na_string_gerada() {
        String toStringConta = conta.toString();
        assertTrue(toStringConta.contains(conta.getAgencia()));
    }
    
    @Test
    public void deve_conter_o_valor_do_nome_do_titular_na_string_gerada() {
        String toStringConta = conta.toString();
        assertTrue(toStringConta.contains(conta.getTitular()));
    }
    
}
