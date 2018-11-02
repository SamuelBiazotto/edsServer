package br.com.eds.Application.model;

import br.com.eds.Application.model.enumModel.Gender;
import br.com.eds.Application.model.enumModel.PatientsStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Patients extends AbstractEntity {

    @NotNull(message = "O valor não pode ser menor que 6 caracteres")
    @Column(columnDefinition="TEXT")
    private String Name;

    @NotNull(message = "Data de Nascimento não pode ser null")
    @Column(name = "data_nascimento", insertable = false, columnDefinition = "timestamp with time zone DEFAULT now()")
    private Date birthDate;

    @NotNull(message = "Rg não pode ser null")
    @Column(columnDefinition="TEXT", unique = true)
    private String rg;

    private Integer gender;

    @NotNull(message = "rua não pode ser null")
    @Column(columnDefinition="TEXT")
    private String street;

    @NotNull(message = "bairro não pode ser null")
    @Column(columnDefinition="TEXT")
    private String neighborhood;

    @NotNull(message = "cidade não pode ser null")
    @Column(columnDefinition="TEXT")
    private String city;

    @Column(columnDefinition="TEXT")
    private String complement;

    @Column(columnDefinition="TEXT")
    private String observations;

    private boolean deleted;

    private Integer status;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient")
    private Set<FormularyOphtalmologisty> formularyOphtalmologistys = new HashSet<>();

    public Gender getGender() {
        return Gender.toEnum(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender.getCode();
    }

    public PatientsStatus getPatientsStatus() {
        return PatientsStatus.toEnum(status);
    }

    public void setPatientsStatus(PatientsStatus status) {
        this.status = status.getCode();
    }

    public Set<FormularyOphtalmologisty> getFormularyOphtalmologistys() {
        return formularyOphtalmologistys;
    }

    public void setFormularyOphtalmologistys(Set<FormularyOphtalmologisty> formularyOphtalmologistys) {
        this.formularyOphtalmologistys = formularyOphtalmologistys;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }


    @Override
    public String toString() {
        return "Patients{" +
                "Name='" + Name + '\'' +
                ", birthDate=" + birthDate +
                ", rg='" + rg + '\'' +
                ", gender=" + gender +
                ", street='" + street + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", complement='" + complement + '\'' +
                ", observations='" + observations + '\'' +
                ", deleted=" + deleted +
                ", status=" + status +
                ", formularyOphtalmologistys=" + formularyOphtalmologistys +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patients patients = (Patients) o;
        return deleted == patients.deleted &&
                Objects.equals(Name, patients.Name) &&
                Objects.equals(birthDate, patients.birthDate) &&
                Objects.equals(rg, patients.rg) &&
                Objects.equals(gender, patients.gender) &&
                Objects.equals(street, patients.street) &&
                Objects.equals(neighborhood, patients.neighborhood) &&
                Objects.equals(city, patients.city) &&
                Objects.equals(complement, patients.complement) &&
                Objects.equals(observations, patients.observations) &&
                Objects.equals(status, patients.status) &&
                Objects.equals(formularyOphtalmologistys, patients.formularyOphtalmologistys);
    }

}
