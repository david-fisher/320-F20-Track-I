CREATE TABLE students(
	STUDENT INTEGER NOT NULL,
	Name VARCHAR(70) NOT NULL,
	PRIMARY KEY(STUDENT)
);

CREATE TABLE professors(
	PROFESSOR INTEGER NOT NULL,
	NAME VARCHAR(70) NOT NULL,
	PRIMARY KEY(PROFESSOR)
);

CREATE TABLE courses(
	COURSE_ID INTEGER NOT NULL,
	NAME VARCHAR(70) NOT NULL,
	PRIMARY KEY(COURSE)
);

CREATE TABLE scenarios(
	SCENARIO			INTEGER		NOT NULL,
	VERSION		INTEGER		NOT NULL,
	NAME			VARCHAR(70),
	NUM_CONVERSATION	INTEGER,
	PUBLIC			BOOLEAN,
	PROFESSOR		INTEGER REFERENCES professors(PROFESSOR),
	DATE_CREATED	DATE,
	IS_FINISHED		BOOLEAN,
	PRIMARY KEY(SCENARIO, VERSION)		
);

CREATE TABLE pages(
	PAGE		 INTEGER		NOT NULL,
	PAGE_TYPE	 VARCHAR(70),
	PAGE_TITLE	 VARCHAR(70),
	Scenario	 INTEGER,
	Version      INTEGER,
	NEXT_PAGE INTEGER		REFERENCES pages(PAGE),
	PRIMARY KEY(PAGE),
	FOREIGN KEY (Scenario, Version) references scenarios(SCENARIO, VERSION)
);

CREATE TABLE stakeholders(
	STAKEHOLDER		INTEGER		NOT NULL,
	NAME		VARCHAR(70)	NOT NULL,
	DESCRIPTION		TEXT,
	JOB			VARCHAR(70),
	Scenario	INTEGER,
	Version     INTEGER,
	INTRODUCTION TEXT,
	PRIMARY KEY(STAKEHOLDER),
	FOREIGN KEY (Scenario, Version) references scenarios(SCENARIO, VERSION)
);

CREATE TABLE responses(
	S_ID	INTEGER REFERENCES students(S_ID),
	Scenario	INTEGER,
	ScenarioVer INTEGER,
	C_ID		INTEGER REFERENCES courses(C_ID),
	DATE_TAKEN	DATE NOT NULL,
	CHOICE TEXT,
	PRIMARY KEY(S_ID, C_ID, Scenario, ScenarioVer, DATE_TAKEN),
	FOREIGN KEY (Scenario, ScenarioVer) references scenarios(E_ID, VERSION_ID)
);

CREATE TABLE issues(
	ISSUE_ID INTEGER UNIQUE,
	Scenario	INTEGER,
	ScenarioVer INTEGER,
	Name		VARCHAR(70),
	ImportanceFactor INTEGER,
	PRIMARY KEY (ISSUE_ID, Scenario, ScenarioVer),
	FOREIGN KEY (Scenario, ScenarioVer) REFERENCES scenarios(E_ID, VERSION_ID)
);

CREATE TABLE coverage(
	ISSUE_ID INTEGER references issues(ISSUE_ID),
	STAKEHOLDER INTEGER REFERENCES stakeholders(STAKEHOLDER),
	coverage_score	DECIMAL,
	PRIMARY KEY (ISSUE_ID, STAKEHOLDER),
);

CREATE TABLE assigned_to(
	Student		INTEGER REFERENCES students(S_ID),
	Scenario	INTEGER,
	ScenarioVer INTEGER,
	PRIMARY KEY(Student,Scenario),
	FOREIGN KEY (Scenario, ScenarioVer) references scenarios(E_ID, VERSION_ID)
);

CREATE TABLE students_in(
	S_ID INTEGER REFERENCES students(S_ID),
	C_ID INTEGER REFERENCES courses(C_ID),
	PRIMARY KEY(S_ID,C_ID)
);

CREATE TABLE Professors_teach(
	P_ID INTEGER REFERENCES professors(P_ID),
	C_ID INTEGER REFERENCES courses(C_ID),
	PRIMARY KEY(P_ID,C_ID)
);

