package nl.woensdag.janbusker.service;

import nl.woensdag.janbusker.model.Schip;
import nl.woensdag.janbusker.repository.SchipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchipService {

    @Autowired
    SchipRepository schipRepository;

    public void saveSchip(String name, int length, boolean sunken) {
        Schip schip = new Schip();
        schip.setNaam(name);
        schip.setLengte(length);
        schip.setGezonken(sunken);
        schipRepository.save(schip);
        System.out.println("Schip saved");
    }

    public void saveSchip(Schip schip) {
        schipRepository.save(schip);
        System.out.println("Schip saved");
    }

    public Iterable<Schip> allShips() {
        return schipRepository.findAll();
    }
}
