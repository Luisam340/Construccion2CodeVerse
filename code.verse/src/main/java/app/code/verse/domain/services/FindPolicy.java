package app.code.verse.domain.services;

import app.code.verse.domain.model.Policy;
import app.code.verse.domain.ports.PolicyPort;

public class FindPolicy {
    private PolicyPort policyPort;


    public Policy findById(String patientIdNumber) {
        return policyPort.findByPatient(patientIdNumber);
    }
}
