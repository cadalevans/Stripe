package tn.esprit.demotransaction.AlphaVantage;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaServices {
    private static final String API_KEY = " NE4V4SW97PG1SWWS";
    private static final String API_BASE_URL = "https://www.alphavantage.co/query";

    public String fetchStockData(String symbol) {
        String url = String.format("%s?function=TIME_SERIES_INTRADAY&symbol=%s&interval=5min&apikey=%s", API_BASE_URL, symbol, API_KEY);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
