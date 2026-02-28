package br.com.cazzine.appointment_api.repository;

import br.com.cazzine.appointment_api.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {
}
