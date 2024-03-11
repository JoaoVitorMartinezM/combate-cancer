package br.com.tivit.mvpsaude.service.implementation;


import br.com.tivit.mvpsaude.dto.FieldDTO;
import br.com.tivit.mvpsaude.model.Field;
import br.com.tivit.mvpsaude.repository.FieldRepository;
import br.com.tivit.mvpsaude.service.contract.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FieldServiceImpl implements FieldService {

    private final FieldRepository repository;

    public List<FieldDTO> getFieldsByFieldName(String fieldname) {
        return repository.findByFieldName(fieldname).stream().map(FieldDTO::new).toList();

    }

    @Override
    public Boolean register(FieldDTO dto) {
        if (dto.getLabel() != null){
            repository.save(new Field(dto));

        } else {
            dto.getColectLabels().forEach(el -> repository.save(new Field(dto.getFieldName(), el, dto.getIsActive())));
        }
        return Boolean.TRUE;
    }
}
