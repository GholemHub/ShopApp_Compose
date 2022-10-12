package com.gholem.shopapp.repository.network.api

class MovieModel {

    var page: Int = 0
    var total_results: Int = 0
    var total_pages: Int = 0
    var results: List<ResultsEntity>? = null

    class ResultsEntity {

        var vote_count: Int = 0
        var id: Int = 0
        var isVideo: Boolean = false
        var vote_average: Double = 0.toDouble()
        var title: String? = null
        var popularity: Double = 0.toDouble()
        var poster_path: String? = null
        var original_language: String? = null
        var original_title: String? = null
        var backdrop_path: String? = null
        var isAdult: Boolean = false
        var overview: String? = null
        var release_date: String? = null
        var genre_ids: List<Int>? = null
    }
}