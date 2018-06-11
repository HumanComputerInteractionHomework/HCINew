package youth.bl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import youth.bean.JobDetailBean;
import youth.blservice.CompanyBLService;
import youth.dao.JobDetailRepository;
import youth.model.JobDetail;

import static org.junit.Assert.*;

/**
 * @author lw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyBLTest {


    @Test
    public void getJobDetailByJobId1() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId("39047799");
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }
    @Test
    public void getJobDetailByJobId2() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId("12345678");
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }
    @Test
    public void getJobDetailByJobId3() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId("45955542");
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }
    @Test
    public void getJobDetailByJobId4() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId("47555861");
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }
    @Test
    public void getJobDetailByJobId5() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId("98268760");
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }
    @Test
    public void getJobDetailByJobId6() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId("98268667");
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }
    @Test
    public void getJobDetailByJobId7() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId("98267151");
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }
    @Test
    public void getJobDetailByJobId8() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId("98268908");
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }
    @Test
    public void getJobDetailByJobId9() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId("0");
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }


    @Test
    public void getJobDetailByJobId10() throws Exception {
        JobDetailBean jobDetailBean =companyBLService.getJobDetailByJobId(null);
        System.out.println(jobDetailBean.getCompanyName());
        System.out.println(jobDetailBean.getCompanyIndustry());
        System.out.println(jobDetailBean.getCompanyNature());
    }
    @Test
    public void testMy() throws Exception {
        System.out.println("【开始】");
        System.out.println(jobDetailRepository.findByJobId("39047799"));
    }

    @Autowired
    private JobDetailRepository jobDetailRepository;

    @Autowired
    private CompanyBLService companyBLService;

    @Test
    public void companyRemark() throws Exception {

    }

    @Test
    public void getCompanyRemark() throws Exception {
        System.out.println("【开始】");
        System.out.println(companyBLService.getCompanyRemark("大连万达"));
    }

}