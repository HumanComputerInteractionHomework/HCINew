package youth.bl;
/*
* @author:MAX
*/

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import util.FirstLetterUtil;
import util.LocationUtils;
import youth.bean.JobListBean;
import youth.bean.SearchBean;
import youth.blservice.JobListBLService;
import youth.dao.*;
import youth.model.*;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class JobListBL implements JobListBLService {

    private static final Map<String,Integer> educationDegreeMap;
    private static final Map<String,Integer> companyNatureMap;

    static
    {
        educationDegreeMap = new HashMap<String, Integer>();
        educationDegreeMap.put("初中及以下", 1);
        educationDegreeMap.put("中技、中专、高中", 2);
        educationDegreeMap.put("大专", 3);
        educationDegreeMap.put("本科", 4);
        educationDegreeMap.put("硕士", 5);
        educationDegreeMap.put("博士", 6);

        companyNatureMap= new HashMap<String, Integer>();
        companyNatureMap.put("外资（欧美）", 1);
        companyNatureMap.put("外资（非欧美）", 2);
        companyNatureMap.put("合资", 3);
        companyNatureMap.put("国企", 4);
        companyNatureMap.put("民营公司", 5);
        companyNatureMap.put("外资代表处", 6);
        companyNatureMap.put("政府机关", 7);
        companyNatureMap.put("事业单位", 8);
        companyNatureMap.put("非营利组织", 9);
        companyNatureMap.put("上市公司", 10);
        companyNatureMap.put("创业公司",11);
    }

    @Autowired
    private JobDetailRepository jobDetailRepository;
    @Autowired
    private JobVectorRepository jobVectorRepository;
    @Autowired
    private KeywordsRepository keywordsRepository;
    @Autowired
    private JobClassificationRepository jobClassificationRepository;

    @Override
    public List<JobListBean> getSavedJobList(String phone) {
        ArrayList<JobDetail> jobDetails= (ArrayList<JobDetail>) jobDetailRepository.getSavedJob(phone);
        ArrayList<JobListBean> jobListBeans=new ArrayList<JobListBean>();
        for (JobDetail jobDetail:jobDetails){
            JobListBean jobListBean=new JobListBean();
            System.out.println("jobId"+jobDetail.getJobId());
            BeanUtils.copyProperties(jobDetail,jobListBean);
            jobListBeans.add(jobListBean);

        }
        return jobListBeans;

    }

    @Override
    public List<JobListBean> getRecomandJobList(String phone) {
        return null;
    }

    /*
    搜索职业
     */
    @Override
    public util.Page<JobListBean> searchJob(final @RequestBody SearchBean searchBean) {

        //searchBean里面的属性在这里默认不为空，所以前端要在搜索时必须保证所有选项都不为空
        util.Page<JobListBean> res = new util.Page<JobListBean>();
        res.setSize(searchBean.getNum());
        res.setPage(searchBean.getPage());

        final JobVector jobVector=new JobVector();
        jobVector.setCompanyNature(companyNatureMap.get(searchBean.getCompanyNature()));
        jobVector.setEducationDegree(educationDegreeMap.get(searchBean.getEducationDegree()));
        jobVector.setJobExp(searchBean.getJobExperience());

        org.springframework.data.domain.Page<JobVector> result = null;

        result  = jobVectorRepository.findAll(new Specification<JobVector>() {
            @Override
            public Predicate toPredicate(Root<JobVector> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                List<Predicate> list2 = new ArrayList<Predicate>();
               // System.out.println("我就在这里面啊，真没事");
               // Path<>
                Path<Integer> companyNature = root.get("companyNature");
                Path<Integer> educationDegree = root.get("educationDegree");
                Path<Double> jobExp = root.get("jobExp");
                Path<String> jobName = root.get("jobName");
                Path<String> jobCity = root.get("jobCity");

                if (searchBean.getCompanyNature() != null && !"".equals(searchBean.getCompanyNature())) {
                    list.add(cb.equal(companyNature, jobVector.getCompanyNature() ));
                }
                if (searchBean.getEducationDegree() != null && !"".equals(searchBean.getEducationDegree())) {
                    list.add(cb.ge(educationDegree, jobVector.getEducationDegree() ));
                }
                if (searchBean.getJobExperience() != null && !"".equals(searchBean.getJobExperience())) {
                    list.add(cb.ge(jobExp, jobVector.getJobExp() ));
                }
                if (searchBean.getJobName() != null && !"".equals(searchBean.getJobName())) {
                    list.add(cb.like(jobName, "%" + searchBean.getJobName() + "%"));
                }
                if (searchBean.getJobCityList() != null && !"".equals(searchBean.getJobCityList())) {
                    for(String s:searchBean.getJobCityList()){
                        list2.add(cb.equal(jobCity, s ));
                    }
                    Predicate[] p2 = new Predicate[list2.size()];
                    list.add(cb.or(list2.toArray(p2)));
                }

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }

        }, new PageRequest(searchBean.getPage()-1, searchBean.getNum()));

        List<JobListBean> jobListBeans=new ArrayList<JobListBean>();

        for (JobVector jobVector1 : result.getContent()) {
            JobListBean jobListBean=new JobListBean();
            BeanUtils.copyProperties(jobDetailRepository.findByJobId(Integer.toString(jobVector1.getJobId())),jobListBean);
            //计算matchingDegree
            double matchingDegree=0.0;
 //           double min=100000000;//10万公里足够了
//            for(String s:searchBean.getJobCityList()){
//                JobVector jobVector2=jobVectorRepository.findByJobCity(s);
//                double lat=jobVector2.getLat();
//                double lng=jobVector2.getLng();
//                double dis=LocationUtils.getDistance(jobVector1.getLat(),jobVector1.getLng(),lat,lng);
//                if( dis<min) {
//                    min = dis;
//                }
//            }
            double cityMatch=1;


            int dbSalary = jobVector1.getSalaryMid();
            int expectSalary = searchBean.getSalary();
            double salaryMatch = 1 - (double) Math.abs(dbSalary - expectSalary) / (double) (dbSalary>expectSalary?dbSalary:expectSalary);

            int expectEdu=jobVector.getEducationDegree();
            int dbEdu=jobVector1.getEducationDegree();
            double eduMatch=0;
            if(expectEdu==dbEdu){
                eduMatch=1;
            }else{
                eduMatch=0.5;
            }
            matchingDegree=cityMatch*0.22+salaryMatch*0.25+0.18+eduMatch*0.21+0.13;
            jobListBean.setMatchingDegree(matchingDegree);

            jobListBeans.add(jobListBean);
        }
        res.setResult(jobListBeans);
        res.setTotalCount((int)result.getTotalElements());

        System.out.println("【开始】" + result.getTotalElements());

       return res;
    }


    /*
    模糊搜索
     */
    @Override
    public util.Page<JobListBean> search(String keyword, int page, int num) {
        String jp= FirstLetterUtil.toJP(keyword);
      //  int classification=0;
        List<Keywords> keywordsList=keywordsRepository.findThroughKey(jp);

        //System.out.println(keywordsList);

//        Keywords keywords= keywordsRepository.findByKeywords(jp);
//        if(keywords==null){
//            classification=22;
//        }else{
//            classification=keywords.getClassification();
//        }
        final List<Integer> classificationList=new ArrayList<Integer>();

        if(keywordsList.size()==0){
            classificationList.add(new Integer(22));
        }else{
            for(Keywords keywords:keywordsList){
                classificationList.add(keywords.getClassification());
            }
        }
        System.out.println("【开始】"+classificationList.size());
        util.Page<JobListBean> res = new util.Page<JobListBean>();
        res.setSize(num);
        res.setPage(page);

        //final JobClassification jobClassification=new JobClassification();
        //jobClassification.setClassification(classification);

        org.springframework.data.domain.Page<JobClassification> result = null;

        result  = jobClassificationRepository.findAll(new Specification<JobClassification>() {
            @Override
            public Predicate toPredicate(Root<JobClassification> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                List<Predicate> list2 = new ArrayList<Predicate>();
                Path<Integer> dbClassification= root.get("classification");
                for(Integer myInteger:classificationList){
                    list2.add(cb.equal(dbClassification, myInteger));
                }
                Predicate[] p2 = new Predicate[list2.size()];
                list.add(cb.or(list2.toArray(p2)));

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }

        }, new PageRequest(page-1, num));

        List<JobListBean> jobListBeans=new ArrayList<JobListBean>();

        for (JobClassification jobClassification1 : result.getContent()) {
            JobListBean jobListBean=new JobListBean();
            BeanUtils.copyProperties(jobDetailRepository.findByJobId(jobClassification1.getJobId()),jobListBean);
            jobListBeans.add(jobListBean);
        }
        res.setResult(jobListBeans);
        res.setTotalCount((int)result.getTotalElements());

        System.out.println("【开始】"+result.getTotalElements());

        return res;


    }


//    @Transactional
//    public util.Page<EduTeachers> query(final String tname, final String sex, final Stringdegree, final String orgname) {
//        //TODO Auto-generated method stub
//        return teacherDao.findAll(new Specification<EduTeachers>() {
//            @Override
//            public predi toPredicate(Root<EduTeachers> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                //TODO Auto-generated method stub
//                Path<String> namepath = root.get("name");
//                Path<String> sexpath = root.get("sex");
//                Path<String> degreepath = root.get("degree");
//                List<Predicate> list = newArrayList < Predicate > ();
//                if (tname != null && !"".equals(tname)) {
//                    list.add(cb.like(namepath, "%" + tname + "%"));
//                }
//                if (sex != null && !"".equals(sex)) {
//                    list.add(cb.like(sexpath, "%" + sex + "%"));
//                }
//                if (degree != null && !"".equals(degree)) {
//                    list.add(cb.like(degreepath, "%" + degree + "%"));
//                }
//                if (orgname != null && !"".equals(orgname)) {
//                    Path<String> orgnamepath = root.get("org").get("orgname");
//                    list.add(cb.like(orgnamepath, "%" + orgname + "%"));
//                }
//                Predicate[] p = new Predicate[list.size()];
//                return cb.and(list.toArray(p));
//            }
//        }, new PageRequest(0, 2, new Sort(Direction.DESC, "org.orgname")));
//    }
//
//
//
//    @Override
//    public List<EmployeeModel> findSearch(EmployeeModel model) {
//
//        Assert.notNull(model);
//
//        List<EmployeeModel> result = employeeRepository.findAll(new Specification<EmployeeModel>() {
//            @Override
//            public Predicate toPredicate(Root<EmployeeModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                List<Predicate> list = new ArrayList<Predicate>();
//
//                if (StringUtils.isNoneBlank(model.getName())) {
//                    list.add(cb.like(root.get("name").as(String.class), "%" + model.getName() + "%"));
//                }
//
//                if (model.getGender() != null) {
//                    list.add(cb.equal(root.get("gender").as(GenderType.class), model.getGender()));
//                }
//
//                if (StringUtils.isNotBlank(model.getTelPhone())) {
//                    list.add(cb.like(root.get("telPhone").as(String.class), "%" + model.getTelPhone() + "%"));
//                }
//
//                if (model.getDepartment() != null && model.getDepartment().getCode() != null) {
//                    list.add(cb.equal(root.get("department").as(DepartmentModel.class), model.getDepartment()));
//                }
//
//                Predicate[] p = new Predicate[list.size()];
//                return cb.and(list.toArray(p));
//            }
//
//        });
//
//        return result;
//    }

}

