package br.com.tivit.mvpsaude.model;


import br.com.tivit.mvpsaude.dto.FieldDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Field {

    @Id
    @GeneratedValue
    private Long id;
    private String fieldName;
    private String label;
    private Boolean isActive;

    public Field(FieldDTO dto) {
        this.fieldName = dto.getFieldName();
        this.label = dto.getLabel();
        this.isActive = dto.getIsActive();
    }

    public Field(String fieldName, String label, Boolean isActive) {
        this.fieldName = fieldName;
        this.label = label;
        this.isActive = isActive;
    }
}
