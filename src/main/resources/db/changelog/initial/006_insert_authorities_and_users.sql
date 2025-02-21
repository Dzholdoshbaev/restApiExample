insert into authorities (uuid, authority)
values ('f004aa01-0551-4000-b000-000200200000', 'ADMIN')
     , ('f004aa01-0551-4000-b000-000200200430', 'GUEST');
/*password = qwe */
INSERT INTO users (uuid, name, surname, login, password, enabled, authority_uuid)
VALUES ('f004aa01-0551-4000-b005-000200203000','AKTAN','maratov','maratov01','$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W',true,'f004aa01-0551-4000-b000-000200200000'),
       ('f004aa01-0551-4000-b005-333200203000','alina','mtova','alina01','$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W',true,'f004aa01-0551-4000-b000-000200200430');