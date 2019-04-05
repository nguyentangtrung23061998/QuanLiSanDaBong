package com.quanlysandabong.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.quanlysandabong.dao.GenericDAO;
import com.quanlysandabong.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	
	public Connection getConnetion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/quanlisanbong";
			String user="root";
			String password="1234";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e.toString());
			return null;
		}
	}
	
	
	public <T> List<T> query(String sql,RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnetion();
			System.out.print(sql);	
			statement = connection.prepareStatement(sql);
			System.out.println(statement);
			//set parameter ()
			setParameter(statement,parameters);
 			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		}catch (Exception e) {
			return null;
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement !=null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			}catch(SQLException e) {
				return null;
			}
			
		}
	}
	
	private void setParameter(PreparedStatement statement, Object... parameters) {
		
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}


	@Override
	public Long insert(String sql, Object... parameters) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Long id = null;
			connection = getConnetion();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			System.out.print(statement);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}


	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnetion();
			connection.setAutoCommit(false);
			statement =connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit(); 
		}catch(Exception e) {
			if(connection != null) {
				try {
					connection.rollback();
				}catch(SQLException el) {
					el.printStackTrace();
				}
			}
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}


	@Override
	public void delete(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnetion();
			connection.setAutoCommit(false);
			statement =connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit(); 
		}catch(Exception e) {
			if(connection != null) {
				try {
					connection.rollback();
				}catch(SQLException el) {
					el.printStackTrace();
				}
			}
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

	

	

}
