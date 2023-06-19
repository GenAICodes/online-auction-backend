
package com.genai.auction.repository;

import com.genai.auction.entity.User;
import com.genai.auction.entity.Auction;
import com.genai.auction.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {

    List<Watchlist> findByUser(User user);

    Watchlist findByUserAndAuction(User user, Auction auction);
}
