package com.example.PeregrinosFX.bean;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Carnets Backup")
public class CarnetBackup {
    public String fileName;
    public ArrayList<String> carnetsBackup;

    public CarnetBackup(String fileName, ArrayList<String> carnetsBackup) {
        this.fileName = fileName;
        this.carnetsBackup = carnetsBackup;
    }

    public CarnetBackup() {

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> getCarnetsBackup() {
        return carnetsBackup;
    }

    public void setCarnetsBackup(ArrayList<String> carnetsBackup) {
        this.carnetsBackup = carnetsBackup;
    }
}
