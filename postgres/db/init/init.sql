CREATE SCHEMA example_schema;

CREATE TABLE example_schema.example_table
(
    example_id NUMERIC PRIMARY KEY,
    name character varying(255) NOT NULL
);

CREATE SEQUENCE example_schema.example_sequence
    AS INTEGER
    INCREMENT BY 1
    START WITH 1
    OWNED BY example_schema.example_table.example_id
;

INSERT INTO example_schema.example_table (example_id, name)VALUES
                                                         (nextVal('example_schema.example_sequence'), 'Bob Smith'),
                                                         (nextVal('example_schema.example_sequence'), 'Dave Johnson'),
                                                         (nextVal('example_schema.example_sequence'), 'Mark Thompson');