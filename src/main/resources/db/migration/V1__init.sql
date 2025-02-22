CREATE TABLE projects
(
    id      UUID PRIMARY KEY,
    title   VARCHAR NOT NULL,
    user_id UUID    NOT NULL
);

CREATE TABLE partitions
(
    id         UUID PRIMARY KEY,
    title      VARCHAR NOT NULL,
    project_id UUID,
    FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE
);

CREATE TABLE tasks
(
    id           UUID PRIMARY KEY,
    title        VARCHAR NOT NULL,
    description  VARCHAR DEFAULT NULL,
    start_date   TIMESTAMP,
    end_date     TIMESTAMP,
    parent_id    UUID,
    partition_id UUID,
    completed BOOLEAN,
    FOREIGN KEY (partition_id) REFERENCES partitions (id) ON DELETE CASCADE
);

CREATE TABLE labels
(
    id    UUID PRIMARY KEY,
    name  VARCHAR NOT NULL,
    color VARCHAR NOT NULL
);

CREATE TABLE tasks_labels
(
    task_id  UUID NOT NULL,
    label_id UUID NOT NULL,
    PRIMARY KEY (task_id, label_id),
    FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE,
    FOREIGN KEY (label_id) REFERENCES labels (id) ON DELETE CASCADE
);