package br.com.contmatic.validacao;

public class ValidaCpf {
    
    public static String validaCpf(String cpf) {
        
    int[] cpfLista = new int[11];
    
    int verificadorDigito10;
    
    int verificadorDigito11;
    
    for( int i = 0; i < cpfLista.length; i++) {
        cpfLista[i] = Integer.parseInt(cpf.substring(i, i + 1));
    }
    
    verificadorDigito10 = ( cpfLista[0] * 10 + cpfLista[1] * 9 + cpfLista[2] * 8 + cpfLista[3] * 7 + cpfLista[4] * 6 + cpfLista[5] * 5 + cpfLista[6] * 4 + cpfLista[7] * 3 + cpfLista[8] * 2);
    
    if ( (verificadorDigito10 % 11) < 2) {
        verificadorDigito10 = 0;
    } else {
        verificadorDigito10 = 11 - (verificadorDigito10 % 11);
    }
    
    if (verificadorDigito10 == Integer.parseInt(cpf.substring(9, 10))) {
    } else {
        throw new IllegalArgumentException("CPF inválido, erro no décimo dígito");
    }
    
    verificadorDigito11 = ( cpfLista[0] * 11 + cpfLista[1] * 10 + cpfLista[2] * 9 + cpfLista[3] * 8 + cpfLista[4] * 7 + cpfLista[5] * 6 + cpfLista[6] * 5 + cpfLista[7] * 4 + cpfLista[8] * 3 + verificadorDigito10 * 2);
    
    if((verificadorDigito11 % 11) < 2) {
        verificadorDigito11 = 0;
    } else {
        verificadorDigito11 = 11 - (verificadorDigito11 % 11);
    }
    
    if (verificadorDigito11 == Integer.parseInt(cpf.substring(10, 11))) {
    } else {
        throw new IllegalArgumentException("CPF inválido, erro no décimo primeiro dígito");
    }
   
    return cpf;
  
    }
    
}
    

