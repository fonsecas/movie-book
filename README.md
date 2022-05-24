![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/iuricode/README-template?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/iuricode/README-template?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/iuricode/README-template?style=for-the-badge)

# Problematica:

 - Consumir uma api de filmes, para atravez de um app, trazer um catalogo de filmes e seus detalhes,
trazendo assim uma informação basica sobre algum filme.

# Soluções Apresentadas:

- Projeto estruturado aplicando o conceito de camadas do Clean Architecture (Data, Domain e Presentation)
- Aplicação da arquitetura MVVM na camada presentation
- Utilização do Jetpack Components (View Model, Data Binding, Lifecycle, LiveData)
- Ultilização do Koin para injeção de dependencia
- Consumindo a API do TMDB usando Retrofit
- ### Testes
    - Testes unitários na camada de presentation, domain e data. Na camada da presentation os
       testes foram realizados na ViewModel visando garantir que os sinais disparados eram iguais aos esperados.
    - Já na camada de domain, os testes foram feitos nos interactors. Essa escolha foi motivada pelo fato deles 
       representarem a regra de negócio da aplicação.
    - E por último, na camada do data, os testes foram feitos nos mappers e nos repositorys.


# Tecnologias e Conceitos Ultilizadas:

- Clean Architecture
- MVVM
- Jetpack Components
- Retrofit
- TMDB API
- Koin
- Mockito
- Glide

# Funcionalidades:

- Compartilhar filme com amigos
- Assitir o Trailer de um filme
- Ver informação completa de um filme no TMDB

# Prints

| Catalogo de Filmes  | Detalhe do Filme  |
| ------------------- | ------------------- |
|  ![Screenshot_20220520-155912](https://user-images.githubusercontent.com/2872913/169603151-3b097750-f553-41a0-bf5f-b7832169ade8.png) |  ![Screenshot_20220520-155927](https://user-images.githubusercontent.com/2872913/169603172-d273a46a-c7d8-415b-a9db-2d474f419c04.png)
 |

