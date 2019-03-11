package com.ruoyi.project.llc.document.service;


import com.ruoyi.project.llc.activity.domain.Activity;
import com.ruoyi.project.llc.document.domain.Document;
import com.ruoyi.project.llc.document.domain.DocumentInfor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author  ricardo
 * Description: repository类
 * Date: 2019/3/10
 */
public interface DocumentRepository extends JpaRepository<Document,Integer> {

     List<Document> findByAuthor(String author);
//    @Query("from Document d where d.author = :author")
//    List<Document> findByAuthor1(@Param("author")String author);
//
//    @Query(value = "select * from llc_document b where b.author=?1", nativeQuery = true)
//    List<DocumentInfor> findByAuthor123(String author);
}
