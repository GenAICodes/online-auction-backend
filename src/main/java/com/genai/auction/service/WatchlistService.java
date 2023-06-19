package com.genai.auction.service;

import org.springframework.http.ResponseEntity;

public interface WatchlistService {
    ResponseEntity<?> addToWatchlist(Long userId, Long auctionId);
    ResponseEntity<?> removeFromWatchlist(Long userId, Long auctionId);
    ResponseEntity<?> getWatchlist(Long userId);
}
