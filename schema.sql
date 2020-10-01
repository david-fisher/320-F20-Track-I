CREATE TABLE students(
	ID 		INTEGER 	NOT NULL,
	Name 		VARCHAR(70) 	NOT NULL,
	PRIMARY KEY(ID)
);

CREATE TABLE students_in(
	S_ID INTEGER REFERENCES students(ID),
	C_ID INTEGER REFERENCES courses(ID)
	PRIMARY KEY(S_ID,C_ID)
);

CREATE TABLE Professors_teach(
	P_ID INTEGER REFERENCES professors(ID),
	C_ID INTEGER REFERENCES courses(ID)
	PRIMARY KEY(P_ID,C_ID)
);

CREATE TABLE demographics(
	ID	INTEGER REFERENCES students(ID)
	AGE	INTEGER,
	GRADE	VARCHAR(3),
	GENDER	VARCHAR(10),
	RACE	VARCHAR(10),
	MAJOR	VARCHAR(70),
	PRIMARY KEY(ID)
);

CREATE TABLE professors(
	ID	INTEGER 	NOT NULL,
	NAME	VARCHAR(70)	NOT NULL,
	PRIMARY KEY(ID)
);

CREATE TABLE courses(
	ID 	INTEGER		NOT NULL,
	NAME	VARCHAR(70)	NOT NULL,
	PRIMARY KEY(ID)
);

CREATE TABLE responses(
	S_ID		INTEGER	REFERENCES students(ID),
	P_ID		INTEGER REFERENCES professors(ID),
	E_ID		INTEGER REFERENCES scenarios(ID),/* Reliant on the scenario editor having an ID field */
	C_ID 		INTEGER REFERENCES courses(ID),
	DATE 		DATE	NOT NULL,
	CHOICE		TEXT,
	PRIMARY KEY(S_ID, C_ID, E_ID, DATE) /* E_ID would also go in, see comment above */	
);

CREATE TABLE reflections_taken(
	REFLECTIONS TEXT,
	S_ID INTEGER REFERENCES responses(S_ID),
	C_ID INTEGER REFERENCES responses(C_ID),
	E_ID INTEGER REFERENCES responses(E_ID),
	DATE DATE REFERENCES responses(DATE)
	PRIMARY KEY(REFLECTIONS, S_ID, C_ID, E_ID, DATE)
);

CREATE TABLE conversations_had(
	S_ID 		INTEGER REFERENCES responses(S_ID),
	C_ID 		INTEGER REFERENCES responses(C_ID),
	E_ID 		INTEGER REFERENCES responses(E_ID),
	DATE 		DATE REFERENCES responses(DATE),
	STAKEHOLDER 	INTEGER REFERENCES stakeholders(ID),
	SCORE INTEGER,
	QUESTION TEXT,
);

/*

This is a hypothetical scenario editor storage, not up to us

CREATE TABLE scenarios(
	ID			INTEGER		NOT NULL,
	NAME			VARCHAR(70),
	NUM_CONVERSATION	INTEGER,
	MATRIX			INTEGER[][]	NOT NULL,
	PRIMARY KEY(ID)		
);

CREATE TABLE choices_for(
	E_ID 	INTEGER REFERENCES scenarios(ID),
	CHOICES TEXT
	PRIMARY KEY(E_ID, CHOICES)
);

CREATE TABLE scenarios_for(
	E_ID 	INTEGER REFERENCES scenarios(ID),
	C_ID	INTEGER REFERENCES courses(ID)
	PRIMARY KEY(E_ID, C_ID)
);

CREATE TABLE stakeholders_in(
	STAKEHOLDER 	INTEGER REFERENCES stakeholders(ID),
	E_ID 		INTEGER REFERENCES scenarios(ID)
	PRIMARY KEY(STAKEHOLDER,E_ID)
);

CREATE TABLE stakeholders(
	ID		INTEGER		NOT NULL,
	NAME		VARCHAR(70)	NOT NULL,
	DESC		TEXT,
	MATRIX		INTEGER[][],
	E_ID		INTEGER	REFERENCES simulations(ID),
	PRIMARY KEY(ID)
);

CREATE TABLE conversations(
	STAKEHOLDER INTEGER REFERENCES stakeholders(ID)
	QUESTION TEXT,
	RESPONSE TEXT
	PRIMARY KEY(STAKEHOLDER, QUESTION, RESPONSE)
);

CREATE TABLE scenarios_in(
	E_ID	INTEGER REFERENCES scenarios(ID),
	C_ID	INTEGER REFERENCES courses(ID)
	PRIMARY KEY(E_ID,C_ID)
);

*/
