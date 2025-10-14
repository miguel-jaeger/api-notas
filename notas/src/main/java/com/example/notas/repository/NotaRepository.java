package com.example.notas.repository;
import com.example.notas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByArchivada(boolean archivada);
}

