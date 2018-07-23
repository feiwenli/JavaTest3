package com.hand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class App {
    public static String getCountry(Connection conn, String id) throws SQLException {

        String sql = "SELECT country FROM country WHERE country_id = "+id;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        String country;
        if (rs.next()) {
            country = rs.getString("country");
            System.out.println(country);
            return country;

        }

        return "no such country";
    }

    public static void getId(Connection conn, String id, String country) throws SQLException {

        String sql = "SELECT * FROM city WHERE country_id="+id;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("Country ID: "+id);
        System.out.println("Country "+country+" 的城市");
        System.out.println("城市 ID  |  城市名称");
        while(rs.next()){
            System.out.print(rs.getInt("city_id")+" | ");
            System.out.println(rs.getString("city")+" ");
            System.out.println("");

        }
    }

    public static void main(String [] args) throws SQLException {
        ConnectionFactory cf = ConnectionFactory.getInstance();
        Connection conn = null;

        System.out.println("请输入要查询的country ID：");
        Scanner in = new Scanner(System.in);
        String id = in.next();
        try {
            conn = cf.makeConnection();
//            System.out.println(conn.getAutoCommit());
            conn.setAutoCommit(false);

            String country = getCountry(conn, id);
            getId(conn, id, country);


//            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try{
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
