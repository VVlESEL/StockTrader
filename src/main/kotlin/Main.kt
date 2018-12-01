import iex.IexApiController
import iex.Stock
import iex.Types
import javafx.application.Application
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.*

lateinit var stocks: List<Stock>

fun main(args: Array<String>) {

    val iexApiController = IexApiController()
    val symbols = iexApiController.getSP500Symbols()
    val types = listOf(Types.company.name,Types.quote.name)
    stocks = FXCollections.observableArrayList(iexApiController.getStocksList(symbols,types))

    Application.launch(HelloWorldApp::class.java, *args)
}

class HelloWorld : View() {

    override val root = tableview(stocks as ObservableList<Stock>) {
        readonlyColumn("Symbol", Stock::symbol)
        readonlyColumn("CEO", Stock::CEO)
        readonlyColumn("Company", Stock::companyName)
        readonlyColumn("PE Ratio", Stock::peRatio)
        columnResizePolicy = SmartResize.POLICY
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