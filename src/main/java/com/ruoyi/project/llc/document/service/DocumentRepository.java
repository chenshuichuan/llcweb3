package com.ruoyi.project.llc.document.service;


import com.ruoyi.project.llc.activity.domain.Activity;
import com.ruoyi.project.llc.document.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author  ricardo
 * Description: repository类
 * Date: 2019/3/10
 */
public interface DocumentRepository extends JpaRepository<Document,Integer> {


}
