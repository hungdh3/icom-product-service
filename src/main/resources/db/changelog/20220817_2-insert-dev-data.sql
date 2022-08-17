--liquibase formatted sql
--changeset hungdh:20220817_2

insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-1', current_timestamp);
insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-2', current_timestamp);
insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-3', current_timestamp);
insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-4', current_timestamp);
insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-5', current_timestamp);
insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-6', current_timestamp);
insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-7', current_timestamp);
insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-8', current_timestamp);
insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-9', current_timestamp);
insert into PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME, CREATED_AT) values ('CATEGORY-10', current_timestamp);

-- CATEGORY-1
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-1', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 1', 'RED', 100.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-2', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 2', 'RED', 1200.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-3', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 3', 'ORANGE', 1300.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-4', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 4', 'ORANGE', 1400.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-5', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 5', 'ORANGE', 1500.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-6', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 6', 'ORANGE', 1060.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-7', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 7', 'GOLD', 1070.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-8', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 8', 'GOLD', 1010.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-9', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 9', 'GOLD', 2100.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('PRODUCT-NAME-10', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 10', 'RED', 3100.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-1')
);

-- CATEGORY-2
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('A', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 1', 'RED', 4100.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-2')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('B', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 2', 'YELLOW', 5100.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-2')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('C', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 3', 'YELLOW', 1001.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-2')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('D', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 4', 'YELLOW', 1002.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-2')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('E', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 5', 'RED', 1003.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-2')
);
-- CATEGORY-3
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('AA', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 6', 'RED', 1004.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-3')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('BB', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 7', 'RED', 1005.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-3')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('CC', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 8', 'RED', 1006.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-4')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('DD', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 9', 'LAVENDER', 1007.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-5')
);
insert into PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, CREATED_AT, PRODUCT_BRANCH, PRODUCT_COLOR, PRODUCT_PRICE, PRODUCT_CATEGORY_ID)
values ('EE', 'PRODUCT DESCRIPTION', current_timestamp, 'branch 10', 'LAVENDER', 10022.30,
        (select pc.PRODUCT_CATEGORY_ID from PRODUCT_CATEGORY pc where pc.PRODUCT_CATEGORY_NAME = 'CATEGORY-6')
);