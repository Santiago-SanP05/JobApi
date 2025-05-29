
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.dto.JobDto;
import com.Globant.JobOffers.persistence.entity.Job;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;


public interface JobService {
    List<JobDto> getAllJobs();
    List<JobDto> getAllJobArea(Long idArea);
    ResponseEntity<JobDto> getJobById(Long id);
    ResponseEntity<JobDto> getJobByName(String name);
    
    ResponseEntity<JobDto> saveJob (JobDto jobDto);
    ResponseEntity<Void> deleteJob(Long id);
    Boolean updateArea(Long id, Long idArea);
    Optional<Job> findById(Long id);
}
