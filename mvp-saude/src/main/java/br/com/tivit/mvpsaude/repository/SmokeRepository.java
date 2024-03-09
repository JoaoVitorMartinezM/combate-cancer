package br.com.tivit.mvpsaude.repository;

import br.com.tivit.mvpsaude.model.Smoke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmokeRepository extends JpaRepository<Smoke, Long> {
}
