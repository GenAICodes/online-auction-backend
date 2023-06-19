
package com.genai.auction.controller;

import com.genai.auction.entity.Seller;
import com.genai.auction.exception.ResourceNotFoundException;
import com.genai.auction.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/sellers/{id}")
    public ResponseEntity<?> getSeller(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Seller seller = sellerService.getSeller(id);
        return ResponseEntity.ok().body(seller);
    }

    @GetMapping("/sellers")
    public ResponseEntity<?> getAllSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        return ResponseEntity.ok().body(sellers);
    }

    @PostMapping("/sellers")
    public ResponseEntity<?> createSeller(@RequestBody Seller seller) {
        sellerService.createSeller(seller);
        return ResponseEntity.ok().body(seller);
    }

    @PutMapping("/sellers/{id}")
    public ResponseEntity<?> updateSeller(@PathVariable(value = "id") Long id, @RequestBody Seller seller) throws ResourceNotFoundException {
        Seller existingSeller = sellerService.getSeller(id);
        existingSeller.setName(seller.getName());
        existingSeller.setEmail(seller.getEmail());
        existingSeller.setPassword(seller.getPassword());
        existingSeller.setRatings(seller.getRatings());
        existingSeller.setAuctions(seller.getAuctions());
        sellerService.updateSeller(existingSeller);
        return ResponseEntity.ok().body(existingSeller);
    }

    @DeleteMapping("/sellers/{id}")
    public ResponseEntity<?> deleteSeller(@PathVariable(value = "id") Long id) {
        sellerService.deleteSeller(id);
        return ResponseEntity.ok().build();
    }
}
