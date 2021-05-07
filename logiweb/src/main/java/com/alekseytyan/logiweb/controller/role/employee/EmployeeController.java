package com.alekseytyan.logiweb.controller.role.employee;

import com.alekseytyan.logiweb.entity.Driver;
import com.alekseytyan.logiweb.entity.Lorry;
import com.alekseytyan.logiweb.service.api.CityService;
import com.alekseytyan.logiweb.service.api.DriverService;
import com.alekseytyan.logiweb.service.api.LorryService;
import com.alekseytyan.logiweb.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final OrderService orderService;
    private final LorryService lorryService;
    private final DriverService driverService;
    private final CityService cityService;

    @Autowired
    public EmployeeController(OrderService orderService,
                              LorryService lorryService,
                              DriverService driverService,
                              CityService cityService) {
        this.orderService = orderService;
        this.lorryService = lorryService;
        this.driverService = driverService;
        this.cityService = cityService;
    }

    @ModelAttribute("cities")
    public List<String> cityNames() {
        return cityService.findAllNames();
    }

    @GetMapping(path = "/orders")
    public String showOrders(Model model) {

        model.addAttribute("orders", orderService.findVerified());
        model.addAttribute("routeList", orderService.calculateRoute(orderService.findVerified()));

        return "role/employee/order/orders";
    }

    @GetMapping(path = "/lorries")
    public String showLorries(Model model) {

        model.addAttribute("lorries", lorryService.findAll());
        model.addAttribute("newLorry", new Lorry());

        return "role/employee/lorry/lorries";
    }

    @GetMapping(path = "/drivers")
    public String showDrivers(Model model) {

        model.addAttribute("drivers", driverService.findAll());
        model.addAttribute("newDriver", new Driver());

        return "role/employee/driver/drivers";
    }

}
