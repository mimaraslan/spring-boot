package com.mimaraslan.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.mimaraslan.modelmapper.dto.UserDTO;
import com.mimaraslan.modelmapper.model.User;

public class ModelmapperApplication {

	public static void main(String[] args) {
		simpleModelMappingDemo();
		System.out.println("-----------------");
		explicitModelMappingDemo();
	}

	private static void simpleModelMappingDemo() {
		User sourceUser = new User(1, "Mimar", "mimar.aslan@gmail.com", "123456789", "Istanbul");
		UserDTO targetUserDTO = new UserDTO();
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.map(sourceUser, targetUserDTO);

		System.out.println(targetUserDTO.getName());
		System.out.println(targetUserDTO.getEmailAddress());
		System.out.println(targetUserDTO.getMobileNumber());
		System.out.println(targetUserDTO.getUserCity());

	}

	private static void explicitModelMappingDemo() {
		User sourceUser = new User(1, "Mimar", "mimar.aslan@gmail.com", "123456789", "Istanbul");
		UserDTO targetUserDTO = new UserDTO();
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
			protected void configure() {
				map().setUserCity(source.getCity());
			}
		});
		
		modelMapper.map(sourceUser, targetUserDTO);

		System.out.println(targetUserDTO.getName());
		System.out.println(targetUserDTO.getEmailAddress());
		System.out.println(targetUserDTO.getMobileNumber());
		System.out.println(targetUserDTO.getUserCity());
	}
}