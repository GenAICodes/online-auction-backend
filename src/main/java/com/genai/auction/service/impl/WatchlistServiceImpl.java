
package com.genai.auction.service.impl;

import com.genai.auction.entity.Auction;
import com.genai.auction.entity.User;
import com.genai.auction.entity.Watchlist;
import com.genai.auction.repository.AuctionRepository;
import com.genai.auction.repository.UserRepository;
import com.genai.auction.repository.WatchlistRepository;
import com.genai.auction.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public ResponseEntity<?> addToWatchlist(Long userId, Long auctionId) {
        User user = userRepository.findById(userId).orElse(null);
        Auction auction = auctionRepository.findById(auctionId).orElse(null);
        if (user == null || auction == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or auction not found");
        }
        Watchlist watchlist = new Watchlist(user, auction);
        watchlistRepository.save(watchlist);
        return ResponseEntity.ok("Auction added to watchlist");
    }

    @Override
    public ResponseEntity<?> removeFromWatchlist(Long userId, Long auctionId) {
        User user = userRepository.findById(userId).orElse(null);
        Auction auction = auctionRepository.findById(auctionId).orElse(null);
        if (user == null || auction == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or auction not found");
        }
        Watchlist watchlist = watchlistRepository.findByUserAndAuction(user, auction);
        if (watchlist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Auction not found in watchlist");
        }
        watchlistRepository.delete(watchlist);
        return ResponseEntity.ok("Auction removed from watchlist");
    }

    @Override
    public ResponseEntity<?> getWatchlist(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        List<Watchlist> watchlist = watchlistRepository.findByUser(user);
        return ResponseEntity.ok(watchlist);
    }
}
