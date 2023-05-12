package com.springdemo.controller;

import com.springdemo.dao.UserLoginRequest;
import com.springdemo.dao.UserRegistrationRequest;
import javax.security.sasl.AuthenticationException;
import javax.validation.Valid;
import com.springdemo.service.AuthenticationService;
import com.springdemo.service.RegistrationService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class HelloWorldController {

    private final AuthenticationService authenticationService;

    private final RegistrationService registrationService;

    public HelloWorldController(AuthenticationService authenticationService,
                                RegistrationService registrationService) {
        this.authenticationService = authenticationService;
        this.registrationService = registrationService;
    }

    @RequestMapping("/login")
    public String login(Model model){
        UserLoginRequest loginRequest = new UserLoginRequest();
        model.addAttribute("loginRequest", loginRequest);
        return "login-form";
    }

    @RequestMapping("/processLogin")
    public String processLogin(@Valid @ModelAttribute("loginRequest")UserLoginRequest loginRequest,
                               BindingResult bindingResult) throws URISyntaxException, IOException, InterruptedException {
        if(bindingResult.hasErrors()){
            return "login-form";
        }
        try {
            authenticationService.submitAuthenticationRequest(loginRequest);
        }catch (AuthenticationException ex){
            return "error-logging-in";
        }
        return "helloworld";
    }

    @RequestMapping("/register")
    public String registerUser(Model model){
        UserRegistrationRequest userRegistration = new UserRegistrationRequest();
        model.addAttribute("userRegistration", userRegistration);
        return "registration-form";
    }

    @RequestMapping("/processRegistration")
    public String confirmRegistration(@Valid @ModelAttribute("userRegistration") UserRegistrationRequest userRegistration,
                                        BindingResult bindingResult) throws IOException, InterruptedException {
        if(bindingResult.hasErrors()){
            return "registration-form";
        }
        try{
            registrationService.submitRegistrationRequest(userRegistration);
        }catch(DataIntegrityViolationException ex){
            return "error-registering";
        }
        return "registration-confirmation";
    }


}
