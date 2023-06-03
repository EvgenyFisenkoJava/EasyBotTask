package com.example.easybottask.service;

import com.example.easybottask.exception.MyArgumentException;
import com.example.easybottask.model.Laptop;
import com.example.easybottask.repository.LaptopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LaptopService extends BaseService<Laptop> {
    public LaptopService(LaptopRepository laptopRepository) {
        super(laptopRepository);
    }

    public Laptop addLaptop(Laptop laptop) throws MyArgumentException {
        if (!validSize(laptop)) {
            log.warn("IN addLaptop: the size {} inches is wrong. Only 13, 14, 15 or 17 allowed ", laptop.getSize());
            throw new MyArgumentException("The size should be 13, 14, 15 or 17");
        }
        return super.add(laptop);
    }

    public Laptop updateLaptop(Long id, Laptop laptop) throws MyArgumentException {
        Laptop result = getLaptop(id);
        if (!validSize(laptop)) {
            log.warn("IN updateLaptop: the size {} inches is wrong. Only 13, 14, 15 or 17 allowed ", laptop.getSize());
            throw new MyArgumentException("The size should be 13, 14, 15 or 17");
        }
        result.setSize(laptop.getSize());
        return super.update(id, laptop);
    }

    public List<Laptop> getAllLaptops() {
        return super.getAll();
    }

    public Laptop getLaptop(Long id) {
        return super.get(id);
    }

    private boolean validSize(Laptop laptop) {
        return laptop.getSize() == 13
                || laptop.getSize() == 14
                || laptop.getSize() == 15
                || laptop.getSize() == 17;
    }
}

