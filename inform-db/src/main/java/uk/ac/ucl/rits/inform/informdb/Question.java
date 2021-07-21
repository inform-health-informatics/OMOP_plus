package uk.ac.ucl.rits.inform.informdb;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Questions.
 * @author Stef Piatek
 */
@Entity
@Table
@Data
@SuppressWarnings("serial")
public class Question  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionId;

    @Column(columnDefinition = "text")
    private String question;

    public Question() {
    }

    public Question(String question) {
        this.question = question;
    }
}
