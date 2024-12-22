# CountryApp

## Visão Geral

Este aplicativo Android, construído com Jetpack Compose, busca e exibe informações sobre países da API REST Countries. Os usuários podem navegar por uma lista de países, pesquisar por países específicos e visualizar informações detalhadas sobre cada país, incluindo sua bandeira, brasão, capital, região, população e muito mais.

## Funcionalidades

*   **Lista de Países:** Exibe uma lista de países obtidos da API REST Countries.
*   **Funcionalidade de Pesquisa:** Permite aos usuários pesquisar países por nome.
*   **Visualização Detalhada do País:** Fornece informações detalhadas sobre um país selecionado, incluindo seu nome oficial, capital, região, sub-região, população, área, bandeira e brasão.
*   **Navegação:** Usa o Jetpack Compose Navigation para navegação perfeita entre as telas.
*   **Interface de Usuário Moderna:** Construído com Jetpack Compose para uma interface de usuário moderna e responsiva.
*   **Injeção de Dependência:** Usa Hilt para injeção de dependência.
*   **Carregamento de Imagem:** Usa Coil para carregamento assíncrono de imagens.

## Tecnologias Utilizadas

*   **Kotlin:** Linguagem de programação.
*   **Jetpack Compose:** Kit de ferramentas de interface do usuário.
*   **REST Countries API:** Fonte de dados.
*   **Retrofit:** Cliente HTTP para comunicação com a API.
*   **Hilt:** Biblioteca de injeção de dependência.
*   **Coil:** Biblioteca de carregamento de imagens.
*   **Coroutines:** Programação assíncrona.
*   **Gson:** Serialização/desserialização JSON.


## Arquitetura

O projeto segue a arquitetura Model-View-ViewModel (MVVM).

*   **Model:** Classes de dados representando informações do país (`Country`).
*   **View:** Composables representando a interface do usuário (`CountryListScreen`, `CountryDetailsScreen`, `CountryCard`, `SearchBar`).
*   **ViewModel:** `CountryViewModel` lida com a busca de dados, pesquisa e gerenciamento de estado.
*   **Repository:** `CountryRepository` interage com o `CountryService` para buscar dados da API.
*   **Service:** `CountryService` usa Retrofit para fazer chamadas de API.
*   **DI:** Módulos Hilt gerenciam dependências.

## Estrutura do Projeto

``` 
app/
├── application
│   └── CountryApp.kt
├── data/
│   ├── api/        # Camada de acesso à API (Retrofit)
│   │   ├── CountryApi.kt
│   │   └── CountryService.kt
│   ├── model/      # Modelos de dados
│   │   └── Country.kt
│   ├── repository/ # Repositório para acessar os dados
│   │   └── CountryRepository.kt
│   └── di/         # Módulos Hilt para injeção de dependências
│       └── AppModule.kt
├── ui/
│   ├── theme/      # Tema do Compose
│   │   ├── Color.kt
│   │   ├── Shape.kt
│   │   ├── Theme.kt
│   │   └── Type.kt
│   ├── view/       # Composable functions (telas e componentes)
│   │   ├── CountryDetailsScreen.kt
│   │   ├── CountryListScreen.kt
│   │   └── components/
│   │       ├── CountryCard.kt
│   │       └── SearchBar.kt
│   └── viewmodel/  # ViewModels
│       └── CountryViewModel.kt
└── MainActivity.kt
```

## Instalação

Para instalar o projeto, siga os seguintes passos:
- Instale o [Android Studio](https://developer.android.com/studio) versão Koala
- Api Do SDK do Android 35 

1.  Clone o repositório: `git clone https://github.com/MizaelDouglasDeMello/Country-App`
2.  Abra o projeto no Android Studio.
3.  Compile e execute o aplicativo.
