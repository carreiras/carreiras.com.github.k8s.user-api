package carreiras.com.github.k8s.userapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import carreiras.com.github.k8s.dto.user.UserRequest;
import carreiras.com.github.k8s.userapi.entity.User;
import carreiras.com.github.k8s.userapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User create(@RequestBody @Valid UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public User findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @GetMapping("/search")
    public List<User> findByNameContainingIgnoreCase(@RequestParam(required = true) String name) {
        return userService.findByNameContainingIgnoreCase(name);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest) {
        return userService.update(id, userRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
