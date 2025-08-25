package com.depi.mvpex.model

import com.depi.mvpex.model.domain.Wisdom

class FakeApiService {
    private val wisdomsList = listOf<Wisdom>(
        Wisdom("أن تشعل شمعة خير من أن تلعن الظلام", "2021/7/22"),
        Wisdom("ابتسم تبتسم لك الدنيا", "2021/7/18"),
        Wisdom("إن الله لا يغير ما بقوم حتى يغيروا ما بأنفسهم", "2021/7/12"),
        Wisdom("العقل زينة", "2021/7/7"),
        Wisdom("الصديق وقت الضيق", "2021/7/1"),
        Wisdom("الوقت كالسيف إن لم تقطعه قطعك", "2021/6/28"),
        Wisdom("العقل السليم في الجسم السليم", "2021/6/20"),
        Wisdom("من جد وجد ومن زرع حصد", "2021/6/15")
    )

    fun getRandomWisdom(): Wisdom {
        val random = (Math.random() * wisdomsList.size).toInt()
        return wisdomsList[random]
    }
}