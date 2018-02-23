package com.example.demo.Security;

import com.example.demo.Models.Job;
import com.example.demo.Models.Skill;
import com.example.demo.Repositories.JobRepository;
import com.example.demo.Repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    SkillRepository skillRepository;

    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data....");

        roleRepository.save(new Role("APPLICANT")) ;
        roleRepository.save(new Role("EMPLOYER")) ;
        roleRepository.save(new Role("MANAGER")) ;

        skillRepository.save(new Skill("java",4));
        skillRepository.save(new Skill("php",3));
        skillRepository.save(new Skill("communication",5));

        Skill skill1=skillRepository.findBySkillname("java");
        Skill skill2=skillRepository.findBySkillname("php");
        Skill skill3=skillRepository.findBySkillname("communication");

        Job job1= new Job("back end developer", "montgomery college",
                "sytem upgrading","Full time");
        job1.AddSkill(skill1);
        jobRepository.save(job1);


        Job job2= new Job("full stack developer", "JJ PLC",
                "new system installation","part time");
        job2.AddSkill(skill2);
        jobRepository.save(job2);

        Job job3= new Job("sales", "United Insurance",
                "Customer service","Full time");
        job3.AddSkill(skill3);
        jobRepository.save(job3);

    }
}
