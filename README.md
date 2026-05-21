# 🎬 CineTrack

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
![Licença](https://img.shields.io/badge/Licença-MIT-green?style=for-the-badge)

> Sistema de gerenciamento e catalogação de conteúdos audiovisuais desenvolvido em Java puro com foco em Programação Orientada a Objetos.

</div>

---

## 📑 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Arquitetura](#-arquitetura)
- [Classes e Responsabilidades](#-classes-e-responsabilidades)
- [Conceitos de POO Aplicados](#-conceitos-de-poo-aplicados)
- [Como Executar](#-como-executar)
- [Exemplo de Uso](#-exemplo-de-uso)
- [Equipe](#-equipe)

---

## 📖 Sobre o Projeto

O **CineTrack** é um sistema orientado a objetos desenvolvido em Java para cadastrar, avaliar e calcular a duração total de conteúdos audiovisuais. O projeto contempla dois tipos de conteúdo — **longas-metragens** e **seriados** — que compartilham atributos comuns por meio de uma classe base chamada `Conteudo`.

Desenvolvido como projeto prático para a disciplina de **Programação Orientada a Objetos (POO)**.

---

## ✨ Funcionalidades

- ✅ Cadastrar longas-metragens com nome, diretor, ano e duração
- ✅ Registrar e calcular média de avaliações de um longa
- ✅ Cadastrar seriados com temporadas, episódios e duração por episódio
- ✅ Calcular duração total acumulada de todos os conteúdos via `GerenciadorDeDuracao`
- ✅ Exibir ficha técnica completa de cada conteúdo

---

## 🏗️ Arquitetura

```
cinetrack/
└── src/
    ├── Aplicacao.java
    └── br/
        └── com/
            └── acr/
                └── cinetrack/
                    ├── modelos/
                    │   ├── Conteudo.java        ← Classe base (abstração)
                    │   ├── Longa.java           ← Longa-metragem
                    │   └── Seriado.java         ← Série de TV
                    └── calculos/
                        └── GerenciadorDeDuracao.java
```

---

## 📁 Classes e Responsabilidades

### `Conteudo` — Classe Base

**Pacote:** `br.com.acr.cinetrack.modelos`

Classe pai que representa qualquer conteúdo audiovisual. Centraliza atributos e comportamentos compartilhados por longas e seriados.

| Atributo | Tipo | Descrição |
|---|---|---|
| `designacao` | `String` | Nome/título do conteúdo |
| `anoDeEstreia` | `int` | Ano de lançamento (> 1888) |
| `duracaoTotal` | `int` | Duração em minutos (> 0) |
| `quantidadeDeAvaliacoes` | `int` | Contador de avaliações |
| `somaDeNotas` | `double` | Soma de todas as notas |
| `disponivelNaPlataforma` | `boolean` | Se o conteúdo está ativo |

| Método | Descrição |
|---|---|
| `exibirDetalhes()` | Imprime os dados principais do conteúdo |
| `registrarAvaliacao(double nota)` | Acumula uma nota e incrementa o contador |
| `calcularMedia()` | Retorna a média aritmética das avaliações |
| `obterDuracaoEmMinutos()` | Retorna a duração total em minutos |

> **Validações:** `setAnoDeEstreia` exige ano > 1888; `setDuracaoTotal` exige valor > 0.

---

### `Longa` — Longa-Metragem

**Pacote:** `br.com.acr.cinetrack.modelos`

Subclasse de `Conteudo`. Adiciona o atributo `realizador` e sobrescreve `obterDuracaoEmMinutos()`.

| Atributo | Tipo | Descrição |
|---|---|---|
| `realizador` | `String` | Nome do diretor do filme |

---

### `Seriado` — Série de TV

**Pacote:** `br.com.acr.cinetrack.modelos`

Subclasse de `Conteudo`. A duração total é calculada automaticamente com base no número de temporadas, episódios e duração por episódio.

| Atributo | Tipo | Descrição |
|---|---|---|
| `totalDeTemporadas` | `int` | Número de temporadas |
| `episodiosPorTemp` | `int` | Episódios por temporada |
| `duracaoPorEpisodio` | `int` | Duração de cada episódio (min) |
| `emExibicao` | `boolean` | Se ainda está no ar |

> **Cálculo:** `obterDuracaoEmMinutos()` = `totalDeTemporadas × episodiosPorTemp × duracaoPorEpisodio`

---

### `GerenciadorDeDuracao` — Calculadora de Tempo Total

**Pacote:** `br.com.acr.cinetrack.calculos`

Responsável por acumular e fornecer a duração total de todos os conteúdos adicionados. Utiliza polimorfismo para ser compatível com `Longa` e `Seriado` por meio da superclasse `Conteudo`.

| Atributo | Tipo | Descrição |
|---|---|---|
| `duracaoAcumulada` | `int` | Soma total de todos os conteúdos |

| Método | Descrição |
|---|---|
| `adicionarConteudo(Conteudo c)` | Chama `obterDuracaoEmMinutos()` e acumula ao total |
| `getDuracaoAcumulada()` | Retorna o tempo total acumulado em minutos |

---

### `Aplicacao` — Ponto de Entrada

**Arquivo:** `src/Aplicacao.java`

Lê os dados via terminal com `Scanner`, instancia os objetos e exibe os resultados. Fluxo:

1. Lê e cadastra um longa-metragem
2. Lê e cadastra um seriado
3. Exibe a ficha técnica de ambos
4. Exibe soma, quantidade e média de avaliações do longa
5. Adiciona os dois ao `GerenciadorDeDuracao` e exibe o tempo total acumulado

---

## 🧠 Conceitos de POO Aplicados

| Conceito | Aplicação no Projeto |
|---|---|
| **Herança** | `Longa` e `Seriado` herdam de `Conteudo` |
| **Polimorfismo** | `obterDuracaoEmMinutos()` é sobrescrito em cada subclasse; `GerenciadorDeDuracao` usa `Conteudo` como tipo base |
| **Encapsulamento** | Todos os atributos são `private` com acesso via getters/setters |
| **Abstração** | `Conteudo` centraliza os comportamentos e atributos comuns |
| **Validação** | Setters com regras de negócio (`anoDeEstreia > 1888`, `duracaoTotal > 0`) |

---

## 🚀 Como Executar

### Pré-requisitos

- JDK 8 ou superior
- Terminal (cmd, bash ou PowerShell)

### 1. Clone o repositório

```bash
git clone https://github.com/eliandravirginia-prog/cinetrack.git
cd cinetrack
```

### 2. Compile

Dentro da pasta `src/`:

```bash
javac -d . Aplicacao.java \
  br/com/acr/cinetrack/modelos/Conteudo.java \
  br/com/acr/cinetrack/modelos/Longa.java \
  br/com/acr/cinetrack/modelos/Seriado.java \
  br/com/acr/cinetrack/calculos/GerenciadorDeDuracao.java
```

### 3. Execute

```bash
java Aplicacao
```

---

## 💡 Exemplo de Uso

```
Digite o nome do filme: Oppenheimer
Digite o nome do diretor do filme: Christopher Nolan
Digite o ano de lançamento do filme: 2023
Digite a duração do filme em minutos: 180
Digite a quantidade de avaliações: 2
Digite a nota da avaliação 1: 9.5
Digite a nota da avaliação 2: 8.0

Digite o nome da série: Breaking Bad
Digite o ano de lançamento da série: 2008
Digite a quantidade de temporadas da série: 5
Digite a quantidade de episódios por temporada: 13
Digite a duração de cada episódio em minutos: 47

--- Ficha Técnica ---
Nome: Oppenheimer | Ano: 2023 | Duração: 180 min
Nome: Breaking Bad | Ano: 2008 | Duração: 3055 min

Soma das avaliações: 17.5
Total de avaliações: 2
Média das avaliações: 8.75

Tempo total acumulado: 3235 min
```

---

## 👥 Equipe

| Nome |
|---|
| Ayslan Gadelha |
| Cristian Ribeiro |
| Eliandra Virginia |
| Rodney Moreira |
| Filipe Sales |

---

<div align="center">

*Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO).*

</div>
