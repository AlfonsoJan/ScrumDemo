package nl.woensdag.janbusker.view;

import nl.woensdag.janbusker.model.Schip;
import nl.woensdag.janbusker.service.SchipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FelixEndpoint {

    @Autowired
    SchipService schipService;

    @GetMapping("alleschepen")
    public Iterable<Schip> alleSchepen(){
        return schipService.allShips();
    }
}
