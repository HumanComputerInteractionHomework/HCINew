package youth.blservice;

import org.springframework.web.bind.annotation.PathVariable;
import youth.bean.*;

import java.util.List;

public interface CompanyBLService {


    public ResultMessageBean companyRemark(String phone,String company,int recomandScore,
                                           int futureScore,int ceoScore, String remark);
    public CompanyRemarkBean getCompanyRemark(String company);
    public ResultMessageBean interviewRemark(String phone,String company,String result,
                                             int difficulty,int feeling,String remark);
    public CompanyInterviewRemarkBean getInterviewRemark(String company);
    public JobDetailBean getJobDetailByJobId( String jobId);




}
