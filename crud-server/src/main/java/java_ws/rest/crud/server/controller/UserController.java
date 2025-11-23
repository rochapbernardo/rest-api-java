package java_ws.rest.crud.server.controller;

import java_ws.rest.crud.server.entity.User;
import java_ws.rest.crud.server.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @GetMapping
    public List<User> list(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable int id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User created = service.create(user);
        return ResponseEntity.status(201).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user){
        User update = service.update(id, user);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
