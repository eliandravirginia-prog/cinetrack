package br.com.acr.cinetrack.modelos;

public class Seriado extends Conteudo {

    private int totalDeTemporadas;
    private int episodiosPorTemp;
    private int duracaoPorEpisodio;
    private boolean emExibicao;

    public int getTotalDeTemporadas() {
        return totalDeTemporadas;
    }

    public void setTotalDeTemporadas(int totalDeTemporadas) {
        this.totalDeTemporadas = totalDeTemporadas;
    }

    public int getEpisodiosPorTemp() {
        return episodiosPorTemp;
    }

    public void setEpisodiosPorTemp(int episodiosPorTemp) {
        this.episodiosPorTemp = episodiosPorTemp;
    }

    public int getDuracaoPorEpisodio() {
        return duracaoPorEpisodio;
    }

    public void setDuracaoPorEpisodio(int duracaoPorEpisodio) {
        this.duracaoPorEpisodio = duracaoPorEpisodio;
    }

    public boolean isEmExibicao() {
        return emExibicao;
    }

    public void setEmExibicao(boolean emExibicao) {
        this.emExibicao = emExibicao;
    }

    // Duração total do seriado: temporadas × episódios × minutos por episódio
    @Override
    public int obterDuracaoEmMinutos() {
        return totalDeTemporadas * episodiosPorTemp * duracaoPorEpisodio;
    }
}
