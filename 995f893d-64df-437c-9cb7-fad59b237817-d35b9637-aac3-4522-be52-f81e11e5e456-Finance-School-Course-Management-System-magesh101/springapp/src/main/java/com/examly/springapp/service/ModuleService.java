package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Module;

public interface ModuleService {
    Module saveModule(Module module);
    List<Module> getAllModules();
    Module getModuleById(Long id);
}
