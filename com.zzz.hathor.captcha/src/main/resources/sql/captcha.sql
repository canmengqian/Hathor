create table dic_data_info(
    id INT PRIMARY KEY     integer PRIMARY KEY autoincrement     ,
    key            CHAR(50) NOT NULL,
   value         CHAR(2000)     ,
   clazzName    CHAR(500) ,
   desc char(100),
   deprecated int ,
   createTime date ,
   updateTime date,
   is_delete int
)