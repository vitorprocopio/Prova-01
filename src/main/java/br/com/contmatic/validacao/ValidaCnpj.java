package br.com.contmatic.validacao;

public class ValidaCnpj {

    public static String validaCnpj(String cnpj) {

        int[] cnpjLista = new int[14];

        int verificadorDigito13;

        int verificadorDigito14;

        for(int i = 0 ; i < cnpjLista.length ; i++) {
            cnpjLista[i] = Integer.parseInt(cnpj.substring(i, i + 1));
        }

        verificadorDigito13 = (cnpjLista[0] * 5 + cnpjLista[1] * 4 + cnpjLista[2] * 3 + cnpjLista[3] * 2 + cnpjLista[4] * 9 + cnpjLista[5] * 8 + cnpjLista[6] * 7 + cnpjLista[7] * 6 + cnpjLista[8] * 5 + cnpjLista[9] * 4 + cnpjLista[10] * 3 + cnpjLista[11] * 2);

        if ((verificadorDigito13 % 11) < 2) {
            verificadorDigito13 = 0;
        } else {
            verificadorDigito13 = 11 - (verificadorDigito13 % 11);
        }

        if (verificadorDigito13 == Integer.parseInt(cnpj.substring(12, 13))) {
        } else {
            throw new IllegalArgumentException("CNPJ inválido, erro no décimo terceiro dígito");
        }

        verificadorDigito14 = (cnpjLista[0] * 6 + cnpjLista[1] * 5 + cnpjLista[2] * 4 + cnpjLista[3] * 3 + cnpjLista[4] * 2 + cnpjLista[5] * 9 + cnpjLista[6] * 8 + cnpjLista[7] * 7 + cnpjLista[8] * 6 + cnpjLista[9] * 5 + cnpjLista[10] * 4 + cnpjLista[11] * 3 + verificadorDigito13 * 2);

        if ((verificadorDigito14 % 11) < 2) {
            verificadorDigito14 = 0;
        } else {
            verificadorDigito14 = 11 - (verificadorDigito14 % 11);
        }

        if (verificadorDigito14 == Integer.parseInt(cnpj.substring(13, 14))) {
        } else {
            throw new IllegalArgumentException("CNPJ inválido, erro no décimo quarto dígito");
        }

        return cnpj;

    }
        
}
