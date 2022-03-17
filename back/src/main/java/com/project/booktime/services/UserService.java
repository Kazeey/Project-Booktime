package com.project.booktime.services;

import com.project.booktime.exception.UserNotFoundException;
import com.project.booktime.model.dto.BookDTO;
import com.project.booktime.model.dto.UserDTO;
import com.project.booktime.model.entity.User;
import com.project.booktime.model.helper.UserHelper;
import com.project.booktime.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService {

    private final IUserRepository repository;
    private final BookService bookService;

    public UserService(IUserRepository repository, BookService bookService) {
        this.repository = repository;
        this.bookService = bookService;
    }

    private UserDTO createUserDTO(User user) {
        UserDTO userDTO = UserHelper.convert(user);

        List<BookDTO> addedDTOList = bookService.findBookListById(user.getLibrary());
        List<BookDTO> likedDTOList = bookService.findBookListById(user.getLiked());

        userDTO.setLibrary(addedDTOList);
        userDTO.setLiked(likedDTOList);

        return userDTO;
    }

    public UserDTO findMe(String id) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty()) throw new UserNotFoundException();

        return createUserDTO(user.get());
    }

    public List<UserDTO> findAll() {
        List<User> userList = repository.findAll();

        return UserHelper.convertAll(userList);
    }

    public UserDTO findById(String id) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty()) throw new UserNotFoundException();

        return createUserDTO(user.get());
    }

    public UserDTO add(User user) {
        User createdUser = repository.insert(user);

        return createUserDTO(createdUser);
    }

    public UserDTO update(String id, User user) {
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isEmpty()) throw new UserNotFoundException();

        User updatedUser = repository.save(user);

        return createUserDTO(updatedUser);
    }

    public void delete(String id) {
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isEmpty()) throw new UserNotFoundException();

        repository.delete(optionalUser.get());
    }
}
