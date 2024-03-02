package br.com.tivit.mvpsaude.dto.model;

import br.com.tivit.mvpsaude.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonDTO {
    protected UUID id;
    protected String name;
    protected String document;
    protected Set<String> phones;
    protected String email;

    protected PersonDTO(Person model) {
        this.id = model.getId();
        this.document = model.getDocument();
        this.phones = model.getPhones();
        this.email = model.getEmail();
    }

}