package com.example.POSTCall.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Fruits Data")
public class FruitModel {
    @Id
    @GeneratedValue
    private int id;
    private String fruitName;
    private String fruitSerialNumber;

    @Override
    public String toString() {
        return "FruitModel{" +
                "id=" + id +
                ", fruitName='" + fruitName + '\'' +
                ", fruitSerialNumber='" + fruitSerialNumber + '\'' +
                '}';
    }
}
