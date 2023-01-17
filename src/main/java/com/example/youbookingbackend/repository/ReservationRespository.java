package com.example.youbookingbackend.repository;

import com.example.youbookingbackend.entity.Chambre;
import com.example.youbookingbackend.entity.Reservation;
import com.example.youbookingbackend.entity.StatusReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Repository
public interface ReservationRespository extends JpaRepository<Reservation,Long> {

    @Query("select r.chambre from Reservation r where ((:dateDebut not between r.dateDebut and" +
            " r.dateFin) and (:dateFin not between r.dateDebut and r.dateFin))")
    public List<Chambre> findAllByDateDebutAndDateFin(LocalDate dateDebut,LocalDate dateFin);

//    select c.* from chambre c where c.id not in(select r.chambre_id from Reservation r where ("2023-01-19" not between r.date_debut and r.date_fin) and ("2023-01-19" not between r.date_debut and r.date_fin)) and c.status_chambre="Disponible"
    @Query("select c from Chambre c where c.id not in(select r.chambre.id from Reservation r where (:dateDebut between r.dateDebut and r.dateFin) and (:dateFin between r.dateDebut and r.dateFin)) and c.statusChambre='Disponible'")
    public List<Chambre> findAllChamberNotRserved(LocalDate dateDebut,LocalDate dateFin);

    public List<Reservation> findAllByStatusReservation(StatusReservation statusReservation);
}
