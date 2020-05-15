package br.com.contmatic.empresa;

import java.time.LocalDate;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.validacao.ValidaCpf;

public class Cliente {
    
    private String codigo;
    
    private String nome;
    
    private LocalDate dataNascimento;
    
    private String cpf;
    
    private Endereco endereco;
    
    private Contato contato;
    
    public Cliente(String codigo, String nome, LocalDate dataNascimento, String cpf, Endereco endereco, Contato contato) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setCpf(cpf);
        this.setEndereco(endereco);
        this.setContato(contato);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        verificaCampoNulo(codigo);
        verificaTamanhoMenorQue6(codigo);
        verificaContemSomenteNumeros(codigo);
        verificaCampoVazio(codigo);
        this.codigo = codigo;
    }
    
    private void verificaTamanhoMenorQue6(String campo) {
        if(campo.length() > 5) {
            throw new IllegalArgumentException("Este campo deve ter no máximo 5 dígitos");
        }
    }
    
    private void verificaCampoVazio(String campo) {
        if(campo.isEmpty()) {
            throw new IllegalArgumentException("Este campo não deve ser vazio");
        }
    }
    
    private void verificaContemSomenteNumeros(String campo) {
        for(char palavra: campo.toCharArray()) {
            if(!Character.isDigit(palavra)) {
                throw new IllegalArgumentException("Só deve conter números");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        verificaCampoNulo(nome);
        verificaCampoVazio(nome);
        verificaEspacoInicio(nome);
        verificaContemSomenteLetras(nome);
        verificaTamanhoAteCem(nome);
        this.nome = nome;
    }
    
    private void verificaEspacoInicio(String campo) {
        if(campo.charAt(0) == ' ') {
            throw new IllegalArgumentException("O campo não deve começar com espaços");
        }
    }
    
    private void verificaContemSomenteLetras(String campo) {
        for(char palavra: campo.toCharArray()) {
            if(!(Character.isAlphabetic(palavra) || Character.isSpaceChar(palavra))) {
                throw new IllegalArgumentException("Só deve conter letras");
            }
        }
    }

    private void verificaTamanhoAteCem(String campo) {
        if(campo.length() > 100) {
        throw new IllegalArgumentException("O campo deve ter até 100 caracteres");
        }
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        verificaDataNula(dataNascimento);
        verificaDataNascimento(dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    private void verificaDataNascimento(LocalDate dataNascimento) {
        if(dataNascimento.isBefore(LocalDate.of(1900, 1, 1)) || dataNascimento.isAfter(LocalDate.now())) {
           throw new IllegalArgumentException("Coloque uma data a partir de 01/01/1900 e não ultrapasse a data de hoje"); 
        }
    }

    private void verificaDataNula(LocalDate dataNascimento) {
        if(dataNascimento == null) {
            throw new IllegalArgumentException("O campo não deve ser nulo");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        verificaCampoNulo(cpf);
        verificaTodosDigitosRepetidos(cpf);
        verificaTamanhoCpf(cpf);
        verificaContemSomenteNumeros(cpf);
        ValidaCpf.validaCpf(cpf);
        this.cpf = cpf;
    }
    
    private void verificaCampoNulo(String campo) {
        if (campo == null) {
            throw new IllegalArgumentException("Esse campo não pode ser nulo");
        }
    }
    
    private void verificaTamanhoCpf(String cpf) {
        if(cpf.length() != 11) {
            throw new IllegalArgumentException("O número do CPF deve ter 11 dígitos");
        }
    }
    
    private void verificaTodosDigitosRepetidos(String cpf) {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")) {
            throw new IllegalArgumentException("Os digítos do CPF não podem ser todos repetidos"); 
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        verificaEnderecoNulo(endereco);
        this.endereco = endereco;
    }
    
    private void verificaEnderecoNulo(Endereco endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("Esse campo não pode ser nulo");
        }
    }

    public Contato getContato() {
        return contato;
    }
    
    public void setContato(Contato contato) {
        verificaContatoNulo(contato);
        this.contato = contato;
    }
    
    private void verificaContatoNulo(Contato contato) {
        if (contato == null) {
            throw new IllegalArgumentException("Esse campo não pode ser nulo");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Cliente))
            return false;
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", endereco=" + endereco + ", contato=" + contato + "]";
    }
    
}
