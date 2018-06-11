package youth.blservice;

import youth.bean.ResultMessageBean;
/*
* @author:MAX
*/
public interface JobBLService {




    public ResultMessageBean scanJob(String phone, String jobId);
    public ResultMessageBean likeJob(String phone, String jobId);
    public ResultMessageBean dislikeJob(String phone, String jobId);
    public ResultMessageBean cancelLikeJob(String phone, String jobId);


}

