alter table core_new_permission_policies drop foreign key FK78924013124F3B2type=InnoDB;
alter table core_new_permission_policies drop foreign key FK7892401D1Btype=InnoDB;
alter table core_extended_permissions_operations drop foreign key FK715AC7ADEFA94EF3type=InnoDB;
alter table core_extended_permissions_operations drop foreign key FK715AC7ADA144CD05type=InnoDB;
alter table core_menu_items drop foreign key FK29AB998038A56BFBtype=InnoDB;
alter table core_menu_items drop foreign key FK29AB9980CDF3DCtype=InnoDB;
alter table core_menues drop foreign key FKE3CC92EDCDF3DCtype=InnoDB;
alter table core_permission_extended_permissions drop foreign key FK247C364EA144CD05type=InnoDB;
alter table core_permission_extended_permissions drop foreign key FK247C364EAA55FEB6type=InnoDB;
alter table core_security_objects drop foreign key FKF1B4A7B5732D70D8type=InnoDB;
alter table core_security_objects drop foreign key FKF1B4A7B51F259EDEtype=InnoDB;
alter table core_default_permission_policies drop foreign key FK162D06223124F3B2type=InnoDB;
alter table core_default_permission_policies drop foreign key FK162D0622D1Btype=InnoDB;
alter table role_groups_roles drop foreign key FK358BF5BB1E2E76DBtype=InnoDB;
alter table role_groups_roles drop foreign key FK358BF5BB52119584type=InnoDB;
alter table core_simple_sockets drop foreign key FK5CDA827393E6D1A7type=InnoDB;
alter table core_simple_sockets drop foreign key FK5CDA8273D1Btype=InnoDB;
alter table core_operations drop foreign key FK2F91D48CCA65A6E7type=InnoDB;
alter table core_permissions drop foreign key FKFE808BE430880107type=InnoDB;
alter table core_permissions drop foreign key FKFE808BE4167E6353type=InnoDB;
alter table core_permissions drop foreign key FKFE808BE452119584type=InnoDB;
alter table core_permissions drop foreign key FKFE808BE4E7D6477Dtype=InnoDB;
alter table core_permissions drop foreign key FKFE808BE4A34022FCtype=InnoDB;
alter table core_multi_sockets drop foreign key FK2CBF41BAD1Btype=InnoDB;
alter table user_roles drop foreign key FK7342994952119584type=InnoDB;
alter table user_roles drop foreign key FK73429949F73AEE0Ftype=InnoDB;
alter table core_plugins drop foreign key FK40C6BF00D6C53967type=InnoDB;
drop table if exists core_new_permission_policiestype=InnoDB;
drop table if exists core_extended_permissions_operationstype=InnoDB;
drop table if exists core_menu_itemstype=InnoDB;
drop table if exists core_menuestype=InnoDB;
drop table if exists core_permission_extended_permissionstype=InnoDB;
drop table if exists core_security_objectstype=InnoDB;
drop table if exists core_default_permission_policiestype=InnoDB;
drop table if exists rolestype=InnoDB;
drop table if exists core_socketstype=InnoDB;
drop table if exists role_groups_rolestype=InnoDB;
drop table if exists core_simple_socketstype=InnoDB;
drop table if exists core_operationstype=InnoDB;
drop table if exists userstype=InnoDB;
drop table if exists role_groupstype=InnoDB;
drop table if exists core_permissionstype=InnoDB;
drop table if exists core_extended_permissionstype=InnoDB;
drop table if exists core_multi_socketstype=InnoDB;
drop table if exists user_rolestype=InnoDB;
drop table if exists core_permission_policiestype=InnoDB;
drop table if exists core_pluginstype=InnoDB;
create table core_new_permission_policies (
   id bigint not null,
   anonymous_role_id bigint,
   primary key (id)
)type=InnoDB;
create table core_extended_permissions_operations (
   extended_permission_id bigint not null,
   operation_id bigint not null,
   primary key (extended_permission_id, operation_id)
)type=InnoDB;
create table core_menu_items (
   id bigint not null,
   module_id varchar(255),
   order_seq integer,
   security_object_id bigint,
   title_key varchar(255),
   url varchar(255),
   menu_id bigint,
   parent_item_id bigint,
   primary key (id)
)type=InnoDB;
create table core_menues (
   id bigint not null auto_increment,
   name varchar(255),
   security_object_id bigint,
   titleKey varchar(255),
   primary key (id)
)type=InnoDB;
create table core_permission_extended_permissions (
   permissions_id bigint not null,
   extended_permission_id bigint not null,
   primary key (permissions_id, extended_permission_id)
)type=InnoDB;
create table core_security_objects (
   id bigint not null,
   description varchar(255),
   father_id bigint,
   name varchar(255),
   permission_policy_id bigint,
   primary key (id)
)type=InnoDB;
create table core_default_permission_policies (
   id bigint not null,
   anonymous_role_id bigint,
   primary key (id)
)type=InnoDB;
create table roles (
   id bigint not null,
   description varchar(255),
   name varchar(255),
   primary key (id)
)type=InnoDB;
create table core_sockets (
   id bigint not null auto_increment,
   name varchar(255) not null unique,
   description varchar(255),
   class varchar(255) not null,
   primary key (id)
)type=InnoDB;
create table role_groups_roles (
   group_id bigint not null,
   role_id bigint not null,
   primary key (group_id, role_id)
)type=InnoDB;
create table core_simple_sockets (
   id bigint not null,
   plugin_id bigint,
   primary key (id)
)type=InnoDB;
create table core_operations (
   id bigint not null auto_increment,
   description varchar(255),
   menu_item_id bigint,
   name varchar(255),
   primary key (id)
)type=InnoDB;
create table users (
   id bigint not null,
   display_name varchar(255),
   email varchar(255),
   enabled varchar(255),
   first_name varchar(255),
   last_name varchar(255),
   password varchar(255),
   registration_date datetime,
   username varchar(255),
   primary key (id)
)type=InnoDB;
create table role_groups (
   id bigint not null,
   name varchar(255) not null unique,
   primary key (id)
)type=InnoDB;
create table core_permissions (
   id bigint not null auto_increment,
   delete_operation_id bigint,
   execute_operation_id bigint,
   read_operation_id bigint,
   role_id bigint,
   write_operation_id bigint,
   is_delete bit,
   is_execute bit,
   is_read bit,
   is_write bit,
   security_object_id bigint,
   primary key (id)
)type=InnoDB;
create table core_extended_permissions (
   id bigint not null auto_increment,
   description varchar(255),
   name varchar(255) unique,
   primary key (id)
)type=InnoDB;
create table core_multi_sockets (
   id bigint not null,
   primary key (id)
)type=InnoDB;
create table user_roles (
   user_id bigint not null,
   role_id bigint not null,
   primary key (user_id, role_id)
)type=InnoDB;
create table core_permission_policies (
   id bigint not null auto_increment,
   type varchar(255) not null,
   description varchar(255),
   name varchar(255),
   primary key (id)
)type=InnoDB;
create table core_plugins (
   id bigint not null auto_increment,
   name varchar(255) not null unique,
   description varchar(255),
   class varchar(255) not null,
   socket_id bigint,
   primary key (id)
)type=InnoDB;
alter table core_new_permission_policies add index FK78924013124F3B2 (anonymous_role_id), add constraint FK78924013124F3B2 foreign key (anonymous_role_id) references roles (id)type=InnoDB;
alter table core_new_permission_policies add index FK7892401D1B (id), add constraint FK7892401D1B foreign key (id) references core_permission_policies (id)type=InnoDB;
alter table core_extended_permissions_operations add index FK715AC7ADEFA94EF3 (operation_id), add constraint FK715AC7ADEFA94EF3 foreign key (operation_id) references core_extended_permissions (id)type=InnoDB;
alter table core_extended_permissions_operations add index FK715AC7ADA144CD05 (extended_permission_id), add constraint FK715AC7ADA144CD05 foreign key (extended_permission_id) references core_extended_permissions (id)type=InnoDB;
alter table core_menu_items add index FK29AB998038A56BFB (menu_id), add constraint FK29AB998038A56BFB foreign key (menu_id) references core_menues (id)type=InnoDB;
alter table core_menu_items add index FK29AB9980CDF3DC (security_object_id), add constraint FK29AB9980CDF3DC foreign key (security_object_id) references core_security_objects (id)type=InnoDB;
alter table core_menues add index FKE3CC92EDCDF3DC (security_object_id), add constraint FKE3CC92EDCDF3DC foreign key (security_object_id) references core_security_objects (id)type=InnoDB;
alter table core_permission_extended_permissions add index FK247C364EA144CD05 (extended_permission_id), add constraint FK247C364EA144CD05 foreign key (extended_permission_id) references core_extended_permissions (id)type=InnoDB;
alter table core_permission_extended_permissions add index FK247C364EAA55FEB6 (permissions_id), add constraint FK247C364EAA55FEB6 foreign key (permissions_id) references core_permissions (id)type=InnoDB;
alter table core_security_objects add index FKF1B4A7B5732D70D8 (permission_policy_id), add constraint FKF1B4A7B5732D70D8 foreign key (permission_policy_id) references core_permission_policies (id)type=InnoDB;
alter table core_security_objects add index FKF1B4A7B51F259EDE (father_id), add constraint FKF1B4A7B51F259EDE foreign key (father_id) references core_security_objects (id)type=InnoDB;
alter table core_default_permission_policies add index FK162D06223124F3B2 (anonymous_role_id), add constraint FK162D06223124F3B2 foreign key (anonymous_role_id) references roles (id)type=InnoDB;
alter table core_default_permission_policies add index FK162D0622D1B (id), add constraint FK162D0622D1B foreign key (id) references core_permission_policies (id)type=InnoDB;
alter table role_groups_roles add index FK358BF5BB1E2E76DB (group_id), add constraint FK358BF5BB1E2E76DB foreign key (group_id) references role_groups (id)type=InnoDB;
alter table role_groups_roles add index FK358BF5BB52119584 (role_id), add constraint FK358BF5BB52119584 foreign key (role_id) references roles (id)type=InnoDB;
alter table core_simple_sockets add index FK5CDA827393E6D1A7 (plugin_id), add constraint FK5CDA827393E6D1A7 foreign key (plugin_id) references core_plugins (id)type=InnoDB;
alter table core_simple_sockets add index FK5CDA8273D1B (id), add constraint FK5CDA8273D1B foreign key (id) references core_sockets (id)type=InnoDB;
alter table core_operations add index FK2F91D48CCA65A6E7 (menu_item_id), add constraint FK2F91D48CCA65A6E7 foreign key (menu_item_id) references core_menu_items (id)type=InnoDB;
alter table core_permissions add index FKFE808BE430880107 (delete_operation_id), add constraint FKFE808BE430880107 foreign key (delete_operation_id) references core_operations (id)type=InnoDB;
alter table core_permissions add index FKFE808BE4167E6353 (write_operation_id), add constraint FKFE808BE4167E6353 foreign key (write_operation_id) references core_operations (id)type=InnoDB;
alter table core_permissions add index FKFE808BE452119584 (role_id), add constraint FKFE808BE452119584 foreign key (role_id) references roles (id)type=InnoDB;
alter table core_permissions add index FKFE808BE4E7D6477D (execute_operation_id), add constraint FKFE808BE4E7D6477D foreign key (execute_operation_id) references core_operations (id)type=InnoDB;
alter table core_permissions add index FKFE808BE4A34022FC (read_operation_id), add constraint FKFE808BE4A34022FC foreign key (read_operation_id) references core_operations (id)type=InnoDB;
alter table core_multi_sockets add index FK2CBF41BAD1B (id), add constraint FK2CBF41BAD1B foreign key (id) references core_sockets (id)type=InnoDB;
alter table user_roles add index FK7342994952119584 (role_id), add constraint FK7342994952119584 foreign key (role_id) references roles (id)type=InnoDB;
alter table user_roles add index FK73429949F73AEE0F (user_id), add constraint FK73429949F73AEE0F foreign key (user_id) references users (id)type=InnoDB;
alter table core_plugins add index FK40C6BF00D6C53967 (socket_id), add constraint FK40C6BF00D6C53967 foreign key (socket_id) references core_multi_sockets (id)type=InnoDB;
