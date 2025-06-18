SELECT 
    ed.id AS ID, 
    CASE 
      WHEN ed.per <= 0.25 THEN 'CRITICAL' 
      WHEN ed.per <= 0.50 THEN 'HIGH' 
      WHEN ed.per <= 0.75 THEN 'MEDIUM' 
      ELSE 'LOW' 
    END 
    AS COLONY_NAME 
FROM 
    (SELECT 
        ID, 
        PERCENT_RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) AS PER 
     FROM 
        ECOLI_DATA
    ) AS ed
ORDER BY ID;