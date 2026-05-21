package br.com.acr.cinetrack.modelos;

public class Conteudo {

    // Declarando os atributos da classe
    private String designacao;
    private int anoDeEstreia, duracaoTotal, quantidadeDeAvaliacoes;
    private double somaDeNotas, pontuacao, mediaDasNotas;
    private boolean disponivelNaPlataforma;

    // Exibe as informações principais do conteúdo
    public void exibirDetalhes() {
        System.out.println("Nome: " + designacao);
        System.out.println("Ano de estreia: " + anoDeEstreia);
        System.out.println("Duração em minutos: " + duracaoTotal);
    }

    // Registra uma nova avaliação
    public void registrarAvaliacao(double pontuacao) {
        somaDeNotas += pontuacao;
        quantidadeDeAvaliacoes++;
    }

    // Calcula e retorna a média das avaliações
    public double calcularMedia() {
        return somaDeNotas / quantidadeDeAvaliacoes;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public int getAnoDeEstreia() {
        return anoDeEstreia;
    }

    public void setAnoDeEstreia(int anoDeEstreia) {
        // Ano de invenção do cinema: 1888
        if (anoDeEstreia > 1888) {
            this.anoDeEstreia = anoDeEstreia;
        } else {
            System.out.println("Ano de estreia inválido!");
        }
    }

    public int getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(int duracaoTotal) {
        // Duração mínima de um conteúdo: 1 minuto
        if (duracaoTotal > 0) {
            this.duracaoTotal = duracaoTotal;
        } else {
            System.out.println("Duração inválida!");
        }
    }

    public int getQuantidadeDeAvaliacoes() {
        return quantidadeDeAvaliacoes;
    }

    public void setQuantidadeDeAvaliacoes(int quantidadeDeAvaliacoes) {
        this.quantidadeDeAvaliacoes = quantidadeDeAvaliacoes;
    }

    public double getSomaDeNotas() {
        return somaDeNotas;
    }

    public void setSomaDeNotas(double somaDeNotas) {
        this.somaDeNotas = somaDeNotas;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public double getMediaDasNotas() {
        return mediaDasNotas;
    }

    public void setMediaDasNotas(double mediaDasNotas) {
        this.mediaDasNotas = mediaDasNotas;
    }

    public boolean isDisponivelNaPlataforma() {
        return disponivelNaPlataforma;
    }

    public void setDisponivelNaPlataforma(boolean disponivelNaPlataforma) {
        this.disponivelNaPlataforma = disponivelNaPlataforma;
    }

    public int obterDuracaoEmMinutos() {
        return duracaoTotal;
    }
}
