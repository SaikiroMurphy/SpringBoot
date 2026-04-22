package session13.session13.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v2")
public class AdminController {
    @GetMapping("/admin/test")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminTest() {
        return "Hello Admin";
    }

    @GetMapping("/user/test")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String getUserTest() {
        return "Hello User";
    }

    @GetMapping("/manager/test")
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    public String getManagerTest() {
        return "Hello Manager";
    }
}
