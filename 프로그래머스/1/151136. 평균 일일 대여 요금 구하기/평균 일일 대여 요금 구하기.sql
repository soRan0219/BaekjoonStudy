-- 코드를 입력하세요
SELECT ROUND(AVG(daily_fee), 0)
FROM CAR_RENTAL_COMPANY_CAR
WHERE car_type = 'SUV';