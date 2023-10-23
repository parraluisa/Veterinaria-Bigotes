package com.bigotes.app.controller;

import com.bigotes.app.model.Drug;
import com.bigotes.app.service.DrugService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = DrugController.class)
@ActiveProfiles("test")
public class DrugControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DrugService drugService;


    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void DrugController_saveDrug_Drug() throws Exception {
        //Arrange
        Drug drug = new Drug("Paracetamol", 50, 100, 50, 1);
        when(drugService.save(any(Drug.class))).thenReturn(drug);
        //Act
        ResultActions response = mockMvc.perform(post("/drug")
                .contentType(MediaType.valueOf("application/json"))
                .content(objectMapper.writeValueAsString(drug)));
        //Assert
        response.andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Paracetamol"))
                .andExpect(jsonPath("$.buyPrice").value(50))
                .andExpect(jsonPath("$.sellPrice").value(100))
                .andExpect(jsonPath("$.itemsAvailable").value(50))
                .andExpect(jsonPath("$.itemsSell").value(1));
    }

    @Test
    public void DrugController_updateDrug_Drug() throws Exception {
        //Arrange
        Drug updatedDrug = new Drug("Paracetamol Updated", 60, 110, 60, 2);
        when(drugService.save(any(Drug.class))).thenReturn(updatedDrug);
        //Act
        ResultActions response = mockMvc.perform(put("/drug")
                .contentType(MediaType.valueOf("application/json"))
                .content(objectMapper.writeValueAsString(updatedDrug)));
        //Assert
        response.andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Paracetamol Updated"))
                .andExpect(jsonPath("$.buyPrice").value(60))
                .andExpect(jsonPath("$.sellPrice").value(110))
                .andExpect(jsonPath("$.itemsAvailable").value(60))
                .andExpect(jsonPath("$.itemsSell").value(2));
    }

    @Test
    public void DrugController_deleteDrug_Drug() throws Exception {
        //Arrange
        Long drugIdToDelete = 1L;
        doNothing().when(drugService).deleteById(drugIdToDelete);

        //Act
        ResultActions response = mockMvc.perform(delete("/drug/{id}", drugIdToDelete));

        //Assert
        response.andExpect(status().isOk())
                .andExpect(content().string("Drug deleted"));
    }


    @Test
    public void DrugController_getDrugById_Drug() throws Exception {
        //Arrange
        when(drugService.findById(1L)).thenReturn(
                null
        );
        //Act
        ResultActions response = mockMvc.perform(get("/drug/").param("id", "1"));
        //Assert
        response.andExpect(status().isNotFound());
    }

    @Test
    public void DrugController_getAllDrugs_ListDrug() throws Exception {
        //Arrange
        when(drugService.findAll()).thenReturn(
                List.of(
                        new Drug("Paracetamol", 50, 100, 50, 1),
                        new Drug("Ibuprofeno", 50, 100, 50, 1)
                ));
        //Act
        ResultActions response = mockMvc.perform(get("/drug"));
        //Assert
        response.andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.size()").value(2));
    }


}
