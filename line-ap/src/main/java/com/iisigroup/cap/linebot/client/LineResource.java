package com.iisigroup.cap.linebot.client;

import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.LineBotClientBuilder;

public class LineResource {
    private static LineBotClient lineBotClient;

    static {
        LineBotClientBuilder lbcb = LineBotClientBuilder.create("1461968250", "8b40651e023e9b296c12196d5675cf45", "uf4d14d3d43b707adf996a6bd6b581118");
        lineBotClient = lbcb.build();
    }

    public static LineBotClient getLineBotClient() {
        return lineBotClient;
    }

}
