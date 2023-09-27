/*
SQL Statements with Errors and Poor Formatting
1.Identify errors in the following SQL statement and label errors with error type 
(syntax, redundancy, or semantic). To simplify your work, the statement has only one type
 of error. Rewrite the statement to remove the error.
SELECT eventrequest.eventno, dateheld, status, estcost
FROM eventrequest, employee, facility, eventplan
WHERE estaudience > 5000
  AND eventplan.empno = employee.empno 
  AND eventrequest.facno = facility.facno
  AND facname = 'Football stadium' 
  AND empname = 'Mary Manager'
*/

/*
Semantic Error :  "AND eventrequest.eventno = eventplan.eventno" is missing
*/

/*
SELECT eventrequest.eventno, dateheld, status, estcost
FROM eventrequest, employee, facility, eventplan
WHERE estaudience > 5000
  AND eventplan.empno = employee.empno 
  AND eventrequest.facno = facility.facno
  AND eventrequest.eventno = eventplan.eventno
  AND facname = 'Football stadium' 
  AND empname = 'Mary Manager';
*/

/*
2.Identify errors in the following SQL statement and label errors with error type
 (syntax, redundancy, or semantic). To simplify your work, the statement has only
 one type of error. Rewrite the statement to remove the error.
SELECT DISTINCT eventrequest.eventno, dateheld, status, estcost
FROM eventrequest, eventplan
WHERE estaudience > 4000
  AND eventplan.eventno = eventrequest.eventno 
GROUP BY eventrequest.eventno, dateheld, status, estcost
*/

/*
Redundancy Error : there can be only DISTINCT or GROUP BY 
*/

/*
SELECT DISTINCT eventrequest.eventno, dateheld, status, estcost
FROM eventrequest, eventplan
WHERE estaudience > 4000
  AND eventplan.eventno = eventrequest.eventno;
 */ 
  
/*
3.Identify errors in the following SQL statement and label errors with error type
 (syntax, redundancy, or semantic). To simplify your work, the statement has only
 one type of error. Rewrite the statement to remove the error.
SELECT DISTINCT eventrequest.eventno, dateheld, status, estcost
FROM eventrequest, employee, facility, eventplan
WHERE estaudience > 5000
  AND eventplan.empno = employee.empno 
  AND eventrequest.facno = facility.facno
  AND eventplan.eventno = eventrequest.eventno 
  AND facname = 'Football stadium' 
*/

/*
Redundency : Employee Table is redundant
*/

/*
SELECT DISTINCT eventrequest.eventno, dateheld, status, estcost
FROM eventrequest, facility, eventplan
WHERE estaudience > 5000
  AND eventrequest.facno = facility.facno
  AND eventplan.eventno = eventrequest.eventno 
  AND facname = 'Football stadium' ;
*/

/*
4.Identify errors in the following SQL statement and label errors with error type (syntax, redundancy, or semantic). To simplify your work, the statement has only one type of error. Rewrite the statement to remove the errors.
SELECT DISTINCT eventno, dateheld, status, estcost
FROM eventrequest, employee, eventplan
WHERE estaudience BETWEN 5000 AND 10000
  AND eventplan.empno = employee.empno 
  AND eventrequest.eventno = eventplan.eventno
  AND empname = 'Mary Manager'
*/

/*
Syntac Error : BEWEEN spelling is wrong and eventno is ambiguous
*/

/*
SELECT DISTINCT eventrequest.eventno, dateheld, status, estcost
FROM eventrequest, employee, eventplan
WHERE estaudience BETWEEN 5000 AND 10000
  AND eventplan.empno = employee.empno 
  AND eventrequest.eventno = eventplan.eventno
  AND empname = 'Mary Manager';
*/

/*
5.Identify areas in which the SQL statement has poor coding practices and rewrite the
 statement to improve the coding practices. You do not need to search for errors.
      SELECT eventplan.planno, lineno, resname, 
numberfld, timestart, timeend
    FROM eventrequest, facility, eventplan, 
eventplanline, resourcetbl
     WHERE estaudience = '10000'
AND eventplan.planno = 
eventplanline.planno AND eventrequest.facno 
= facility.facno
      AND facname = 
'Basketball arena' AND 
   eventplanline.resno = resourcetbl.resno
      AND eventrequest.eventno = eventplan.eventno 
*/

/*
SELECT eventplan.planno, lineno, resname, numberfld, timestart, timeend
FROM eventrequest, facility, eventplan, eventplanline, resourcetbl
WHERE estaudience = '10000'
	AND eventplan.planno = eventplanline.planno
    AND eventrequest.facno = facility.facno
    AND eventplanline.resno = resourcetbl.resno
	AND eventrequest.eventno = eventplan.eventno
    AND facname = 'Basketball arena';
*/