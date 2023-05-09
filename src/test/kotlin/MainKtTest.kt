import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun comissionVkPay() {
        val transferOnMonth = 12_000
        val transfer = 16_000
        val cardOwnership = "VK Pay"

        val result = comission(transfer, transferOnMonth, cardOwnership)
        assertEquals(0, result)
    }
    @Test
    fun comissionMastercardNoLimit() {
        val transferOnMonth = 12_000
        val transfer = 16_000
        val cardOwnership = "Mastercard"

        val result = comission(transfer, transferOnMonth, cardOwnership)
        assertEquals(0, result)
    }
    @Test
    fun comissionMastercardLimit() {
        val transferOnMonth = 82_000
        val transfer = 16_000
        val cardOwnership = "Mastercard"

        val result = comission(transfer, transferOnMonth, cardOwnership)
        assertEquals(116, result)
    }@Test
    fun comissionVisaNoLimit() {
        val transferOnMonth = 12_000
        val transfer = 16_000
        val cardOwnership = "Visa"

        val result = comission(transfer, transferOnMonth, cardOwnership)
        assertEquals(120, result)
    }
    @Test
    fun comissionVisaLimit() {
        val transferOnMonth = 12_000
        val transfer = 3_000
        val cardOwnership = "Visa"

        val result = comission(transfer, transferOnMonth, cardOwnership)
        assertEquals(35, result)
    }
    //
    @Test
    fun comissionMaestroNoLimit() {
        val transferOnMonth = 12_000
        val transfer = 16_000
        val cardOwnership = "Maestro"

        val result = comission(transfer, transferOnMonth, cardOwnership)
        assertEquals(0, result)
    }
    @Test
    fun comissionMaestroLimit() {
        val transferOnMonth = 82_000
        val transfer = 16_000
        val cardOwnership = "Maestro"

        val result = comission(transfer, transferOnMonth, cardOwnership)
        assertEquals(116, result)
    }@Test
    fun comissionMirNoLimit() {
        val transferOnMonth = 12_000
        val transfer = 16_000
        val cardOwnership = "Mir"

        val result = comission(transfer, transferOnMonth, cardOwnership)
        assertEquals(120, result)
    }
    @Test
    fun comissionMirLimit() {
        val transferOnMonth = 12_000
        val transfer = 3_000
        val cardOwnership = "Mir"

        val result = comission(transfer, transferOnMonth, cardOwnership)
        assertEquals(35, result)
    }
    @Test
    fun limitsVkPayMore() {
        val transferOnMonth = 52_000
        val transferDaily = 14_000
        val transfer = 16_000
        val cardOwnership = "VK Pay"

        val result = limits(transfer, transferDaily, transferOnMonth, cardOwnership)
        assertEquals(false, result)
    }
    @Test
    fun limitsVkPayMonthMore() {
        val transferOnMonth = 52_000
        val transferDaily = 14_000
        val transfer = 12_000
        val cardOwnership = "VK Pay"

        val result = limits(transfer, transferDaily, transferOnMonth, cardOwnership)
        assertEquals(false, result)
    }
    @Test
    fun limitsVkPayTransferMore() {
        val transferOnMonth = 12_000
        val transferDaily = 14_000
        val transfer = 16_000
        val cardOwnership = "VK Pay"

        val result = limits(transfer, transferDaily, transferOnMonth, cardOwnership)
        assertEquals(false, result)
    }
    @Test
    fun limitsVkPayLess() {
        val transferOnMonth = 12_000
        val transferDaily = 14_000
        val transfer = 14_000
        val cardOwnership = "VK Pay"

        val result = limits(transfer, transferDaily, transferOnMonth, cardOwnership)
        assertEquals(true, result)
    }
    @Test
    fun limitsOtherTransferMore() {
        val transferOnMonth = 20_000
        val transferDaily = 14_000
        val transfer = 160_000
        val cardOwnership = "Mir"

        val result = limits(transfer, transferDaily, transferOnMonth, cardOwnership)
        assertEquals(false, result)
    }
    @Test
    fun limitsOtherMonthMore() {
        val transferOnMonth = 620_000
        val transferDaily = 14_000
        val transfer = 40_000
        val cardOwnership = "Mir"

        val result = limits(transfer, transferDaily, transferOnMonth, cardOwnership)
        assertEquals(false, result)
    }
    @Test
    fun limitsOtherLess() {
        val transferOnMonth = 12_000
        val transferDaily = 14_000
        val transfer = 14_000
        val cardOwnership = "Mir"

        val result = limits(transfer, transferDaily, transferOnMonth, cardOwnership)
        assertEquals(true, result)
    }
}