# 🎬 CineTrack

> Sistema de gerenciamento e catalogação de conteúdos audiovisuais desenvolvido em Java puro.

---

## 👥 Equipe

| Nome               |
|--------------------|
| Ayslan Gadelha     |
| Cristian Ribeiro   |
| Eliandra Virginia  |
| Rodney Moreira     |
| Filipe Sales       |

---

## 📋 Descrição

O **CineTrack** é um sistema orientado a objetos desenvolvido em Java para cadastrar, avaliar e calcular a duração total de conteúdos audiovisuais. O projeto contempla dois tipos de conteúdo: **longas-metragens** e **seriados**, ambos compartilhando atributos comuns por meio de uma classe base chamada `Conteudo`.

O sistema permite:
- Cadastrar um longa-metragem com nome, realizador (diretor), ano de estreia e duração.
- Registrar múltiplas avaliações para um longa e calcular a média delas.
- Cadastrar um seriado com nome, ano de estreia, número de temporadas, episódios por temporada e duração por episódio.
- Calcular a duração total acumulada de todos os conteúdos cadastrados por meio do `GerenciadorDeDuracao`.

---

## 🏗️ Estrutura do Projeto

```
cinetrack/
└── src/
    ├── Aplicacao.java
    └── br/
        └── com/
            └── acr/
                └── cinetrack/
                    ├── modelos/
                    │   ├── Conteudo.java
                    │   ├── Longa.java
                    │   └── Seriado.java
                    └── calculos/
                        └── GerenciadorDeDuracao.java
```

---

## 📁 Classes e Responsabilidades

### `Conteudo` — Classe Base (Abstração)
**Pacote:** `br.com.acr.cinetrack.modelos`

Classe pai que representa qualquer conteúdo audiovisual da plataforma. Contém os atributos e comportamentos compartilhados por longas e seriados.

| Atributo                  | Tipo      | Descrição                                      |
|---------------------------|-----------|------------------------------------------------|
| `designacao`              | `String`  | Nome/título do conteúdo                        |
| `anoDeEstreia`            | `int`     | Ano de lançamento (deve ser maior que 1888)    |
| `duracaoTotal`            | `int`     | Duração em minutos (deve ser maior que 0)      |
| `quantidadeDeAvaliacoes`  | `int`     | Contador de avaliações registradas             |
| `somaDeNotas`             | `double`  | Soma de todas as notas recebidas               |
| `pontuacao`               | `double`  | Pontuação individual                           |
| `mediaDasNotas`           | `double`  | Campo auxiliar para média                      |
| `disponivelNaPlataforma`  | `boolean` | Indica se o conteúdo está ativo na plataforma  |

| Método                              | Descrição                                          |
|-------------------------------------|----------------------------------------------------|
| `exibirDetalhes()`                  | Imprime no console os dados principais do conteúdo |
| `registrarAvaliacao(double nota)`   | Acumula uma nota e incrementa o contador           |
| `calcularMedia()`                   | Retorna a média aritmética das avaliações          |
| `obterDuracaoEmMinutos()`           | Retorna a duração total em minutos                 |

**Validações:**
- `setAnoDeEstreia`: o ano deve ser superior a 1888 (ano de invenção do cinema).
- `setDuracaoTotal`: a duração deve ser maior que zero.

---

### `Longa` — Longa-Metragem
**Pacote:** `br.com.acr.cinetrack.modelos`

Subclasse de `Conteudo` que representa um filme de longa-metragem. Adiciona o atributo `realizador` (diretor do filme) e sobrescreve o método `obterDuracaoEmMinutos()`.

| Atributo     | Tipo     | Descrição                   |
|--------------|----------|-----------------------------|
| `realizador` | `String` | Nome do diretor do filme    |

| Método                   | Descrição                                     |
|--------------------------|-----------------------------------------------|
| `obterDuracaoEmMinutos()`| Retorna diretamente o valor de `duracaoTotal` |

---

### `Seriado` — Série de TV
**Pacote:** `br.com.acr.cinetrack.modelos`

Subclasse de `Conteudo` que representa uma série de televisão. A duração total é calculada automaticamente com base no número de temporadas, episódios e duração de cada episódio.

| Atributo               | Tipo      | Descrição                                  |
|------------------------|-----------|--------------------------------------------|
| `totalDeTemporadas`    | `int`     | Número de temporadas do seriado            |
| `episodiosPorTemp`     | `int`     | Quantidade de episódios por temporada      |
| `duracaoPorEpisodio`   | `int`     | Duração de cada episódio em minutos        |
| `emExibicao`           | `boolean` | Indica se o seriado ainda está no ar       |

| Método                   | Descrição                                                              |
|--------------------------|------------------------------------------------------------------------|
| `obterDuracaoEmMinutos()`| Calcula: `totalDeTemporadas × episodiosPorTemp × duracaoPorEpisodio`  |

