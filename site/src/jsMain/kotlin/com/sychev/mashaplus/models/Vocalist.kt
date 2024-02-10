package com.sychev.mashaplus.models

import com.sychev.mashaplus.utils.Resources

data class Vocalist(
    val name: String = "",
    val imgRes: String,
)

val vokalistkyList = listOf(
    Vocalist(Resources.Strings.liza_ionovoa, Resources.Images.liza_vok),
    Vocalist(Resources.Strings.yla, Resources.Images.yla_vok),
    Vocalist(Resources.Strings.ula_lank, Resources.Images.ula_vok),
    Vocalist(Resources.Strings.natalya_molodojen, Resources.Images.natalya_vok),
    Vocalist(Resources.Strings.milana, Resources.Images.milana_vok),
    Vocalist(Resources.Strings.elena, Resources.Images.elena_vok),
    Vocalist(Resources.Strings.dora, Resources.Images.dora_vok),
    Vocalist(Resources.Strings.alya, Resources.Images.alya_vok),
    Vocalist(Resources.Strings.alina_viera, Resources.Images.alina_vok),
    Vocalist(Resources.Strings.jia, Resources.Images.djia_vok),
)
val vokalistyList = listOf(
    Vocalist(Resources.Strings.andrey, Resources.Images.andrey_vok),
    Vocalist(Resources.Strings.ilya, Resources.Images.ilya_vok),
    Vocalist(Resources.Strings.ilya_star, Resources.Images.ilay_star_vok),
    Vocalist(Resources.Strings.marat, Resources.Images.marat_vok),
)

@Deprecated("old design")
fun getMaleVocalists() = listOf(
    Vocalist(
        name = "Андрей Махо",
        imgRes = "/andrey_maho.png"
    ),
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
)

@Deprecated("old design")
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

@Deprecated("old design")
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