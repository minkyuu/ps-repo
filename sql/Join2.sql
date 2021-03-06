-- 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59043?language=oracle 

-- 풀이 1
SELECT  I.ANIMAL_ID, I.NAME
FROM    ANIMAL_INS I, ANIMAL_OUTS O
WHERE   I.ANIMAL_ID = O.ANIMAL_ID
AND     O.DATETIME < I.DATETIME
ORDER BY I.DATETIME;

-- 풀이 2
SELECT  I.ANIMAL_ID, I.NAME
FROM    ANIMAL_INS I INNER JOIN ANIMAL_OUTS O
        ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE   O.DATETIME < I.DATETIME
ORDER BY I.DATETIME;
