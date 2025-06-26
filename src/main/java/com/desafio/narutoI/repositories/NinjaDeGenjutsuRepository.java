package com.desafio.narutoI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaDeGenjutsuRepository extends JpaRepository<NinjaDeGenjutsu, Long> {
}
