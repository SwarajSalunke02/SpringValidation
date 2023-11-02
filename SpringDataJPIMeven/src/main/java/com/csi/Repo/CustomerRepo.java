package com.csi.Repo;

import com.csi.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer , Integer> {

}