---

### `GerenciadorDeDuracao` — Calculadora de Tempo Total
**Pacote:** `br.com.acr.cinetrack.calculos`

Responsável por acumular e fornecer a duração total de todos os conteúdos adicionados. Trabalha com a abstração `Conteudo`, sendo compatível tanto com `Longa` quanto com `Seriado` (polimorfismo).

| Atributo            | Tipo  | Descrição                                         |
|---------------------|-------|---------------------------------------------------|
| `duracaoAcumulada`  | `int` | Soma total da duração de todos os conteúdos       |

| Método                              | Descrição                                                         |
|-------------------------------------|-------------------------------------------------------------------|
| `adicionarConteudo(Conteudo c)`     | Chama `obterDuracaoEmMinutos()` e acumula ao total               |
| `getDuracaoAcumulada()`             | Retorna o tempo total acumulado em minutos                        |

---

### `Aplicacao` — Classe Principal
**Arquivo:** `src/Aplicacao.java`

Ponto de entrada da aplicação. Responsável por ler os dados via terminal usando `Scanner`, instanciar os objetos e exibir os resultados.

**Fluxo de execução:**
1. Lê e cadastra um longa-metragem (nome, realizador, ano, duração e avaliações).
2. Lê e cadastra um seriado (nome, ano, temporadas, episódios e duração por episódio).
3. Exibe a ficha técnica de ambos.
4. Exibe a soma, a quantidade e a média das avaliações do longa.
5. Adiciona os dois ao `GerenciadorDeDuracao` e exibe o tempo total acumulado.

---

## 🧠 Conceitos de POO Aplicados

| Conceito          | Onde é aplicado                                                                                 |
|-------------------|-------------------------------------------------------------------------------------------------|
| **Herança**       | `Longa` e `Seriado` herdam de `Conteudo`                                                        |
| **Polimorfismo**  | `obterDuracaoEmMinutos()` é sobrescrito em `Longa` e `Seriado`; `GerenciadorDeDuracao` usa `Conteudo` |
| **Encapsulamento**| Todos os atributos são `private` com acesso via getters e setters                               |
| **Abstração**     | `Conteudo` centraliza os atributos e comportamentos comuns                                      |
| **Validação**     | Setters de `anoDeEstreia` e `duracaoTotal` possuem regras de negócio                           |

---

## ▶️ Como Compilar e Executar

### Pré-requisitos
- JDK 8 ou superior instalado
- Terminal (cmd, bash ou PowerShell)

### Compilação

Dentro da pasta `src/`:

```bash
javac -d . Aplicacao.java br/com/acr/cinetrack/modelos/Conteudo.java br/com/acr/cinetrack/modelos/Longa.java br/com/acr/cinetrack/modelos/Seriado.java br/com/acr/cinetrack/calculos/GerenciadorDeDuracao.java
```

### Execução

```bash
java Aplicacao
```

---

## 💡 Exemplo de Uso

```
Digite o nome do filme:
Oppenheimer
Digite o nome do diretor do filme:
Christopher Nolan
Digite o ano de lançamento do filme:
2023
Digite a duração do filme em minutos:
180
Digite a quantidade de avaliações:
2
Digite a nota da avaliação 1:
9.5
Digite a nota da avaliação 2:
8.0
Digite o nome da série:
Breaking Bad
Digite o ano de lançamento da série:
2008
Digite a quantidade de temporadas da série:
5
Digite a quantidade de episódios por temporada:
13
Digite a duração de cada episódio em minutos:
47

Nome: Oppenheimer
Ano de estreia: 2023
Duração em minutos: 180
Nome: Breaking Bad
Ano de estreia: 2008
Duração em minutos: 0
Soma das avaliações: 17.5
Total de avaliações: 2
Média das avaliações: 8.75
Adicionando duração em minutos de br.com.acr.cinetrack.modelos.Longa@...
Adicionando duração em minutos de br.com.acr.cinetrack.modelos.Seriado@...
Tempo total: 3235
```

---

## 📌 Observações

- A classe `Seriado` não utiliza o atributo `duracaoTotal` herdado de `Conteudo` para calcular sua duração — ela usa a multiplicação `totalDeTemporadas × episodiosPorTemp × duracaoPorEpisodio` via override do método `obterDuracaoEmMinutos()`.
- O `GerenciadorDeDuracao` usa polimorfismo: recebe um objeto do tipo `Conteudo` e chama `obterDuracaoEmMinutos()`, que se comporta diferente para `Longa` e `Seriado`.
- As versões comentadas dos métodos `inclui(Filme)` e `inclui(Serie)` do original foram substituídas por uma única implementação polimórfica usando a superclasse `Conteudo`.

---

*Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO).*
