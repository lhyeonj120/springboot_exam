insert into user values(9001, sysdate(), 'User1', 'test1', '70000');
insert into user values(9002, sysdate(), 'User2', 'test2', '80000');
insert into user values(9003, sysdate(), 'User3', 'test3', '90000');

insert into post values(1001, 'My first post', 9001);
insert into post values(1002, 'My second post', 9001);