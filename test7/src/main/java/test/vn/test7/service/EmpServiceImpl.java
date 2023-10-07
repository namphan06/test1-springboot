package test.vn.test7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import test.vn.test7.entity.EmployeeEntity;
import test.vn.test7.repository.EmpRepository;

import javax.servlet.http.HttpSession;
import java.util.List;
@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpRepository rp;
    @Override
    public EmployeeEntity saveEmp(EmployeeEntity emp){
        EmployeeEntity newEmp= rp.save(emp);
        return newEmp;
    }
    @Override
    public List<EmployeeEntity> getAllEmp(){
        return rp.findAll();
    }
    @Override
    public EmployeeEntity getEmpById(int id){
        EmployeeEntity emp = rp.findById(id).get();
        return emp;
    }
    @Override
    public boolean deleteEmp(int id){
        EmployeeEntity emp = rp.findById(id).get();
        if(emp != null){
            rp.delete(emp);
            return true;
        }
        return false;
    }
    public void removeSessionMessage() {
        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
                .getSession();

        session.removeAttribute("msg");

    }

}
