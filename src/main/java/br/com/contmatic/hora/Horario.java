package br.com.contmatic.hora;

import java.time.LocalTime;

public class Horario {
    
    private LocalTime entrada;
    
    private LocalTime saidaAlmoco;
    
    private LocalTime retornoAlmoco;
    
    private LocalTime saida;
    
    public Horario(LocalTime entrada, LocalTime saidaAlmoco, LocalTime retornoAlmoco, LocalTime saida) {
        this.setEntrada (entrada);
        this.setSaidaAlmoco(saidaAlmoco);
        this.setRetornoAlmoco(retornoAlmoco);
        this.setSaida(saida);
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalTime entrada) {
        verificaHorarioNulo(entrada);
        verificaEntrada(entrada);
        this.entrada = entrada;
    }

    private void verificaEntrada(LocalTime entrada) {
        if(entrada.isBefore(LocalTime.of(07, 00, 00)) || entrada.isAfter(LocalTime.of(18, 00, 00))) {
           throw new IllegalArgumentException("Coloque um horário entre 07:00:00 e 18:00:00"); 
        }
    }

    private void verificaHorarioNulo(LocalTime campo) {
        if(campo == null) {
            throw new IllegalArgumentException("O campo não deve ser nulo");
        }
    }

    public LocalTime getSaidaAlmoco() {
        return saidaAlmoco;
    }

    public void setSaidaAlmoco(LocalTime saidaAlmoco) {
        verificaHorarioNulo(saidaAlmoco);
        verificaSaidaAlmoco(saidaAlmoco);
        this.saidaAlmoco = saidaAlmoco;
    }

    private void verificaSaidaAlmoco(LocalTime saidaAlmoco) {
        if(saidaAlmoco.isBefore(LocalTime.of(11, 00, 00)) || saidaAlmoco.isAfter(LocalTime.of(14, 00, 00))) {
           throw new IllegalArgumentException("Coloque um horário entre 11:00:00 e 14:00:00"); 
        }
    }

    public LocalTime getRetornoAlmoco() {
        return retornoAlmoco;
    }

    public void setRetornoAlmoco(LocalTime retornoAlmoco) {
        verificaHorarioNulo(retornoAlmoco);
        verificaRetornoAlmoco(retornoAlmoco);
        this.retornoAlmoco = retornoAlmoco;
    }

    private void verificaRetornoAlmoco(LocalTime retornoAlmoco) {
        if(retornoAlmoco.isBefore(LocalTime.of(12, 00, 00)) || retornoAlmoco.isAfter(LocalTime.of(15, 00, 00))) {
           throw new IllegalArgumentException("Coloque um horário entre 12:00:00 e 15:00:00"); 
        }
    }

    public LocalTime getSaida() {
        return saida;
    }

    public void setSaida(LocalTime saida) {
        verificaHorarioNulo(saida);
        verificaSaida(saida);
        this.saida = saida;
    }

    private void verificaSaida(LocalTime saida) {
        if(saida.isBefore(LocalTime.of(8, 00, 00)) || saida.isAfter(LocalTime.of(20, 00, 00))) {
           throw new IllegalArgumentException("Coloque um horário entre 8:00:00 e 20:00:00"); 
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
        result = prime * result + ((retornoAlmoco == null) ? 0 : retornoAlmoco.hashCode());
        result = prime * result + ((saida == null) ? 0 : saida.hashCode());
        result = prime * result + ((saidaAlmoco == null) ? 0 : saidaAlmoco.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Horario))
            return false;
        Horario other = (Horario) obj;
        if (entrada == null) {
            if (other.entrada != null)
                return false;
        } else if (!entrada.equals(other.entrada))
            return false;
        if (retornoAlmoco == null) {
            if (other.retornoAlmoco != null)
                return false;
        } else if (!retornoAlmoco.equals(other.retornoAlmoco))
            return false;
        if (saida == null) {
            if (other.saida != null)
                return false;
        } else if (!saida.equals(other.saida))
            return false;
        if (saidaAlmoco == null) {
            if (other.saidaAlmoco != null)
                return false;
        } else if (!saidaAlmoco.equals(other.saidaAlmoco))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Horario [entrada=" + entrada + ", saidaAlmoco=" + saidaAlmoco + ", retornoAlmoco=" + retornoAlmoco + ", saida=" + saida + "]";
    }
    
    

}
