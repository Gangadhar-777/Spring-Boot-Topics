package com.ganga;

import java.util.ArrayList;
import java.util.List;

import com.ganga.dto.UserDTO;
import com.ganga.dto.Userprofile2DTO;
import com.ganga.dto.Userprofile3DTO;
import com.ganga.dto.UserprofileDTO;
import com.ganga.mappers.UserMapper;
import com.ganga.mappers.UserprofileMapper;
import com.ganga.models.User;
import com.ganga.models.User2;
import com.ganga.models.Userprofile;

/**
 * Hello world!
 *
 */
public class App {
        private static List<User2> getUserWithProfiles() {
                return new ArrayList<>(
                                List.of(
                                                new User2(1, "Pavan", 24,
                                                                new Userprofile(1, 1, "Pavan", "Ram", "Male")),
                                                new User2(2, "Venkat", 22,
                                                                new Userprofile(2, 2, "Venkat", "Ramaih", "Male")),
                                                new User2(3, "Sai", 28, new Userprofile(1, 1, "Sai", "Ram", "Male")),
                                                new User2(4, "Suresh", 26,
                                                                new Userprofile(1, 1, "Suresh", "Kayala", "Male")),
                                                new User2(5, "Manohar", 25,
                                                                new Userprofile(1, 1, "Manohar", "Manu", "Male"))));
        }

        private static List<User> getUsers() {
                return new ArrayList<>(
                                List.of(
                                                new User(1, "Pavan", 24),
                                                new User(2, "Venkat", 22),
                                                new User(3, "Sai", 28),
                                                new User(4, "Suresh", 26),
                                                new User(5, "Manohar", 25)));
        }

        private static List<Userprofile> getProfiles() {
                return new ArrayList<>(
                                List.of(
                                                new Userprofile(2, 2, "Sai", "lol", "Male"),
                                                new Userprofile(3, 3, "Manohar", "lol", "Male"),
                                                new Userprofile(4, 4, "Sai", "lol", "Female"),
                                                new Userprofile(5, 5, "Sai", "lol", "Female"),
                                                new Userprofile(6, 6, "Sai", "lol", "Female")));
        }


        static void profileExecutor() {
                Userprofile profile = new Userprofile(1, 1, "Pavan", "kaja", "Male");

                UserprofileDTO pDTO1 = UserprofileMapper.INSTANCE.profileToProfileDTO(profile);
                Userprofile2DTO pDTO2 = UserprofileMapper.INSTANCE.profileToProfile2DTO(profile);
                Userprofile3DTO pDTO3 = UserprofileMapper.INSTANCE.profileToProfile3DTO(profile);

                System.out.println(profile);
                System.out.println(pDTO1);
                System.out.println(pDTO2);
                System.out.println(pDTO3);

                List<Userprofile> profs = getProfiles();
                System.out.println("================================================");
                System.out.println(UserprofileMapper.INSTANCE.profileToProfileDTOList(profs));
                System.out.println(UserprofileMapper.INSTANCE.profileToProfileDTO2List(profs));
                System.out.println(UserprofileMapper.INSTANCE.profileToProfileDTO3List(profs));

                System.out.println("================================================");
                Userprofile up1 = UserprofileMapper.INSTANCE.profileDTOtoProfile(pDTO1);
                Userprofile up2 = UserprofileMapper.INSTANCE.profileDTO2toProfile(pDTO2);
                Userprofile up3 = UserprofileMapper.INSTANCE.profileDTO3toProfile(pDTO3);

                System.out.println(up1);
                System.out.println(up2);
                System.out.println(up3);

                System.out.println(UserprofileMapper.INSTANCE
                                .profileDTOToProfileList(UserprofileMapper.INSTANCE.profileToProfileDTOList(profs)));
                System.out.println(UserprofileMapper.INSTANCE
                                .profileDTO2ToProfileList(UserprofileMapper.INSTANCE.profileToProfileDTO2List(profs)));
                System.out.println(UserprofileMapper.INSTANCE
                                .profileDTO3ToProfileList(UserprofileMapper.INSTANCE.profileToProfileDTO3List(profs)));
        }

        static void UserWithUserProfileExecutor() {
                User user = new User(1, "Pavan Ram", 22);
                Userprofile profile = new Userprofile(1, 1, "Pavan", "kaja", "Male");
                User2 user2 = new User2(1, "Pavan Ram", 22, profile);

                UserDTO uDTO = UserMapper.INSTANCE.userToUserDTO(user);
                System.out.println(uDTO);

                UserDTO u2DTO = UserMapper.INSTANCE.user2ToUserDTO(user2);
                System.out.println(u2DTO);

                System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                System.out.println(UserMapper.INSTANCE.userToUserDTOList(getUsers()));
                System.out.println(UserMapper.INSTANCE.user2ToUserDTOList(getUserWithProfiles()));
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

                System.out.println("=======================================");
                System.out.println(UserMapper.INSTANCE
                                .userDTOtoUserList(UserMapper.INSTANCE.userToUserDTOList(getUsers())));
                System.out.println(UserMapper.INSTANCE
                                .user2DTOtoUserList(UserMapper.INSTANCE.user2ToUserDTOList(getUserWithProfiles())));
                System.out.println("=======================================");
        }

        public static void main(String[] args) {
                UserWithUserProfileExecutor();
        }
}
