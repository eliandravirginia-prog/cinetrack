import java.util.Scanner;

import br.com.acr.cinetrack.calculos.GerenciadorDeDuracao;
import br.com.acr.cinetrack.modelos.Longa;
import br.com.acr.cinetrack.modelos.Seriado;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Informações do longa-metragem
        Longa longa1 = new Longa();
        System.out.println("Digite o nome do filme:");
        longa1.setDesignacao(scanner.nextLine());
        System.out.println("Digite o nome do diretor do filme:");
        longa1.setRealizador(scanner.nextLine());
        System.out.println("Digite o ano de lançamento do filme:");
        longa1.setAnoDeEstreia(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a duração do filme em minutos:");
        longa1.setDuracaoTotal(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a quantidade de avaliações:");
        int qtd = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < qtd; i++) {
            System.out.println("Digite a nota da avaliação " + (i + 1) + ":");
            longa1.registrarAvaliacao(Double.parseDouble(scanner.nextLine().trim()));
        }

        // Informações do seriado
        Seriado seriado1 = new Seriado();
        System.out.println("Digite o nome da série:");
        seriado1.setDesignacao(scanner.nextLine());
        System.out.println("Digite o ano de lançamento da série:");
        seriado1.setAnoDeEstreia(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a quantidade de temporadas da série:");
        seriado1.setTotalDeTemporadas(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a quantidade de episódios por temporada:");
        seriado1.setEpisodiosPorTemp(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Digite a duração de cada episódio em minutos:");
        seriado1.setDuracaoPorEpisodio(Integer.parseInt(scanner.nextLine().trim()));

        scanner.close();

        longa1.exibirDetalhes();
        seriado1.exibirDetalhes();

        System.out.println("Soma das avaliações: " + longa1.getSomaDeNotas());
        System.out.println("Total de avaliações: " + longa1.getQuantidadeDeAvaliacoes());
        System.out.println("Média das avaliações: " + longa1.calcularMedia());

        // Gerenciador de duração
        GerenciadorDeDuracao gerenciador = new GerenciadorDeDuracao();
        gerenciador.adicionarConteudo(longa1);
        gerenciador.adicionarConteudo(seriado1);
        System.out.println("Tempo total: " + gerenciador.getDuracaoAcumulada());
    }
}
