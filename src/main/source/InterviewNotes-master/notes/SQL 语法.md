<!-- GFM-TOC -->
* [����](#����)
* [��ѯ](#��ѯ)
* [����](#����)
* [����](#����)
* [ͨ���](#ͨ���)
* [�����ֶ�](#�����ֶ�)
* [����](#����)
    * [�ı�����](#�ı�����)
    * [���ں�ʱ�䴦��](#���ں�ʱ�䴦��)
    * [��ֵ����](#��ֵ����)
    * [����](#����)
* [����](#����)
* [�Ӳ�ѯ](#�Ӳ�ѯ)
* [����](#����)
    * [������](#������)
    * [������](#������)
    * [��Ȼ����](#��Ȼ����)
    * [������](#������)
* [��ϲ�ѯ](#��ϲ�ѯ)
* [����](#����)
* [����](#����)
* [ɾ��](#ɾ��)
* [������](#������)
* [�޸ı�](#�޸ı�)
* [��ͼ](#��ͼ)
* [�洢����](#�洢����)
* [�α�](#�α�)
* [������](#������)
* [������](#������)
* [�ַ���](#�ַ���)
* [Ȩ�޹���](#Ȩ�޹���)
<!-- GFM-TOC -->

# ����

ģʽ��������������δ洢���洢ʲô���������Լ�������ηֽ����Ϣ�����ݿ�ͱ���ģʽ��

������ֵ�������޸ģ�Ҳ�������ã�����ʹ���Ѿ�ɾ��������ֵ�����������е���������

SQL��Structured Query Language)����׼ SQL �� ANSI ��׼ίԱ������Ӷ���Ϊ ANSI SQL������ DBMS �����Լ���ʵ�֣��� PL/SQL��Transact-SQL �ȡ�

# ��ѯ

SQL ��䲻���ִ�Сд���������ݿ������������ֵ�Ƿ����������ھ���� DBMS �Լ����á�

**DISTINCT**

��ֵֻͬ�����һ�Ρ��������������У�Ҳ����˵�����е�ֵ����ͬ������ͬ��

```sql
SELECT DISTINCT col1, col2
FROM mytable;
```

**LIMIT**

���Ʒ��ص�������������������������һ������Ϊ��ʼ�У��� 0 ��ʼ���ڶ�������Ϊ���ص���������

����ǰ 5 �е� SQL��

```sql
SELECT *
FROM mytable
LIMIT 5;
```

```sql
SELECT *
FROM mytable
LIMIT 0, 5;
```

���ص� 3 \~ 5 �У�

```sql
SELECT *
FROM mytable
LIMIT 2, 3;
```

**ע��**

```sql
# ע��
SELECT *
FROM mytable -- ע��
/* ע��1
   ע��2 */
```

# ����

**ASC**������Ĭ�ϣ�
**DESC**������

���԰�����н�������

```sql
SELECT *
FROM mytable
ORDER BY col1 DESC, col2 ASC;
```

# ����

��Ӧ�ò�Ҳ���Թ������ݣ����ǲ��ڷ������˽��й��˵����ݷǳ��󣬵���ͨ�����紫���˺ܶ��������ݣ��Ӷ��˷����������

```sql
SELECT *
FROM mytable
WHERE col IS NULL;
```

�±���ʾ�� WHERE �Ӿ���õĲ�����

|  ������ | ˵��  |
| ------------ | ------------ |
| = <  >  | ���� С�� ���� |
| <> !=  | ������  |
| <= !> | С�ڵ��� |
| >= !< | ���ڵ��� |
| BETWEEN | ������ֵ֮�� |
| IS NULL | ΪNULLֵ |

Ӧ��ע�⵽��NULL �� 0 �����ַ�������ͬ��

**AND OR** �������Ӷ���������������ȴ��� AND����˵�һ�����˱��ʽ�漰����� AND �� OR ʱ��Ӧ��ʹ�� () ���������ȼ���

**IN** ����������ƥ��һ��ֵ�����Ҳ���Խ�һ�� SELECT �Ӿ䣬�Ӷ�ƥ���Ӳ�ѯ�õ���һ��ֵ��

**NOT** ���������ڷ�һ��������

# ͨ���

ͨ���Ҳ�����ڹ�������У�ֻ�������ı��ֶΡ�

- **%** ƥ�� >=0 �������ַ��������� \*��

- **\_** ƥ�� ==1 �������ַ��������� \.��

- **[ ]** ����ƥ�伯���ڵ��ַ��������ַ� ^ ���Զ�����з�

ʹ�� Like ������ͨ���ƥ�䡣

```sql
SELECT *
FROM mytable
WHERE col LIKE '[^AB]%' -- ����AB��ͷ�������ı�
```

��Ҫ����ͨ�����ͨ���λ�ڿ�ͷ��ƥ���ǳ�����

# �����ֶ�

�����ݿ��������������ݵ�ת���͸�ʽ���Ĺ��������ȿͻ����Ͽ�ö࣬����ת���͸�ʽ��������������ٵĻ����Լ�������ͨ������

�����ֶ�ͨ����Ҫʹ�� **AS** ��ȡ���������������ʱ���ֶ���Ϊ������ʽ��

```sql
SELECT col1*col2 AS alias
FROM mytable
```

**Concat()** �������������ֶΡ�������ݿ��ʹ�ÿո��һ��ֵ���Ϊ�п�������ӵĽ�������һЩ����Ҫ�Ŀո�ʹ�� **TRIM()** ����ȥ����β�ո�

```sql
SELECT Concat(TRIM(col1), ' (', TRIM(col2), ')')
FROM mytable
```

# ����

���� DBMS �ĺ������ǲ���ͬ�ģ���˲�����ֲ��

## �ı�����

| ����  | ˵��  |
| ------------ | ------------ |
|  LEFT() RIGHT() |  ��߻����ұߵ��ַ� |
|  LOWER() UPPER() |  ת��ΪСд���ߴ�д |
| LTRIM() RTIM() | ȥ����߻����ұߵĿո� |
| LENGTH() | ���� |
| SUNDEX() | ת��Ϊ����ֵ |

���У�**SOUNDEX()** �ǽ�һ���ַ���ת��Ϊ������������ʾ����ĸ����ģʽ���㷨�����Ǹ��ݷ�����������ĸ�Ƚϡ�

```sql
SELECT *
FROM mytable
WHERE SOUNDEX(col1) = SOUNDEX('apple')
```
## ���ں�ʱ�䴦��

���ڸ�ʽ��YYYY-MM-DD

ʱ���ʽ��HH:MM:SS

|�� �� | ˵ ��|
| --- | --- |
| AddDate() | ����һ�����ڣ��졢�ܵȣ�|
| AddTime() | ����һ��ʱ�䣨ʱ���ֵȣ�|
| CurDate() | ���ص�ǰ���� |
| CurTime() | ���ص�ǰʱ�� |
|Date() |��������ʱ������ڲ���|
|DateDiff() |������������֮��|
|Date_Add() |�߶������������㺯��|
|Date_Format() |����һ����ʽ�������ڻ�ʱ�䴮|
|Day()| ����һ�����ڵ���������|
|DayOfWeek() |����һ�����ڣ����ض�Ӧ�����ڼ�|
|Hour() |����һ��ʱ���Сʱ����|
|Minute() |����һ��ʱ��ķ��Ӳ���|
|Month() |����һ�����ڵ��·ݲ���|
|Now() |���ص�ǰ���ں�ʱ��|
|Second() |����һ��ʱ����벿��|
|Time() |����һ������ʱ���ʱ�䲿��|
|Year() |����һ�����ڵ���ݲ���|

```sql
mysql> SELECT NOW();
        -> '2017-06-28 14:01:52'
```

## ��ֵ����

| ���� | ˵�� |
| --- | --- |
| SIN() | ���� |
|COS() | ���� |
| TAN() | ���� |
| ABS() | ����ֵ |
| SQRT() | ƽ����|
| MOD() | ����|
| EXP() | ָ��|
| PI() | Բ����|
|RAND() | �����|

## ����

|�� �� |˵ ��|
| --- | --- |
|AVG() |����ĳ�е�ƽ��ֵ|
|COUNT()| ����ĳ�е�����|
|MAX()| ����ĳ�е����ֵ|
|MIN()| ����ĳ�е���Сֵ|
|SUM() |����ĳ��ֵ֮��|

AVG() ����� NULL �С�

DISTINCT �ؼ��ֻ�ֻ���ܲ�ͬ��ֵ��

```sql
SELECT AVG(DISTINCT col1) AS avg_col
FROM mytable
```

# ����

������ǰ���ͬ�����ݷ���ͬһ���С�

���Զ�ÿ������ʹ�û��ܺ������д���������ÿ������ƽ��ֵ�ȡ�

�� col ���򲢷������ݣ�

```sql
SELECT col, COUNT(*) AS num
FROM mytable
GROUP BY col;
```

WHERE �����У�HAVING ���˷��飬�й���Ӧ�����������ˣ�

```sql
SELECT col, COUNT(*) AS num
FROM mytable
WHERE col > 2
GROUP BY col
HAVING COUNT(*) >= 2;
```

GROUP BY ��������Ϊ�����ֶΣ��� ORDER BY Ҳ�����Ծۼ��ֶ�����������

```sql
SELECT col, COUNT(*) AS num
FROM mytable
GROUP BY col
ORDER BY num;
```

����涨��

1. GROUP BY �Ӿ������ WHERE �Ӿ�֮��ORDER BY �Ӿ�֮ǰ��
2. ���˻��ܼ������֮�⣬SELECT ����е�ÿһ�ж������� GROUP BY �Ӿ��и�����
3. NULL ���лᵥ����Ϊһ�飻
4. ����� SQL ʵ�ֲ�֧�� GROUP BY �о��пɱ䳤�ȵ��������͡�

# �Ӳ�ѯ

�Ӳ�ѯ��ֻ�ܷ���һ���С�

���Խ��Ӳ�ѯ�Ľ����Ϊ WHRER ���Ĺ���������

```
SELECT *
FROM mytable1
WHERE col1 IN (SELECT col2
                 FROM mytable2);
```

����������Լ������ͻ��Ķ����������Ӳ�ѯ����Լ�������ÿ���ͻ�ִ��һ�Σ�

```sql
SELECT cust_name, (SELECT COUNT(*)
                   FROM Orders
                   WHERE Orders.cust_id = Customers.cust_id)
                   AS orders_num
FROM Customers
ORDER BY cust_name;
```

# ����

�����������Ӷ����ʹ�� JOIN �ؼ��֣������������ʹ�� ON��

���ӿ����滻�Ӳ�ѯ�����ұ��Ӳ�ѯ��Ч��һ�����졣

������ AS �������������ֶκͱ���ȡ������������ȡ������Ϊ�˼� SQL ����Լ�������ͬ��

## ������

�������ֳƵ�ֵ���ӣ�ʹ�� INNER JOIN �ؼ��֡�

```
select a, b, c
from A inner join B
on A.key = B.key
```

���Բ���ȷʹ�� INNER JOIN����ʹ����ͨ��ѯ���� WHERE �н���������Ҫ���ӵ����õ�ֵ��������������

```
select a, b, c
from A, B
where A.key = B.key
```

��û��������������·��صѿ�������

## ������

�����ӿ��Կ��������ӵ�һ�֣�ֻ�����ӵı���������ѡ�

һ��Ա��������Ա��������Ա���������ţ�Ҫ�ҳ��� Jim ����ͬһ���ŵ�����Ա��������

**�Ӳ�ѯ�汾**

```
select name
from employee
where department = (
      select department
      from employee
      where name = "Jim");
```

**�����Ӱ汾**

```
select name
from employee as e1, employee as e2
where e1.department = e2.department
      and e1.name = "Jim";
```

����һ����Ӳ�ѯ��Ч�ʸߡ�

## ��Ȼ����

��Ȼ�����ǰ�ͬ����ͨ����ֵ�������������ģ�ͬ���п����ж����

�����Ӻ���Ȼ���ӵ������������ṩ���ӵ��У�����Ȼ�����Զ���������ͬ���У�������������Ȼ���ӡ�

```
select *
from employee natural join department;
```

## ������

�����ӱ�����û�й�������Щ�С���Ϊ�������ӣ����������Լ�ȫ�����ӣ��������Ӿ��Ǳ������������С�

�������й˿͵Ķ�����Ϣ��������û�ж�����Ϣ�Ĺ˿͡�

```
select Customers.cust_id, Orders.order_num
   from Customers left outer join Orders
   on Customers.cust_id = Orders.curt_id
```

�����Ҫͳ�ƹ˿͵Ķ�������ʹ�þۼ�������

```
select Customers.cust_id,
       COUNT(Orders.order_num) as num_ord
from Customers left outer join Orders
on Customers.cust_id = Orders.curt_id
group by Customers.cust_id
```

# ��ϲ�ѯ

ʹ�� **UNION** ������������ѯ��ÿ����ѯ���������ͬ���С����ʽ���߾ۼ�������

Ĭ�ϻ�ȥ����ͬ�У������Ҫ������ͬ�У�ʹ�� UNION ALL ��

ֻ�ܰ���һ�� ORDER BY �Ӿ䣬���ұ���λ���������

```sql
SELECT col
FROM mytable
WHERE col = 1
UNION
SELECT col
FROM mytable
WHERE col =2;
```

# ����

**��ͨ����**

```sql
INSERT INTO mytable(col1, col2)
VALUES(val1, val2);
```

**�����������������**

```sql
INSERT INTO mytable1(col1, col2)
SELECT col1, col2
FROM mytable2;
```

**��һ��������ݸ��Ƶ�һ���±�**

```sql
CREATE TABLE newtable AS
SELECT * FROM mytable;
```

# ����

```sql
UPDATE mytable
SET col = val
WHERE id = 1;
```

# ɾ��

```sql
DELETE FROM mytable
WHERE id = 1;
```

**TRUNCATE TABLE** ������ձ�Ҳ����ɾ�������С�

ʹ�ø��º�ɾ������ʱһ��Ҫ�� WHERE �Ӿ䣬��Ȼ������ű�����ݶ��ƻ����������� SELECT �����в��ԣ���ֹ����ɾ����

# ������

```sql
CREATE TABLE mytable (
  id INT NOT NULL AUTO_INCREMENT,
  col1 INT NOT NULL DEFAULT 1,
  col2 VARCHAR(45) NULL,
  col3 DATE NULL,
  PRIMARY KEY (`id`));
```

# �޸ı�

**�����**

```sql
ALTER TABLE mytable
ADD col CHAR(20);
```

**ɾ����**

```sql
ALTER TABLE mytable
DROP COLUMN col;
```

**ɾ����**

```sql
DROP TABLE mytable;
```

# ��ͼ

��ͼ������ı������������ݣ�Ҳ�Ͳ��ܶ��������������������ͼ�Ĳ����Ͷ���ͨ��Ĳ���һ����

��ͼ�������ºô���

1. �򻯸��ӵ� SQL ���������縴�ӵ����᣻
2. ֻʹ��ʵ�ʱ��һ�������ݣ�
3. ͨ��ֻ���û�������ͼ��Ȩ�ޣ���֤���ݵİ�ȫ�ԣ�
4. �������ݸ�ʽ�ͱ�ʾ��

```sql
CREATE VIEW myview AS
SELECT Concat(col1, col2) AS concat_col, col3*col4 AS count_col
FROM mytable
WHERE col5 = val;
```

# �洢����

�洢���̿��Կ����Ƕ�һϵ�� SQL ������������

**ʹ�ô洢���̵ĺô�**

1. ��ʵ�ַ�װ���˴洢�����У������򵥣�Ҳ��֤�˰�ȫ�ԣ�
2. ���Ը��ô��룻
3. ������Ԥ�ȱ��룬��˾��кܸߵ����ܡ�

**�����洢����**

�������д����洢������Ҫ�Զ���ָ�������Ϊ���������� ; Ϊ�����������洢������Ҳ�����˷ֺţ���˻������ⲿ�ַֺŵ����ǽ�����������﷨����

���� in��out �� inout ���ֲ�����

��������ֵ����Ҫ�� select into ��䡣

ÿ��ֻ�ܸ�һ��������ֵ����֧�ּ��ϵĲ�����

```sql
delimiter //

create procedure myprocedure( out ret int )
    begin
        declare y int;
        select sum(col1)
        from mytable
        into y;
        select y*y into ret;
    end //
delimiter ;
```

```sql
call myprocedure(@ret);
select @ret;
```

# �α�

�ڴ洢������ʹ���α���Զ�һ������������ƶ�������

�α���Ҫ���ڽ���ʽӦ�ã������û���Ҫ�����ݼ��е������н���������޸ġ�

**ʹ���α���ĸ����裺**

1. �����α꣬�������û��ʵ�ʼ��������ݣ�
2. ���αꣻ
3. ȡ�����ݣ�
4. �ر��αꣻ

```sql
delimiter //
create procedure myprocedure(out ret int)
    begin
        declare done boolean default 0;

        declare mycursor cursor for
        select col1 from mytable;
        # ������һ��continue handler���� sqlstate '02000' �����������ʱ����ִ�� set done = 1
        declare continue handler for sqlstate '02000' set done = 1;

        open mycursor;

        repeat
            fetch mycursor into ret;
            select ret;
        until done end repeat;

        close mycursor;
    end //
 delimiter ;
```

# ������

����������ĳ����ִ���������ʱ���Զ�ִ�У�DELETE��INSERT��UPDATE

����������ָ�������ִ��֮ǰ����֮���Զ�ִ�У�֮ǰִ��ʹ�� BEFORE �ؼ��֣�֮��ִ��ʹ�� AFTER �ؼ��֡�BEFORE ����������֤�;�����

INSERT ����������һ����Ϊ NEW �������

```sql
CREATE TRIGGER mytrigger AFTER INSERT ON mytable
FOR EACH ROW SELECT NEW.col;
```

DELETE ����������һ����Ϊ OLD �������������ֻ���ġ�

UPDATE ����������һ����Ϊ NEW ��һ����Ϊ OLD ����������� NEW �ǿ��Ա��޸ĵأ��� OLD ��ֻ���ġ�

����ʹ�ô�������������Ƹ��٣����޸ļ�¼������һ�ű��С�

MySQL �������ڴ�������ʹ�� CALL ��� ��Ҳ���ǲ��ܵ��ô洢���̡�

# ������

**��������**

1. ����transaction��ָһ�� SQL ��䣻
2. ���ˣ�rollback��ָ����ָ�� SQL ���Ĺ��̣�
3. �ύ��commit��ָ��δ�洢�� SQL �����д�����ݿ��
4. �����㣨savepoint��ָ�����������õ���ʱռλ����placeholder��������Զ����������ˣ����������������ͬ����

���ܻ��� SELECT ��䣬���� SELECT ���Ҳû���壻Ҳ���ܻ��� CRETE �� DROP ��䡣

MySQL �������ύĬ������ʽ�ύ��Ҳ����ÿִ��һ�����ͻ��ύһ�Ρ������� START TRANSACTION ���ʱ����ر���ʽ�ύ���� COMMIT �� ROLLBACK ���ִ�к�������Զ��رգ����»ָ���ʽ�ύ��

ͨ������ autocommit Ϊ 0 ����ȡ���Զ��ύ��ֱ�� autocommit ������Ϊ 1 �Ż��ύ��autocommit ��������ÿ�����Ӷ�������Է������ġ�

���û�����ñ����㣬ROLLBACK ����˵� START TRANSACTION ��䴦����������˱����㣬������ ROLLBACK ��ָ���ñ����㣬�����˵��ñ����㡣

```sql
START TRANSACTION
// ...
SAVEPOINT delete1
// ...
ROLLBACK TO delete1
// ...
COMMIT
```

# �ַ���

**��������**

1. �ַ���Ϊ��ĸ�ͷ��ŵļ��ϣ�
2. ����Ϊĳ���ַ�����Ա���ڲ���ʾ��
3. У���ַ�ָ����αȽϣ���Ҫ��������ͷ��顣

���˸���ָ���ַ�����У���⣬Ҳ���Ը���ָ����

```sql
CREATE TABLE mytable
(col VARCHAR(10) CHARACTER SET latin COLLATE latin1_general_ci )
DEFAULT CHARACTER SET hebrew COLLATE hebrew_general_ci;
```

���������򡢷���ʱָ��У�ԣ�

```sql
SELECT *
FROM mytable
ORDER BY col COLLATE latin1_general_ci;
```

# Ȩ�޹���

MySQL ���˻���Ϣ������ mysql ������ݿ��С�

```sql
USE mysql;
SELECT user FROM user;
```

**�����˻�**

```sql
CREATE USER myuser IDENTIFIED BY 'mypassword';
```

�´������˻�û���κ�Ȩ�ޡ�

**�޸��˻���**

```sql
RENAME myuser TO newuser;
```

**ɾ���˻�**

```sql
DROP USER myuser;
```

**�鿴Ȩ��**

```sql
SHOW GRANTS FOR myuser;
```
![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/c73aa08e-a987-43c9-92be-adea4a884c25.png)

�˻��� username@host ����ʽ���壬username@% ʹ�õ���Ĭ����������

**����Ȩ��**

```sql
GRANT SELECT, INSERT ON mydatabase.* TO myuser;
```

**ɾ��Ȩ��**

```sql
REVOKE SELECT, INSERT ON mydatabase.* FROM myuser;
```

GRANT �� REVOKE ���ڼ�������Ͽ��Ʒ���Ȩ�ޣ�

- ������������ʹ�� GRANT ALL�� REVOKE ALL��
- �������ݿ⣬ʹ�� ON database.\*��
- �ض��ı�ʹ�� ON database.table��
- �ض����У�
- �ض��Ĵ洢���̡�

**��������**

����ʹ�� Password() ����

```sql
SET PASSWROD FOR myuser = Password('newpassword');
```

