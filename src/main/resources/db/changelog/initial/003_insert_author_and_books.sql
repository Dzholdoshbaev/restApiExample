insert into author(uuid,name, surname, birthday)
VALUES
    ('f000aa01-0451-4000-b000-000200000000','Jorsh', 'Oruel', '1990-01-15'), ('f000aa01-0451-4200-b000-000200000000','Chyngyz', 'Aitmatov', '1928-12-21')
    ;

insert into book(uuid,title, author_uuid)
values
    ('f000aa01-0451-4000-b000-000003000000','1984', 'f000aa01-0451-4000-b000-000200000000'), ('f000aa01-0451-4000-b000-000260000000','Jamila', 'f000aa01-0451-4200-b000-000200000000')
    ;