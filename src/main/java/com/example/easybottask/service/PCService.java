package com.example.easybottask.service;

import com.example.easybottask.exception.MyArgumentException;
import com.example.easybottask.model.PC;
import com.example.easybottask.repository.PCRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PCService extends BaseService<PC> {
    public PCService(PCRepository pcRepository) {
        super(pcRepository);
    }

    public PC addPC(PC pc) throws MyArgumentException {
        if (!validType(pc)) {
            log.warn("IN addPC : type {} is wrong. Only DESKTOP, MONOBLOCK or NETTOP are allowed", pc.getType());
            throw new MyArgumentException("Field 'type' can only be DESKTOP, MONOBLOCK or NETTOP");
        }
        return super.add(pc);
    }

    public PC updatePC(Long id, PC pc) throws MyArgumentException {
        PC result = getPC(id);
        if (!validType(pc)) {
            log.warn("IN updatePC: type {} is wrong. Only DESKTOP, MONOBLOCK or NETTOP are allowed", pc.getType());
            throw new MyArgumentException("Field 'type' can only be DESKTOP, MONOBLOCK or NETTOP");
        }
        result.setType(pc.getType());
        return super.update(id, pc);
    }

    public List<PC> getAllPC() {
        return super.getAll();
    }

    public PC getPC(Long id) {
        return super.get(id);
    }

    private boolean validType(PC pc) {
        return pc.getType().equals("DESKTOP")
                || pc.getType().equals("NETTOP")
                || pc.getType().equals("MONOBLOCK");
    }
}
