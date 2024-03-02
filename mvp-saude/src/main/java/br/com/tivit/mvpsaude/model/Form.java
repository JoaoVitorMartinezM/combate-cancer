package br.com.tivit.mvpsaude.model;

import br.com.tivit.mvpsaude.dto.model.FormDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Form {

    @Id
    private Long id;
    private LocalDateTime date;
    private String fullName;
    private String email;
    private String sex;
    private LocalDate birthday;
    private String diseases;
    private Boolean smoke;
    private Boolean quitSmoke;
    private Boolean drink;
    private Boolean drinkRarely;
    private Boolean haveCancer;
    private Boolean cancerHistory;
    private Boolean wentDentist;
    private Boolean sunscreen;
    private Boolean consumeMate;
    private Boolean sunstroke;
    private Boolean skinLesion;

    public Form(FormDTO dto) {
        this.date = dto.getDate();
        this.fullName = dto.getFullName();
        this.email = dto.getEmail();
        this.sex = dto.getSex();
        this.birthday = dto.getBirthday();
        this.diseases = dto.getDiseases();
        this.smoke = dto.getSmoke();
        this.quitSmoke = dto.getQuitSmoke();
        this.drink = dto.getDrink();
        this.drinkRarely = dto.getDrinkRarely();
        this.haveCancer = dto.getHaveCancer();
        this.cancerHistory = dto.getCancerHistory();
        this.wentDentist = dto.getWentDentist();
        this.sunscreen = dto.getSunscreen();
        this.consumeMate = dto.getConsumeMate();
        this.sunstroke = dto.getSunstroke();
        this.skinLesion = dto.getSkinLesion();
    }

}
