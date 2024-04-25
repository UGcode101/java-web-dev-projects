package org.launchcode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("controller")
public class HelloController {

    @GetMapping
    public String greetingForm() {
        return "<html>" +
                "<body>" +
                "<h1>Greeting Form</h1>" +
                "<form action='/hello' method='post'>" +
                "<label for='name'>Name:</label>" +
                "<input type='text' id='name' name='name'><br>" +
                "<label for='language'>Language:</label>" +
                "<select name='language'>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "</select><br>" +
                "<input type='submit' value='Greet'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    // Method to handle the POST request and respond with a greeting
    @PostMapping
    @ResponseBody
    public String helloPost(@RequestParam(defaultValue = "World") String name, @RequestParam String language) {
        return createMessage(name, language);
    }

    // Helper method to create the greeting message based on the language
    public static String createMessage(String name, String language) {
        switch (language.toLowerCase()) {
            case "english": return "Hello " + name;
            case "french": return "Bonjour " + name;
            case "italian": return "Buongiorno " + name;
            case "spanish": return "Hola " + name;
            case "german": return "Hallo " + name;
            default: return "Hello " + name; // Default case to handle unexpected input
        }
    }
}