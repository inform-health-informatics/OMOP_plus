package uk.ac.ucl.rits.inform.informdb.labs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.ac.ucl.rits.inform.informdb.AuditCore;
import uk.ac.ucl.rits.inform.informdb.TemporalCore;
import uk.ac.ucl.rits.inform.informdb.annotation.AuditTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

/**
 * A LabResult is a single component result of a lab. A single order or sample
 * is likely to produce several results.
 * @author Roma Klapaukh
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AuditTable
public class LabResult extends TemporalCore<LabResult, AuditCore> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long labResultId;
    private long labResultDurableId;

    private long labNumberId;
    private long labTestDefinitionDurableId;

    @Column(columnDefinition = "timestamp with time zone")
    private Instant resultLastModifiedTime;

    private boolean abnormal;
    private String resultAsText;
    private double resultAsReal;

    private String resultOperator;
    private double rangeHigh;
    private double rangeLow;

    private String comment;

    public LabResult() {}

    public LabResult(LabResult other) {
        super(other);

        this.labResultDurableId = other.labResultDurableId;
        this.labNumberId = other.labNumberId;
        this.labTestDefinitionDurableId = other.labTestDefinitionDurableId;
        this.resultLastModifiedTime = other.resultLastModifiedTime;
        this.abnormal = other.abnormal;
        this.resultAsText = other.resultAsText;
        this.resultAsReal = other.resultAsReal;
        this.resultOperator = other.resultOperator;
        this.rangeHigh = other.rangeHigh;
        this.rangeLow = other.rangeLow;
        this.comment = other.comment;
    }

    @Override
    public LabResult copy() {
        return new LabResult(this);
    }

    @Override
    public AuditCore createAuditEntity(Instant validUntil, Instant storedUntil) {
        throw new UnsupportedOperationException();
    }
}
