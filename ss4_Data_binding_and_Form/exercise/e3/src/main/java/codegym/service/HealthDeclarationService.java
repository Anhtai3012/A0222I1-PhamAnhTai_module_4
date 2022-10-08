package codegym.service;

import codegym.model.HealthDeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HealthDeclarationService {
    private List<HealthDeclaration> healthDeclarations = new ArrayList<>();

    public List<HealthDeclaration> findAll(){
        return healthDeclarations;
    }

    public void save(HealthDeclaration healthDeclaration){
        healthDeclarations.add(healthDeclaration);
    }

    public Optional<HealthDeclaration> findById(int id){
        return healthDeclarations.stream().filter(e -> e.getId() == id).findFirst();
    }
}
