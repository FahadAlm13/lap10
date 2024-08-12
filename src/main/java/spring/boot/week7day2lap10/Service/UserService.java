package spring.boot.week7day2lap10.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.week7day2lap10.Model.User;
import spring.boot.week7day2lap10.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(User user, Integer id) {
        User u = userRepository.findById(id).orElse(null);
        if (u == null) {
            return false;
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        userRepository.save(u);
        return true;
    }

    public boolean deleteUser(Integer id) {
        User u = userRepository.findById(id).orElse(null);
        if (u == null) {
            return false;
        }
        userRepository.delete(u);
        return true;
    }
}
