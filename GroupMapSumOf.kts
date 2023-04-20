import java.time.Month

data class Data(val month: Month, val code: String, val amount: Double)

val dataList = listOf(
    Data(month = Month.JANUARY, code = "AAA", amount = 11.0),
    Data(month = Month.FEBRUARY, code = "AAA", amount = 50.0),
    Data(month = Month.MARCH, code = "BBB", amount = 3.0),
    Data(month = Month.MARCH, code = "CCC", amount = 100.0),
    Data(month = Month.APRIL, code = "CCC", amount = 25.0),
    Data(month = Month.APRIL, code = "CCC", amount = 25.0),
    Data(month = Month.APRIL, code = "DDD", amount = 300.0),
)

val groupedDataByMonthWithSum = dataList
    .groupBy { it.month }
    .mapValues { monthlyData ->
        monthlyData.value
            .groupBy { it.code }
            .mapValues {
                it.value.sumOf { data ->
                    data.amount
                }
            }
    }

println(groupedDataByMonthWithSum)

val maxByMonth = groupedDataByMonthWithSum.values.flatMap { it.values }.max()

println(maxByMonth)

val groupedDataWithSum = dataList
    .groupBy { it.code }
    .mapValues {
        it.value.sumOf { data ->
            data.amount
        }
    }

println(groupedDataWithSum)

val max = groupedDataWithSum.maxBy { it.value }

println(max)

val sortedDataByValue = groupedDataWithSum.entries.sortedBy { it.value }.asReversed()

println(sortedDataByValue)
