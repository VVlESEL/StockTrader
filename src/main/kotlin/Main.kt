import iex.IexApiController
import iex.Stock
import iex.Types
import javafx.application.Application
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.paint.Color
import tornadofx.*

lateinit var stocks: List<Stock>

fun main(args: Array<String>) {

    val iexApiController = IexApiController()
    val symbols = iexApiController.getSP500Symbols()//.subList(0,20)
    val types = listOf(Types.company.name,Types.quote.name,Types.stats.name)
    stocks = FXCollections.observableArrayList(iexApiController.getStocksList(symbols,types))

    Application.launch(HelloWorldApp::class.java, *args)
}

class HelloWorld : View() {

    override val root = tableview(stocks as ObservableList<Stock>) {
        readonlyColumn("Symbol", Stock::symbol)
        readonlyColumn("Company", Stock::companyName)
        readonlyColumn("PE Ratio", Stock::peRatio)
        readonlyColumn("Profit Margin", Stock::profitMargin)
        readonlyColumn("Return on Equity", Stock::returnOnEquity)
        readonlyColumn("6 Month Change", Stock::month6ChangePercent).cellFormat {
            text = String.format("%.2f%%",it*100)
            style {
                textFill = if(it > 0) Color.GREEN else Color.RED
            }
        }
        readonlyColumn("1 Year Change", Stock::year1ChangePercent).cellFormat {
            text = String.format("%.2f%%",it*100)
            style {
                textFill = if(it > 0) Color.GREEN else Color.RED
            }
        }
        columnResizePolicy = SmartResize.POLICY
    }

    init {
        with(root) {
            prefHeight = 500.0
            prefWidth = 1000.0
        }
    }
}

class HelloWorldApp : App(HelloWorld::class, Styles::class)

class Styles : Stylesheet() {
    init {
        label {
            fontSize = 20.px
        }
    }
}