package com.vehicle.manager.controller;

import com.vehicle.manager.data.transfer.object.JobTitle;
import com.vehicle.manager.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitles")
    public String getJobTitles(Model model) {
        List<JobTitle> jobTitles = this.jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitles);
        return "jobTitle";
    }

    @PostMapping("/jobTitles/add")
    public String addJobTitles(JobTitle jobTitle) {
        this.jobTitleService.addJobTitles(jobTitle);
        return "redirect:/jobTitles";
    }

    @GetMapping("/jobTitles/updateById")
    @ResponseBody
    public Optional<JobTitle> updateJobTitleById(int id) {
        return this.jobTitleService.updateJobTitleById(id);
    }

    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateJobTitles(JobTitle jobTitle) {
        this.jobTitleService.updateJobTitles(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteJobTitles(@PathVariable("id") int id) {
        this.jobTitleService.deleteJobTitles(id);
        return "redirect:/jobTitles";
    }


}
