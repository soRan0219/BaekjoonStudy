-- 코드를 입력하세요
SELECT 
    i.rest_id as REST_ID, 
    i.rest_name as REST_NAME, 
    i.food_type as FOOD_TYPE, 
    i.favorites as FAVORITES, 
    i.address as ADDRESS, 
    ROUND(AVG(r.review_score), 2) as SCORE 
FROM 
    REST_INFO i INNER JOIN REST_REVIEW r ON i.rest_id = r.rest_id 
WHERE 
    i.address LIKE '서울%' 
GROUP BY 
    i.rest_id 
ORDER BY 
    SCORE DESC, FAVORITES DESC;