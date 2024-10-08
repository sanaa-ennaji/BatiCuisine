CREATE DATABASE BatiCuisine ;

\c BatiCuisine

CREATE TYPE project_state_enum AS ENUM ('IN_PROGRESS', 'COMPLETED', 'CANCELED');

CREATE TABLE clients(
                        id UUID PRIMARY KEY DEFAULT  gen_random_uuid(),
                        name VARCHAR(50) NOT NULL ,
                        address VARCHAR(50) NOT NULL ,
                        phone VARCHAR(50) ,
                        isProfessional BOOLEAN
);

CREATE TABLE projects (
                          id UUID  PRIMARY KEY DEFAULT gen_random_uuid(),
                          projeC ctName VARCHAR(50) NOT NULL ,
                          profitMargin DOUBLE PRECISION,
                          totalCost  DOUBLE PRECISION,
                          projectState project_state_enum  DEFAULT 'IN_PROGRESS',
                          surface DOUBLE PRECISION,
                          client_id UUID REFERENCES   clients(id) ON DELETE CASCADE

);
// heritage decrease la contite a ecrire
CREATE TABLE components(
                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                           name VARCHAR(50) NOT NULL ,
                           VATrate DOUBLE PRECISION,
                           project_id UUID REFERENCES  projects(id) ON DELETE CASCADE
);

CREATE TABLE material (
                          quantity DOUBLE PRECISION,
                          unitCost DOUBLE PRECISION,
                          transportCost DOUBLE PRECISION,
                          qualityCoefficient DOUBLE PRECISION
)INHERITS(components);

CREATE TABLE  labor (
                        hourlyRate DOUBLE PRECISION,
                        workHours DOUBLE PRECISION,
                        workEfficiency DOUBLE PRECISION
)INHERITS (components);

CREATE TABLE  estimate (
                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                           estimatedAmount DOUBLE PRECISION,
                           issueDate date,
                           validationDate date ,
                           accepted BOOLEAN ,
                           project_id UUID REFERENCES projects(id) ON DELETE CASCADE

);