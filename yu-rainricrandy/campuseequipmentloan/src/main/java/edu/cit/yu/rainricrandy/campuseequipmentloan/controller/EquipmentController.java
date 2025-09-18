package edu.cit.yu.rainricrandy.campuseequipmentloan.controller;

import edu.cit.yu.rainricrandy.campuseequipmentloan.DTO.EquipmentDTO;
import edu.cit.yu.rainricrandy.campuseequipmentloan.model.Equipment;
import edu.cit.yu.rainricrandy.campuseequipmentloan.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipment> createEquipment(@Valid @RequestBody EquipmentDTO equipmentDto) {
        Equipment equipment = equipmentService.createEquipment(
                equipmentDto.getName(),
                equipmentDto.getType(),
                equipmentDto.getSerialNumber()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(equipment);
    }
}