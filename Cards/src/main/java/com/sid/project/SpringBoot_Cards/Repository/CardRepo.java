package com.sid.project.SpringBoot_Cards.Repository;

import com.sid.project.SpringBoot_Cards.Entity.Cards;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepo extends JpaRepository<Cards, Long>
{

    Optional<Cards> findByMobileNo(String mobileNumber);

    Optional<Cards> findByCardNumber(String cardNumber);
}
