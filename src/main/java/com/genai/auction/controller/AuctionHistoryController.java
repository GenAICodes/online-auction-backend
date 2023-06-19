
package com.genai.auction.controller;

import com.genai.auction.entity.Auction;
import com.genai.auction.service.AuctionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/auction-history")
public class AuctionHistoryController {

    @Autowired
    private AuctionHistoryService auctionHistoryService;

    @GetMapping("/auctions")
    public List<Auction> getAllAuctions() {
        return auctionHistoryService.getAllAuctions();
    }

    @GetMapping("/auctions/{id}")
    public Auction getAuctionById(@PathVariable Long id) {
        return auctionHistoryService.getAuctionById(id);
    }

    @PostMapping("/auctions")
    public Auction createAuction(@RequestBody Auction auction) {
        return auctionHistoryService.createAuction(auction);
    }

    @PutMapping("/auctions")
    public Auction updateAuction(@RequestBody Auction auction) {
        return auctionHistoryService.updateAuction(auction);
    }

    @DeleteMapping("/auctions/{id}")
    public void deleteAuction(@PathVariable Long id) {
        auctionHistoryService.deleteAuction(id);
    }

    @GetMapping("/auctions/end-time-before/{endTime}")
    public List<Auction> getAuctionsByEndTimeBefore(@PathVariable LocalDateTime endTime) {
        return auctionHistoryService.getAuctionsByEndTimeBefore(endTime);
    }
}
