package br.com.tivit.mvpsaude.dto;


import br.com.tivit.mvpsaude.model.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldDTO {

    private String fieldName;
    private String label;
    private List<String> colectLabels;
    private Boolean isActive = Boolean.TRUE;

    public FieldDTO(Field model) {
        this.fieldName = model.getFieldName();
        this.label = model.getLabel();
        this.isActive = model.getIsActive();
    }
}
