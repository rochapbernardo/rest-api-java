package java_ws.rest.crud.server.service;

import jakarta.transaction.Transactional;
import java_ws.rest.crud.server.entity.User;
import java_ws.rest.crud.server.exception.ResourceNotFoundException;
import java_ws.rest.crud.server.repository.UserRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;


    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        if (user.getNome() == null || user.getNome().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (user.getCpf() == null || user.getCpf().isBlank()) {
            throw new IllegalArgumentException("CPF is required");
        }
        return repository.save(user);
    }

    public Optional<User> findById(int id) {
        return repository.findById(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional
    public User update(int id, User newUser) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Update not performed, user not found by ID"));

        if (newUser.getNome() != null && !newUser.getNome().isBlank()) {
            user.setNome(newUser.getNome());
        }
        if (newUser.getEmail() != null && !newUser.getEmail().isBlank()) {
            user.setEmail(newUser.getEmail());
        }
        if (newUser.getDt_nascimento() != null && !newUser.getDt_nascimento().isBlank()) {
            user.setDt_nascimento(newUser.getDt_nascimento());
        }
        if (newUser.getCpf() != null && !newUser.getCpf().isBlank()) {
            user.setCpf(newUser.getCpf());
        }
        return repository.save(user);

    }

    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("User not found by ID");
        }
        repository.deleteById(id);
    }
}
