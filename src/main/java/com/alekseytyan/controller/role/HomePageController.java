package com.alekseytyan.controller.role;

import com.alekseytyan.controller.role.exception.NoSuchRoleException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomePageController {

    @RequestMapping(value = "/homePage")
    public String homePage(HttpServletResponse response) throws IOException {

        // TODO get current user role as a string and do redirect

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "role/admin/users";
        } else if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_EMPLOYEE"))) {
            return "role/employee/orders";
        } else if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_DRIVER"))) {
            return "role/driver/driverOrder";
        }

        throw new NoSuchRoleException("Unknown role");
    }
}
