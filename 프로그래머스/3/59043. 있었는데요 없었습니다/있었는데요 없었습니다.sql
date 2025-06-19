-- 코드를 입력하세요
SELECT 
    outs.animal_id, outs.name 
FROM 
    animal_ins ins JOIN animal_outs outs ON ins.animal_id=outs.animal_id 
WHERE 
    outs.datetime < ins.datetime 
ORDER BY 
    ins.datetime ASC;