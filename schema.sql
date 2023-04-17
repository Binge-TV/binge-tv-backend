
    create table binge_list (
       show_id bigint not null,
        date_added timestamp(6) with time zone,
        date_updated timestamp(6) with time zone,
        watched boolean,
        users_user_id bigint,
        primary key (show_id)
    );

    create table shows (
       id bigserial not null,
        date_added timestamp(6) with time zone,
        date_updated timestamp(6) with time zone,
        image_url varchar(255),
        show_id bigint,
        show_name varchar(255),
        primary key (id)
    );

    create table users (
       user_id bigserial not null,
        bio varchar(255),
        created timestamp(6) with time zone,
        email varchar(255),
        enabled boolean,
        first_name varchar(255),
        last_name varchar(255),
        updated timestamp(6) with time zone,
        username varchar(255),
        primary key (user_id)
    );

    alter table users
       add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);

    alter table users
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);

    alter table binge_list 
       add constraint FKobhaw4cuqclllbeo0le59vwf6 
       foreign key (users_user_id) 
       references users;
