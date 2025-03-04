package com.shop.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shop.cafe.dto.Product;

@Component
public class ProductDao {
	public List<Product> getAllProducts() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/ureka?serverTimezone=UTC";
		String user = "ureca";
		String pw = "ureca";
		String sql = "select * from product";
		try(
		Connection con = DriverManager.getConnection(url, user, pw);
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
		){
			
			List<Product> list = new ArrayList<>();
			
			while(rs.next()) {
				int prodcode = rs.getInt("prodcode");
				String prodname = rs.getString("prodname");
				String pimg = rs.getString("pimg");
				int price = rs.getInt("price");
				
				list.add(new Product(prodcode, price, prodname, pimg));
			}
			
			return list;
			
		}
	}
}
