
package com.genai.auction.service.impl;

import com.genai.auction.entity.Auction;
import com.genai.auction.repository.AuctionRepository;
import com.genai.auction.service.AuctionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuctionHistoryServiceImpl implements AuctionHistoryService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction getAuctionById(Long id) {
        return auctionRepository.findById(id).orElse(null);
    }

    @Override
    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public Auction updateAuction(Auction auction) {
        Auction existingAuction = auctionRepository.findById(auction.getId()).orElse(null);
        if (existingAuction != null) {
            existingAuction.setName(auction.getName());
            existingAuction.setDescription(auction.getDescription());
            existingAuction.setStartingPrice(auction.getStartingPrice());
            existingAuction.setStartDate(auction.getStartDate());
            existingAuction.setEndDate(auction.getEndDate());
            return auctionRepository.save(existingAuction);
        }
        return null;
    }

    @Override
    public void deleteAuction(Long id) {
        auctionRepository.deleteById(id);
    }

    @Override
    public List<Auction> getAuctionsByEndTimeBefore(LocalDateTime endTime) {
        return auctionRepository.findAllByEndTimeBefore(endTime);
    }
}
