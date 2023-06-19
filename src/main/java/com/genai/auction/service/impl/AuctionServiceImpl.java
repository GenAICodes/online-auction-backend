
package com.genai.auction.service.impl;

import com.genai.auction.entity.Auction;
import com.genai.auction.exception.ResourceNotFoundException;
import com.genai.auction.repository.AuctionRepository;
import com.genai.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public Auction getAuctionById(Long id) throws ResourceNotFoundException {
        return auctionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Auction", "id", id));
    }

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public Auction updateAuction(Auction auction) throws ResourceNotFoundException {
        Auction existingAuction = auctionRepository.findById(auction.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Auction", "id", auction.getId()));
        existingAuction.setName(auction.getName());
        existingAuction.setDescription(auction.getDescription());
        existingAuction.setStartingPrice(auction.getStartingPrice());
        existingAuction.setCurrentPrice(auction.getCurrentPrice());
        existingAuction.setStartDate(auction.getStartDate());
        existingAuction.setEndDate(auction.getEndDate());
        existingAuction.setSeller(auction.getSeller());
        existingAuction.setWinner(auction.getWinner());
        return auctionRepository.save(existingAuction);
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
