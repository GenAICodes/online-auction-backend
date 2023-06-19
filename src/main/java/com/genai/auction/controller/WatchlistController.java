
package com.genai.auction.controller;

import com.genai.auction.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @PostMapping("/{userId}/{auctionId}")
    public ResponseEntity<?> addToWatchlist(@PathVariable Long userId, @PathVariable Long auctionId) {
        return watchlistService.addToWatchlist(userId, auctionId);
    }

    @DeleteMapping("/{userId}/{auctionId}")
    public ResponseEntity<?> removeFromWatchlist(@PathVariable Long userId, @PathVariable Long auctionId) {
        return watchlistService.removeFromWatchlist(userId, auctionId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getWatchlist(@PathVariable Long userId) {
        return watchlistService.getWatchlist(userId);
    }
}
