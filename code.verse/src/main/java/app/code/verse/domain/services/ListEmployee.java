package app.code.verse.domain.services;

import app.code.verse.domain.model.Employee;

public class ListEmployee {
    private FindEmployee findEmployee;

    public Employee consult(String idNumber) {
        return findEmployee.findById(idNumber);
    }
}
