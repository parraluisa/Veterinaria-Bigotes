package com.bigotes.app.DTOs;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bigotes.app.model.Veterinarian;

@Mapper
public interface VeterinarianMapper {
    VeterinarianMapper INSTANCE = Mappers.getMapper(VeterinarianMapper.class);
    VeterinarianDTO convert(Veterinarian veterinarian);
    List<VeterinarianDTO> convertList(List<Veterinarian> veterinarians);
    
}
