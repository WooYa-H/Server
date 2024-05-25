package com.example.GP.dto.excel;

import com.example.GP.domain.excel.Crop;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExcelDTO {

    private String month;

    private String item;

    private String name;

    private String accidentNumber;

    private String securitiesNumber;

    private String targetNumber;

    private String date;

    private String investigator;

    private String contractor;

    public ExcelDTO(Crop crop) {
        this.month = crop.getSurveyMonth();
        this.item = crop.getItem();
        this.name = crop.getName();
        this.accidentNumber = crop.getAccidentNumber();
        this.securitiesNumber = crop.getSecuritiesNumber();
        this.targetNumber = crop.getTargetNumber();
        this.date = crop.getDate();
        this.investigator = crop.getInvestigator();
        this.contractor = crop.getContractor();
    }
}
