package com.ascending.training.jdbc;

import com.ascending.training.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    static final String DB_URL = "jdbc:postgresql://localhost:5433/project_db";
    static final String USER = "admin";
    static final String PASS = "kkmacs213";

    public List<Users> getUsers(){
        List<Users> users = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //Step 2. Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Step 3. Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM users";
            rs = stmt.executeQuery(sql);

            //Step 4. Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                long id = rs.getLong("id");
                String name = rs.getString("fullname");

                //Fill the object
                Users user = new Users();
                user.setId(id);
                user.setName(name);
                users.add(user);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            //STEP 6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }

        logger.debug(String.format("printing user dao object size %d"),users.size());

        return users;

    }
    public static void main(String[] args){
        UsersDao userDao = new UsersDao();
        List<UsersDao> users = UsersDao.getUsers();

        for(Users user : users){
            System.out.println(user.getName());
        }
    }

}


