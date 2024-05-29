package nl.woensdag.janbusker.service;

import nl.woensdag.janbusker.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStoryService {
    @Autowired
    UserStoryRepository userStoryRepository;

    public void voorbeeld() {
        System.out.println("Dit doet nog niks");
    }
}
