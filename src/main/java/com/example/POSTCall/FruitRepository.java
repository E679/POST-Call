package com.example.POSTCall;

import com.example.POSTCall.Entity.FruitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<FruitModel,Integer> {
}