CREATE TABLE demographics(
	S_ID INTEGER REFERENCES students(S_ID),
	AGE INTEGER,
	GRADE VARCHAR(3),
	GENDER VARCHAR(10),
	RACE VARCHAR(10),
	MAJOR VARCHAR(70),
	PRIMARY KEY(S_ID)
);

CREATE TABLE reflections_taken(
	REFLECTIONS TEXT,
	S_ID		INTEGER,
	C_ID		INTEGER,
	Scenario	INTEGER,
	ScenarioVer INTEGER,
	DATE_TAKEN	DATE,
	PRIMARY KEY(REFLECTIONS, S_ID, C_ID, Scenario, ScenarioVer, DATE_TAKEN),
	FOREIGN KEY (S_ID, Scenario, ScenarioVer, C_ID, DATE_TAKEN) references responses(S_ID, Scenario, ScenarioVer, C_ID, DATE_TAKEN)
);

CREATE TABLE conversations(
	STAKEHOLDER INTEGER REFERENCES stakeholders(STAKEHOLDER),
	CONVERSATION_ID INTEGER UNIQUE,
	QUESTION TEXT,
	RESPONSE TEXT,
	PRIMARY KEY(STAKEHOLDER, CONVERSATION_ID)
);

CREATE TABLE conversations_had(
	STUDENT_ID		INTEGER,
	COURSE_ID		INTEGER,
	Scenario	INTEGER,
	ScenarioVer INTEGER,
	DATE_TAKEN	DATE,
	STAKEHOLDER INTEGER REFERENCES stakeholders(STAKEHOLDER),
	SCORE INTEGER,
	CONVERSATION_ID INTEGER REFERENCES conversations(CONVERSATION_ID),
	PRIMARY KEY(STUDENT_ID,COURSE_ID,Scenario, ScenarioVer, DATE_TAKEN,STAKEHOLDER,CONVERSATION_ID),
	FOREIGN KEY (STUDENT_ID, COURSE_ID, Scenario, ScenarioVer, DATE_TAKEN) references responses(S_ID,C_ID, Scenario, ScenarioVer, DATE_TAKEN)
);

CREATE TABLE action_page(
	PAGE_ID		INTEGER		REFERENCES pages(PAGE_ID),
	CHOICE		TEXT,
	RESULT_PAGE INTEGER,
	PRIMARY KEY(PAGE_ID, CHOICE)
);

CREATE TABLE reflection_questions(
	PAGE_ID					INTEGER		REFERENCES pages(PAGE_ID),
	REFLECTION_QUESTION		TEXT,
	PRIMARY KEY(PAGE_ID,REFLECTION_QUESTION)
);

CREATE TABLE generic_page(
	PAGE_ID		INTEGER		REFERENCES pages(PAGE_ID),
	BODY		TEXT,
	PRIMARY KEY(PAGE_ID)
);

CREATE TABLE stakeholder_page(
	PAGE_ID INTEGER REFERENCES pages(PAGE_ID),
	STAKEHOLDER INTEGER REFERENCES stakeholders(STAKEHOLDER)
);

CREATE TABLE scenarios_for(
	Scenario	 INTEGER,
	ScenarioVer	 INTEGER,
	C_ID		 INTEGER REFERENCES courses(C_ID),
	PRIMARY KEY(Scenario, ScenarioVer, C_ID),
	FOREIGN KEY (Scenario, ScenarioVer) references scenarios(E_ID, VERSION_ID)

);

CREATE TABLE stakeholders_in(
	STAKEHOLDER 	INTEGER REFERENCES stakeholders(STAKEHOLDER),
	Scenario		INTEGER,
	ScenarioVer		INTEGER,
	PRIMARY KEY(STAKEHOLDER,Scenario, ScenarioVer),
	FOREIGN KEY (Scenario, ScenarioVer) references scenarios(E_ID, VERSION_ID)
);

CREATE TABLE scenarios_in(
	Scenario INTEGER,
	ScenarioVer INTEGER,
	C_ID	INTEGER REFERENCES courses(C_ID),
	PRIMARY KEY(Scenario, ScenarioVer, C_ID),
	FOREIGN KEY (Scenario, ScenarioVer) references scenarios(E_ID, VERSION_ID)
);
