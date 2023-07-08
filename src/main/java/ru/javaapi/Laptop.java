package ru.javaapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    private String name;
    private Double rating;
    private String manufacturer;
    private Double screenDiagonal;
    private String color;
    private Double price;
}
