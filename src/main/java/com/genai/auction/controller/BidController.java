
package com.genai.auction.controller;

import com.genai.auction.entity.Bid;
import com.genai.auction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/auction/{auctionId}")
    public ResponseEntity<List<Bid>> getAllBidsByAuctionId(@PathVariable Long auctionId) {
        List<Bid> bids = bidService.getBidsByAuctionId(auctionId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @GetMapping("/auction/{auctionId}/highest")
    public ResponseEntity<Bid> getHighestBidByAuctionId(@PathVariable Long auctionId) {
        Bid bid = bidService.getHighestBidByAuctionId(auctionId);
        return new ResponseEntity<>(bid, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Bid> createBid(@RequestBody Bid bid) {
        Bid createdBid = bidService.createBid(bid);
        return new ResponseEntity<>(createdBid, HttpStatus.CREATED);
    }
}
