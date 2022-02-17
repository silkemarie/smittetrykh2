package com.example.demo.controller;

import com.example.demo.model.County;
import com.example.demo.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //kan ikke snakke med HTML-side, men laver java om til JSON og udskriver direkte
public class CountyRESTController {

  @Autowired
  CountyRepository countyRepository;

  @GetMapping("/counties")
  public List<County> getAllCounties() {
    return countyRepository.findAll(); //findAll = collection
  }


  @GetMapping("/")
  public String hej() {
    return "Hello World";
  }

  @GetMapping("/county/{id}")
  public County findCountyById(@PathVariable String id) { //Kan kalde den her metode hvad end vi vil.
    //^ vi kalder en String, fordi vores PK er en String.
    //vigtigt at id i linje 31 er det samme som id i linje 30
    Optional<County> obj = countyRepository.findById(id);
    if (obj.isPresent()) {
      return obj.get();
    } else {
      return null;
    }

  }

  @PostMapping("/county") //vigtigt at endpoint hedder det samme (med og uden parametre ift linje 31.
  //her det POST, i linje 30 GET.
  @ResponseStatus(HttpStatus.CREATED)
  public County postCounty(@RequestBody County county) {
    System.out.println(county);
    return countyRepository.save(county);
  }

  @PutMapping("/county/{id}")
  public ResponseEntity<County> updateCounty(@PathVariable String id, @RequestBody County county) {
    Optional<County> optCounty = countyRepository.findById(id);
    if (optCounty.isPresent()) {
      countyRepository.save(county); //her har vi opdateret vores database
      return new ResponseEntity<County>(county, HttpStatus.OK);
    } else {
      County notfoundCounty = new County();
      notfoundCounty.setName("Jeg kunne ikke finde id " + id);
      return new ResponseEntity<County>(notfoundCounty, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/county/{id}")
  public ResponseEntity<String> deleteCounty(@PathVariable String id) {
    try {
      countyRepository.deleteById(id);
      return new ResponseEntity<>("Slettet id " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Jeg kunne ikke slette id " + id, HttpStatus.NOT_FOUND);
    }
  }
}
