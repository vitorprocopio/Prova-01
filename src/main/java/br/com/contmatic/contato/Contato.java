package br.com.contmatic.contato;

public class Contato {
    
    private String telefone;
    
    private String celular;
    
    private String recado;
    
    private String email;
    
    public Contato(String telefone, String celular, String recado, String email) {
        this.setTelefone(telefone);
        this.setCelular(celular);
        this.setRecado(recado);
        this.setEmail(email);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone != null) {
        verificaTamanhoTelefone(telefone);
        verificaContemSomenteNumeros(telefone);
        }
    }
    
    private void verificaContemSomenteNumeros(String campo) {
        for(char palavra: campo.toCharArray()) {
            if(!Character.isDigit(palavra)) {
                throw new IllegalArgumentException("Só deve conter números");
            }
        }
    }

    private void verificaTamanhoTelefone(String telefone) {
        if(telefone.length() != 8) {
           throw new IllegalArgumentException("O número deve conter 8 dígitos"); 
        }
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if(celular != null) {
        verificaTamanhoCelular(celular);
        verificaContemSomenteNumeros(celular);
        }
    }

    private void verificaTamanhoCelular(String celular) {
        if(celular.length() != 9) {
            throw new IllegalArgumentException("O número deve conter 9 dígitos"); 
         }
        this.celular = celular;
    }

    public String getRecado() {
        return recado;
    }

    public void setRecado(String recado) {
        if(recado != null) {
        verificaTamanhoRecado(recado);
        verificaContemSomenteNumeros(recado);
        }
    }

    private void verificaTamanhoRecado(String recado) {
        if(recado.length() < 8 || recado.length() > 9) {
            throw new IllegalArgumentException("O número deve conter 8 ou 9 dígitos"); 
         }
        this.recado = recado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null) {
        verificaTamanhoEmail(email);
        }
    }

    private void verificaTamanhoEmail(String email) {
        if(email.length() > 250) {
            throw new IllegalArgumentException("O email deve ter até 100 caracteres");
        }
        for(char palavra: email.toCharArray()) {
            if(Character.isSpaceChar(palavra)) {
                throw new IllegalArgumentException("Não deve ter espaço");
            }
        }
        this.email = email;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((celular == null) ? 0 : celular.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((recado == null) ? 0 : recado.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Contato))
            return false;
        Contato other = (Contato) obj;
        if (celular == null) {
            if (other.celular != null)
                return false;
        } else if (!celular.equals(other.celular))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (recado == null) {
            if (other.recado != null)
                return false;
        } else if (!recado.equals(other.recado))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Contato [telefone=" + telefone + ", celular=" + celular + ", recado=" + recado + ", email=" + email + "]";
    }
    
    
}
