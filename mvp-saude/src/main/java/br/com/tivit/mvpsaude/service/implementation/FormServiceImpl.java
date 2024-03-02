package br.com.tivit.mvpsaude.service.implementation;


import br.com.tivit.mvpsaude.dto.model.FormDTO;
import br.com.tivit.mvpsaude.model.Form;
import br.com.tivit.mvpsaude.repository.FormRepository;
import br.com.tivit.mvpsaude.service.contract.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FormServiceImpl implements FormService {

    private final FormRepository repository;


    @Override
    public Boolean register(FormDTO dto) {
        Form form = new Form(dto);
        form.setDate(LocalDateTime.now());
        repository.save(form);
        return Boolean.TRUE;
    }

    public List<FormDTO> findALl(){
        return repository.findAll().stream().map(FormDTO::new).toList();
    }
}
