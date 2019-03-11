package com.ruoyi.project.llc.patent.service;


import com.ruoyi.project.llc.activity.domain.Activity;
import com.ruoyi.project.llc.patent.domain.Patent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author  ricardo
 * Description: repository类
 * Date: 2019/3/10
 */
public interface PatentRepository extends JpaRepository<Patent,Integer> {
    Patent findBySourceFile(Integer sourceFile);
}
