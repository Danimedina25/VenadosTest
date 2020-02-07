package com.example.equipo.venadostest.Models.Models.games

class Games {

    var local:Boolean?=null
    var opponent:String?=null
    var opponent_image:String?=null
    var datetime:String?=null
    var league:String?=null
    var image:String?=null
    var home_score:Int?=null
    var away_score:Int?=null

    fun getOpponents(): String {
        return opponent.toString()
    }

    fun setOpponents(opponent:String) {
        this.opponent = opponent
    }
}