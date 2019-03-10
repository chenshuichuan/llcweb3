package com.ruoyi.project.llc.files.service;


import com.ruoyi.project.llc.files.domain.MyFiles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author  ricardo
 * Description: repository类
 * Date: 2019/3/10
 */
public interface FilesRepository extends JpaRepository<MyFiles,Integer> {


}
