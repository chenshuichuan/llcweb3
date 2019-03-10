package com.ruoyi.project.llc.comments.service;


import com.ruoyi.project.llc.activity.domain.Activity;
import com.ruoyi.project.llc.comments.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author  ricardo
 * Description: repository类
 * Date: 2019/3/10
 */
public interface CommentsRepository extends JpaRepository<Comments,Integer> {


}
