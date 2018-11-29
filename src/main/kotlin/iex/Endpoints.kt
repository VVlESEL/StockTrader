package iex

object Endpoints {
    private const val PREFIX = "https://api.iextrading.com/1.0"

    const val SYMBOLS = "$PREFIX/ref-data/symbols"

    /**
     * Separate symbols and types by ,
     */
    fun MARKET(symbols: String, types: String): String {
        return "$PREFIX/stock/market/batch?symbols=$symbols&types=$types"
    }

    /**
     * periods: 5y, 2y, 1y, ytd, 6m, 3m, 1m
     * */
    fun DIVIDENDS(symbol: String, period: String): String {
        return "$PREFIX/stock/$symbol/dividends/$period"
    }
}