package com.shop.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.shop.cafe.dto.Product;

@Component
public class ProductDao {
	
	@Value(value = "${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	@Value(value = "${spring.datasource.url}")
	private String DB_URL;
	@Value(value = "${spring.datasource.username}")
	private String DB_USER;
	@Value(value = "${spring.datasource.password}")
	private String DB_PW;
	
	
	
	public List<Product> getAllProducts() throws Exception{
		Class.forName(DB_DRIVER);
		
		String sql = "select * from product";
		try(
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
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