package br.com.eds.Application.repository;

import br.com.eds.Application.model.FormularyOphtalmologisty;
import br.com.eds.Application.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepository extends CrudRepository<Patients, Long>, JpaRepository<Patients, Long> {


//    @Query("select u from Patients u where u.deleted = false AND u.name like  %?1% ")
//    List<Patients> findFormularyOphtalmologistiesByPatientName(String name);

}
