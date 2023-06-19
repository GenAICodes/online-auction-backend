
package com.genai.auction.service.impl;

import com.genai.auction.entity.Bid;
import com.genai.auction.repository.BidRepository;
import com.genai.auction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    @Override
    public List<Bid> getBidsByAuctionId(Long auctionId) {
        return bidRepository.findAllByAuctionId(auctionId);
    }

    @Override
    public Bid createBid(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public List<Bid> getBidsByUserId(Long userId) {
        return bidRepository.findAllByUserId(userId);
    }

    @Override
    public Bid getHighestBidByAuctionId(Long auctionId) {
        List<Bid> bids = bidRepository.findAllByAuctionIdOrderByAmountDesc(auctionId);
        if (!bids.isEmpty()) {
            return bids.get(0);
        }
        return null; // or handle the case when no bid is found for the given auctionId
    }
}
