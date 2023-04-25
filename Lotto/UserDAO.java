package Lotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	// 연결하기
	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "service";
			String pw = "12345";
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
	}

	// 연결해제
	private void close() {
		if (rs != null) {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

    // 회원가입
    public boolean signup(String id, String pw){
        getConn();
		try {
			String sql = "insert into member values (?, ?, null)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);

			int result = pstm.executeUpdate();
			if (result > 0) {
                close();
				return true;
			}

		} catch (SQLException e) {
			System.out.println("쿼리문 오류");
			e.printStackTrace();
		}
		close();
		return false;
    }

    // 로그인
    public UserDTO login(String id, String pw){
        getConn();
		UserDTO dto = null;
		try {
			String sql = "select * from member where ID = ? and PW = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			rs = pstm.executeQuery();
			if(rs.next()){
                return dto;
            }
		} catch (SQLException e) {
			System.out.println("쿼리문 오류");
			e.printStackTrace();
		}
		close();
		return dto;
    }
    
}
