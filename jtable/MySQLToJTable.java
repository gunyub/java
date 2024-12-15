package mySQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MySQLToJTable {
    public static void main(String[] args) {
        // 데이터베이스 연결 정보 설정
        // useSSL=false : SSL 미사용
        // allowPublicKeyRetrieval=true : Public Key Retrieval 허용 (MySQL 8.0 인증 문제 해결용)
        // serverTimezone=UTC : 서버 타임존 설정
        String url = "jdbc:mysql://localhost:3306/category?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";        // DB 접속 계정명
        String password = "Kim121426!";  // DB 접속 비밀번호

        // JFrame(윈도우) 생성
        JFrame frame = new JFrame("음식 데이터 뷰어");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // JTable에 데이터를 뿌려줄 DefaultTableModel 생성
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // 음식, 카테고리, 재료를 JOIN하여 조회하는 쿼리
        // GROUP_CONCAT를 사용하여 한 음식에 해당하는 모든 재료를 하나의 칼럼에 쉼표로 구분하여 표시
        String query = 
            "SELECT " +
            "   F.food_id, " +
            "   F.food_name, " +
            "   C.category_name, " +
            "   GROUP_CONCAT(I.ingredient_name SEPARATOR ', ') AS ingredients " +
            "FROM Food AS F " +
            "LEFT JOIN Category AS C ON F.category_id = C.category_id " +
            "LEFT JOIN Food_Ingredient AS FI ON F.food_id = FI.food_id " +
            "LEFT JOIN Ingredient AS I ON FI.ingredient_id = I.ingredient_id " +
            "GROUP BY F.food_id, F.food_name, C.category_name";

        try (
            // DB 연결 시도
            Connection conn = DriverManager.getConnection(url, user, password);
            // 쿼리 실행을 위한 Statement 객체 생성
            Statement stmt = conn.createStatement();
            // 쿼리 실행 결과를 담은 ResultSet 반환
            ResultSet rs = stmt.executeQuery(query)
        ) {

            // 메타데이터를 이용해 칼럼명 가져오기
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // 테이블 모델에 칼럼명 추가
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // ResultSet의 각 행을 테이블 모델에 추가
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    // i+1인 이유: ResultSet 칼럼 인덱스는 1부터 시작
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }

        } catch (SQLException e) {
            // DB 연결/쿼리 실행 중 발생할 수 있는 예외 처리
            e.printStackTrace();
        }

        // 구성한 JFrame 표시
        frame.setVisible(true);
    }
}
