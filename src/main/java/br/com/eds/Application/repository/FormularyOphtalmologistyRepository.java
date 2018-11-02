package br.com.eds.Application.repository;

import br.com.eds.Application.model.FormularyOphtalmologisty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FormularyOphtalmologistyRepository extends CrudRepository<FormularyOphtalmologisty, Long>, JpaRepository<FormularyOphtalmologisty, Long> {


    @Query("select u from FormularyOphtalmologisty u where u.deleted = false AND u.patientId = ?1")
    List<FormularyOphtalmologisty> findFormularyOphtalmologistiesByPatientId(Long id);


}
