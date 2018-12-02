package iex

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject

data class Stock(/**Company*/
                 val symbol: String = "",
                 val companyName: String = "",
                 val exchange: String = "",
                 val industry: String = "",
                 val website: String = "",
                 val description: String = "",
                 val CEO: String = "",
                 val issueType: String = "",
                 val sector: String = "",
                 val tags: Array<String> = arrayOf(""),
                 /**Stats*/
                 val marketcap: Long = 0,
                 val beta: Double = 0.0,
                 val week52high: Double = 0.0,
                 val week52low: Double = 0.0,
                 val week52change: Double = 0.0,
                 val shortInterest: Double = 0.0,
                 //val shortDate: String = "",
                 val dividendRate: Double = 0.0,
                 val dividendYield: Double = 0.0,
                 val exDividendRate: Double = 0.0,
                 val latestEPS: Double = 0.0,
                 val latestEPSDate: String = "",
                 val sharesOutstanding: Long = 0,
                 val float: Long = 0,
                 val returnOnEquity: Double = 0.0,
                 val consensusEPS: Double = 0.0,
                 val DoubleOfEstimates: Double = 0.0,
                 val EPSSurpriseDollar: Double = 0.0,
                 val EPSSurprisePercent: Double = 0.0,
                 val EBITDA: Long = 0,
                 val revenue: Long = 0,
                 val grossProfit: Long = 0,
                 val cash: Long = 0,
                 val debt: Long = 0,
                 val ttmEPS: Double = 0.0,
                 val revenuePerShare: Long = 0,
                 val revenuePerEmployee: Long = 0,
                 val peRatioHigh: Double = 0.0,
                 val peRatioLow: Double = 0.0,
                 val returnOnAssets: Double = 0.0,
                 val returnOnCapital: Double = 0.0,
                 val profitMargin: Double = 0.0,
                 val priceToSales: Double = 0.0,
                 val priceToBook: Double = 0.0,
                 val day200MovingAvg: Double = 0.0,
                 val day50MovingAvg: Double = 0.0,
                 val institutionPercent: Double = 0.0,
                 val insiderPercent: Double = 0.0,
                 val shortRatio: Double = 0.0,
                 val year5ChangePercent: Double = 0.0,
                 val year2ChangePercent: Double = 0.0,
                 val year1ChangePercent: Double = 0.0,
                 val ytdChangePercent: Double = 0.0,
                 val month6ChangePercent: Double = 0.0,
                 val month3ChangePercent: Double = 0.0,
                 val month1ChangePercent: Double = 0.0,
                 val day5ChangePercent: Double = 0.0,
                 val day30ChangePercent: Double = 0.0,
                 /**Quote*/
                 val primaryExchange: String = "",
                 val calculationPrice: String = "",
                 val open: Double = 0.0,
                 val openTime: Double = 0.0,
                 val close: Double = 0.0,
                 val closeTime: Double = 0.0,
                 val high: Double = 0.0,
                 val low: Double = 0.0,
                 val latestPrice: Double = 0.0,
                 val latestSource: String = "",
                 val latestTime: String = "",
                 val latestUpdate: Double = 0.0,
                 val latestVolume: Long = 0,
                 val iexRealtimePrice: Double = 0.0,
                 val iexRealtimeSize: Double = 0.0,
                 val iexLastUpdated: Double = 0.0,
                 val delayedPrice: Double = 0.0,
                 val delayedPriceTime: Double = 0.0,
                 val extendedPrice: Double = 0.0,
                 val extendedChange: Double = 0.0,
                 val extendedChangePercent: Double = 0.0,
                 val extendedPriceTime: Double = 0.0,
                 val previousClose: Double = 0.0,
                 val change:Double = 0.0,
                 val changePercent:Double = 0.0,
                 val iexMarketPercent:Double = 0.0,
                 val iexVolume:Long = 0,
                 val avgTotalVolume:Long = 0,
                 val iexBidPrice:Double = 0.0,
                 val iexBidSize:Double = 0.0,
                 val iexAskPrice:Double = 0.0,
                 val iexAskSize:Double = 0.0,
                 val marketCap:Long = 0,
                 val peRatio:Double = 0.0,
                 val week52High:Double = 0.0,
                 val week52Low:Double = 0.0,
                 val ytdChange:Double = 0.0
    //val financials: Array<JsonObject> = arrayOf(JsonObject()),
    //val earnings: Array<String> = arrayOf(""),
    //val news:Array<String> = arrayOf("")
                 ){
    lateinit var financials: JsonArray<JsonObject>
    lateinit var earnings: JsonArray<JsonObject>
    lateinit var news: JsonArray<JsonObject>

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}

/*
Qualität
1. Eigenkapitalrendite (returnOnEquity)
2. Gewinnmarge (profitMargin)
3. Eigenkapitalquote

Bewertung
4. Kurs-Gewinn-Verhältnis (KGV) über 5 Jahre
5. Kurs-Gewinn-Verhältnis im aktuellen Jahr (peRatio)

Stimmung
6. Analystenmeinungen
7. Reaktion auf die letzten Quartalszahlen

Momentum
8. Gewinnrevisionen
9. 6-Monats-Kursverlauf (month6ChangePercent)
10. 1-Jahres-Kursverlauf (year1ChangePercent)
11. Kursmomentum

Technik
12. Reversaleffekt

Wachstum
13. Gewinnwachstum
        */