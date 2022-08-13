INSERT INTO tb_users (id, name, email, password) VALUES ('d5090956-3765-4564-b264-10fe9362f9a2', 'Thiago Rodrigues', 'thiagor_@live.com', '$2a$12$ZP5mxuE45WPAIGyhVHlbEu8q1owgXfSQLhZIu1IRq6FE/edhabOc6');
INSERT INTO tb_users (id, name, email, password) VALUES ('f0420de8-6a58-42ec-b153-7aef586c44de', 'Ailee Ledwidge', 'aledwidge1@google.pl', '$2a$12$ZP5mxuE45WPAIGyhVHlbEu8q1owgXfSQLhZIu1IRq6FE/edhabOc6');
INSERT INTO tb_users (id, name, email, password) VALUES ('4b17b30d-710b-4d85-9e55-8ee6d2fa617c', 'Regan Longbottom', 'rlongbottom2@zdnet.com', '$2a$12$ZP5mxuE45WPAIGyhVHlbEu8q1owgXfSQLhZIu1IRq6FE/edhabOc6');
INSERT INTO tb_users (id, name, email, password) VALUES ('64d1c5ce-db02-4759-b352-44424b5e2ac8', 'Winne Brocklesby', 'wbrocklesby3@nydailynews.com', '$2a$12$ZP5mxuE45WPAIGyhVHlbEu8q1owgXfSQLhZIu1IRq6FE/edhabOc6');
INSERT INTO tb_users (id, name, email, password) VALUES ('cdc00191-9894-46b7-9486-952fa8e90993', 'Karil Kezourec', 'kkezourec4@toplist.cz', '$2a$12$ZP5mxuE45WPAIGyhVHlbEu8q1owgXfSQLhZIu1IRq6FE/edhabOc6');

INSERT INTO tb_roles (id, authority) VALUES ('a830071c-291c-4015-b844-413ca4bb415d', 'ROLE_ADMIN');
INSERT INTO tb_roles (id, authority) VALUES ('8941d6ab-d705-4c71-ada4-6944fa8f3505', 'ROLE_MANAGER');
INSERT INTO tb_roles (id, authority) VALUES ('63bf9a87-ca88-42df-ade9-d7d483d68cda', 'ROLE_COMMON_USER');

INSERT INTO tb_users_roles (user_id, role_id) VALUES ('d5090956-3765-4564-b264-10fe9362f9a2', 'a830071c-291c-4015-b844-413ca4bb415d');
