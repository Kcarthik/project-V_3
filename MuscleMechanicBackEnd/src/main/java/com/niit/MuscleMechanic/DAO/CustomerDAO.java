package com.niit.MuscleMechanic.DAO;

import com.niit.MuscleMechanic.model.Customer;

public interface CustomerDAO {
  boolean saveCustomer(Customer customer);
  Customer getCustomerByUsername(String Username);
}
