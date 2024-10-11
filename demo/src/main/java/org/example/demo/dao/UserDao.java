package org.example.demo.dao;

import org.example.demo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO (Data Access Object, DB의 데이터에 접근하기 위한 객체)
public class UserDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo_db";  // 자기에게 맞는 경로 설정
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    // CRUDS
    private static final String INSERT_USER_SQL = "insert into users (name, email, country) VALUES(?,?,?)"; // id는 auto_increment
    private static final String SELECT_USER_SQL = "select id, name, email, country from users where id = ?";
    private static final String SELECT_ALL_USERS = "select * FROM users";

    private static final String DELETE_USER_SQL = "delete from users where id = ?";
    private static final String UPDATE_USER_SQL = "UPDATE  users SET name = ?, email = ?, country = ? WHERE id = ?";

    public UserDao() {}

    // DB 연결
    protected Connection getConnection() throws SQLException { // 상속 혹은 같은 패키지

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // CRUD 실행
    // 1. Create
    public void insertUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             // PreparedStatment 객체를 통해 SQL에 데이터를 바인딩
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
        }
    }

        // 2. Read
        public User selectUser(int id) throws  SQLException {
            User user = null; // 조회한 사용자 정보를 저장할 객체

            try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {
                ResultSet rs = preparedStatement.executeQuery(); // 쿼리 실행 후 결과 집합을 반환

                // 결과 집합에서 데이터가 존재하면 사용자 객체를 생성
                while (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String country = rs.getString("country");
                    user = new User(id, name, email, country);
                }
            }
            return user; // 조회된 사용자 반환 (없으면 null)
        }

        public List<User> selectAllUsers() throws SQLException {
            List<User> users = new ArrayList<>(); // 사용자 목록을 저장할 리스트

            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {
                ResultSet rs = preparedStatement.executeQuery(); // 쿼리 실행 후 결과 집합을 반환

                // 결과 집합에서 데이터가 존재하면 사용자 객체를 생성
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String country = rs.getString("country");
                    users.add(new User(id, name, email, country));
                }
            }
            return users; // 조회된 사용자 반환 (없으면 null)

        }

        // 4. Update
        public boolean updateUser(User user) throws SQLException {
            boolean rowUpdated;

            try (Connection connection = getConnection();
                 // PreparedStatment 객체를 통해 SQL에 데이터를 바인딩
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL)) {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                preparedStatement.setInt(4, user.getId());

                // excuteupdate() 메서드를 사용해 SQL 실행 및 수정된 행 수 반환
                rowUpdated = preparedStatement.executeUpdate() > 0; // 행이 업데이트 된 경우 true를 반환
            }

            return rowUpdated;
        }

        // 5. Delete
        public boolean deleteUser(int id) throws  SQLException {
            boolean rowDeleted;
            try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL)) {
                preparedStatement.setInt(1, id);
                rowDeleted = preparedStatement.executeUpdate() > 0;
            }

            return rowDeleted;
        }
    }


