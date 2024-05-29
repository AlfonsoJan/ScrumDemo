package nl.woensdag.janbusker.view;

import nl.woensdag.janbusker.model.Schip;
import nl.woensdag.janbusker.service.SchipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SchipEndpoint {
    @Autowired
    SchipService schipService;

    @RequestMapping(value = "/saveschip", method = RequestMethod.POST)
    public void process(@RequestBody Schip schip) {
        schipService.saveSchip(schip);
    }

    @RequestMapping(value = "/allship", method = RequestMethod.POST)
    public Iterable<Schip> getAllShip() {
        return schipService.allShips();
    }
}
