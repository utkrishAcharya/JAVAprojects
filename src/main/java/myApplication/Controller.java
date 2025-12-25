//package myApplication;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class Controller {
//
//    // GET request
//    @GetMapping("/hello")
//    public String hello(
//            @RequestParam(name = "name", required = false, defaultValue = "Guest") String name,
//            @RequestParam(name = "email", required = false, defaultValue = "ram@utkrish.com") String email,
//            @RequestParam(name = "age", required = false, defaultValue = "0") int age
//    ) {
//        return "Name: " + name + "<br>" +
//                "Email: " + email + "<br>" +
//                "Age: " + age;
//    }}

package myApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "age", required = false) String age
    ) {
        try {
            // Validate name
            if (name == null || name.isEmpty()) {
                throw new AppException("Name is required");
            }
            if (!name.matches("[a-zA-Z]+")) {
                throw new AppException("Name should be in letters");
            }

            // Validate age
            if (age == null || age.isEmpty()) {
                throw new AppException("Age is required");
            }
            if (!age.matches("\\d+")) {
                throw new AppException("Age should be in number");
            }
            int ageValue = Integer.parseInt(age);

            // Validate email
            if (email == null || email.isEmpty()) {
                throw new AppException("Email is required");
            }
            if (!email.endsWith("@gmail.com")) {
                throw new AppException("In Email @gmail.com is required");
            }

            return "Name: " + name + "<br>" +
                    "Email: " + email + "<br>" +
                    "Age: " + ageValue;

        } catch (AppException u) {
            // Return  the message
            return u.getMessage();
        }
    }
}
