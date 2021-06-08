package com.vehicle.manager.service;

import com.vehicle.manager.data.transfer.object.JobTitle;
import com.vehicle.manager.data.transfer.object.MessageDto;
import com.vehicle.manager.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    @Autowired
    private HttpSession session;


    public void helperAddJobTitles(JobTitle jobTitle)
    {
        try {
            this.jobTitleRepository.saveAndFlush(jobTitle);
            session.setAttribute("message", new MessageDto("JobTitle details have been added !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error uploading JobTitle !", "alert-danger"));

        }
    }

    public void helperUpdateJobTitles(JobTitle jobTitle)
    {
        this.jobTitleRepository.saveAndFlush(jobTitle);
    }

    public List<JobTitle> getJobTitles()
    {

        return this.jobTitleRepository.findAll();
    }

    public void addJobTitles(JobTitle jobTitle)
    {
        helperAddJobTitles(jobTitle);
    }

    public Optional<JobTitle> updateJobTitleById(int id)
    {
        Optional<JobTitle> jobTitle =this.jobTitleRepository.findById(id);
        return jobTitle;
    }

    public void updateJobTitles(JobTitle jobTitle)
    {
        try {

            helperUpdateJobTitles(jobTitle);
            session.setAttribute("message", new MessageDto("JobTitle details have been Updated !", "alert-success"));

        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error updating JobTitle !", "alert-danger"));
        }
    }

    public void deleteJobTitles(int id)
    {
        try {

            JobTitle jobTitle =this.jobTitleRepository.findById(id).get();
            this.jobTitleRepository.delete(jobTitle);
            session.setAttribute("message", new MessageDto("JobTitle details have been deleted !", "alert-danger"));
        }catch (Exception e)
        {
            session.setAttribute("message", new MessageDto("Error deleting JobTitle !", "alert-danger"));


        }
    }


}
