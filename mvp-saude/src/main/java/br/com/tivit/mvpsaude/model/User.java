package br.com.tivit.mvpsaude.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity(name = "tb_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    private String username;
    private String email;
    @ElementCollection
    private Set<String> roles;
    @Column(columnDefinition = "text")
    private String password;
    @OneToOne
    private Person pessoa;

}

