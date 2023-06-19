package com.genai.auction.service;

import com.genai.auction.entity.Auction;

import java.time.LocalDateTime;
import java.util.List;

public interface AuctionHistoryService {
        List<Auction> getAllAuctions();
        Auction getAuctionById(Long id);
        Auction createAuction(Auction auction);
        Auction updateAuction(Auction auction);
        void deleteAuction(Long id);
        List<Auction> getAuctionsByEndTimeBefore(LocalDateTime endTime);

}
