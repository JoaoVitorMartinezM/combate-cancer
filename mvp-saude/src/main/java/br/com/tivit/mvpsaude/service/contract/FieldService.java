package br.com.tivit.mvpsaude.service.contract;

import br.com.tivit.mvpsaude.dto.FieldDTO;

import java.util.List;

public interface FieldService {

    List<FieldDTO> getFieldsByFieldName(String fieldName);

    Boolean register(FieldDTO dto);
}
