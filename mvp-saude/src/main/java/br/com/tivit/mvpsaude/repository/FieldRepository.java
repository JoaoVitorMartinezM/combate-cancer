package br.com.tivit.mvpsaude.repository;


import br.com.tivit.mvpsaude.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {


    List<Field> findByFieldName(String fieldName);


}
