

## Estrutura do Projeto

``` 
app/
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
├── MainActivity.kt
└── CountryApp.kt


```