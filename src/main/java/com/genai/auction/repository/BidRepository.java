
package com.genai.auction.repository;

import com.genai.auction.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findAllByUserId(Long userId);

    List<Bid> findAllByAuctionId(Long auctionId);

    List<Bid> findAllByAuctionIdOrderByAmountDesc(Long auctionId);
}
