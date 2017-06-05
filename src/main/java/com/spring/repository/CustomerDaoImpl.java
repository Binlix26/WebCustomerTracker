package com.spring.repository;

import com.spring.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by binlix26 on 4/06/17.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Customer> getCustomers() {

        Query<Customer> query =
                getSession().createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        getSession().saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return getSession().get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Query query =
                getSession().createQuery("delete from Customer where id =:theCustomerId");
        query.setParameter("theCustomerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String name) {
        Session session = getSession();

        Query<Customer> query = null;

        // Only search by name if the name is not empty
        if (name != null && name.trim().length() > 0) {
            // search for first or last name, case insensitive
            query = session.createQuery(
                    "from Customer Where lower(firstName) LIKE :theName OR lower(lastName) LIKE :theName"
                    , Customer.class);

            query.setParameter("theName", "%" + name.toLowerCase() + "%");
        } else {
            // name is empty, when get all the customers
            query = session.createQuery("from Customer", Customer.class);
        }

        return query.getResultList();
    }
}
