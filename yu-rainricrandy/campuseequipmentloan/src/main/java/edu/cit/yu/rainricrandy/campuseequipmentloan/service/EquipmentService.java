package edu.cit.yu.rainricrandy.campuseequipmentloan.service;

import edu.cit.yu.rainricrandy.campuseequipmentloan.model.Equipment;
import edu.cit.yu.rainricrandy.campuseequipmentloan.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment createEquipment(String name, String type, String serialNumber) {
        Equipment equipment = new Equipment();
        equipment.setName(name);
        equipment.setType(type);
        equipment.setSerialNumber(serialNumber);
        equipment.setAvailability(true);
        return equipmentRepository.save(equipment);
    }
}