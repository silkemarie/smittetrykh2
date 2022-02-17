package com.example.demo.config;

import com.example.demo.model.County;
import com.example.demo.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitData implements CommandLineRunner {

  @Autowired
  CountyRepository countyRepository;

  @Override
  public void run(String... args) throws Exception {
    County county1 = new County();
    county1.setName("Roskilde");
    county1.setCountyCode("0265");
    //county1.setHref("https://api.dataforsyningen.dk/kommuner/0265");
    county1.setHref("http://localhost:8080/county/0265");
    countyRepository.save(county1);

    county1.setName("Køge");
    county1.setCountyCode("0259");
    //county1.setHref("https://api.dataforsyningen.dk/kommuner/0259");
    county1.setHref("http://localhost:8080/county/0259");
    countyRepository.save(county1);
  }
}
