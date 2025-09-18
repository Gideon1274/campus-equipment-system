package edu.cit.yu.rainricrandy.campuseequipmentloan.DTO;

import jakarta.validation.constraints.NotBlank;

public class EquipmentDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotBlank
    private String serialNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}