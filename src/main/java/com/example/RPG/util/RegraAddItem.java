package com.example.RPG.util;

import com.example.RPG.exceptions.RegraDeNegocioException;
import com.example.RPG.model.Item;
import com.example.RPG.model.ItemMagico;
import com.example.RPG.model.Personagem;

public class RegraAddItem {


    public static void validarPontosInicial(int somaAtributos){
        if (somaAtributos > 10) {
            throw new RegraDeNegocioException("A soma de força e defesa não pode ultrapassar 10 pontos.");
        }

    }

    public static void validar(ItemMagico item) {
        validarPontosPorTipo(item);
        validarLimiteDePontos(item);
    }

    private static void validarPontosPorTipo(ItemMagico item) {
            String tipo = item.getTipoDoItem().name();

    if ("Arma".equalsIgnoreCase(tipo)) {
        if (item.getForca() <= 0 || item.getDefesa() > 0) {
            throw new RegraDeNegocioException("Um item do tipo 'Arma' precisa ter força (maior que zero) e não pode ter defesa.");
        }
    } else if ("Armadura".equalsIgnoreCase(tipo)) {
        if (item.getForca() > 0 || item.getDefesa() <= 0) {
            throw new RegraDeNegocioException("Um item do tipo 'Armadura' precisa ter defesa (maior que zero) e não pode ter força.");
        }
    } else if ("Amuleto".equalsIgnoreCase(tipo)) {
        if (item.getForca() <= 0 || item.getDefesa() <= 0) {
            throw new RegraDeNegocioException("Um item do tipo 'Amuleto' precisa ter força e defesa maiores que zero.");
        }
    } else {
        throw new RegraDeNegocioException("Tipo de item inválido: " + tipo);
    }
}

private static void validarLimiteDePontos(ItemMagico item) {
        int somaAtributos = item.getForca() + item.getDefesa();
    String tipo = item.getTipoDoItem().name();

        if (somaAtributos > 10) {
            if ("Arma".equalsIgnoreCase(tipo)) {
                throw new RegraDeNegocioException("O item do tipo 'Arma' não pode ter força maior que 10.");
            } else if ("Armadura".equalsIgnoreCase(tipo)) {
                throw new RegraDeNegocioException("O item do tipo 'Armadura' não pode ter defesa maior que 10.");
            } else if ("Amuleto".equalsIgnoreCase(tipo)) {
                throw new RegraDeNegocioException("A soma de força e defesa do item 'Amuleto' não pode ultrapassar 10 pontos.");
            }
        }
    }

    public static void validarAmuletoExistente(Personagem personagem, ItemMagico itemMagico) {

        boolean jaTemAmuleto = personagem.getListaItemMagico().stream()
                .anyMatch(item -> item.getTipoDoItem() == Item.Amuleto);

        if (jaTemAmuleto && itemMagico.getTipoDoItem() == Item.Amuleto) {
            throw new RegraDeNegocioException("O personagem já possui um amuleto!");
        }
    }

}
