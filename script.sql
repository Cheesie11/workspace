-- Create Category Table
CREATE TABLE Category (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

-- Create Tag Table
CREATE TABLE Tag (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

-- Many-to-many Relationship Table between Entry and Tag
CREATE TABLE entry_tag (
    entry_id INT NOT NULL,
    tag_id INT NOT NULL,
    PRIMARY KEY (entry_id, tag_id),
    FOREIGN KEY (entry_id) REFERENCES entry(id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES Tag(id) ON DELETE CASCADE
);

-- Add Category Reference in Entry Table
ALTER TABLE entry
ADD COLUMN category_id INT,
ADD CONSTRAINT fk_category
    FOREIGN KEY (category_id) REFERENCES Category(id) ON DELETE SET NULL;
