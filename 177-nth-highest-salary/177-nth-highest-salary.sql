CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE ans INT; declare newN INT;
    SET newN = N-1;
    select (select distinct salary from Employee order by salary desc limit 1 offset newN) as salary into ans;
    RETURN (
      ans
    );
END