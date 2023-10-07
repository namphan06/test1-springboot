package test.vn.test7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.vn.test7.entity.EmployeeEntity;

public interface EmpRepository extends JpaRepository<EmployeeEntity,Integer> {
}
