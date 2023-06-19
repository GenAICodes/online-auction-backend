
package com.genai.auction.service;

import com.genai.auction.entity.Seller;

import java.util.List;

public interface SellerService {
    Seller getSeller(Long id);
    List<Seller> getAllSellers();
    Seller createSeller(Seller seller);
    Seller updateSeller(Seller seller);
    void deleteSeller(Long id);
}
