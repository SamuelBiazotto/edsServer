package br.com.eds.Application.model;

import br.com.eds.Application.model.enumModel.FormularyOphtalmologistyStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class FormularyOphtalmologisty extends AbstractEntity{

    @Column(columnDefinition="TEXT")
    private String visualAcuity;

    @Column(columnDefinition="TEXT")
    private String refraction;

    @Column(columnDefinition="TEXT")
    private String biomicroscopy;

    @Column(columnDefinition="TEXT")
    private String fundoscopy;

    @Column(columnDefinition="TEXT")
    private String diagnosticHypothesis;

    @Column(columnDefinition="TEXT")
    private String condute;

    @Column(columnDefinition="TEXT")
    private String observation;

    @Column(name = "patient_id")
    private Long patientId;
//    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patients patient;
    
    private Boolean deleted;

    private Integer status;


    public FormularyOphtalmologistyStatus getFormularyOphtalmologistyStatus() {
        return FormularyOphtalmologistyStatus.toEnum(status);
    }

    public void setFormularyOphtalmologistyStatus(FormularyOphtalmologistyStatus status) {
        this.status = status.getCode();
    }

    public String getVisualAcuity() {
        return visualAcuity;
    }

    public void setVisualAcuity(String visualAcuity) {
        this.visualAcuity = visualAcuity;
    }

    public String getRefraction() {
        return refraction;
    }

    public void setRefraction(String refraction) {
        this.refraction = refraction;
    }

    public String getBiomicroscopy() {
        return biomicroscopy;
    }

    public void setBiomicroscopy(String biomicroscopy) {
        this.biomicroscopy = biomicroscopy;
    }

    public String getFundoscopy() {
        return fundoscopy;
    }

    public void setFundoscopy(String fundoscopy) {
        this.fundoscopy = fundoscopy;
    }

    public String getDiagnosticHypothesis() {
        return diagnosticHypothesis;
    }

    public void setDiagnosticHypothesis(String diagnosticHypothesis) {
        this.diagnosticHypothesis = diagnosticHypothesis;
    }

    public String getCondute() {
        return condute;
    }

    public void setCondute(String condute) {
        this.condute = condute;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "FormularyOphtalmologisty{" +
                "visualAcuity='" + visualAcuity + '\'' +
                ", refraction='" + refraction + '\'' +
                ", biomicroscopy='" + biomicroscopy + '\'' +
                ", fundoscopy='" + fundoscopy + '\'' +
                ", diagnosticHypothesis='" + diagnosticHypothesis + '\'' +
                ", condute='" + condute + '\'' +
                ", observation='" + observation + '\'' +
                ", patientId=" + patientId +
                ", patient=" + patient +
                ", deleted=" + deleted +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FormularyOphtalmologisty that = (FormularyOphtalmologisty) o;
        return Objects.equals(visualAcuity, that.visualAcuity) &&
                Objects.equals(refraction, that.refraction) &&
                Objects.equals(biomicroscopy, that.biomicroscopy) &&
                Objects.equals(fundoscopy, that.fundoscopy) &&
                Objects.equals(diagnosticHypothesis, that.diagnosticHypothesis) &&
                Objects.equals(condute, that.condute) &&
                Objects.equals(observation, that.observation) &&
                Objects.equals(patientId, that.patientId) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(status, that.status);
    }
}
