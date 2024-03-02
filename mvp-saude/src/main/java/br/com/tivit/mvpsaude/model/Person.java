package br.com.tivit.mvpsaude.model;

import br.com.tivit.mvpsaude.dto.model.PersonDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    @Id
    @Column(name = "id", nullable = false)
    protected UUID id;
    protected String document;
    protected String name;
    @ElementCollection
    protected Set<String> phones;
    protected String email;
    protected Boolean excluded;

    protected Person(PersonDTO dto) {
        this.id = dto.getId();
        this.document = dto.getDocument();
        this.phones = dto.getPhones();
        this.email = dto.getEmail();
        this.excluded = false;
    }

}