-- 코드를 입력하세요
SELECT 
    f.flavor as FLAVOR
FROM first_half AS f JOIN icecream_info AS i ON f.flavor = i.flavor 
WHERE f.total_order > 3000 AND i.ingredient_type = 'fruit_based' 
ORDER BY f.total_order DESC;