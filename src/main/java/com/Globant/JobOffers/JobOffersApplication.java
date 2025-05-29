package com.Globant.JobOffers;

import com.Globant.JobOffers.domain.service.*;
import com.Globant.JobOffers.dto.*;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JobOffersApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JobOffersApplication.class, args);

        AreaServiceImpl areaService = context.getBean(AreaServiceImpl.class);
        CountryServiceImpl countryService = context.getBean(CountryServiceImpl.class);
        CityServiceImpl cityService = context.getBean(CityServiceImpl.class);
        JobServiceImpl jobService = context.getBean(JobServiceImpl.class);
        TechnologyServiceImpl techService = context.getBean(TechnologyServiceImpl.class);
        OfferServiceImpl offerService = context.getBean(OfferServiceImpl.class);
        // Create Areas
        AreaDto area1 = areaService.saveArea(new AreaDto("Business")).getBody();
        AreaDto area2 = areaService.saveArea(new AreaDto("Engineering")).getBody();
        AreaDto area3 = areaService.saveArea(new AreaDto("Staff")).getBody();

        areaService.getAllAreas();

        // Create Country
        CountryDto country1 = countryService.saveCountry(new CountryDto("Colombia")).getBody();

        countryService.getAllCountries();

        //Create Cities
        CityDto city1 = cityService.saveCity(new CityDto("N/A", country1.getId())).getBody();
        CityDto city2 = cityService.saveCity(new CityDto("Bogota", country1.getId())).getBody();
        CityDto city3 = cityService.saveCity(new CityDto("Medellin", country1.getId())).getBody();

        cityService.getAllCities(country1.getId());

        //Create Jobs
        JobDto job1 = jobService.saveJob(new JobDto("Software Engineer", area2.getId())).getBody();
        JobDto job2 = jobService.saveJob(new JobDto("Front-End Developer", area2.getId())).getBody();
        JobDto job3 = jobService.saveJob(new JobDto("Backend Developer", area2.getId())).getBody();
        JobDto job4 = jobService.saveJob(new JobDto("Product Manager", area1.getId())).getBody();
        JobDto job5 = jobService.saveJob(new JobDto("Data Scientist", area2.getId())).getBody();
        JobDto job6 = jobService.saveJob(new JobDto("DevOps Engineer", area2.getId())).getBody();
        JobDto job7 = jobService.saveJob(new JobDto("UX/UI Designer", area3.getId())).getBody();
        JobDto job8 = jobService.saveJob(new JobDto("Quality Assurance Engineer", area2.getId())).getBody();
        JobDto job9 = jobService.saveJob(new JobDto("Systems Analyst", area1.getId())).getBody();
        JobDto job10 = jobService.saveJob(new JobDto("Mobile App Developer", area2.getId())).getBody();
        JobDto job11 = jobService.saveJob(new JobDto("IT Support Specialist", area3.getId())).getBody();
        JobDto job12 = jobService.saveJob(new JobDto("Business Analyst", area1.getId())).getBody();
        JobDto job13 = jobService.saveJob(new JobDto("Cloud Architect", area2.getId())).getBody();
        JobDto job14 = jobService.saveJob(new JobDto("Security Analyst", area2.getId())).getBody();
        JobDto job15 = jobService.saveJob(new JobDto("Technical Writer", area3.getId())).getBody();
        JobDto job16 = jobService.saveJob(new JobDto("Software Quality Engineer", area2.getId())).getBody();
        JobDto job17 = jobService.saveJob(new JobDto("Network Engineer", area2.getId())).getBody();
        JobDto job18 = jobService.saveJob(new JobDto("Scrum Master", area1.getId())).getBody();

        jobService.getAllJobs();

        //Create Technologies
        TechnologyDto technology1 = techService.saveTechnology(new TechnologyDto("Adobe XD")).getBody();
        TechnologyDto technology2 = techService.saveTechnology(new TechnologyDto("Agile")).getBody();
        TechnologyDto technology3 = techService.saveTechnology(new TechnologyDto("Agile Methodologies")).getBody();
        TechnologyDto technology4 = techService.saveTechnology(new TechnologyDto("AWS")).getBody();
        TechnologyDto technology5 = techService.saveTechnology(new TechnologyDto("Azure")).getBody();
        TechnologyDto technology6 = techService.saveTechnology(new TechnologyDto("Business Analysis")).getBody();
        TechnologyDto technology7 = techService.saveTechnology(new TechnologyDto("Business Process Modeling")).getBody();
        TechnologyDto technology8 = techService.saveTechnology(new TechnologyDto("C#")).getBody();
        TechnologyDto technology9 = techService.saveTechnology(new TechnologyDto("Cisco")).getBody();
        TechnologyDto technology10 = techService.saveTechnology(new TechnologyDto("CSS")).getBody();
        TechnologyDto technology11 = techService.saveTechnology(new TechnologyDto("Cybersecurity")).getBody();
        TechnologyDto technology12 = techService.saveTechnology(new TechnologyDto("Docker")).getBody();
        TechnologyDto technology13 = techService.saveTechnology(new TechnologyDto("Excel")).getBody();
        TechnologyDto technology14 = techService.saveTechnology(new TechnologyDto("Figma")).getBody();
        TechnologyDto technology15 = techService.saveTechnology(new TechnologyDto("Firewalls")).getBody();
        TechnologyDto technology16 = techService.saveTechnology(new TechnologyDto("Google Cloud")).getBody();
        TechnologyDto technology17 = techService.saveTechnology(new TechnologyDto("HTML")).getBody();
        TechnologyDto technology18 = techService.saveTechnology(new TechnologyDto("Java")).getBody();
        TechnologyDto technology19 = techService.saveTechnology(new TechnologyDto("JavaScript")).getBody();
        TechnologyDto technology20 = techService.saveTechnology(new TechnologyDto("JIRA")).getBody();
        TechnologyDto technology21 = techService.saveTechnology(new TechnologyDto("JUnit")).getBody();
        TechnologyDto technology22 = techService.saveTechnology(new TechnologyDto("Kotlin")).getBody();
        TechnologyDto technology23 = techService.saveTechnology(new TechnologyDto("Kubernetes")).getBody();
        TechnologyDto technology24 = techService.saveTechnology(new TechnologyDto("Linux")).getBody();
        TechnologyDto technology25 = techService.saveTechnology(new TechnologyDto("Machine Learning")).getBody();
        TechnologyDto technology26 = techService.saveTechnology(new TechnologyDto("Markdown")).getBody();
        TechnologyDto technology27 = techService.saveTechnology(new TechnologyDto("MongoDB")).getBody();
        TechnologyDto technology28 = techService.saveTechnology(new TechnologyDto("Network Security")).getBody();
        TechnologyDto technology29 = techService.saveTechnology(new TechnologyDto("Networking")).getBody();
        TechnologyDto technology30 = techService.saveTechnology(new TechnologyDto("Node.js")).getBody();
        TechnologyDto technology31 = techService.saveTechnology(new TechnologyDto("PostgreSQL")).getBody();
        TechnologyDto technology32 = techService.saveTechnology(new TechnologyDto("Python")).getBody();
        TechnologyDto technology33 = techService.saveTechnology(new TechnologyDto("React")).getBody();
        TechnologyDto technology34 = techService.saveTechnology(new TechnologyDto("React Native")).getBody();
        TechnologyDto technology35 = techService.saveTechnology(new TechnologyDto("R")).getBody();
        TechnologyDto technology36 = techService.saveTechnology(new TechnologyDto("Scrum")).getBody();
        TechnologyDto technology37 = techService.saveTechnology(new TechnologyDto("Selenium")).getBody();
        TechnologyDto technology38 = techService.saveTechnology(new TechnologyDto("Sketch")).getBody();
        TechnologyDto technology39 = techService.saveTechnology(new TechnologyDto("Spring")).getBody();
        TechnologyDto technology40 = techService.saveTechnology(new TechnologyDto("SQL")).getBody();
        TechnologyDto technology41 = techService.saveTechnology(new TechnologyDto("Swift")).getBody();
        TechnologyDto technology42 = techService.saveTechnology(new TechnologyDto("Technical Writing")).getBody();
        TechnologyDto technology43 = techService.saveTechnology(new TechnologyDto("TestNG")).getBody();
        TechnologyDto technology44 = techService.saveTechnology(new TechnologyDto("UX/UI Principles")).getBody();
        TechnologyDto technology45 = techService.saveTechnology(new TechnologyDto("VPN")).getBody();
        TechnologyDto technology46 = techService.saveTechnology(new TechnologyDto("Windows")).getBody();
        TechnologyDto technology47 = techService.saveTechnology(new TechnologyDto("Express")).getBody();
        TechnologyDto technology48 = techService.saveTechnology(new TechnologyDto("Penetration Testing.")).getBody();
        techService.getAllTechnologies();
        
        //Create Offers
        OfferDto offer1 = offerService.saveOffer(new OfferDto(
                "Software Engineer ", 
                "Develop and maintain software applications.", 
                job1.getId(), 
                city2.getId(), 
                LocalDate.parse("2024-10-01"), 
                false
        )).getBody();
        
        OfferDto offer2 = offerService.saveOffer(new OfferDto(
                "Front-End Developer", 
                "Build user interfaces and improve user experience.", 
                job2.getId(), 
                city3.getId(), 
                LocalDate.parse("2024-10-02"), 
                false
        )).getBody();
        
        OfferDto offer3 = offerService.saveOffer(new OfferDto(
                "Backend Developer", 
                "Create server-side applications and APIs.", 
                job3.getId(), 
                city1.getId(), 
                LocalDate.parse("2024-10-03"), 
                true
        )).getBody();
        
        OfferDto offer4 = offerService.saveOffer(new OfferDto(
                "Product Manager", 
                "Lead product development and manage product lifecycle.", 
                job4.getId(), 
                city2.getId(), 
                LocalDate.parse("2024-10-04"), 
                false
        )).getBody();
        
        OfferDto offer5 = offerService.saveOffer(new OfferDto(
                "Data Scientist ", 
                "Analyze data and provide actionable insights. ", 
                job5.getId(), 
                city1.getId(), 
                LocalDate.parse("2024-10-05"), 
                true
        )).getBody();
        
        OfferDto offer6 = offerService.saveOffer(new OfferDto(
                "DevOps Engineer", 
                "Automate and streamline operations and processes. ", 
                job6.getId(), 
                city3.getId(), 
                LocalDate.parse("2024-10-06"), 
                false
        )).getBody();
        
        OfferDto offer7 = offerService.saveOffer(new OfferDto(
                "UX/UI Designer", 
                "Design user-friendly interfaces and experiences.", 
                job7.getId(), 
                city2.getId(), 
                LocalDate.parse("2024-10-07"), 
                false
        )).getBody();
        
        OfferDto offer8 = offerService.saveOffer(new OfferDto(
                "Quality Assurance Engineer", 
                "Ensure software quality through testing and debugging.", 
                job8.getId(), 
                city1.getId(), 
                LocalDate.parse("2024-10-08"), 
                true
        )).getBody();
        
        OfferDto offer9 = offerService.saveOffer(new OfferDto(
                "Systems Analyst", 
                "Analyze and improve IT systems and processes.", 
                job9.getId(), 
                city3.getId(), 
                LocalDate.parse("2024-10-09"), 
                false
        )).getBody();
        
        OfferDto offer10 = offerService.saveOffer(new OfferDto(
                "Mobile App Developer", 
                "Develop applications for mobile platforms.", 
                job10.getId(), 
                city2.getId(), 
                LocalDate.parse("2024-10-10"), 
                false
        )).getBody();
        
        OfferDto offer11 = offerService.saveOffer(new OfferDto(
                "IT Support Specialist", 
                "Provide technical support and troubleshooting assistance.", 
                job11.getId(), 
                city1.getId(), 
                LocalDate.parse("2024-10-11"), 
                true
        )).getBody();
        
        OfferDto offer12 = offerService.saveOffer(new OfferDto(
                "Business Analyst", 
                "Gather requirements and analyze business needs.", 
                job12.getId(), 
                city3.getId(), 
                LocalDate.parse("2024-10-12"), 
                false
        )).getBody();
        
        OfferDto offer13 = offerService.saveOffer(new OfferDto(
                "Cloud Architect", 
                "Design and manage cloud infrastructure and solutions.", 
                job13.getId(), 
                city1.getId(), 
                LocalDate.parse("2024-10-13"), 
                true
        )).getBody();
        
        OfferDto offer14 = offerService.saveOffer(new OfferDto(
                "Security Analyst", 
                "Protect systems and networks from security breaches.", 
                job14.getId(), 
                city2.getId(), 
                LocalDate.parse("2024-10-14"), 
                false
        )).getBody();
        
        OfferDto offer15 = offerService.saveOffer(new OfferDto(
                "Technical Writer", 
                "Create documentation and user manuals for software.", 
                job15.getId(), 
                city1.getId(), 
                LocalDate.parse("2024-10-15"), 
                true
        )).getBody();
        
        OfferDto offer16 = offerService.saveOffer(new OfferDto(
                "Software Quality Engineer ", 
                "Design and implement quality assurance processes.", 
                job16.getId(), 
                city3.getId(), 
                LocalDate.parse("2024-10-15"), 
                false
        )).getBody();
        
        OfferDto offer17 = offerService.saveOffer(new OfferDto(
                "Network Engineer", 
                "Manage and maintain network infrastructure.", 
                job17.getId(), 
                city2.getId(), 
                LocalDate.parse("2024-10-16"), 
                false
        )).getBody();
        
        OfferDto offer18 = offerService.saveOffer(new OfferDto(
                "Scrum Master", 
                "Facilitate Agile development processes and teams.", 
                job18.getId(), 
                city1.getId(), 
                LocalDate.parse("2024-10-17"), 
                true
        )).getBody();
        
        //Add Technologies
        offerService.addTechnologies(offer1.getId(), List.of(technology18.getId(), technology39.getId(), technology31.getId()));
        offerService.addTechnologies(offer2.getId(), List.of(technology33.getId(), technology17.getId(), technology10.getId(), technology19.getId()));
        offerService.addTechnologies(offer3.getId(), List.of(technology30.getId(), technology47.getId(), technology27.getId()));
        offerService.addTechnologies(offer4.getId(), List.of(technology2.getId(), technology20.getId(), technology44.getId()));
        offerService.addTechnologies(offer5.getId(), List.of(technology32.getId(), technology35.getId(), technology40.getId(), technology25.getId()));
        offerService.addTechnologies(offer6.getId(), List.of(technology4.getId(), technology12.getId(), technology23.getId()));
        offerService.addTechnologies(offer7.getId(), List.of(technology14.getId(), technology1.getId(), technology38.getId()));
        offerService.addTechnologies(offer8.getId(), List.of(technology37.getId(), technology21.getId(), technology43.getId()));
        offerService.addTechnologies(offer9.getId(), List.of(technology40.getId(), technology2.getId(), technology6.getId()));
        offerService.addTechnologies(offer10.getId(), List.of(technology41.getId(), technology22.getId(), technology34.getId()));
        offerService.addTechnologies(offer11.getId(), List.of(technology46.getId(), technology24.getId(), technology29.getId()));
        offerService.addTechnologies(offer12.getId(), List.of(technology40.getId(), technology13.getId(), technology7.getId()));
        offerService.addTechnologies(offer13.getId(), List.of(technology4.getId(), technology5.getId(), technology16.getId()));
        offerService.addTechnologies(offer14.getId(), List.of(technology11.getId(), technology15.getId(), technology48.getId()));
        offerService.addTechnologies(offer15.getId(), List.of(technology26.getId(), technology42.getId()));
        offerService.addTechnologies(offer16.getId(), List.of(technology8.getId(), technology37.getId(), technology2.getId()));
        offerService.addTechnologies(offer17.getId(), List.of(technology9.getId(), technology28.getId(), technology45.getId()));
        offerService.addTechnologies(offer18.getId(), List.of(technology36.getId(), technology3.getId()));
    }

}
