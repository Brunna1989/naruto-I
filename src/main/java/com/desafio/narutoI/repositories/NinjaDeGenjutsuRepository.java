package com.desafio.narutoI.repositories;

import com.desafio.narutoI.entidades.NinjaDeGenjutsu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaDeGenjutsuRepository extends JpaRepository<NinjaDeGenjutsu, Long> {
}
