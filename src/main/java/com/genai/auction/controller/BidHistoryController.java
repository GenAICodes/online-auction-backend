
package com.genai.auction.controller;

import com.genai.auction.entity.Bid;
import com.genai.auction.service.BidHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bid-history")
public class BidHistoryController {

    @Autowired
    private BidHistoryService bidHistoryService;

    @GetMapping("/bids")
    public List<Bid> getAllBids() {
        return bidHistoryService.getAllBids();
    }

    @GetMapping("/bids/auction/{auctionId}")
    public List<Bid> getBidsByAuctionId(@PathVariable Long auctionId) {
        return bidHistoryService.getBidsByAuctionId(auctionId);
    }

    @GetMapping("/bids/user/{userId}")
    public List<Bid> getBidsByUserId(@PathVariable Long userId) {
        return bidHistoryService.getBidsByUserId(userId);
    }
}
