
package com.genai.auction.service;

import com.genai.auction.entity.Bid;

import java.util.List;

public interface BidService {
    List<Bid> getAllBids();
    List<Bid> getBidsByAuctionId(Long auctionId);
    Bid createBid(Bid bid);
    List<Bid> getBidsByUserId(Long userId);
    Bid getHighestBidByAuctionId(Long auctionId);
}
