delete from user_roles;
delete from roles;
delete from users;
delete from cities;
delete from states;

insert into roles (id, name) values(1, 'ROLE_ADMIN');
insert into roles (id, name) values(2, 'ROLE_CLIENT');
insert into users (id, email, name, password, username) values(1,'olivan@teste.com','olivan','$2a$10$Bd1oc2wcyOSD0YxgpdOcTuU2IAmmjpWZJug41uN2raQE.fegzIIVK','olivan');
insert into users (id, email, name, password, username) values(2,'rony@teste.com','rony','$2a$10$Bd1oc2wcyOSD0YxgpdOcTuU2IAmmjpWZJug41uN2raQE.fegzIIVK','rony');
insert into users (id, email, name, password, username) values(3,'rivaldo@teste.com','rivaldo','$2a$10$Bd1oc2wcyOSD0YxgpdOcTuU2IAmmjpWZJug41uN2raQE.fegzIIVK','rivaldo');
insert into user_roles (user_id, role_id) values(1,1);
insert into user_roles (user_id, role_id) values(1,2);
insert into user_roles (user_id, role_id) values(2,1);
insert into user_roles (user_id, role_id) values(2,2);
insert into user_roles (user_id, role_id) values(3,1);
insert into user_roles (user_id, role_id) values(3,2);
ALTER SEQUENCE users_id_seq RESTART;
UPDATE users SET id = DEFAULT;

insert into states (id, name, acronym) values(1, 'Piauí', 'PI');
insert into states (id, name, acronym) values(2, 'Maranhão', 'PI');
ALTER SEQUENCE states_id_seq RESTART;
UPDATE states SET id = DEFAULT;

insert into cities (id, name, state_id) values(1,'Teresina',1);
insert into cities (id, name, state_id) values(2,'Luis Correia',1);
insert into cities (id, name, state_id) values(3,'Parnaiba',1);
insert into cities (id, name, state_id) values(4,'Timo',2);
insert into cities (id, name, state_id) values(5,'Arame',2);
ALTER SEQUENCE cities_id_seq RESTART;
UPDATE cities SET id = DEFAULT;


