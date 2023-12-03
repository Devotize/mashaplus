package com.sychev.mashaplus.models

data class Vocalist(
    val name: String = "",
    val imgRes: String,
)

fun getMaleVocalists() = listOf(
    Vocalist(
        name = "Дима Сэ",
        imgRes = "/dima_se.png"
    ),
    Vocalist(
        name = "Илья Окулов",
        imgRes = "/ilya_okulov.png"
    ),
    Vocalist(
        name = "Саша Ростов",
        imgRes = "/sasha_rostov.png"
    ),
    Vocalist(
        name = "Андрей Махо",
        imgRes = "/andrey_maho.png"
    ),
)

fun getFemaleVocalists() = listOf(
    Vocalist(
        name = "Аля",
        imgRes = "/alya.png"
    ),
    Vocalist(
        name = "Юлия Ланк",
        imgRes = "/uliya.png"
    ),
    Vocalist(
        name = "Дора",
        imgRes = "/dora.png"
    ),
    Vocalist(
        name = "Лиза Ионова",
        imgRes = "/liza_ionova.png"
    ),
    Vocalist(
        name = "Джия",
        imgRes = "/djiya.png"
    ),
    Vocalist(
        name = "Алина Виера",
        imgRes = "/alina_viyera.png"
    ),
    Vocalist(
        name = "Наталья Молодожен",
        imgRes = "/natasha.png"
    ),
    Vocalist(
        name = "Милана",
        imgRes = "/milana.png"
    ),
    Vocalist(
        name = "Ула",
        imgRes = "/ula.png"
    ),
    Vocalist(
        name = "Адель",
        imgRes = "/adel.png"
    ),
    Vocalist(
        name = "Елена",
        imgRes = "/elena.png"
    ),
)

fun getVocalistsCouples() = listOf(
    Vocalist(
        imgRes = "/alina_ilya.png"
    ),
    Vocalist(
        imgRes = "/dima_lena.png"
    ),
    Vocalist(
        imgRes = "/two_pretty_gr.png"
    ),
    Vocalist(
        imgRes = "/adnrusha_plus_one.png"
    ),
    Vocalist(
        imgRes = "/ulia_sasha.png"
    ),
    Vocalist(
        imgRes = "/sasha_alya.png"
    ),
)