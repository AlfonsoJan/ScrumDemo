package nl.woensdag.janbusker.view;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userstories")
public class UserStoryEndpoint {
    @GetMapping(value = "/")
    public void getAll() {

    }

    @GetMapping(value = "/{id}")
    public void getById(@PathVariable("id") String id) {

    }
}
