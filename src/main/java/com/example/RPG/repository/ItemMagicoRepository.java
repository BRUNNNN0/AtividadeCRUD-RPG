package com.example.RPG.repository;

import com.example.RPG.model.ItemMagico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMagicoRepository extends JpaRepository<ItemMagico, Long> {
}
