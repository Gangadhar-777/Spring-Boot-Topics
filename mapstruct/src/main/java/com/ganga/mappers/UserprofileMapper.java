package com.ganga.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ganga.dto.Userprofile2DTO;
import com.ganga.dto.Userprofile3DTO;
import com.ganga.dto.UserprofileDTO;
import com.ganga.models.Userprofile;

@Mapper
public interface UserprofileMapper {
    UserprofileMapper INSTANCE = Mappers.getMapper(UserprofileMapper.class);

    UserprofileDTO profileToProfileDTO(Userprofile profile);


    @Mapping(source = "firstName", target = "FName")
    @Mapping(source = "lastName", target = "LName")
    @Mapping(target = "isActive", ignore = true)
    Userprofile3DTO profileToProfile3DTO(Userprofile profile);



    @Mapping(source = "firstName", target = "FName")
    @Mapping(source = "lastName", target = "LName")
    Userprofile2DTO profileToProfile2DTO(Userprofile profile); // source = parameter, target = output

    List<UserprofileDTO> profileToProfileDTOList(List<Userprofile> profiles);

    List<Userprofile2DTO> profileToProfileDTO2List(List<Userprofile> profiles);

    List<Userprofile3DTO> profileToProfileDTO3List(List<Userprofile> profiles);

    Userprofile profileDTOtoProfile(UserprofileDTO dto);

    @Mapping(source = "FName", target = "firstName")
    @Mapping(source = "LName", target = "lastName")
    @Mapping(target = "profileId", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Userprofile profileDTO2toProfile(Userprofile2DTO dto);

    @Mapping(source = "FName", target = "firstName")
    @Mapping(source = "LName", target = "lastName")
    @Mapping(target = "profileId", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Userprofile profileDTO3toProfile(Userprofile3DTO dto);


    List<Userprofile> profileDTOToProfileList(List<UserprofileDTO> profiles);

    List<Userprofile> profileDTO2ToProfileList(List<Userprofile2DTO> profiles);

    List<Userprofile> profileDTO3ToProfileList(List<Userprofile3DTO
    > profiles);

}
