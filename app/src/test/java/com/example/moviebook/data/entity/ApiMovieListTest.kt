package com.example.moviebook.data.entity

import com.example.moviebook.domain.entity.MoviesList
import com.example.moviebook.src.apiMovieListMock
import com.example.moviebook.src.movieListMock
import org.junit.Test

internal class ApiMovieListTest {

    //  |  Casos |                     Descrição                                              |
    //  |:-------|:---------------------------------------------------------------------------|
    //  | Caso 1 |   Dado uma classe MoviesList da camada de data                                   |
    //  |        |   Quando mapearmos ela para o seu correspondente na camada de domain       |
    //  |        |   Entao devemos assegurar que o objeto resultado é o esperado              |

    @Test
    fun case1() {
        val expectedSUT = MoviesList(
            page = 1,
            results = movieListMock,
            totalPages = 1,
            totalResults = 2

        )
        val currentSUT = ApiMoviesList(
            page = 1,
            movies = apiMovieListMock,
            totalPages = 1,
            totalResults = 2
        ).toDomainObject()

        assert(expectedSUT == currentSUT)
    }
}