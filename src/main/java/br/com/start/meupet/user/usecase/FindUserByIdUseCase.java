package br.com.start.meupet.user.usecase;

import br.com.start.meupet.common.exceptions.EntityNotFoundException;
import br.com.start.meupet.user.dto.UserResponseDTO;
import br.com.start.meupet.user.mapper.UserMapper;
import br.com.start.meupet.user.model.User;
import br.com.start.meupet.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class FindUserByIdUseCase {

    private final UserRepository userRepository;

    public FindUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO execute(UUID id) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        log.info("User found: {}", userEntity);
        return UserMapper.userToResponseDTO(userEntity);
    }

}
