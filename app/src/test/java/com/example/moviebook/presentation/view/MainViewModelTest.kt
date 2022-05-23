package com.example.moviebook.presentation.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.moviebook.domain.CoroutinesTestRule
import com.example.moviebook.domain.entity.Movie
import com.example.moviebook.domain.interector.GetMovieList
import com.example.moviebook.domain.interector.IGetMovieList
import com.example.moviebook.presentation.view.home.MainViewModel
import com.example.moviebook.src.movieList
import com.example.moviebook.src.movieListMock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
internal class MainViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val testCoroutineRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var interector: IGetMovieList

    @Mock
    private lateinit var viewStateObserver: Observer<List<Movie?>?>

    @Before
    fun start() {
        viewModel = MainViewModel(
            interector
        ).apply {
            users.observeForever(viewStateObserver)
        }
    }


    //  |  Casos |                     Descrição                                              |
    //  |:-------|:---------------------------------------------------------------------------|
    //  | Caso 3 |   Dado um usuário acessando a listagem de usuários                         |
    //  |        |   Quando ele solicitar pelos usuários                                      |
    //  |        |   Então devemos assegurar que o sinal disparado é igual ao esperado        |

    @Test
    fun case3() {
        runBlocking {

            `when`(interector.getMovieList()).thenReturn(movieList)

            viewModel.getMovieList()

            verify(viewStateObserver).onChanged(movieListMock)
        }
    }

}