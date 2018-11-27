package iex

import com.beust.klaxon.JsonArray
import com.beust.klaxon.Parser
import org.jsoup.Jsoup
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun main(args: Array<String>) {

    val apiController = IexApiController()

    val symbols = apiController.getAllSymbols()
    println(symbols)
    println(symbols.size)

    val sp500 = apiController.getSP500Symbols()
    println(sp500)
    println(sp500.size)

    val list = symbols.filter { symbol -> sp500.contains(symbol) }
    println(list)
    println(list.size)
}

class IexApiController {
    fun fetchData(stringUrl: String) : String {
        val url = URL(stringUrl)
        val httpURLConnection = url.openConnection() as HttpURLConnection
        val inputStream = httpURLConnection.inputStream
        val inputStreamReader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)

        val response = StringBuffer()
        var inputLine = bufferedReader.readLine()
        while (inputLine != null) {
            response.append(inputLine)
            inputLine = bufferedReader.readLine()
        }

        return response.toString()
    }

    fun getAllSymbols(): ArrayList<String> {
        val res = fetchData(Endpoints.SYMBOLS)

        val parser = Parser()
        val stringBuilder = StringBuilder(res)
        val jsonArr: JsonArray<String> = parser.parse(stringBuilder) as JsonArray<String>

        val list = ArrayList<String>()

        //symbol,name,date,isEnabled,type,iexId
        jsonArr.mapChildren { obj ->
            if(obj["type"]?.equals("cs")?:false){
                list.add(obj["symbol"] as String)
            }
        }

        return list
    }

    fun getSP500Symbols(): ArrayList<String> {
        val soup = Jsoup.parse(URL("https://en.wikipedia.org/wiki/List_of_S%26P_500_companies"),1000)
        val table = soup.select("table").first()
        val rows = table.select("tr")

        val list = ArrayList<String>()

        for(row in rows) {
            val data = row.select("td").first()
            data?: continue
            val symbol = data.text()
            list.add(symbol)
        }

        return list
    }
}

