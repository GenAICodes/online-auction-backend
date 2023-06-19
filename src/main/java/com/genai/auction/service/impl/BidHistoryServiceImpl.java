
package com.genai.auction.service.impl;

import com.genai.auction.entity.Bid;
import com.genai.auction.repository.BidRepository;
import com.genai.auction.service.BidHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidHistoryServiceImpl implements BidHistoryService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    @Override
    public List<Bid> getBidsByUserId(Long userId) {
        return bidRepository.findAllByUserId(userId);
    }

    @Override
    public List<Bid> getBidsByAuctionId(Long auctionId) {
        return bidRepository.findAllByAuctionId(auctionId);
    }
}
