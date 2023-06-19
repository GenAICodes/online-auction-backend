
package com.genai.auction.service;

import com.genai.auction.entity.Bid;

import java.util.List;

public interface BidHistoryService {
    List<Bid> getAllBids();
    List<Bid> getBidsByAuctionId(Long auctionId);
    List<Bid> getBidsByUserId(Long userId);
}
