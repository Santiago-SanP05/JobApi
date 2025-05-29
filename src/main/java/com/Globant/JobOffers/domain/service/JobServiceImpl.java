
package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.domain.repository.JobRepository;
import com.Globant.JobOffers.dto.JobDto;
import com.Globant.JobOffers.persistence.entity.*;
import com.Globant.JobOffers.web.exception.DataInUseException;
import com.Globant.JobOffers.web.exception.NotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final AreaServiceImpl areaServiceImpl;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository, AreaServiceImpl areaServiceImpl) {
        this.jobRepository = jobRepository;
        this.areaServiceImpl = areaServiceImpl;
    }

    // CREATE
    @Transactional
    @Override
    public ResponseEntity<JobDto> saveJob(JobDto jobDto) {
        Optional<Area> areaOpt = areaServiceImpl.findById(jobDto.getIdArea());
        if (areaOpt.isEmpty()) {
            throw new NotFoundException("Area not Found with id: " + jobDto.getIdArea());
        }

        Optional<Job> jobOpt = jobRepository.findJobByNameAndArea(jobDto.getIdArea(), jobDto.getName());
        if (jobOpt.isPresent()) {
            System.out.println("Job was created");
            throw new DataInUseException("The job already exist in this Area " + jobOpt.get().getName());
        }

        Area areaEntity = areaOpt.get();
        Job jobSaved = jobRepository.save(Job.fromDTO(jobDto, areaEntity));
        return ResponseEntity.status(HttpStatus.CREATED).body(jobSaved.toDTO());

    }

    //DELETE
    @Transactional
    @Override
    public ResponseEntity<Void> deleteJob(Long id) {
        Optional<Job> jobOpt = jobRepository.findById(id);
        if (jobOpt.isEmpty()) {
            throw new NotFoundException("Job  not Found with id: " + id);
        }

        jobRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    //GET
    @Transactional
    @Override
    public List<JobDto> getAllJobArea(Long idArea) {

        Optional<Area> areaOpt = areaServiceImpl.findById(idArea);
        if (areaOpt.isEmpty()) {
            throw new NotFoundException("Area not Found with id: " + idArea);
        }

        List<Job> jobs = jobRepository.findJobByArea(areaOpt.get());
        return jobs.stream().map(Job::toDTO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ResponseEntity<JobDto> getJobById(Long id) {
        Optional<Job> jobOpt = jobRepository.findById(id);
        if (jobOpt.isEmpty()) {
            throw new NotFoundException("Job  not Found with id: " + id);
        }

        JobDto jobDto = jobOpt.get().toDTO();
        return ResponseEntity.ok(jobDto);
    }

    @Transactional
    @Override
    public ResponseEntity<JobDto> getJobByName(String name) {
        Optional<Job> jobOpt = jobRepository.findJobByName(name);
        if (jobOpt.isEmpty()) {
            throw new NotFoundException("Job not Found with name: " + name);
        }
        JobDto jobDto = jobOpt.get().toDTO();
        return ResponseEntity.ok(jobDto);

    }

    //UPDATE
    @Transactional
    @Override
    public Boolean updateArea(Long id, Long idArea) {
        if (id == null || idArea == null) {
            throw new IllegalArgumentException("ID and Area ID cannot be null");
        }
        Optional<Job> jobOpt = jobRepository.findById(id);
        if (jobOpt.isEmpty()) {
            throw new NotFoundException("Job not Found with id: " + id);
        }

        Optional<Area> areaOpt = areaServiceImpl.findById(idArea);
        if (areaOpt.isEmpty()) {
            throw new NotFoundException("Area not Found with id: " + idArea);
        }

        Job job = jobOpt.get();
        job.setArea(areaOpt.get());
        jobRepository.save(job);
        return true;

    }
    
    //FIND
    @Transactional
    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findJobById(id);
    }

    @Override
    public List<JobDto> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(Job::toDTO).collect(Collectors.toList());
    }

}
