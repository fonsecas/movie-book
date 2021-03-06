package com.example.moviebook.src

import com.example.moviebook.data.entity.ApiMovie
import com.example.moviebook.domain.entity.Movie
import com.example.moviebook.domain.entity.MoviesList

val listGender: List<Int> = listOf(1, 2)
val movieListMock: List<Movie> = listOf(
    Movie(
        false,
        "/egoyMDLqCxzjnSrWOz50uLlJWmD.jpg",
        listGender,
        1,
        "en",
        "Sonic the Hedgehog 2",
        "After settling in Green Hills, Sonic is eager to prove he has what it takes to be a true hero. His test comes when Dr. Robotnik returns, this time with a new partner, Knuckles, in search for an emerald that has the power to destroy civilizations. Sonic teams up with his own sidekick, Tails, and together they embark on a globe-trotting journey to find the emerald before it falls into the wrong hands.",
        6852.303,
        "/6DrHO1jr3qVrViUO6s6kFiAGM7.jpg",
        "2022-03-30",
        "Sonic the Hedgehog 2",
        false,
        7.8,
        1450,

        )
)

val apiMovieListMock: List<ApiMovie> = listOf(
    ApiMovie(
        6852.303,
        1450,
        false,
        "/6DrHO1jr3qVrViUO6s6kFiAGM7.jpg",
        1,
        false,
        "/egoyMDLqCxzjnSrWOz50uLlJWmD.jpg",
        "en",
        "Sonic the Hedgehog 2",
        listGender,
        "Sonic the Hedgehog 2",
        7.8,
        "After settling in Green Hills, Sonic is eager to prove he has what it takes to be a true hero. His test comes when Dr. Robotnik returns, this time with a new partner, Knuckles, in search for an emerald that has the power to destroy civilizations. Sonic teams up with his own sidekick, Tails, and together they embark on a globe-trotting journey to find the emerald before it falls into the wrong hands.",
        "2022-03-30",

        )
)

val movieList: MoviesList = MoviesList(
    1,
    listOf(
        Movie(
            false,
            "/egoyMDLqCxzjnSrWOz50uLlJWmD.jpg",
            listGender,
            1,
            "en",
            "Sonic the Hedgehog 2",
            "After settling in Green Hills, Sonic is eager to prove he has what it takes to be a true hero. His test comes when Dr. Robotnik returns, this time with a new partner, Knuckles, in search for an emerald that has the power to destroy civilizations. Sonic teams up with his own sidekick, Tails, and together they embark on a globe-trotting journey to find the emerald before it falls into the wrong hands.",
            6852.303,
            "/6DrHO1jr3qVrViUO6s6kFiAGM7.jpg",
            "2022-03-30",
            "Sonic the Hedgehog 2",
            false,
            7.8,
            1450,

            )
    ),
    2,
    3
)

