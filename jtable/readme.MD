-- mysql query문
-- 기존에 동일한 이름의 DB가 있을 경우 삭제 (선택사항)
DROP DATABASE IF EXISTS cotegory;

-- 데이터베이스 생성
CREATE DATABASE cotegory;
USE cotegory;

-- 카테고리 테이블
CREATE TABLE Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL UNIQUE
);

-- 음식 테이블
CREATE TABLE Food (
    food_id INT AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(100) NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

-- 재료 테이블
CREATE TABLE Ingredient (
    ingredient_id INT AUTO_INCREMENT PRIMARY KEY,
    ingredient_name VARCHAR(100) NOT NULL UNIQUE
);

-- 음식-재료 매핑 테이블
CREATE TABLE Food_Ingredient (
    food_id INT,
    ingredient_id INT,
    PRIMARY KEY (food_id, ingredient_id),
    FOREIGN KEY (food_id) REFERENCES Food(food_id),
    FOREIGN KEY (ingredient_id) REFERENCES Ingredient(ingredient_id)
);

-- 카테고리 데이터 삽입
INSERT INTO Category (category_name) VALUES 
('한식'), 
('중식'), 
('양식'), 
('일식');

-- 음식 데이터 삽입
INSERT INTO Food (food_name, category_id) VALUES 
('비빔밥', 1), 
('불고기', 1), 
('김치찌개', 1), 
('짜장면', 2), 
('탕수육', 2), 
('마파두부', 2), 
('스파게티', 3), 
('피자', 3), 
('스테이크', 3), 
('초밥', 4), 
('라멘', 4), 
('우동', 4);

-- 재료 데이터 삽입
INSERT INTO Ingredient (ingredient_name) VALUES 
('쌀'), 
('고추장'), 
('소고기'), 
('김치'), 
('돼지고기'), 
('면'), 
('춘장'), 
('돼지고기 등심'), 
('전분'), 
('두부'), 
('토마토 소스'), 
('치즈'), 
('밀가루'), 
('생선'), 
('다시마');

-- 음식-재료 매핑 데이터 삽입
INSERT INTO Food_Ingredient (food_id, ingredient_id) VALUES
(1, 1),  -- 비빔밥 - 쌀
(1, 2),  -- 비빔밥 - 고추장
(2, 3),  -- 불고기 - 소고기
(3, 4),  -- 김치찌개 - 김치
(3, 5),  -- 김치찌개 - 돼지고기
(4, 6),  -- 짜장면 - 면
(4, 7),  -- 짜장면 - 춘장
(5, 8),  -- 탕수육 - 돼지고기 등심
(5, 9),  -- 탕수육 - 전분
(6, 10), -- 마파두부 - 두부
(7, 6),  -- 스파게티 - 면
(7, 11), -- 스파게티 - 토마토 소스
(8, 12), -- 피자 - 치즈
(8, 13), -- 피자 - 밀가루
(9, 3),  -- 스테이크 - 소고기
(10, 14),-- 초밥 - 생선
(11, 6), -- 라멘 - 면
(11, 15),-- 라멘 - 다시마
(12, 6); -- 우동 - 면

-- 조회 예시: 음식, 카테고리 및 재료를 한 번에 보여주기
SELECT 
    F.food_id,
    F.food_name,
    C.category_name,
    GROUP_CONCAT(I.ingredient_name SEPARATOR ', ') AS ingredients
FROM Food AS F
LEFT JOIN Category AS C ON F.category_id = C.category_id
LEFT JOIN Food_Ingredient AS FI ON F.food_id = FI.food_id
LEFT JOIN Ingredient AS I ON FI.ingredient_id = I.ingredient_id
GROUP BY F.food_id, F.food_name, C.category_name;
