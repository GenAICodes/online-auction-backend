
    package com.genai.auction.repository;
    
    import com.genai.auction.entity.User;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    
    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
    }
