package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Module;
import com.examly.springapp.repository.ModuleRepo;

@Service
public class ModuleServiceImpl implements ModuleService {
    
    @Autowired
    private ModuleRepo moduleRepo;
    
    @Override
    public Module saveModule(Module module) {
        return moduleRepo.save(module);
    }
    
    @Override
    public List<Module> getAllModules() {
        return moduleRepo.findAll();
    }
    
    @Override
    public Module getModuleById(Long id) {
        return moduleRepo.findById(id).orElse(null);
    }
}
