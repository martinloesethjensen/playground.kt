data class Data(val code: String, val amount: Double)

val dataList = listOf(
    Data(code = "AAA", amount = 11.0),
    Data(code = "AAA", amount = 50.0),
    Data(code = "BBB", amount = 3.0),
    Data(code = "CCC", amount = 100.0),
    Data(code = "CCC", amount = 25.0),
)

val groupedDataWithSum = dataList
    .groupBy { it.code }
    .mapValues {
        it.value.sumOf { species ->
            species.amount
        }
    }

println(groupedDataWithSum.toString())

val max = groupedDataWithSum.maxBy { it.value }

println(max.toString())

val sortedDataByValue = groupedDataWithSum.entries.sortedBy { it.value }.asReversed()

println(sortedDataByValue.toString())
