package com.example

import com.fasterxml.jackson.annotation.JsonProperty

data class Signal(
    @JsonProperty("signal_id")
    val signalId: String,

    @JsonProperty("signal_name")
    val signalName: String,

    @JsonProperty("side")
    val side: Side,

    @JsonProperty("instrument_name")
    val instrumentName: String,

    @JsonProperty("amount")
    val amount: Double,

    @JsonProperty("type")
    val type: Type,

    @JsonProperty("exchange")
    val exchange: Exchange
) {
    enum class Side {
        @JsonProperty("buy")
        Buy,

        @JsonProperty("sell")
        Sell
    }

    enum class Type {
        @JsonProperty("limit")
        Limit,

        @JsonProperty("stop_limit")
        StopLimit,

        @JsonProperty("take_limit")
        TakeLimit,

        @JsonProperty("market")
        Market,

        @JsonProperty("stop_market")
        StopMarket,

        @JsonProperty("take_market")
        TakeMarket,

        @JsonProperty("market_limit")
        MarketLimit,

        @JsonProperty("trailing_stop")
        TrailingStop
    }

    enum class Exchange(val exchangeName: String) {
        @JsonProperty("deribit")
        Deribit("deribit");

//        @JsonProperty("binance")
//        Binance

        companion object  {
            fun fromExchangeName(exchangeName: String)
                    = entries.first { it.exchangeName == exchangeName }
        }
    }
}