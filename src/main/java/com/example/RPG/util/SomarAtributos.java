package com.example.RPG.util;

import com.example.RPG.model.ItemMagico;
import com.example.RPG.model.Personagem;

public class SomarAtributos {

        public static int calcularForcaTotal(Personagem personagem) {
            int bonusForca = personagem.getListaItemMagico()
                    .stream()
                    .mapToInt(ItemMagico::getForca)
                    .sum();
            return bonusForca;
        }

        public static int calcularDefesaTotal(Personagem personagem) {
            int bonusDefesa = personagem.getListaItemMagico()
                    .stream()
                    .mapToInt(ItemMagico::getDefesa)
                    .sum();
            return bonusDefesa;
        }
    }
