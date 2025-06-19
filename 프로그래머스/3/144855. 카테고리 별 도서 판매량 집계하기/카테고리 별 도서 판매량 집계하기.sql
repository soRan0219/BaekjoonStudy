-- 코드를 입력하세요
SELECT 
    category, SUM(sales) AS TOTAL_SALES 
FROM 
    book b JOIN book_sales s ON b.book_id=s.book_id 
WHERE 
    YEAR(s.sales_date)=2022 AND MONTH(s.sales_date)=01 
GROUP BY b.category 
ORDER BY b.category ASC;
