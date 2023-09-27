/*
SELECT Statement Problems
1.	For event requests, list the event number, event date (eventrequest.dateheld),
 and count of the event plans.  Only include event requests in the result if the event request
 has more than one related event plan with a work date in December 2018.
*/

/*
select Req.EventNo,Req.DateHeld,count(Plan.EventNo) 
from EventRequest as Req, EventPlan as Plan 
where Req.eventNo = Plan.EventNo 
	and Plan.WorkDate between '2018-12-01' 
    and '2018-12-31' 
    group by Plan.EventNo 
    having count(Plan.EventNo)>1;
*/

/*
2.	List the plan number, event number, work date, and activity of event plans meeting
 the following two conditions: (1) the work date is in December 2018 and (2) the event
 is held in the “Basketball arena”.  Your query must not use the facility number (“F101”)
 of the basketball arena in the WHERE clause. Instead, you should use a condition
 on the FacName column for the value of “Basketball arena”.
*/

/*
select Plan.PlanNo, Plan.EventNo, Plan.WorkDate 
from EventPlan as Plan 
Join EventRequest as Req on Plan.EventNo = Req.EventNo 
Join Facility as Fac on Req.FacNo = Fac.FacNo
where Fac.FacName = 'Basketball arena';
*/

/*
3.	List the event number, event date, status, and estimated cost of events where
 there is an event plan managed by Mary Manager and the event is held in the basketball
 arena in the period October 1 to December 31, 2018.  Your query must not use the
 facility number (“F101”) of the basketball arena or the employee number (“E101”)
 of “Mary Manager” in the WHERE clause. Thus, the WHERE clause should not have conditions
 involving the facility number or employee number compared to constant values.
*/

/*
select Req.EventNo, Req.DateHeld,Status,EstCost 
from EventRequest as Req 
join EventPlan as Plan ON Plan.EventNo = Req.EventNo 
join Employee ON Plan.EmpNo = Employee.EmpNo
join Facility ON Req.FacNo = Facility.FacNo 
where FacName = 'Basketball arena' 
	and EmpName = 'Mary Manager' 
    and DateHeld between '2018-10-01' and '2018-12-31';
*/

/*
4.	List the plan number, line number, resource name, number of resources
 (eventplanline.number), location name, time start, and time end where the event is held
 at the basketball arena, the event plan has activity of activity of “Operation”,
 and the event plan has a work date in the period October 1 to December 31, 2018.
 Your query must not use the facility number (“F101”) of the basketball arena in the
 WHERE clause. Instead, you should use a condition on the FacName column for the
 value of “Basketball arena”.
*/

/*
select Line.PlanNo, Line.LineNo, ResName,NumberFld,LocName,TimeStart,TimeEnd 
from EventPlanLine as Line, ResourceTbl as Res, EventPlan as Plan, Location as Loc, Facility as Fac
where Line.PlanNo = Plan.PlanNo 
	and Line.ResNo = Res.Resno
    and Loc.LocNo = Line.LocNo 
	and  Fac.FacNo = Loc.FacNo
    and FacName = 'Basketball arena'
    and activity = 'Operation'
	and workDate between '2018-10-01' and '2018-12-31';
 */
 