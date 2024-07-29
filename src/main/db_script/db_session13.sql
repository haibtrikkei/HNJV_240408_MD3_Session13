use db_jv240408_session13;

delimiter $$
create procedure update_employee(
    empId_in int,
    fullName_in varchar(50),
    gender_in bit,
    birthday_in datetime,
    address_in varchar(200),
    depId_in varchar(15)
)
begin
    update employees set fullName=fullName_in,gender=gender_in,birthday=birthday_in,address=address_in,depId=depId_in where empId=empId_in;
end $$;

delimiter $$
create procedure get_all_employee()
begin
    select e.*,d.depName from employees e inner join departments d on e.depId=d.depId;
end $$;

delimiter $$
create procedure get_employee_by_id(empId_in int)
begin
    select e.*,d.depName from employees e inner join departments d on e.depId=d.depId where e.empId=empId_in;
end $$;

delimiter $$
create procedure delete_employee(empId_in int)
begin
    delete from employees where empId = empId_in;
end $$;

delimiter $$
create procedure get_employee_by_name(empName_in varchar(50))
begin
    select e.*,d.depName from employees e inner join departments d on e.depId=d.depId where e.fullName like concat('%',empName_in,'%');
end $$;

delimiter $$
create procedure get_all_department()
begin
select * from departments where status = 1;
end $$;