package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rc.bootsecurity.model.forms.SignupViewModel;
import rc.bootsecurity.model.User;
import rc.bootsecurity.repo.UserRepository;
import rc.bootsecurity.security.jwt.JwtProvider;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthRestApis {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignupViewModel signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), passwordEncoder.encode(signUpRequest.getPassword()),
                signUpRequest.getName(), signUpRequest.getRole(), signUpRequest.getPermission());

        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }

}
