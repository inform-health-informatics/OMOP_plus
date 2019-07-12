package uk.ac.ucl.rits.inform.informdb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This represents a grouper for a fact about a patient.
 *
 * @author UCL RITS
 *
 */
@Entity
@JsonIgnoreProperties("encounter")
public class PatientFact extends Fact<PatientFact, PatientProperty> implements Serializable {

    private static final long serialVersionUID = -5867434510066589366L;

    @ManyToOne
    @JoinColumn(name = "encounter", referencedColumnName = "encounter")
    private Encounter         encounter;

    /**
     * @return the encounter
     */
    public Encounter getEncounter() {
        return encounter;
    }

    /**
     * @param encounter the encounter to set
     */
    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    @Override
    public void addProperty(PatientProperty prop) {
        super.addProperty(prop, this);
    }

    @Override
    public String toString() {
        return this.getFactType().getShortName();
    }

}