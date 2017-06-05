package com.spring.controller;

import com.spring.model.Customer;
import com.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by binlix26 on 4/06/17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //convert trim input strings
    // remove leading and trailing whitespaces
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // true means it can be trim to NULL, if it contains all whitespaces.
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String processFrom(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult result) {
//        System.out.println(theCustomer.toString());

        if (result.hasErrors()) {
            return "customer-form";
        } else {
            System.out.println("\n\n");
            System.out.println(theCustomer.toString());
            System.out.println("\n\n");
            customerService.saveCustomer(theCustomer);
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
        Customer customer = customerService.getCustomer(theId);

        System.out.println("\n\n");
        System.out.println(customer.toString());
        System.out.println("\n\n");

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }

    @PostMapping("/search")
    public String processSearch(@RequestParam("theSearchName") String theSearchName, Model model) {
        List<Customer> customers = customerService.searchCustomers(theSearchName);

        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
