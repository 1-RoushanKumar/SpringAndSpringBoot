package com.rOushAn.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add an InitBinder ... to convert or trim input strings
    // remove leading and trailing whitespace
    // resolve the issue for our validation, which is if I pass only space in last name, it's passing the condition not showing error.
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // Create a StringTrimmerEditor instance to trim leading and trailing whitespaces
        // true indicates that empty strings should be converted to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        // Register the custom editor for String class to apply trimming to all string inputs
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    // it will remove the leading and trailing whitespace, and if we added only space,
    // then it will show null which represents there is nothing in lastName.

    /**
     * Displays the form to the user.
     *
     * @param theModel The model object used to pass data to the view.
     * @return The name of the view template "customer-form".
     */
    @GetMapping("/{showForm}")
    public String showForm(Model theModel) {
        // Add a new Customer object to the model to bind form data
        theModel.addAttribute("customer", new Customer());
        return "customer-form"; // Return the view for displaying the form
    }

    /**
     * Processes the submitted form.
     *
     * @param theCustomer The Customer object populated with form data.
     * @param theBindingResult Holds the result of validation and binding and contains errors if any.
     * @return The name of the view template to display next.
     */
    @PostMapping("/{processForm}")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer, // Perform validation on the Customer object
            BindingResult theBindingResult) { // Holds validation errors if they occur

        // Debugging output to check the value of lastName after processing
        System.out.println("Last name: |" + theCustomer.getLastName() + "|");

        System.out.println("Binding result:"+theBindingResult);
        System.out.println();

        // Check if there are validation errors
        if (theBindingResult.hasErrors()) {
            // If errors exist, return the user to the form view
            return "customer-form";
        }  else {
            // If no errors, proceed to the confirmation view
            return "customer-confirmation";
        }
    }
}
