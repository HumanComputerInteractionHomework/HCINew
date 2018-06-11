package youth.blservice;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import youth.bean.JobListBean;
import youth.bean.SearchBean;

import java.util.List;

/*
* @author:MAX
*/
public interface JobListBLService {


    public List<JobListBean> getSavedJobList(String phone);
    public List<JobListBean> getRecomandJobList(String phone);
    public util.Page<JobListBean> searchJob(@RequestBody SearchBean searchBean);
    public util.Page<JobListBean> search(String keyword,int page,int num);

}

