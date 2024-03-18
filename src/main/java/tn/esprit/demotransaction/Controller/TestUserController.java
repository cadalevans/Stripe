package tn.esprit.demotransaction.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demotransaction.Config.LoginResponse;
import tn.esprit.demotransaction.Entity.LoginRequest;
import tn.esprit.demotransaction.Entity.TestUser;
import tn.esprit.demotransaction.Repository.UserRepository;
import tn.esprit.demotransaction.Service.TestUserService;
import tn.esprit.demotransaction.model.EmailAlreadyExistsException;
import tn.esprit.demotransaction.model.JsonReponse;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TestUserController {
    @Autowired
    private TestUserService testUserService;

    @Autowired
    private UserRepository repository;
/*
    @PostMapping("/users")
    public ResponseEntity<TestUser> createUserWithTransaction(@RequestBody UserTransactionDto userTransactionDto) {
        TestUser user = testUserService.createUserTrans(userTransactionDto);
        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).body(user);
    }

 */

    @PostMapping("/adduser")
    public ResponseEntity<JsonReponse> save(@RequestBody TestUser user) {
        try {
            TestUser savedUser = testUserService.save(user);
            return ResponseEntity.ok().body(new JsonReponse(true,"User created successfully"));
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new JsonReponse(false,"Email address already exists"));
        }
    }
    @GetMapping("/getall")
    public List<TestUser> getall(){
        return testUserService.getAll();
    }

    @GetMapping("/get/{id}")
    public TestUser getById(@PathVariable("id") int userId){
        return testUserService.getById(userId);
    }
    @PutMapping("/put/{id}")
    public TestUser modify(@RequestBody TestUser user){
        return testUserService.modify(user);
    }
    @DeleteMapping("/del/{userId}")
    public String deluser(@PathVariable("userId") int userId){
    return testUserService.deleteById(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        TestUser user = repository.findByEmail(loginRequest.getEmail());
        LoginResponse response = new LoginResponse();

        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // Successful login
            response.setSuccess(true);
            response.setMessage("Login successful");
            return ResponseEntity.ok(response);
        } else {
            // Failed login
            response.setSuccess(false);
            response.setMessage("Wrong email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
