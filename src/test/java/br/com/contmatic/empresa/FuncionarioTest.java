package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.banco.ContaBancaria;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.hora.Horario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FuncionarioTest {
    
    private Funcionario funcionario;
    private LocalDate data;
    private Endereco endereco;
    private ContaBancaria conta;
    private Horario horario;
    private LocalTime entrada = LocalTime.of(8, 00, 00);
    private LocalTime saidaAlmoco = LocalTime.of(12, 30, 00);
    private LocalTime retornoAlmoco = LocalTime.of(13, 30, 00);
    private LocalTime saida = LocalTime.of(18, 00, 00);
    
    @Before
    public void init() {
        horario = new Horario(entrada, saidaAlmoco, retornoAlmoco, saida);
        conta = new ContaBancaria("Joana Pereira","321","7654");
        endereco = new Endereco("01234567", "Rua 1 de Abril", 1, "Bloco 1 Apto 102", "Bairro Um", "São Paulo", "SP", "Brasil");
        data = LocalDate.of(1986,01,06);
        funcionario = new Funcionario("54", "Joana Pereira", data, "Francisca Pereira", "Antonio Pereira", "12345678909", "F", 3500.77, endereco, conta, horario);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_nulo() {
        funcionario.setCodigo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_em_branco() {
        funcionario.setCodigo("   ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_vazio() {
        funcionario.setCodigo("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_mais_de_cinco_digitos() {
        funcionario.setCodigo("100000"); 
    }
        
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_letras() {
        funcionario.setCodigo("123a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_caracteres_especiais() {
        funcionario.setCodigo("1234@");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_com_espacos() {
        funcionario.setCodigo("12 34");
    }
    
    @Test
    public void deve_aceitar_codigo_nao_nulo_com_ate_5_digitos_numericos() {
        assertEquals("54", funcionario.getCodigo());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_nulo() {
        funcionario.setNome(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_nome() {
        funcionario.setNome(" Joana");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_em_branco() {
        funcionario.setNome("  "); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_vazio() {
        funcionario.setNome("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_com_numeros() {
        funcionario.setNome("Joana 1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_com_caracteres_especiais() {
        funcionario.setNome("@Joana");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0; i < 100; i++) {
            maior += "a";
        }
        funcionario.setNome(maior);
    }
    
    @Test
    public void deve_aceitar_nome_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() { 
        assertEquals("Joana Pereira", funcionario.getNome());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_da_mae_nulo() {
        funcionario.setNomeMae(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_da_mae() {
        funcionario.setNomeMae(" Francisca");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_da_mae_em_branco() {
        funcionario.setNomeMae("  "); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_da_mae_vazio() {
        funcionario.setNomeMae("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_da_mae_com_numeros() {
        funcionario.setNomeMae("Francisca 1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_da_mae_com_caracteres_especiais() {
        funcionario.setNomeMae("@Francisca");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_da_mae_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0; i < 100; i++) {
            maior += "a";
        }
        funcionario.setNomeMae(maior);
    }
    
    @Test
    public void deve_aceitar_nome_da_mae_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() { 
        assertEquals("Francisca Pereira", funcionario.getNomeMae());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_do_pai() {
        funcionario.setNomePai(" Antonio");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_do_pai_com_numeros() {
        funcionario.setNomePai("Antonio 1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_do_pai_com_caracteres_especiais() {
        funcionario.setNomePai("@Antonio");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_do_pai_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0; i < 100; i++) {
            maior += "a";
        }
        funcionario.setNomePai(maior);
    }
    
    @Test
    public void deve_aceitar_nome_do_pai_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() { 
        assertEquals("Antonio Pereira", funcionario.getNomePai());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_nulo() {
        funcionario.setCpf(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_todos_os_digitos_repetidos() {
        String repetido = "";
        for( int i = 0; i < 10; i++) {
            for( int cont = 0; cont < 11; cont++ ) {
            repetido += Integer.toString(i);
        }
        funcionario.setCpf(repetido);
        repetido = "";
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_do_cpf_em_branco() {
        funcionario.setCpf("           ");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_do_cpf_vazio() {
        funcionario.setCpf("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_espacos() {
        funcionario.setCpf("12345 67890");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_letras() {
        funcionario.setCpf("123456789xy");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_caracteres_especiais() {
        funcionario.setCpf("123456789@@");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_menos_de_onze_digitos() {
        funcionario.setCpf("1234567890"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_mais_de_onze_digitos() {
        funcionario.setCpf("123456789091"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_decimo_digito_invalido() {
        funcionario.setCpf("12345678989"); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_decimo_primeiro_digito_invalido() {
        funcionario.setCpf("12345678901"); 
    }
    
    @Test
    public void deve_aceitar_cpf_valido_somente_com_11_digitos_numericos_sem_hamcrest() {
        assertEquals("12345678909", funcionario.getCpf());
    }
    
    @Test 
    public void deve_aceitar_cpf_valido_somente_com_11_digitos_numericos_com_hamcrest() {     
        assertThat(funcionario.getCpf(), equalTo("12345678909")); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Sexo_nulo() {
        funcionario.setSexo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Sexo_em_branco() {
        funcionario.setSexo(" ");  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Sexo_vazio() {
        funcionario.setSexo("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Sexo_com_mais_de_1_digito() {
        funcionario.setSexo("FF"); 
    }
        
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Sexo_com_numeros() {
        funcionario.setSexo("1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_Sexo_com_caracteres_especiais() {
        funcionario.setSexo("@");
    }
    
    @Test
    public void deve_aceitar_Sexo_nao_nulo_com_a_letra_F_ou_M_ou_O() {
        assertEquals("F", funcionario.getSexo());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_salario_maior_que_99999() {
        funcionario.setSalario(99999.01); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_salario_negativo() { 
        funcionario.setSalario(-0.1);
    }
    
    @Test
    public void deve_aceitar_salario_até_99999() {
        assertEquals(3500.77, funcionario.getSalario(), 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_nascimento_nula() {
        funcionario.setDataNascimento(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_nascimento_anterior_a_01_01_1900() {
        funcionario.setDataNascimento(LocalDate.of(1899,12,31));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_nascimento_posterior_a_data_atual() {
        funcionario.setDataNascimento(LocalDate.now().plusDays(1));
    }
    
    @Test
    public void deve_aceitar_data_nascimento_nao_nula_entre_01_01_1900_e_data_atual() {
        assertEquals(data, funcionario.getDataNascimento());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_endereco_nulo() {
        funcionario.setEndereco(null);
    }
    
    @Test
    public void deve_aceitar_endereco_nao_nulo_de_acordo_com_as_regras_da_classe_endereco() { 
        assertEquals(endereco, funcionario.getEndereco());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_conta_nulo() {
        funcionario.setConta(null);
    }
    
    @Test
    public void deve_aceitar_conta_nao_nulo_de_acordo_com_as_regras_da_classe_conta() { 
        assertEquals(conta, funcionario.getConta());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_horario_nulo() {
        funcionario.setHorario(null);
    }
    
    @Test
    public void deve_aceitar_horario_nao_nulo_de_acordo_com_as_regras_da_classe_horario() { 
        assertEquals(horario, funcionario.getHorario());
    }
    
}
