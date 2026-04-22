package session13.session13.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @GetMapping("/admin/test")
    public String getMethodName() {
        return "Hello Admin";
    }
    
    @GetMapping("/user/test")
    public String getUserTest() {
        return "Hello User";
    }

    @GetMapping("/manager/test")
    public String getManagerTest() {
        return "Hello Manager";
    }
}
