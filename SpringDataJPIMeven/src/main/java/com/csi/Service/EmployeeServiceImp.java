package com.csi.Service;

import com.csi.Model.Customer;
import com.csi.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImp {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer signUp(Customer customer){

        return customerRepo.save(customer);
    }

    public boolean signIn(String custEmail, String custPassword){
        boolean flag = false;
        for (Customer customer : customerRepo.findAll()){
            if(customer.getCustEmail().equals(custEmail) && customer.getCustPassword().equals(custPassword)){
                flag = true;
            }
        }
        return flag;
    }
    public Optional<Customer> findById(int custId){

        return customerRepo.findById(custId);
    }
    public List<Customer> findByName(String custName){
        return customerRepo.findAll().stream().filter(emp-> emp.getCustName().equals(custName)).toList();
    }

    public List<Customer> findByAddress(String custAddress){
        return customerRepo.findAll().stream().filter(emp->emp.getCustAddress().equals(custAddress)).toList();
    }

    public List<Customer> findByLocalDate(String custlocalDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return customerRepo.findAll().stream().filter(emp->simpleDateFormat.format(emp.getCustlocalDate()).equals(custlocalDate)).toList();
    }
    public List<Customer> findByEmail(String custEmail){
        return customerRepo.findAll().stream().filter(emp->emp.getCustEmail().equals(custEmail)).toList();
    }

    public List<Customer> findByAnyInput(String input){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return customerRepo.findAll().stream().filter(emp-> emp.getCustName().equals(input)
                || String.valueOf(emp.getCustId()).equals(input)
                || emp.getCustAddress().equals(input)
                || simpleDateFormat.format(emp.getCustlocalDate()).equals(input)
                || emp.getCustEmail().equals(input)
                || emp.getCustPassword().equals(input)).toList();
    }

    public List<Customer> sortById(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustId)).toList();
    }

    public List<Customer> sortByName(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustName)).toList();
    }

    public List<Customer> sortByAddress(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustAddress)).toList();
    }

    public List<Customer> sortByLocalDate(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustlocalDate)).toList();
    }

    public List<Customer> sortByEmail(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustEmail)).toList();
    }
    public List<Customer> sortByPassword(){
        return customerRepo.findAll().stream().sorted(Comparator.comparing(Customer::getCustPassword)).toList();
    }


}
