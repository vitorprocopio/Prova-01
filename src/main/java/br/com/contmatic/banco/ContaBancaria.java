package br.com.contmatic.banco;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ContaBancaria {
    
	@Pattern(regexp = "^[A-ZÀ-Úa-zà-ú]['A-ZÀ-Ú a-zà-ú]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "Titular inválido")
    @NotEmpty(message = "O titular não deve ser nulo nem vazio")
    private String titular;
    
	@Pattern(regexp = "\\d{1,20}", message = "Numero da conta inválido")
    @NotEmpty(message = "O número da conta não deve ser nulo nem vazio")
    private String numero; 
    
	@Pattern(regexp = "\\d{4}", message = "Numero da agência inválido")
    @NotEmpty(message = "A agência não deve ser nula nem vazia")
    private String agencia;
    
    public ContaBancaria(String titular, String numero, String agencia) {
        this.setTitular(titular);
        this.setNumero(numero);
        this.setAgencia(agencia);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
//        verificaCampoNulo(titular);
//        verificaCampoVazio(titular);
//        verificaEspacoInicio(titular);
//        verificaContemSomenteLetras(titular);
//        verificaTamanhoAteCem(titular);
        this.titular = titular;
    }

//    private void verificaTamanhoAteCem(String campo) {
//        if(campo.length() > 100) {
//        throw new IllegalArgumentException("O campo deve ter até 100 caracteres");
//        }
//    }
//    
//    private void verificaEspacoInicio(String campo) {
//        if(campo.charAt(0) == ' ') {
//            throw new IllegalArgumentException("O campo não deve começar com espaços");
//        }
//    }
//
//    private void verificaCampoVazio(String campo) {
//        if(campo.isEmpty()) {
//            throw new IllegalArgumentException("Este campo não deve ser vazio");
//        }
//    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
//        verificaCampoNulo(numero);
//        verificaCampoVazio(numero);
//        verificaEspacoInicio(numero);
//        verificaContemSomenteNumeros(numero);
//        verificaTamanhoMenorVinte(numero);
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
//        verificaCampoNulo(agencia);
//        verificaAgenciaQuatroDigitos(agencia);
//        verificaContemSomenteNumeros(agencia);
//        verificaCampoVazio(titular);
//        verificaEspacoInicio(titular);
        this.agencia = agencia;
    }
    
//    private void verificaTamanhoMenorVinte(String campo) {
//        if(campo.length() > 20) {
//        throw new IllegalArgumentException("O campo deve ter até 20 caracteres");
//        }
//    }
//    
//    private void verificaContemSomenteNumeros(String campo) {
//        for(char palavra: campo.toCharArray()) {
//            if(!Character.isDigit(palavra)) {
//                throw new IllegalArgumentException("Só deve conter números");
//            }
//        }
//    }
//
//    private void verificaContemSomenteLetras(String campo) {
//        for(char palavra: campo.toCharArray()) {
//            if(!(Character.isAlphabetic(palavra) || Character.isSpaceChar(palavra))) {
//                throw new IllegalArgumentException("Só deve conter letras");
//            }
//        }
//    }
//    
//    private void verificaAgenciaQuatroDigitos(String agencia) {
//        if(agencia.length() != 4) {
//            throw new IllegalArgumentException("O número da agência deve ter 4 dígitos");
//        }
//    }
//
//    private void verificaCampoNulo(String campo) {
//        if (campo == null) {
//            throw new IllegalArgumentException("O campo não deve ser nulo");
//        }
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ContaBancaria))
            return false;
        ContaBancaria other = (ContaBancaria) obj;
        if (agencia == null) {
            if (other.agencia != null)
                return false;
        } else if (!agencia.equals(other.agencia))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ContaBancaria [titular=" + titular + ", numero=" + numero + ", agencia=" + agencia + "]";
    }

}
