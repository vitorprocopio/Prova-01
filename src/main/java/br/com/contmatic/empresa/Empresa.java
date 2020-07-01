package br.com.contmatic.empresa;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.contmatic.endereco.Endereco;
//import br.com.contmatic.validacao.ValidaCnpj;

public class Empresa {
    
	@NotEmpty(message = "Não deve aceitar código nulo nem vazio")
	@Pattern(regexp = "\\d{1,5}", message = "Código inválido")
    private String codigo;
    
	@CNPJ
    @NotNull(message = "Cnpj não pode ser nulo")
    private String cnpj;
    
	@Size(max=100)
    @NotBlank(message = "Nome fantasia não pode ser nulo nem vazio")
	@Pattern(regexp = "^[0-9A-Za-z'!@#$%&*-+_§.,;][0-9A-Z a-z'!@#$%&*-+_§.,;]{0,98}[0-9A-Za-z'!@#$%&*-+_§.,;]$", message = "Nome fantasia inválido")
    private String nomeFantasia;
   
	@Size(max=100)
    @NotBlank(message = "Razão social não pode ser nulo nem vazio")
	@Pattern(regexp = "^[0-9A-Za-z'!@#$%&*-+_§.,;][0-9A-Z a-z'!@#$%&*-+_§.,;]{0,98}[0-9A-Za-z'!@#$%&*-+_§.,;]$", message = "Razão social inválido")
    private String razaoSocial;
    
    @NotNull(message = "Endereço não pode ser nulo")
    private Endereco endereco;
    
    public Empresa(String codigo, String cnpj, String nomeFantasia, String razaoSocial, Endereco endereco) {
        this.setCodigo(codigo);
        this.setCnpj(cnpj);
        this.setNomeFantasia(nomeFantasia);
        this.setRazaoSocial(razaoSocial);
        this.setEndereco(endereco);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
//        verificaTamanhoAte5(codigo);
//        verificaContemSomenteNumeros(codigo);
//        verificaCampoVazio(codigo);
        this.codigo = codigo;
    }
    
//    private void verificaTamanhoAte5(String campo) {
//        if(campo.length() > 5) {
//            throw new IllegalArgumentException("Este campo deve ter no máximo 5 dígitos");
//        }
//    }
    
//    private void verificaCampoVazio(String campo) {
//        if(campo.isEmpty()) {
//            throw new IllegalArgumentException("Este campo não deve ser vazio");
//        }
//    }
    
//    private void verificaContemSomenteNumeros(String campo) {
//        for(char palavra: campo.toCharArray()) {
//            if(!Character.isDigit(palavra)) {
//                throw new IllegalArgumentException("Só deve conter números");
//            }
//        }
//    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
//    private void verificaTamanhoCnpj(String cnpj) {
//        if(cnpj.length() != 14) {
//            throw new IllegalArgumentException("O número da agência deve ter 4 dígitos");
//        }
//    }
//
//    private void verificaTodosDigitosRepetidos(String cnpj) {
//        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
//            throw new IllegalArgumentException("Os digítos do CNPJ não podem ser todos repetidos"); 
//        }
//    }
    
//    private void verificaCampoNulo(String campo) {
//        if (campo == null) {
//            throw new IllegalArgumentException("Esse campo não pode ser nulo");
//        }
//    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
//        verificaCampoVazio(nomeFantasia);
//        verificaEspacoInicio(nomeFantasia);
//        verificaTamanhoAteCem(nomeFantasia);
        this.nomeFantasia = nomeFantasia;
    }
    
//    private void verificaEspacoInicio(String campo) {
//        if(campo.charAt(0) == ' ') {
//            throw new IllegalArgumentException("O campo não deve começar com espaços");
//        }
//    }
    
//    private void verificaTamanhoAteCem(String campo) {
//        if(campo.length() > 100) {
//        throw new IllegalArgumentException("O campo deve ter até 100 caracteres");
//        }
//    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
//        verificaCampoNulo(razaoSocial);
//        verificaCampoVazio(razaoSocial);
//        verificaEspacoInicio(razaoSocial);
//        verificaTamanhoAteCem(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
//        verificaEnderecoNulo(endereco);
        this.endereco = endereco;
    }
    
//    private void verificaEnderecoNulo(Endereco endereco) {
//        if (endereco == null) {
//            throw new IllegalArgumentException("Esse campo não pode ser nulo");
//        }
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Empresa))
            return false;
        Empresa other = (Empresa) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empresa [código=" + codigo + ", cnpj=" + cnpj + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", endereco=" + endereco + "]";
    }
    
}
