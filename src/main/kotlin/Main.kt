import kotlin.math.roundToInt

fun main() {
    val transferOnMonth = 12_000
    val transferDaily = 14_000
    val transfer = 14_000
    val cardOwnership = "Mir"

    if (limits(transfer, transferDaily, transferOnMonth, cardOwnership)) {
        println(
            """Карта: $cardOwnership 
        |Переведено сегодня: $transferDaily
        |Переведено в этом месяце: $transferOnMonth
        |Сумма перевода: $transfer
        |Комиссия за перевод составит: ${comission(transfer, transferOnMonth, cardOwnership)}
        |Сумма перевода с комиссией: ${
                transfer + comission(transfer, transferOnMonth, cardOwnership)
            }""".trimMargin()
        )
    } else {
        println("Вы не сможете выполнить перевод, т.к. превышены лимиты")
    }
}

fun comission(transfer: Int, transferOnMonth: Int, cardOwnership: String): Int {

    return when (cardOwnership) {
        "Mastercard", "Maestro" -> if (transferOnMonth < 75000) {
            0
        } else {
            (transfer * 0.006 + 20).roundToInt()
        }
        "Visa", "Mir" -> if (transfer * 0.0075 < 35) {
            35
        } else {
            (transfer * 0.0075).roundToInt()
        }
        else -> 0
    }
}

fun limits(transfer: Int, transferDaily: Int, transferOnMonth: Int, cardOwnership: String): Boolean {

    if (cardOwnership == "VK Pay") {
        return (transfer < 15_000 && transferOnMonth + transfer < 40_000)
    } else {
        return (transferDaily + transfer < 150_000 && transferOnMonth + transfer < 600_000)
    }
}