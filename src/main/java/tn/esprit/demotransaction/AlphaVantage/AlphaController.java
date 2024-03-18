package tn.esprit.demotransaction.AlphaVantage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlphaController {
    @Autowired
    private AlphaServices alphaServices;
    @GetMapping("/api/stock-data/fetch")
    public ResponseEntity<String> fetchStockData(@RequestParam String symbol) {
        String stockData = alphaServices.fetchStockData(symbol);
        return ResponseEntity.ok(stockData);
    }
}
