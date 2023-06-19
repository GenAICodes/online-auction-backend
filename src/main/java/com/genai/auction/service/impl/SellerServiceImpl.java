
package com.genai.auction.service.impl;

import com.genai.auction.entity.Seller;
import com.genai.auction.exception.ResourceNotFoundException;
import com.genai.auction.repository.SellerRepository;
import com.genai.auction.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller getSeller(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "id", id));
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller updateSeller(Seller seller) {
        Seller existingSeller = sellerRepository.findById(seller.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "id", seller.getId()));
        existingSeller.setName(seller.getName());
        existingSeller.setEmail(seller.getEmail());
        existingSeller.setPassword(seller.getPassword());
        existingSeller.setRatings(seller.getRatings());
        existingSeller.setAuctions(seller.getAuctions());
        return sellerRepository.save(existingSeller);
    }

    @Override
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}
