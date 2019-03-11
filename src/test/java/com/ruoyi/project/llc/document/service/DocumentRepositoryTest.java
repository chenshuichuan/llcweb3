package com.ruoyi.project.llc.document.service;

import com.ruoyi.project.llc.document.domain.Document;
import com.ruoyi.project.llc.document.domain.DocumentInfor;
import com.ruoyi.project.llc.document1.service.IDocument1Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by:Ricardo
 * Description:
 * Date: 2019/3/11
 * Time: 17:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentRepositoryTest {
    @Autowired
    private DocumentRepository documentRepository;

//    @Test
//    public void filesToFiles(){
//        List<Document> documentList = documentRepository.findByAuthor1("admin");
//        Assert.assertThat(documentList,notNullValue());
//        System.out.println("find size = "+documentList.size());
//    }
//
//    @Test
//    public void findByAuthor123(){
//        List<DocumentInfor> documentList = documentRepository.findByAuthor123("admin");
//        Assert.assertThat(documentList,notNullValue());
//        System.out.println("find size = "+documentList.size());
//    }
}