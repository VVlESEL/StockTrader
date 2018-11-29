package iex

enum class Types {
    company,
    /*
    {
        "symbol": "AAPL",
        "companyName": "Apple Inc.",
        "exchange": "Nasdaq Global Select",
        "industry": "Computer Hardware",
        "website": "http://www.apple.com",
        "description": "Apple Inc is an American multinational technology company. It designs, manufactures, and markets mobile communication and media devices, personal computers, and portable digital music players.",
        "CEO": "Timothy D. Cook",
        "issueType": "cs",
        "sector": "Technology",
        "tags": [
        "Technology",
        "Consumer Electronics",
        "Computer Hardware"
        ]
    }
    */
    quote,
    /*
    {
      "symbol": "AAPL",
      "companyName": "Apple Inc.",
      "primaryExchange": "Nasdaq Global Select",
      "sector": "Technology",
      "calculationPrice": "tops",
      "open": 154,
      "openTime": 1506605400394,
      "close": 153.28,
      "closeTime": 1506605400394,
      "high": 154.80,
      "low": 153.25,
      "latestPrice": 158.73,
      "latestSource": "Previous close",
      "latestTime": "September 19, 2017",
      "latestUpdate": 1505779200000,
      "latestVolume": 20567140,
      "iexRealtimePrice": 158.71,
      "iexRealtimeSize": 100,
      "iexLastUpdated": 1505851198059,
      "delayedPrice": 158.71,
      "delayedPriceTime": 1505854782437,
      "extendedPrice": 159.21,
      "extendedChange": -1.68,
      "extendedChangePercent": -0.0125,
      "extendedPriceTime": 1527082200361,
      "previousClose": 158.73,
      "change": -1.67,
      "changePercent": -0.01158,
      "iexMarketPercent": 0.00948,
      "iexVolume": 82451,
      "avgTotalVolume": 29623234,
      "iexBidPrice": 153.01,
      "iexBidSize": 100,
      "iexAskPrice": 158.66,
      "iexAskSize": 100,
      "marketCap": 751627174400,
      "peRatio": 16.86,
      "week52High": 159.65,
      "week52Low": 93.63,
      "ytdChange": 0.3665,
    }
    */
    news,
    /*
    [
      {
        "datetime": "2017-06-29T13:14:22-04:00",
        "headline": "Voice Search Technology Creates A New Paradigm For Marketers",
        "source": "Benzinga via QuoteMedia",
        "url": "https://api.iextrading.com/1.0/stock/aapl/article/8348646549980454",
        "summary": "<p>Voice search is likely to grow by leap and bounds, with technological advancements leading to better adoption and fueling the growth cycle, according to Lindsay Boyajian, <a href=\"http://loupventures.com/how-the-future-of-voice-search-affects-marketers-today/\">a guest contributor at Loup Ventu...",
        "related": "AAPL,AMZN,GOOG,GOOGL,MSFT",
        "image": "https://api.iextrading.com/1.0/stock/aapl/news-image/7594023985414148"
      }
    ]
    */
    earnings,
    /* ///4 most recent quarters///
    {
      "symbol": "AAPL",
      "earnings": [
        {
          "actualEPS": 2.1,
          "consensusEPS": 2.02,
          "estimatedEPS": 2.02,
          "announceTime": "AMC",
          "numberOfEstimates": 14,
          "EPSSurpriseDollar": 0.08,
          "EPSReportDate": "2017-05-02",
          "fiscalPeriod": "Q2 2017",
          "fiscalEndDate": "2017-03-31",
          "yearAgo": 1.67,
          "yearAgoChangePercent": .30,
          "estimatedChangePercent": .28,
          "symbolId": 11
        },
        {
          "actualEPS": 3.36,
          "consensusEPS": 3.22,
          "estimatedEPS": 3.22,
          "announceTime": "AMC",
          "numberOfEstimates": 15,
          "EPSSurpriseDollar": 0.14,
          "EPSReportDate": "2017-01-31",
          "fiscalPeriod": "Q1 2017",
          "fiscalEndDate": "2016-12-31",
          "yearAgo": 1.67,
          "yearAgoChangePercent": .30,
          "estimatedChangePercent": .28,
          "symbolId": 11
        },
      ]
    }
    */
    financials,
    /*
    {
      "symbol": "AAPL",
      "financials": [
        {
          "reportDate": "2017-03-31",
          "grossProfit": 20591000000,
          "costOfRevenue": 32305000000,
          "operatingRevenue": 52896000000,
          "totalRevenue": 52896000000,
          "operatingIncome": 14097000000,
          "netIncome": 11029000000,
          "researchAndDevelopment": 2776000000,
          "operatingExpense": 6494000000,
          "currentAssets": 101990000000,
          "totalAssets": 334532000000,
          "totalLiabilities": 200450000000,
          "currentCash": 15157000000,
          "currentDebt": 13991000000,
          "totalCash": 67101000000,
          "totalDebt": 98522000000,
          "shareholderEquity": 134082000000,
          "cashChange": -1214000000,
          "cashFlow": 12523000000,
          "operatingGainsLosses": null
        } // , { ... }
      ]
    }
    */
    stats
    /*
    {
      "companyName": "Apple Inc.",
      "marketcap": 760334287200,
      "beta": 1.295227,
      "week52high": 156.65,
      "week52low": 93.63,
      "week52change": 58.801903,
      "shortInterest": 55544287,
      "shortDate": "2017-06-15",
      "dividendRate": 2.52,
      "dividendYield": 1.7280395,
      "exDividendDate": "2017-05-11 00:00:00.0",
      "latestEPS": 8.29,
      "latestEPSDate": "2016-09-30",
      "sharesOutstanding": 5213840000,
      "float": 5203997571,
      "returnOnEquity": 0.08772939519857577,
      "consensusEPS": 3.22,
      "numberOfEstimates": 15,
      "symbol": "AAPL",
      "EBITDA": 73828000000,
      "revenue": 220457000000,
      "grossProfit": 84686000000,
      "cash": 256464000000,
      "debt": 358038000000,
      "ttmEPS": 8.55,
      "revenuePerShare": 42.2830389885382,
      "revenuePerEmployee": 1900491.3793103448,
      "peRatioHigh": 25.5,
      "peRatioLow": 8.7,
      "EPSSurpriseDollar": null,
      "EPSSurprisePercent": 3.9604,
      "returnOnAssets": 14.15,
      "returnOnCapital": null,
      "profitMargin": 20.73,
      "priceToSales": 3.6668503,
      "priceToBook": 6.19,
      "day200MovingAvg": 140.60541,
      "day50MovingAvg": 156.49678,
      "institutionPercent": 32.1,
      "insiderPercent": null,
      "shortRatio": 1.6915414,
      "year5ChangePercent": 0.5902546932200027,
      "year2ChangePercent": 0.3777449874142869,
      "year1ChangePercent": 0.39751716851558366,
      "ytdChangePercent": 0.36659492036160124,
      "month6ChangePercent": 0.12208398133748043,
      "month3ChangePercent": 0.08466584665846649,
      "month1ChangePercent": 0.009668596145283263,
      "day5ChangePercent": -0.005762605699968781
    }
    */
}