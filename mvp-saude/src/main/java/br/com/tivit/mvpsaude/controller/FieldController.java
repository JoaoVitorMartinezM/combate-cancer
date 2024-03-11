package br.com.tivit.mvpsaude.controller;


import br.com.tivit.mvpsaude.dto.FieldDTO;
import br.com.tivit.mvpsaude.service.contract.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("fields")
public class FieldController {

    private final FieldService service;

    @GetMapping("{fieldName}")
    public ResponseEntity<List<FieldDTO>> queryFields(@PathVariable String fieldName){
        return ResponseEntity.ok(service.getFieldsByFieldName(fieldName));
    }

    @PostMapping
    public ResponseEntity<Boolean> register(@RequestBody FieldDTO dto){
        System.out.println(dto);
        return ResponseEntity.ok(service.register(dto));
    }


}
