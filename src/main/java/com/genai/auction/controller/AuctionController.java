
package com.genai.auction.controller;

import com.genai.auction.entity.Auction;
import com.genai.auction.exception.ResourceNotFoundException;
import com.genai.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/auctions/{id}")
    public ResponseEntity<?> getAuction(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Auction auction = auctionService.getAuctionById(id);
        return ResponseEntity.ok().body(auction);
    }

    @PostMapping("/auctions")
    public ResponseEntity<?> createAuction(@RequestBody Auction auction) {
        auctionService.createAuction(auction);
        return ResponseEntity.ok().body(auction);
    }

    @PutMapping("/auctions/{id}")
    public ResponseEntity<?> updateAuction(@PathVariable(value = "id") Long id, @RequestBody Auction auction) throws ResourceNotFoundException {
        Auction existingAuction = auctionService.getAuctionById(id);
        existingAuction.setName(auction.getName());
        existingAuction.setDescription(auction.getDescription());
        existingAuction.setStartingPrice(auction.getStartingPrice());
        existingAuction.setCurrentPrice(auction.getCurrentPrice());
        existingAuction.setStartDate(auction.getStartDate());
        existingAuction.setEndDate(auction.getEndDate());
        existingAuction.setSeller(auction.getSeller());
        existingAuction.setWinner(auction.getWinner());
        auctionService.updateAuction(existingAuction);
        return ResponseEntity.ok().body(existingAuction);
    }

    @DeleteMapping("/auctions/{id}")
    public ResponseEntity<?> deleteAuction(@PathVariable(value = "id") Long id) {
        Auction existingAuction = auctionService.getAuctionById(id);
        auctionService.deleteAuction(id);
        return ResponseEntity.ok().body(existingAuction);
    }
}
