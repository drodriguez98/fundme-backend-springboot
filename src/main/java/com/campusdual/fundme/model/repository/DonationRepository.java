package com.campusdual.fundme.model.repository;

import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Integer> {

    List<Donation> findTop5ByOrderByAmountDesc();
    List<Donation> findTop5ByOrderByDateAddedDesc();
    List<Donation> findByUserIdOrderByDateAddedDesc(User user);
    public List<Donation> getAllDonationsByOrderByDateAddedDesc();
    List<Donation> findByProjectIdOrderByDateAddedDesc(Project project);

    @Query("SELECT SUM(d.amount) FROM Donation d WHERE d.userId = :userId")
    Integer getTotalDonationsByUser(@Param("userId") User user);

    @Query("SELECT COUNT(d) FROM Donation d WHERE d.userId = :userId")
    Integer getDonationCountByUser(@Param("userId") User user);

}