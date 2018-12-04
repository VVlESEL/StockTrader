import iex.IexApiController
import iex.Stock
import iex.Types
import javafx.application.Application
import javafx.collections.ObservableList
import javafx.scene.control.TabPane
import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import tornadofx.*

lateinit var stocks: List<Stock>

fun main(args: Array<String>) {

    val iexApiController = IexApiController()
    val symbols = iexApiController.getSP500Symbols()//.subList(0,20)
    val types = listOf(Types.company.name,Types.quote.name,Types.stats.name)
    stocks = iexApiController.getStocksList(symbols,types)

    println("size: ${stocks.size}")
/*
    stocks = stocks.filter { stock -> stock.peRatio > 0.0 && stock.peRatio < 15.0 &&
                                    stock.year5ChangePercent > 0.5}
*/
    println("size: ${stocks.size}")

    stocks = stocks.observable()

    Application.launch(HelloWorldApp::class.java, *args)
}

class HelloWorld : View() {

    override val root = vbox {

        val tabPane = tabpane {
            tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE

            tab("Company")
            tab("Stats")
            tab("Quote")
        }

        val longFormatter: TableCell<Stock, Long>.(Long) -> Unit = { value ->
            this.text = String.format("%,d",value)
        }

        val doubleFormatter: TableCell<Stock, Double>.(Double) -> Unit = { value ->
            this.text = String.format("%.2f%%",value)
        }

        val doubleFormatterColor: TableCell<Stock, Double>.(Double) -> Unit = { value ->
            this.text = String.format("%.2f%%",value*100)
            this.style {
                textFill = if(value > 0) Color.GREEN else Color.RED
            }
        }

        val columnsCompany: ArrayList<TableColumn<Stock, Any?>> = ArrayList()
        val columnsStats: ArrayList<TableColumn<Stock, Any?>> = ArrayList()
        val columnsQuote: ArrayList<TableColumn<Stock, Any?>> = ArrayList()

        @Suppress("UNCHECKED_CAST")
        tableview(stocks as ObservableList<Stock>) {
            vgrow = Priority.ALWAYS

            readonlyColumn("Symbol", Stock::symbol)
            readonlyColumn("Company", Stock::companyName)

            /** Compnay 2 - 8 */
            columnsCompany.add(readonlyColumn("CEO", Stock::CEO))
            columnsCompany.add(readonlyColumn("Sector", Stock::sector))
            columnsCompany.add(readonlyColumn("Industry", Stock::industry))
            columnsCompany.add(readonlyColumn("Website", Stock::website))
            columnsCompany.add(readonlyColumn("Exchange", Stock::exchange))
            columnsCompany.add(readonlyColumn("Description", Stock::description))
            //readonlyColumn("Tags", Stock::tags)

            /** Stats 10 - 56 */
            columnsStats.add(readonlyColumn("Market Cap", Stock::marketCap))
            (columnsStats.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsStats.add(readonlyColumn("Beta", Stock::beta))
            columnsStats.add(readonlyColumn("W52 High", Stock::week52High))
            columnsStats.add(readonlyColumn("W52 Low", Stock::week52Low))
            columnsStats.add(readonlyColumn("W52 Change", Stock::week52change))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatter)
            columnsStats.add(readonlyColumn("Dividend Rate", Stock::dividendRate))
            columnsStats.add(readonlyColumn("Dividend Yield", Stock::dividendYield))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatter)
            columnsStats.add(readonlyColumn("Latest EPS", Stock::latestEPS))
            columnsStats.add(readonlyColumn("Latest EPS Date", Stock::latestEPSDate))
            columnsStats.add(readonlyColumn("Shares Outstanding", Stock::sharesOutstanding))
            (columnsStats.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsStats.add(readonlyColumn("Float", Stock::float))
            (columnsStats.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsStats.add(readonlyColumn("Return On Equity", Stock::returnOnEquity))
            columnsStats.add(readonlyColumn("Consensus EPS", Stock::consensusEPS))
            columnsStats.add(readonlyColumn("EPS Surprise Percent", Stock::EPSSurprisePercent))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatter)
            columnsStats.add(readonlyColumn("EBITDA", Stock::EBITDA))
            (columnsStats.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsStats.add(readonlyColumn("Revenue", Stock::revenue))
            (columnsStats.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsStats.add(readonlyColumn("Gross Profit", Stock::grossProfit))
            (columnsStats.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsStats.add(readonlyColumn("Cash", Stock::cash))
            (columnsStats.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsStats.add(readonlyColumn("Debt", Stock::debt))
            (columnsStats.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsStats.add(readonlyColumn("TTM EPS", Stock::ttmEPS))
            columnsStats.add(readonlyColumn("Revenue per Share", Stock::revenuePerShare))
            columnsStats.add(readonlyColumn("Revenue per Employee", Stock::revenuePerEmployee))
            columnsStats.add(readonlyColumn("PE Ratio High", Stock::peRatioHigh))
            columnsStats.add(readonlyColumn("PE Ratio Low", Stock::peRatioLow))
            columnsStats.add(readonlyColumn("Return on Assets", Stock::returnOnAssets))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatter)
            //readonlyColumn("Return on Capital", Stock::returnOnCapital)
            columnsStats.add(readonlyColumn("Profit Margin", Stock::profitMargin))
            columnsStats.add(readonlyColumn("Price to Sales", Stock::priceToSales))
            columnsStats.add(readonlyColumn("Price to Book", Stock::priceToBook))
            columnsStats.add(readonlyColumn("Day 200 Moving Average", Stock::day200MovingAvg))
            columnsStats.add(readonlyColumn("Day 50 Moving Average", Stock::day50MovingAvg))
            columnsStats.add(readonlyColumn("Institution Percent", Stock::institutionPercent))
            columnsStats.add(readonlyColumn("Insider Percent", Stock::insiderPercent))
            columnsStats.add(readonlyColumn("Short Ratio", Stock::shortRatio))
            columnsStats.add(readonlyColumn("5Y Change", Stock::year5ChangePercent))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            columnsStats.add(readonlyColumn("2Y Change", Stock::year2ChangePercent))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            columnsStats.add(readonlyColumn("1YChange", Stock::year1ChangePercent))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            columnsStats.add(readonlyColumn("ytd Change", Stock::ytdChange))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            columnsStats.add(readonlyColumn("6M Change", Stock::month6ChangePercent))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            columnsStats.add(readonlyColumn("3M Change", Stock::month3ChangePercent))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            columnsStats.add(readonlyColumn("1M Change", Stock::month1ChangePercent))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            columnsStats.add(readonlyColumn("5D Change", Stock::day5ChangePercent))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            columnsStats.add(readonlyColumn("30D Change", Stock::day30ChangePercent))
            (columnsStats.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)

            /** Quote */
            //readonlyColumn("Calculation Price", Stock::calculationPrice)
            columnsQuote.add(readonlyColumn("Open", Stock::open))
            //readonlyColumn("Open Time", Stock::openTime)
            columnsQuote.add(readonlyColumn("Close", Stock::close))
            //readonlyColumn("Close Time", Stock::closeTime)
            columnsQuote.add(readonlyColumn("High", Stock::high))
            columnsQuote.add(readonlyColumn("Low", Stock::low))
            columnsQuote.add(readonlyColumn("Latest Price", Stock::latestPrice))
            //readonlyColumn("Latest Source", Stock::latestSource)
            columnsQuote.add(readonlyColumn("Latest Time", Stock::latestTime))
            //readonlyColumn("Latest Update", Stock::latestUpdate)
            columnsQuote.add(readonlyColumn("Latest Volume", Stock::latestVolume))
            columnsQuote.add(readonlyColumn("Delayed Price", Stock::delayedPrice))
            //readonlyColumn("Delayed Price Time", Stock::delayedPriceTime)
            columnsQuote.add(readonlyColumn("Extended Price", Stock::extendedPrice))
            columnsQuote.add(readonlyColumn("Extended Change", Stock::extendedChange))
            columnsQuote.add(readonlyColumn("Extended Change Percent", Stock::extendedChangePercent))
            (columnsQuote.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            //readonlyColumn("Extended Price Time", Stock::extendedPriceTime)
            columnsQuote.add(readonlyColumn("Previous Close", Stock::previousClose))
            columnsQuote.add(readonlyColumn("Change", Stock::change))
            columnsQuote.add(readonlyColumn("Change Percent", Stock::changePercent))
            (columnsQuote.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)
            columnsQuote.add(readonlyColumn("AVG Total Volume", Stock::avgTotalVolume))
            (columnsQuote.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsQuote.add(readonlyColumn("Market Cap", Stock::marketCap))
            (columnsQuote.last() as TableColumn<Stock, Long>).cellFormat(longFormatter)
            columnsQuote.add(readonlyColumn("PE Ratio", Stock::peRatio))
            columnsQuote.add(readonlyColumn("W52 High", Stock::week52High))
            columnsQuote.add(readonlyColumn("W52 Low", Stock::week52Low))
            columnsQuote.add(readonlyColumn("ytd Change", Stock::ytdChange))
            (columnsQuote.last() as TableColumn<Stock, Double>).cellFormat(doubleFormatterColor)

            //columnResizePolicy = SmartResize.POLICY
        }

        tabPane.selectionModel.selectedItemProperty().addListener { _, _, t2 ->
            when(t2.text) {
                "Company" -> {
                    columnsCompany.forEach { it.isVisible = true }
                    columnsStats.forEach { it.isVisible = false }
                    columnsQuote.forEach { it.isVisible = false }
                }
                "Stats" -> {
                    columnsCompany.forEach { it.isVisible = false }
                    columnsStats.forEach { it.isVisible = true }
                    columnsQuote.forEach { it.isVisible = false }
                }
                "Quote" -> {
                    columnsCompany.forEach { it.isVisible = false }
                    columnsStats.forEach { it.isVisible = false }
                    columnsQuote.forEach { it.isVisible = true }
                }
            }
        }

        columnsStats.forEach { it.isVisible = false }
        columnsQuote.forEach { it.isVisible = false }
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