package com.bigotes.app.DTOs;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bigotes.app.model.Pet;

@Mapper
public interface PetMapper {
    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);
    PetDTO convert(Pet pet);
    List<PetDTO> convertList(List<Pet> pets);
}
