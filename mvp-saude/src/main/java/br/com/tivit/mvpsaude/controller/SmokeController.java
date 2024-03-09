package br.com.tivit.mvpsaude.controller;


import br.com.tivit.mvpsaude.model.Smoke;
import br.com.tivit.mvpsaude.repository.SmokeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/smoke")
public class SmokeController {

    private final SmokeRepository smokeRepository;



    @PostMapping
    public ResponseEntity<Boolean> register (@RequestBody String request){
        Smoke model = new Smoke();
        model.setLabel(request);
        smokeRepository.save(model);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping
    public  ResponseEntity<List<Smoke>> getSmoke() {
        return ResponseEntity.ok(smokeRepository.findAll());
    }
}
