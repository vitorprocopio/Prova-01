package br.com.contmatic.empresa;

import java.time.LocalDate;

import br.com.contmatic.banco.ContaBancaria;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.hora.Horario;
import br.com.contmatic.validacao.ValidaCpf;

public class Funcionario {
    
    private String codigo;
    
    private String nome;
    
    private LocalDate dataNascimento;
   
    private String nomeMae;
    
    private String nomePai;
    
    private String cpf;
    
    private String sexo;
    
    private Endereco endereco;
    
    private double salario;
    
    private Horario horario;
    
    private ContaBancaria conta;
    
    public Funcionario(String codigo, String nome, LocalDate dataNascimento, String nomeMae, String nomePai, String cpf, String sexo, double salario, Endereco endereco, ContaBancaria conta, Horario horario) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setNomeMae(nomeMae);
        this.setNomePai(nomePai);
        this.setCpf(cpf);
        this.setSexo(sexo);
        this.setSalario(salario);
        this.setEndereco(endereco);
        this.setConta(conta);
        this.setHorario(horario);
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

    private void verificaCampoNulo(String campo) {
        if(campo == null) {
            throw new IllegalArgumentException("Este campo não deve ser nulo");
        }
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

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        verificaCampoNulo(nomeMae);
        verificaCampoVazio(nomeMae);
        verificaEspacoInicio(nomeMae);
        verificaContemSomenteLetras(nomeMae);
        verificaTamanhoAteCem(nomeMae);
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        verificaEspacoInicio(nomePai);
        verificaContemSomenteLetras(nomePai);
        verificaTamanhoAteCem(nomePai);
        this.nomePai = nomePai;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        verificaCampoNulo(cpf);
        verificaTamanhoCpf(cpf);
        verificaContemSomenteNumeros(cpf);
        verificaTodosDigitosRepetidos(cpf); 
        ValidaCpf.validaCpf(cpf);
        this.cpf = cpf;
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
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        verificaCampoNulo(sexo);
        verificaTamanhoIgualUm(sexo);
        verificaSexo(sexo);
        this.sexo = sexo;
    }

    private void verificaTamanhoIgualUm(String sexo) {
        if(sexo.length() != 1) {
            throw new IllegalArgumentException("Tamanho inválido: Escreva F (Feminino), M (Masculino) ou O (Outro)");
        }
    }

    private void verificaSexo(String sexo) {
            if (sexo.equals("F") || sexo.equals("M") || sexo.equals("O")) {
            } else {
                throw new IllegalArgumentException("Escreva F (Feminino), M (Masculino) ou O (Outro)");
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
        if(endereco == null) {
            throw new IllegalArgumentException("Este campo não deve ser nulo");
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        verificaSalario(salario);
        this.salario = salario;
    }

    private void verificaSalario(double salario) {
        if(salario < 0 || salario > 99999) {
            throw new IllegalArgumentException("O salário vai de 0 até 99999 reais");
        }
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        verificaHorarioNulo(horario);
        this.horario = horario;
    }
    
    private void verificaHorarioNulo(Horario horario) {
        if(horario == null) {
            throw new IllegalArgumentException("Este campo não deve ser nulo");
        }
    }
    
    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        verificaContaNulo(conta);
        this.conta = conta;
    }
    
    private void verificaContaNulo(ContaBancaria conta) {
        if(conta == null) {
            throw new IllegalArgumentException("Este campo não deve ser nulo");
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
        if (!(obj instanceof Funcionario))
            return false;
        Funcionario other = (Funcionario) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", cpf=" + cpf + ", sexo=" +
            sexo + ", endereco=" + endereco + ", salario=" + salario + ", horario=" + horario + ", conta=" + conta + "]";
    }
    
}
