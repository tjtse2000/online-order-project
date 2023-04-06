package com.example.onlineOrder;

import com.example.onlineOrder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);
        response.getWriter().print(mapper.writeValueAsString(customer));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(IOUtils.toString(req.getReader()), Customer.class);
        System.out.println(customer.getEmail());
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        resp.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}