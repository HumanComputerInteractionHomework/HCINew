package youth.blservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import youth.bean.*;
import youth.dao.UserRepository;

import java.util.List;
import java.util.Map;

public interface UserBLService {


    public ResultMessageBean login(String username, String password);
    public ResultMessageBean signUp(String phone, String password, String mail, String name);
    public ResultMessageBean editPassword(String phone, String password);
    public ResultMessageBean saveJobExperience(List<JobExperienceBean> jobExperienceBeans) ;
    public List<JobExperienceBean> getJobExperience(String phone) ;
    public ResultMessageBean saveUserBasicMessage(UserBasicMessageBean userBasicMessageBean);
    public UserBasicMessageBean getUserBasicMessage(String phone);
    public ResultMessageBean saveEducation( EducationBean educationBean);
    public EducationBean getEducation(String phone);
    public ResultMessageBean saveProjectExperience( List<ProjectExperienceBean> projectExperienceBeans);
    public List<ProjectExperienceBean> getProjectExperience(String phone);
    public ResultMessageBean saveSkill( List<SkillBean> skillBeans);
    public List<SkillBean> getSkill(String phone);
    public ResultMessageBean saveExpectation( ExpectationBean expectationBean);
    public ExpectationBean getExpectation(String phone);




}
