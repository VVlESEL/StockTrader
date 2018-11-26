import com.ib.client.Contract
import com.ib.client.Order
import com.ib.client.OrderType
import com.ib.client.Types
import com.ib.controller.ApiController
import iex.Endpoints
import iex.IexApiController
import java.lang.Exception
import java.lang.StringBuilder
import java.util.ArrayList

object connectionHandler: ApiController.IConnectionHandler {
    override fun connected() {
        println("connected...")
    }

    override fun disconnected() {
        println("disconnected...")
    }

    override fun accountList(list: ArrayList<String>?) {
        println("account list:")
        println(list)
    }

    override fun error(e: Exception?) {
        e?.printStackTrace()
    }

    override fun message(id: Int, errorCode: Int, errorMsg: String?) {
        println(StringBuilder().append("id: ")
            .append(id)
            .append(" error code: ")
            .append(errorCode)
            .append(" error msg: ")
            .append(errorMsg))
    }

    override fun show(string: String?) {
        println("show:")
        println(string)
    }

}

fun main(args: Array<String>) {
    val inLogLambda = {inLog: String -> println(inLog)}
    val outLogLambda = {outLog: String -> println(outLog)}
    val controller = ApiController(connectionHandler, inLogLambda, outLogLambda)
    controller.connect("127.0.0.1",7497,0,null)

    val contract = Contract()
    contract.symbol("AAPL")
    contract.exchange("ARCA") //NYSE
    contract.secType(Types.SecType.STK)
    contract.currency("USD")

    val order = Order()
    order.orderId(1)
    order.action(Types.Action.BUY)
    order.orderType(OrderType.MKT)
    order.totalQuantity(100.0)
    order.account("DU1276521")
    order.clientId(0)

    controller.client().placeOrder(contract,order)

    controller.disconnect()
}

class Stock {
    var stockId: Int = 0
    var symbol: String = ""

    constructor(stockId: Int, symbol: String) {
        this.stockId = stockId
        this.symbol = symbol
    }

    fun createContract(symbol: String, exchange: String) {

    }
}

class OrderManagement : Thread() {

}

/*
fun main(args: Array<String>) {

    val apiController = IexApiController()
    val res = apiController.fetchData(Endpoints.SYMBOLS)

    val parser = Parser()
    val stringBuilder = StringBuilder(res)
    val jsonArr: JsonArray<String> = parser.parse(stringBuilder) as JsonArray<String>

    var counter = 0

    jsonArr.mapChildren { obj ->
        val builder = StringBuilder()
        builder.append("Symbol: ")
        builder.append(obj["symbol"])
        builder.append(", Name: ")
        builder.append(obj["name"])
        builder.append(", Date: ")
        builder.append(obj["date"])
        builder.append(", Enabled: ")
        builder.append(obj["isEnabled"])
        builder.append(", Type: ")
        builder.append(obj["type"])
        builder.append(", iexId: ")
        builder.append(obj["iexId"])

        if(obj["type"]!!.equals("cs")) counter++

        println(builder.toString())
    }

    println(jsonArr.size)
    println(counter)
}
//symbol,name,date,isEnabled,type,iexId
*/