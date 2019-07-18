package com.jy.springboot_customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
public class HomeController {

    @Autowired
    private CustomerRepository customerRepository;
    private CompanyRepository companyRepository;


    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("customers", customerRepository.findAll());
//        String lastname = "Smith";
//        String companyname = "ABC Markets";
//        model.addAttribute("customers",customerRepository.findByLastname(lastname));
//        model.addAttribute("companys",companyRepository.findByCompany(companyname));
        return "index";
    }

    @RequestMapping("/loadform")
    public String loadFormPage() {
        return "form";
    }

    @PostMapping("/process")
    public String processForm(@RequestParam(value = "title",required=false) String title,
                              @RequestParam(value = "firstname",required=false) String firstname,
                              @RequestParam(value = "lastname",required=false) String lastname,
                              @RequestParam(value = "city",required=false) String city,
                              @RequestParam(value = "state",required=false) String state,
                              @RequestParam(value = "zipcode",required=false) String zipcode,
                              @RequestParam(value = "id",required=false) String id, Model model) {
        if(title != null)
        {
            model.addAttribute("customers", customerRepository.findByTitle(title));
        }
        else if(firstname != null)
        {
            model.addAttribute("customers", customerRepository.findByFirstname(firstname));
        }
        else if(lastname != null)
        {
            model.addAttribute("customers", customerRepository.findByLastname(lastname));
        }
        else if(city != null)
        {
            model.addAttribute("customers", customerRepository.findByCity(city));
        }
        else if(state != null)
        {
            model.addAttribute("customers", customerRepository.findByState(state));
        }
        else if(zipcode != null)
        {
            model.addAttribute("customers", customerRepository.findByZipcode(zipcode));
        }

        return "confirm";
    }
}
