package br.com.acr.cinetrack.calculos;

import br.com.acr.cinetrack.modelos.Conteudo;

public class GerenciadorDeDuracao {

    private int duracaoAcumulada = 0;

    public int getDuracaoAcumulada() {
        return duracaoAcumulada;
    }

    // Adiciona a duração de qualquer conteúdo ao acumulador
    public void adicionarConteudo(Conteudo conteudo) {
        System.out.println("Adicionando duração em minutos de " + conteudo);
        this.duracaoAcumulada += conteudo.obterDuracaoEmMinutos();
    }
}
