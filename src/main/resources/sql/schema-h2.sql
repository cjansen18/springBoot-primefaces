

CREATE
    TABLE px_attribute
    (
        id INT NOT NULL,
        data_set VARCHAR(64),
        display_name VARCHAR(64),
        source_name VARCHAR(256),
        type VARCHAR(32),
        format VARCHAR(80),
        col_size INT,
        group_action VARCHAR(32),
        col_visible VARCHAR(5),
        px_attr_name VARCHAR(256),
        updateTime DATETIME,
        formula VARCHAR(1000),
        historic VARCHAR(32),
        PRIMARY KEY (id)
    );

    
    CREATE
    TABLE px_dataset_props
    (
        prop_id INT NOT NULL,
        data_set VARCHAR(64) NOT NULL,
        property_name VARCHAR(80) NOT NULL,
        property_value VARCHAR(5000),
        updateTime DATETIME,
        PRIMARY KEY (prop_id)
    );

    CREATE SEQUENCE px_attribute_seq
  START WITH 5000
  INCREMENT BY 1
  CACHE 100;

      CREATE SEQUENCE px_dataset_props_seq
  START WITH 5000
  INCREMENT BY 1
  CACHE 100;