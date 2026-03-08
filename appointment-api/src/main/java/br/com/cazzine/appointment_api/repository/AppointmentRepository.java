package br.com.cazzine.appointment_api.repository;

import br.com.cazzine.appointment_api.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    boolean existsByProfessionalIdAndAppointmentDate(Integer professionalId, LocalDateTime appointmentDate);
}
