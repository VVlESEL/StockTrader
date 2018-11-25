import iex.Endpoints
import iex.IexApiController

fun main(args: Array<String>) {

    val apiController = IexApiController()
    val res = apiController.fetchData(Endpoints.SYMBOLS)

    println(res)
}