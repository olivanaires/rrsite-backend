delete from user_roles;
delete from roles;
delete from users;
insert into roles (id, name) values(1, 'ROLE_ADMIN');
insert into roles (id, name) values(2, 'ROLE_CLIENT');
insert into users (id, email, name, password, username) values(1,'olivan@teste.com','olivan','$2a$10$Bd1oc2wcyOSD0YxgpdOcTuU2IAmmjpWZJug41uN2raQE.fegzIIVK','olivan');
insert into user_roles (user_id, role_id) values(1,1);
insert into user_roles (user_id, role_id) values(1,2);


delete from cities;
delete from states;
insert into states (id, name, acronym) values(1, 'Piauí', 'PI');
insert into states (id, name, acronym) values(2, 'Maranhão', 'PI');
insert into cities (id, name, state_id) values(1,'Teresina',1);
insert into cities (id, name, state_id) values(2,'Luis Correia',1);
insert into cities (id, name, state_id) values(3,'Parnaiba',1);
insert into cities (id, name, state_id) values(4,'Timo',2);
insert into cities (id, name, state_id) values(5,'Arame',2);
