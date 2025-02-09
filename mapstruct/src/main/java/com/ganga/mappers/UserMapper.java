package com.ganga.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ganga.dto.UserDTO;
import com.ganga.models.User;
import com.ganga.models.User2;

@Mapper(uses = UserprofileMapper.class)
// If you don’t add @Mapper(uses = UserprofileMapper.class), MapStruct will not
// know how to convert profile to profileDto automatically.
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "profileDTO", ignore = true)
    UserDTO userToUserDTO(User user);

    @Mapping(target = "userId", ignore = true)
    User userDTOToUser(UserDTO dto);

    @Mapping(source = "profile", target = "profileDTO")
    UserDTO user2ToUserDTO(User2 user);

    @Mapping(source = "profileDTO", target = "profile")
    @Mapping(target = "userId", ignore = true)
    User2 userDTOtoUser2(UserDTO dto);


    List<User> userDTOtoUserList(List<UserDTO> userDTO);

    List<User2> user2DTOtoUserList(List<UserDTO> users);

    List<UserDTO> userToUserDTOList(List<User> users);

    List<UserDTO> user2ToUserDTOList(List<User2> users);
}
