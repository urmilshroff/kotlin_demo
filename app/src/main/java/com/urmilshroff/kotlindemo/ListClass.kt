package com.urmilshroff.kotlindemo

class ListClass
{
    var title: String = ""
    var genre: String = ""
    var year: String = ""
    var image: Int = 0

    constructor() {}

    constructor(title: String, genre: String, year: String,image: Int) {
        this.title = title
        this.genre = genre
        this.year = year
        this.image = image
    }
}