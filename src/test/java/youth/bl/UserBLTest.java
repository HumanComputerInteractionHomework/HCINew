package youth.bl;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import youth.bean.*;
import youth.blservice.UserBLService;
import youth.dao.JobExperienceRepository;
import youth.model.ProjectExperience;
import youth.model.User;
import youth.model.UserBasicMessage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBLTest {
    @Test
    public void saveExpectation() throws Exception {

    }

    @Test
    public void getExpectation() throws Exception {

    }



    @Test
    public void saveSkill() throws Exception {
        System.out.println("【开始】");
        List<SkillBean> list=new ArrayList<SkillBean>();
        SkillBean j1=new SkillBean("101","钢琴","十级",
                "小红花杯冠军","天资聪颖，大器可成");
        SkillBean j2=new SkillBean("101","LOL","资深玩家",
                "宿舍LOL亚军","光顾着打野，水晶被偷了");
        list.add(j1);
        list.add(j2);
        userBLService.saveSkill(list);
        Assert.assertEquals("1","1");
    }

    @Test
    public void getSkill() throws Exception {

        System.out.println("【开始】");
        List<SkillBean> list=new ArrayList<SkillBean>();
        for(SkillBean e:userBLService.getSkill("100")){
            System.out.println(e);
        }
        Assert.assertEquals("1","1");

    }


    @Test
    public void saveProjectExperience() throws Exception {
        System.out.println("【开始】");
        List<ProjectExperienceBean> list=new ArrayList<ProjectExperienceBean>();
        ProjectExperienceBean j1=new ProjectExperienceBean("101","花旗杯","high",
                "2010","2011","这是一个很好的项目","我在里面打酱油");
        ProjectExperienceBean j2=new ProjectExperienceBean("101","LOL全球总决赛","very high",
                "2018","2019","这是一个电竞狂欢盛典","我在里面看直播");
        list.add(j1);
        list.add(j2);
        userBLService.saveProjectExperience(list);
        Assert.assertEquals("1","1");

    }

    @Test
    public void getProjectExperience() throws Exception {
        System.out.println("【开始】");
        List<ProjectExperienceBean> list=new ArrayList<ProjectExperienceBean>();
        for(ProjectExperienceBean e:userBLService.getProjectExperience("101")){
            System.out.println(e);
        }
        Assert.assertEquals("1","1");
    }

    @Test
    public void saveUserBasicMessage() throws Exception {
        System.out.println("【开始】");


        UserBasicMessageBean u2=new UserBasicMessageBean("100","bob","1998-10-10","sex","上海",2.5,
                "3w",20000,40000,10000,666,10086,1);

        userBLService.saveUserBasicMessage(u2);

        Assert.assertEquals("1","1");
    }



    @Test
    public void getUserBasicMessage() throws Exception {
        System.out.println("【开始】");

        System.out.println( userBLService.getUserBasicMessage("100"));

        Assert.assertEquals("1","1");
    }

    @Autowired
    private UserBLService userBLService;

    @Test
    public void saveJobExperienceTest() throws Exception {
        System.out.println("【开始】");
        List<JobExperienceBean> list=new ArrayList<JobExperienceBean>();
        JobExperienceBean j1=new JobExperienceBean("101","company5","high",
                "A","coder","2010","2011","good");
        JobExperienceBean j2=new JobExperienceBean("101","company6","middle",
                "B","viewer","2011","2012","well");
        list.add(j1);
        list.add(j2);
        userBLService.saveJobExperience(list);
        Assert.assertEquals("1","1");

    }

    @Test
    public void getJobExperienceTest() throws Exception {
        System.out.println("【开始】");
        List<JobExperienceBean> list=new ArrayList<JobExperienceBean>();
        for(JobExperienceBean e:userBLService.getJobExperience("101")){
            System.out.println(e);
        }
        Assert.assertEquals("1","1");
    }

}