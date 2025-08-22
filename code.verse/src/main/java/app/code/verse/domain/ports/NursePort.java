package app.code.verse.domain.ports;

import app.code.verse.domain.model.MedicineAdministration;
import app.code.verse.domain.model.VitalSign;

public interface NursePort {
    public void registerVitalSign(VitalSign vitalSign) throws Exception;

    public void registerMedicationAdministration(MedicineAdministration medicineAdministration) throws Exception;
}
