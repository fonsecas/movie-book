package com.example.moviebook.domain.interector

import com.example.moviebook.domain.boundary.MovieRepository
import com.example.moviebook.domain.entity.MoviesList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
internal class GetMovieListTest {

    @Mock
    private lateinit var interector: IGetMovieList

    @Mock
    private lateinit var mockedUserRepository: MovieRepository

    @Mock
    private lateinit var mockMovieList: MoviesList

    @Before
    fun start() {
        interector = GetMovieList(mockedUserRepository)
    }

    //  |  Casos |                     Descrição                                              |
    //  |:-------|:---------------------------------------------------------------------------|
    //  | Caso 1 |   Dado um usuário acessando a listagem de filmes                           |
    //  |        |   Quando ele solicitar pelos filmes                                        |
    //  |        |   Então devemos assegurar que a listagem obtida pela chamada será igual a  |
    //  |        |   retornada pelo repositório                                               |

    @Test
    fun case1() {
        runBlocking {
            `when`(mockedUserRepository.getMovieList()).thenReturn(mockMovieList)

            val currentSUT = interector.getMovieList()

            assert(currentSUT == mockMovieList)
        }
    }

    //  |  Casos |                     Descrição                                              |
    //  |:-------|:---------------------------------------------------------------------------|
    //  | Caso 2 |   Dado um usuário acessando a listagem de filmes                           |
    //  |        |   Quando ele solicitar pelos filmes                                      |
    //  |        |   Então devemos assegurar que o repositorio sera chamado                   |

    @Test
    fun case2() {
        runBlocking {
            interector.getMovieList()
            verify(mockedUserRepository).getMovieList()
        }
    }
}