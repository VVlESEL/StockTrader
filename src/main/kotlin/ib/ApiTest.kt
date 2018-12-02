package ib

import com.ib.client.*
import com.ib.contracts.StkContract
import com.ib.controller.ApiController
import java.lang.Exception
import java.lang.StringBuilder
import java.util.ArrayList

fun main(args: Array<String>) {
    val inLogLambda = {inLog: String -> println(inLog)}
    val outLogLambda = {outLog: String -> println(outLog)}
    val controller = ApiController(ConnectionHandler, inLogLambda, outLogLambda)

    controller.connect("127.0.0.1",7497,0,null)

    for(i in 1..5) {
        if(ConnectionHandler.isConnected) break
        println("waiting for connection...")
        Thread.sleep(500)
    }
    if(!ConnectionHandler.isConnected){
        println("unable to establish a connection...")
        return
    }

    val contract = StkContract("AAPL")

    val order = Order()
    order.action(Types.Action.BUY)
    order.orderType(OrderType.MKT)
    order.totalQuantity(1.0)
    order.account("DU1276521")
    order.clientId(0)

    controller.placeOrModifyOrder(contract, order, OrderHandler)

    controller.disconnect()
}

object ConnectionHandler: ApiController.IConnectionHandler {
    var isConnected = false;

    override fun connected() {
        isConnected = true;
        println("connected...")
    }

    override fun disconnected() {
        isConnected = false;
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
        println(StringBuilder()
            .append("id: ")
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

object OrderHandler: ApiController.IOrderHandler{
    override fun orderState(orderState: OrderState?) {
        println(orderState?.status)
    }

    override fun orderStatus(
        status: OrderStatus?,
        filled: Double,
        remaining: Double,
        avgFillPrice: Double,
        permId: Long,
        parentId: Int,
        lastFillPrice: Double,
        clientId: Int,
        whyHeld: String?
    ) {
        println(StringBuilder().append("status: ").append(status?.toString()))
        println(StringBuilder().append("filled: ").append(filled))
        println(StringBuilder().append("remaining: ").append(remaining))
        println(StringBuilder().append("avgFillPrice: ").append(avgFillPrice))
        println(StringBuilder().append("permId: ").append(permId))
        println(StringBuilder().append("parentId: ").append(parentId))
        println(StringBuilder().append("lastFillPrice: ").append(lastFillPrice))
        println(StringBuilder().append("clientId: ").append(clientId))
        println(StringBuilder().append("whyHeld: ").append(whyHeld))
    }

    override fun handle(errorCode: Int, errorMsg: String?) {
        println(StringBuilder()
            .append("errorCode: ").append(errorCode)
            .append("errorMsg: ").append(errorMsg))
    }
}