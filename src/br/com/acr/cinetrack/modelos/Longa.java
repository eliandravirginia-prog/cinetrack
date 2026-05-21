package br.com.acr.cinetrack.modelos;

public class Longa extends Conteudo {

    private String realizador;

    public String getRealizador() {
        return realizador;
    }

    public void setRealizador(String realizador) {
        this.realizador = realizador;
    }

    @Override
    public int obterDuracaoEmMinutos() {
        return getDuracaoTotal();
    }
}
