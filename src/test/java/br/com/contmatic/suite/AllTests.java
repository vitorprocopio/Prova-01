package br.com.contmatic.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.banco.ContaBancariaTest;
import br.com.contmatic.contato.ContatoTest;
import br.com.contmatic.empresa.ClienteTest;
import br.com.contmatic.empresa.EmpresaTest;
import br.com.contmatic.empresa.FuncionarioTest;
import br.com.contmatic.endereco.EnderecoTest;
import br.com.contmatic.hora.HorarioTest;

@RunWith(Suite.class)
@SuiteClasses({ContaBancariaTest.class, ContatoTest.class, EnderecoTest.class, ClienteTest.class, EmpresaTest.class, FuncionarioTest.class, HorarioTest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AllTests {
    
    @BeforeClass
    public static void inicio_dos_testes() {
        System.out.println("-----------------------------");
        System.out.println("VAMOS INICIAR TODOS OS TESTES");
        System.out.println("-----------------------------");
    }
    
    @AfterClass
    public static void fim_dos_testes() {
        System.out.println("-----------------------");
        System.out.println("FIM DE TODOS OS TESTES");
        System.out.println("-----------------------");
    }
    
}
