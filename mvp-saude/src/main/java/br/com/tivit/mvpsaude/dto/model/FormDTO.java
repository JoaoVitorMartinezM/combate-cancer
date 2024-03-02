package br.com.tivit.mvpsaude.dto.model;

import br.com.tivit.mvpsaude.model.Form;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class FormDTO {

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

    public FormDTO(Form model) {
        this.date = model.getDate();
        this.fullName = model.getFullName();
        this.email = model.getEmail();
        this.sex = model.getSex();
        this.birthday = model.getBirthday();
        this.diseases = model.getDiseases();
        this.smoke = model.getSmoke();
        this.quitSmoke = model.getQuitSmoke();
        this.drink = model.getDrink();
        this.drinkRarely = model.getDrinkRarely();
        this.haveCancer = model.getHaveCancer();
        this.cancerHistory = model.getCancerHistory();
        this.wentDentist = model.getWentDentist();
        this.sunscreen = model.getSunscreen();
        this.consumeMate = model.getConsumeMate();
        this.sunstroke = model.getSunstroke();
        this.skinLesion = model.getSkinLesion();
    }

}
