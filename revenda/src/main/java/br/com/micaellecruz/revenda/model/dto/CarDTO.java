package br.com.micaellecruz.revenda.model.dto;

import br.com.micaellecruz.revenda.model.Color;

public class CarDTO {
    private int id;
    private String board;
    private String model;
    private String mark;
    private Color color;
    private short modelYear;
    private short yearOfManufacture;
    private float price;

    public CarDTO(int id, String board, String model, String mark, Color color, 
            short modelYear, 
            short yearOfManufacture,
            float price) {
        this.id = id;
        this.board = board;
        this.model = model;
        this.mark = mark;
        this.color = color;
        this.modelYear = modelYear;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
    }

    public CarDTO() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoard() {
        return this.board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return this.mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public short getModelYear() {
        return this.modelYear;
    }

    public void setModelYear(short modelYear) {
        this.modelYear = modelYear;
    }

    public short getYearOfManufacture() {
        return this.yearOfManufacture;
    }

    public void setYearOfManufacture(short yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}