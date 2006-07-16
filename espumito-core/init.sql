insert into core_security_objects (name, description) values ('ROOT', 'Root security object');
insert into core_security_objects (name, father_id, description) values ('ADMIN', 1, 'Administration');
insert into core_security_objects (name, father_id, description) values ('PUBLIC', 1, 'Public access');

insert into core_permissions (is_delete, is_execute, is_read, is_write, role_id, security_object_id) values (0, 1, 1, 0, 3, 3);
insert into core_permissions (is_delete, is_execute, is_read, is_write, role_id, security_object_id) values (1, 1, 1, 1, 1, 2);

insert into core_menues (name, security_object_id, titleKey) values ('sections', 3, 'menu.sections.title');
insert into core_menu_items (id, module_id, security_object_id, title_key, url, menu_id) values (1, '/reflexion', 3, 'menu.reflection', '/list', 1);
insert into core_menu_items (id, module_id, security_object_id, title_key, url, menu_id) values (2, '/forums', 3, 'menu.forums', '/index', 1);
insert into core_menu_items (id, module_id, security_object_id, title_key, url, menu_id) values (3, '/links', 3, 'menu.links', '/show', 1);
insert into core_menu_items (id, module_id, security_object_id, title_key, url, menu_id) values (4, '/guestbook', 3, 'menu.guestbook', '/showGuestbook', 1);

select * from roles
select * from core_permissions
select * from core_security_objects

create view core_permissions_view as select r.name as role, s.name as name, p.is_delete, p.is_execute, p.is_read, p.is_write from roles r, core_security_objects s, core_permissions p where r.id = p.role_id and p.security_object_id = s.id