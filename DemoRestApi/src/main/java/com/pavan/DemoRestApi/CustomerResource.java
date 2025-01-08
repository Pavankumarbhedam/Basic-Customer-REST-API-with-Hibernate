package com.pavan.DemoRestApi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("customers")
public class CustomerResource {
	CustomerRepository cr=new CustomerRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Customer> getCustomers()
	{
		return cr.getCustomers();
	}
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Customer getCustomerById(@PathParam("id") int id)
	{
		return cr.getCustomer(id);
	}
	@POST
	@Path("posting")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Customer createCustomer(Customer customer)
	{
		cr.post(customer);
		return customer;
	}
	
	@PUT
	@Path("update")
	@Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	public Customer updateCustomer(Customer customer)
	{
		if(getCustomerById(customer.getCid())==null)
			cr.post(customer);
		else
		   cr.update(customer);
		return customer;
	}
	
	@DELETE
	@Path("delete/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Customer deleteCustomer(@PathParam(value = "id") int id)
	    {
		      Customer c=getCustomerById(id);
		         if(c!=null)
	                  cr.delete(id);
	             return c;
	    }
}
