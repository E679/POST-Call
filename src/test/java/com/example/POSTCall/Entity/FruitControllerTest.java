package com.example.POSTCall.Entity;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.util.ReflectionTestUtils;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("POST call Test")
@RunWith(MockitoJUnitRunner.class)
class FruitControllerTest {
    @Mock
    private FruitModel fruitModel;
    @Mock
    private JpaRepository jpaRepository;

    @InjectMocks
    private FruitController fruitController;

    @BeforeEach
    void setUp() {
        fruitModel= Mockito.spy(FruitModel.class);
        fruitController=Mockito.spy(FruitController.class);
    }

    @Test
    void testAddFruit() {
        ReflectionTestUtils.setField(fruitController,"jpaRepository",jpaRepository);
        FruitModel fruitModel1=new FruitModel(1,"Orange","50208");
        //Mockito.when(fruitController.addFruit(fruitModel)).thenReturn(fruitModel1);
        //jpaRepository= (JpaRepository) new FruitController();
        FruitModel fruitModel2 = fruitController.addFruit(fruitModel1);
        assertNotNull(fruitModel2);
        assertNotNull(fruitModel2.toString());
        assertEquals(fruitModel2.getFruitName(),"Orange");
        assertEquals(fruitModel2.getFruitSerialNumber(),"50208");
        assertNotEquals(fruitModel2.getId(),"23");
    }

    @Test
    void testAddFruitNegative() throws RuntimeException{
        FruitModel fruitModel3 = fruitController.addFruit(null);
        assertNull(fruitModel3.getFruitName());
        assertNull(fruitModel3.getFruitSerialNumber());
        //assertNull(fruitModel3.getId());
    }

    @Test
    public void testFruitJsonData() throws IOException {
        String filename="/fruitmodel.json";
        InputStream resourceAsStream = FruitModel.class.getResourceAsStream(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        FruitModel fruitModel1 = objectMapper.readValue(resourceAsStream, FruitModel.class);
        System.out.println(fruitModel1.toString());
    }
}