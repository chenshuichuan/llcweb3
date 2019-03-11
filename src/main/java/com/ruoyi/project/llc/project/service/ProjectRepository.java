package com.ruoyi.project.llc.project.service;


import com.ruoyi.project.llc.activity.domain.Activity;
import com.ruoyi.project.llc.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author  ricardo
 * Description: repository类
 * Date: 2019/3/10
 */
public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Project findByIntroductionFile(Integer introductionFile);
}
