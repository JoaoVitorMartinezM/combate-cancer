package br.com.tivit.mvpsaude.controller;


import br.com.tivit.mvpsaude.dto.model.FormDTO;
import br.com.tivit.mvpsaude.service.contract.FormService;
import br.com.tivit.mvpsaude.service.implementation.FormServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/form")
public class FormController {



    private final FormService service;

    @PostMapping
    ResponseEntity<Boolean> register(FormDTO dto) {
        return ResponseEntity.ok(service.register(dto));
    }



}
