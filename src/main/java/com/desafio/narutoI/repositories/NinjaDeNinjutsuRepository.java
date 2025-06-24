package com.desafio.narutoI.repositories;

import com.desafio.narutoI.entidades.NinjaDeNinjutsu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaDeNinjutsuRepository extends JpaRepository<NinjaDeNinjutsu, Long> {
}
