package youth.bl;

import org.springframework.stereotype.Service;
import youth.bean.ResultMessageBean;
import youth.blservice.JobBLService;
import youth.dao.DislikedJobRepository;
import youth.dao.LikedJobRepository;
import youth.dao.ScannedJobRepository;
import youth.model.DisLikedJob;
import youth.model.LikedJob;
import youth.model.ScannedJob;
/*
* @author:MAX
*/
@Service
public class JobBL implements JobBLService {
    private final LikedJobRepository likedJobRepository;
    private final DislikedJobRepository dislikedJobRepository;
    private final ScannedJobRepository scannedJobRepository;




    public JobBL(LikedJobRepository likedJobRepository, DislikedJobRepository dislikedJobRepository,
                 ScannedJobRepository scannedJobRepository){
        this.likedJobRepository=likedJobRepository;
        this.dislikedJobRepository=dislikedJobRepository;
        this.scannedJobRepository=scannedJobRepository;
    }

    @Override
    public ResultMessageBean scanJob(String phone, String jobId) {
        try {
            scannedJobRepository.save(new ScannedJob(phone,jobId));
        }catch (Exception e){
            return new ResultMessageBean(false,"浏览记录保存失败");
        }




        return new ResultMessageBean(true);
    }

    @Override
    public ResultMessageBean likeJob(String phone, String jobId) {

        try {
            likedJobRepository.save(new LikedJob(phone,jobId));
        }catch (Exception e){
            return new ResultMessageBean(false,"保存失败");
        }




        return new ResultMessageBean(true);
    }

    @Override
    public ResultMessageBean dislikeJob(String phone, String jobId) {

        try {
            dislikedJobRepository.save(new DisLikedJob(phone,jobId));
        }catch (Exception e){
            return new ResultMessageBean(false,"记录保存失败");
        }




        return new ResultMessageBean(true);
    }

    @Override
    public ResultMessageBean cancelLikeJob(String phone, String jobId) {
        try {
            likedJobRepository.deleteByPhoneAndJobId(phone,jobId);

        }catch (Exception e){
            System.out.println(e);
            return new ResultMessageBean(false,"删除失败");
        }




        return new ResultMessageBean(true);
    }




}

