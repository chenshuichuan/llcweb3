package com.ruoyi.project.llc.myFiles.service;


import com.ruoyi.project.llc.myFiles.domain.MyFiles;
import com.ruoyi.project.system.files.domain.Files;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author  ricardo
 * Description: repository类
 * Date: 2019/3/10
 */
public interface MyFilesRepository extends JpaRepository<MyFiles,Integer> {


}
