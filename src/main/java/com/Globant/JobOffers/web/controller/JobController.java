
package com.Globant.JobOffers.web.controller;

import com.Globant.JobOffers.domain.service.JobServiceImpl;
import com.Globant.JobOffers.dto.JobDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/job")
public class JobController {
    
    private final JobServiceImpl jobServiceImpl;
    
    @Autowired
    public JobController(JobServiceImpl jobServiceImpl) {
        this.jobServiceImpl = jobServiceImpl;
    }
    
    //CREATE
    @PostMapping("/create")
    public ResponseEntity<JobDto> saveJob(@RequestBody JobDto jobDto){
        System.out.println("Receiving request to create job");
        return jobServiceImpl.saveJob(jobDto);
    }
    
    // GET 
    @GetMapping("/all")
    public List<JobDto> getAllJob(){
        return jobServiceImpl.getAllJobs();
    }
    
    @GetMapping("/all/{idArea}")
    public List<JobDto> getAllJobArea(@PathVariable Long idArea){
        return jobServiceImpl.getAllJobArea(idArea);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable Long id){
        return jobServiceImpl.getJobById(id);
    } 
    
    @GetMapping("/name/{name}")
    public ResponseEntity<JobDto> getJobByName(@PathVariable String name){
        return jobServiceImpl.getJobByName(name);
    }
    
    //UPDATE
    @PatchMapping("/update/Area/{id}")
    public Boolean updateArea(@PathVariable Long id,@RequestParam Long idArea){
        return jobServiceImpl.updateArea(id, idArea);
    }
}
