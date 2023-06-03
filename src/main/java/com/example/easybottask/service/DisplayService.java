package com.example.easybottask.service;

import com.example.easybottask.exception.MyArgumentException;
import com.example.easybottask.model.Display;
import com.example.easybottask.repository.DisplayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayService extends BaseService<Display> {
    public DisplayService(DisplayRepository displayRepository) {
        super(displayRepository);
    }

    public Display addDisplay(Display display) throws MyArgumentException {
        return super.add(display);
    }

    public Display updateDisplay(Long id, Display display) throws MyArgumentException {
        Display result = get(id);
        result.setSize(display.getSize());
        return super.update(id, result);
    }

    public List<Display> getAllDisplays() {
        return super.getAll();
    }

    public Display getDisplay(Long id) {
        return super.get(id);
    }
}
