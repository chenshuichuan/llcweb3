package com.ruoyi.project.llc.myFiles.service;

import com.ruoyi.project.llc.document.service.DocumentRepository;
import com.ruoyi.project.llc.document.service.IDocumentService;
import com.ruoyi.project.llc.paper.service.PaperRepository;
import com.ruoyi.project.llc.patent.domain.Patent;
import com.ruoyi.project.llc.patent.service.IPatentService;
import com.ruoyi.project.llc.patent.service.PatentRepository;
import com.ruoyi.project.llc.project.domain.Project;
import com.ruoyi.project.llc.project.service.ProjectRepository;
import com.ruoyi.project.llc.software.domain.Software;
import com.ruoyi.project.llc.software.service.ISoftwareService;
import com.ruoyi.project.llc.software.service.SoftwareRepository;
import com.ruoyi.project.system.files.domain.Files;
import com.ruoyi.project.system.files.service.FilesRepository;
import com.ruoyi.project.system.files.service.IFilesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jnlp.FileSaveService;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by:Ricardo
 * Description:
 * Date: 2019/3/11
 * Time: 12:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyFilesServiceImplTest {

    @Autowired
    private FilesRepository filesRepository;
    @Autowired
    private IFilesService filesService;
    @Autowired
    private PatentRepository patentRepository;
    @Autowired
    private IPatentService patentService;
    @Autowired
    private SoftwareRepository softwareRepository;
    @Autowired
    private ISoftwareService softwareService;

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private IDocumentService documentService;

//    @Test
//    public void filesToFiles() {
//        List<MyFiles> myFilesList = myFilesRepository.findAll();
//        for (MyFiles myFiles : myFilesList) {
//            Files f2 = new Files();
//            f2.setFileName(myFiles.getFileName());
//
//            //f2.setId(myFiles.getId());
//            f2.setUrl("D:/temp/" + myFiles.getFileName() + "." + myFiles.getSuffix());
//            f2.setStatus(myFiles.getStatus());
//            f2.setFileName(myFiles.getFileName());
//            f2.setRemark(myFiles.getOriginalName());
//            f2.setContent(myFiles.getContent());
//
//            f2.setSuffix(myFiles.getSuffix());
//            f2.setType(Integer.toString(2));
//            f2.setDelFlag("0");
//            f2.setCreateBy(myFiles.getAuthor());
//            f2.setCreateByName(myFiles.getAuthor());
//            f2.setUpdateBy(myFiles.getAuthor());
//            f2.setUpdateByName(myFiles.getAuthor());
//            f2.setCreateTime(myFiles.getCreateTime());
//            f2.setUpdateTime(myFiles.getUpdateTime());
//            System.out.println("myFilesId = " + myFiles.getId());
//            Files files = filesRepository.save(f2);
//
//            if (files != null && files.getId() > 0) {
//                Project project = projectRepository.findByIntroductionFile(myFiles.getId());
//                if (project != null) {
//                    System.out.println("oid-" + myFiles.getId() + ": nid-" + files.getId());
//                    project.setIntroductionFile(files.getId());
//                    projectRepository.save(project);
//                    System.out.println(project);
//                } else {
//                    System.out.println("文件无映射：" + myFiles);
////                    Paper paper = paperRepository.findBySourceFile(myFiles.getId());
////                    if (paper != null) {
////                        System.out.println("oid-" + myFiles.getId() + ": nid-" + files.getId());
////                        paper.setSourceFile(files.getId());
////                        paperRepository.save(paper);
////                        System.out.println(paper);
////                    } else {
////
////                    }
//                }
//            }
//        }
//    }

    @Test
    public void testServerAdd2(){
        Files images = filesService.selectFilesById(299);
        Assert.assertThat(images,notNullValue());
        System.out.println("find files = "+images.getFileName());
        Files f2 = new Files();
        f2.setFileName(images.getFileName());

        //f2.setId(images.getId());
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
        images =  filesRepository.save(f2);
        System.out.println("files id = "+images.getId());

        Patent patent = patentService.selectPatentById(299);
        Assert.assertThat(patent,notNullValue());
        System.out.println("find files = "+patent.getAppliNum());
        Patent patent1 = new Patent();
        patent1.setId(332);
        patent1.setAppliNum(patent.getAppliNum());
        patent1.setUpdateTime(new Date());
        patent = patentRepository.save(patent1);
        //int i = patentService.insertPatent(patent1);
        System.out.println("patent id = "+patent.getId());


        Software software = softwareService.selectSoftwareById(9);
        Assert.assertThat(software,notNullValue());
        System.out.println("find files = "+software.getPublicNum());
        Software software1 = new Software();
        software1.setPublicNum(software.getPublicNum());
        software = softwareRepository.save(software1);
        //i = softwareService.insertSoftware(software1);
        System.out.println("software id = "+software.getId());

    }
}