package myApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    // GET request
    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "Guest") String name,
            @RequestParam(name = "email", required = false, defaultValue = "ram@utkrish.com") String email,
            @RequestParam(name = "age", required = false, defaultValue = "0") int age
    ) {
        return "Name: " + name + "<br>" +
                "Email: " + email + "<br>" +
                "Age: " + age;
    }}

//    // POST request
//    @PostMapping("/submitUser")
//    public String submitUser(
//            @RequestParam(name = "name", required = false, defaultValue = "Guest") String name,
//            @RequestParam(name = "email", required = false, defaultValue = "utkrishdada@email.com") String email,
//            @RequestParam(name = "age", required = false, defaultValue = "0") int age
//    ) {
//        return "Received POST —<br>" +
//                "Name: " + name + "<br>" +
//                "Email: " + email + "<br>" +
//                "Age: " + age;
//    }
//http://localhost:8080/hello?name=Utkrish&email=utkrish@utk.com&age=20