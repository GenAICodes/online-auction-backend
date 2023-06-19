
    package com.genai.auction.service.impl;
    
    import com.genai.auction.entity.User;
    import com.genai.auction.exception.ResourceNotFoundException;
    import com.genai.auction.repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;
    
    @Service
    public class UserServiceImpl {
    
        @Autowired
        private UserRepository userRepository;
    
        public ResponseEntity<?> getUser(Long id) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
            return ResponseEntity.ok().body(user);
        }
    
        public ResponseEntity<?> createUser(User user) {
            userRepository.save(user);
            return ResponseEntity.ok().body(user);
        }
    
        public ResponseEntity<?> updateUser(Long id, User user) {
            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            userRepository.save(existingUser);
            return ResponseEntity.ok().body(existingUser);
        }
    
        public ResponseEntity<?> deleteUser(Long id) {
            // Your code here
            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
            userRepository.delete(existingUser);
            return ResponseEntity.ok().body(existingUser);
        }
    }
