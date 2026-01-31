package ru.netology.userservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.userservice.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UsersRepository {
    private final Map<Integer, User> userRepository = new ConcurrentHashMap<>();

    public UsersRepository() {
        repoInit();
    }

    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userRepository.get(id));
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(userRepository.values());
    }

    private void repoInit() {
        User user1 = new User(1, "Иван", "Иванов", "г.Москва, ул.Ленина 1", "+79227788990", "ivan@yandex.ru");
        User user2 = new User(2, "Сергей", "Сергеев", "г.Москва, ул.Ленина 1", "+79225566777", "sergey@yandex.ru");
        User user3 = new User(3, "Семен", "Семенов", "г.Москва, ул.Ленина 1", "+79223333334", "semen@andex.ru");
        userRepository.put(1, user1);
        userRepository.put(2, user2);
        userRepository.put(3, user3);

    }
}

