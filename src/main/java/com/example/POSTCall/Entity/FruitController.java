package com.example.POSTCall.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruitPath/api/")
//@CrossOrigin("http://localhost:3000/")
public class FruitController {

    @Autowired
    JpaRepository jpaRepository;

    @PostMapping("/entry")
    public FruitModel addFruit(@RequestBody FruitModel fruitModel){
        FruitModel fruitModel1=new FruitModel();
        try {
            if(fruitModel!=null) {
                fruitModel1.setFruitName(fruitModel.getFruitName());
                fruitModel1.setId(fruitModel.getId());
                fruitModel1.setFruitSerialNumber(fruitModel.getFruitSerialNumber());
                jpaRepository.save(fruitModel1);
            }
//            FruitModel fruitModel2 = FruitModel.builder()
//                    .id(fruitModel.getId())
//                    .fruitName(fruitModel.getFruitName())
//                    .fruitSerialNumber(fruitModel.getFruitSerialNumber())
//                    .build();
            //displayStartPage();
            return fruitModel1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    @RequestMapping(value="/", method= RequestMethod.GET)
//    public @ResponseBody String displayStartPage(){
//        return "hello";
//    }
    @GetMapping("/getFruits")
    public ResponseEntity<List<FruitModel>> getFruitDetails(){
        List<FruitModel> allFruitList = jpaRepository.findAll();
        return ResponseEntity.ok(allFruitList);
    }

    @GetMapping("/getFruitsById/{fruitID}")
    public ResponseEntity<Optional<FruitModel>> getFruitDetailsBtID(@PathVariable int fruitID){
        //List<FruitModel> allFruitList =
        Optional<FruitModel> id = jpaRepository.findById(fruitID);

        if (id.isPresent()) {
            return ResponseEntity.ok(jpaRepository.findById(fruitID));
        }
        return null;
    }
}
