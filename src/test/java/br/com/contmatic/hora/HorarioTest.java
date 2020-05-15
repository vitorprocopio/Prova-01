package br.com.contmatic.hora;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HorarioTest {
    
    private Horario horario;
    private LocalTime entrada = LocalTime.of(8, 00, 00);
    private LocalTime saidaAlmoco = LocalTime.of(12, 30, 00);
    private LocalTime retornoAlmoco = LocalTime.of(13, 30, 00);
    private LocalTime saida = LocalTime.of(18, 00, 00);
    
    @Before
    public void init() {
        horario = new Horario(entrada, saidaAlmoco, retornoAlmoco, saida);
    }
    
    @After
    public void finalize() {
        System.out.println("Teste realizado");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_entrada_nulo() {
        horario.setEntrada(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_horario_anterior_a_07_00_00() {
        horario.setEntrada(LocalTime.of(6,59,59));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_horario_posterior_a_18_00_00() {
        horario.setEntrada(LocalTime.of(18,00,01));
    }
    
    @Test
    public void deve_aceitar_entrada_nao_nulo_entre_07_00_00_e_18_00_00() {
        assertEquals(entrada, horario.getEntrada());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_saida_almoco_nulo() {
        horario.setSaidaAlmoco(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_saida_almoco_anterior_a_11_00_00() {
        horario.setSaidaAlmoco(LocalTime.of(10,59,59));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_saida_almoco_posterior_a_14_00_00() {
        horario.setSaidaAlmoco(LocalTime.of(14,00,01));
    }
    
    @Test
    public void deve_aceitar_saida_almoco_nao_nulo_entre_11_00_00_e_14_00_00() {
        assertEquals(saidaAlmoco, horario.getSaidaAlmoco());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_retorno_almoco_nulo() {
        horario.setRetornoAlmoco(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_retorno_almoco_anterior_a_12_00_00() {
        horario.setRetornoAlmoco(LocalTime.of(11,59,59));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_retorno_almoco_posterior_a_15_00_00() {
        horario.setRetornoAlmoco(LocalTime.of(15,00,01));
    }
    
    @Test
    public void deve_aceitar_retorno_almoco_nao_nulo_entre_12_00_00_e_15_00_00() {
        assertEquals(retornoAlmoco, horario.getRetornoAlmoco());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_saida_nulo() {
        horario.setSaida(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_saida_anterior_a_8_00_00() {
        horario.setSaida(LocalTime.of(7,59,59));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_saida_posterior_a_20_00_00() {
        horario.setSaida(LocalTime.of(20,00,01));
    }
    
    @Test
    public void deve_aceitar_saida_nao_nulo_entre_8_00_00_e_20_00_00() {
        assertEquals(saida, horario.getSaida());
    }

}
