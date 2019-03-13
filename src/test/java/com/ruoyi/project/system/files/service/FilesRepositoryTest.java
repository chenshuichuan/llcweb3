package com.ruoyi.project.system.files.service;

import com.ruoyi.project.llc.document.domain.Document;
import com.ruoyi.project.llc.document.service.DocumentRepository;
import com.ruoyi.project.llc.patent.domain.Patent;
import com.ruoyi.project.llc.patent.service.PatentRepository;
import com.ruoyi.project.llc.software.domain.Software;
import com.ruoyi.project.llc.software.service.SoftwareRepository;
import com.ruoyi.project.system.files.domain.Files;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by:Ricardo
 * Description:
 * Date: 2019/3/11
 * Time: 10:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FilesRepositoryTest {
    @Autowired
    private FilesRepository filesRepository;
    @Autowired
    private PatentRepository patentRepository;
    @Autowired
    private SoftwareRepository softwareRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Test
    public void testAdd(){
        Files images = filesRepository.getOne(299);
        Optional<Files> optionalFiles =filesRepository.findById(299);
        if(optionalFiles.isPresent()){
            images = optionalFiles.get();
            Assert.assertThat(images,notNullValue());
            System.out.println("find files = "+images.getFileName());
            Files f2 = new Files();
            f2.setFileName(images.getFileName());

            f2.setId(images.getId());
            f2.setUrl("D:/temp/"+images.getFileName()+"."+images.getSuffix());

            f2.setStatus(images.getStatus());
            f2.setFileName(images.getFileName());
            f2.setRemark(images.getRemark());
            f2.setContent(images.getContent());

            f2.setSuffix(images.getSuffix());
            f2.setType(images.getType());
            f2.setDelFlag("0");
            f2.setCreateBy(images.getCreateBy());
            f2.setCreateByName(images.getCreateByName());
            f2.setUpdateBy(images.getUpdateBy());
            f2.setUpdateByName(images.getUpdateByName());

            filesRepository.save(f2);
        }

        Patent patent = patentRepository.getOne(299);
        Optional<Patent> optionalPatent =patentRepository.findById(299);
        if(optionalPatent.isPresent()){
            patent = optionalPatent.get();
            Assert.assertThat(patent,notNullValue());
            System.out.println("find files = "+patent.getAppliNum());
            Patent patent1 = new Patent();
            patent1.setAppliNum(patent.getAppliNum());
            patentRepository.save(patent1);
        }


        Optional<Software> optionalSoftware = softwareRepository.findById(299);
        if(optionalSoftware.isPresent())
        {
            Software software = optionalSoftware.get();
            Assert.assertThat(software,notNullValue());
            System.out.println("find files = "+software.getPublicNum());
            Software software1 = new Software();
            software1.setPublicNum(software.getPublicNum());
            softwareRepository.save(software1);
        }

    }

    @Test
    public void testFiles(){
        List<Files> objects = filesRepository.findAll();
        Assert.assertThat(objects,notNullValue());
        Assert.assertThat(objects.size(),greaterThan(0));
        System.out.println("find size = "+objects.size());
    }

    @Test
    public void testDocument(){
        List<Document> objects = documentRepository.findAll();
        Assert.assertThat(objects,notNullValue());
        Assert.assertThat(objects.size(),greaterThan(0));
        System.out.println("find size = "+objects.size());
    }
//    @Test
//    public void testDocument1(){
//        List<Document1> objects = document1Repository.findAll();
//        Assert.assertThat(objects,notNullValue());
//        Assert.assertThat(objects.size(),greaterThan(0));
//        System.out.println("find size = "+objects.size());
//    }
//    @Test
//    public void d2d(){
//        List<Document1> objects = document1Repository.findAll();
//        for (Document1 doc:objects){
//
//            Document document = new Document();
//            document.setId(doc.getId());
//            document.setAuthor(doc.getAuthor());
//            document.setContent(doc.getContent());
//            document.setCreateTime(doc.getCreateDate());
//            document.setInfor(doc.getInfor());
//            document.setModel(doc.getModel());
//            document.setTitle(doc.getTitle());
//            document.setUpdateTime(doc.getModifyDate());
//
//            documentRepository.save(document);
//        }
//    }
    @Test
    public void testCreateByName(){
        List<Files> objects = filesRepository.findByCreateByName("admin");
        Assert.assertThat(objects,notNullValue());
        Assert.assertThat(objects.size(),greaterThan(0));
        System.out.println("find size = "+objects.size());
    }

}