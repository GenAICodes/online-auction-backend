
    package com.genai.auction.entity;
    
    import javax.persistence.*;
    import java.util.Date;
    
    @Entity
    @Table(name = "auctions")
    public class Auction {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(name = "name")
        private String name;
    
        @Column(name = "description")
        private String description;
    
        @Column(name = "starting_price")
        private Double startingPrice;
    
        @Column(name = "current_price")
        private Double currentPrice;
    
        @Column(name = "start_date")
        private Date startDate;
    
        @Column(name = "end_date")
        private Date endDate;
    
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "seller_id")
        private User seller;
    
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "winner_id")
        private User winner;
    
        public Auction() {
        }
    
        public Auction(String name, String description, Double startingPrice, Double currentPrice, Date startDate, Date endDate, User seller, User winner) {
            this.name = name;
            this.description = description;
            this.startingPrice = startingPrice;
            this.currentPrice = currentPrice;
            this.startDate = startDate;
            this.endDate = endDate;
            this.seller = seller;
            this.winner = winner;
        }
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getDescription() {
            return description;
        }
    
        public void setDescription(String description) {
            this.description = description;
        }
    
        public Double getStartingPrice() {
            return startingPrice;
        }
    
        public void setStartingPrice(Double startingPrice) {
            this.startingPrice = startingPrice;
        }
    
        public Double getCurrentPrice() {
            return currentPrice;
        }
    
        public void setCurrentPrice(Double currentPrice) {
            this.currentPrice = currentPrice;
        }
    
        public Date getStartDate() {
            return startDate;
        }
    
        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }
    
        public Date getEndDate() {
            return endDate;
        }
    
        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }
    
        public User getSeller() {
            return seller;
        }
    
        public void setSeller(User seller) {
            this.seller = seller;
        }
    
        public User getWinner() {
            return winner;
        }
    
        public void setWinner(User winner) {
            this.winner = winner;
        }
    }
