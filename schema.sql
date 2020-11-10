CREATE TABLE students(
	S_ID INTEGER NOT NULL,
	Name VARCHAR(70) NOT NULL,
	PRIMARY KEY(S_ID)
);

CREATE TABLE professors(
	P_ID INTEGER NOT NULL,
	NAME VARCHAR(70) NOT NULL,
	PRIMARY KEY(P_ID)
);

CREATE TABLE courses(
	C_ID INTEGER NOT NULL,
	NAME VARCHAR(70) NOT NULL,
	PRIMARY KEY(C_ID)
);

CREATE TABLE scenarios(
	E_ID			INTEGER		NOT NULL,
	VERSION_ID		INTEGER		NOT NULL,
	NAME			VARCHAR(70),
	NUM_CONVERSATION	INTEGER,
	PUBLIC			BOOLEAN,
	CREATOR			INTEGER REFERENCES professors(P_ID),
	DATE_CREATED	DATE,
	IS_FINISHED		BOOLEAN,
	PRIMARY KEY(E_ID, VERSION_ID)		
);

CREATE TABLE pages(
	PAGE_ID		 INTEGER		NOT NULL,
	PAGE_TYPE	 VARCHAR(70),
	PAGE_TITLE	 VARCHAR(70),
	Scenario	 INTEGER,
	ScenarioVer  INTEGER,
	NEXT_PAGE_ID INTEGER		REFERENCES pages(PAGE_ID),
	PRIMARY KEY(PAGE_ID),
	FOREIGN KEY (Scenario, ScenarioVer) references scenarios(E_ID, VERSION_ID)
);

CREATE TABLE stakeholders(
	STK_ID		INTEGER		NOT NULL,
	NAME		VARCHAR(70)	NOT NULL,
	DESCRIPTION		TEXT,
	JOB			VARCHAR(70),
	Scenario	INTEGER,
	ScenarioVer INTEGER,	
	PRIMARY KEY(STK_ID),
	FOREIGN KEY (Scenario, ScenarioVer) references scenarios(E_ID, VERSION_ID)
);

CREATE TABLE responses(
	S_ID		INTEGER REFERENCES students(S_ID),
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
	STAKEHOLDER INTEGER REFERENCES stakeholders(STK_ID),
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
	STAKEHOLDER INTEGER REFERENCES stakeholders(STK_ID),
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
	STAKEHOLDER INTEGER REFERENCES stakeholders(STK_ID),
	SCORE INTEGER,
	CONVERSATION_ID INTEGER REFERENCES conversations(CONVERSATION_ID),
	PRIMARY KEY(S_ID,C_ID,Scenario, ScenarioVer, DATE_TAKEN,STAKEHOLDER,CONVERSATION_ID),
	FOREIGN KEY (S_ID, C_ID, Scenario, ScenarioVer, DATE_TAKEN) references responses(S_ID,C_ID, Scenario, ScenarioVer, DATE_TAKEN)
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
	STAKEHOLDER INTEGER REFERENCES stakeholders(STK_ID)
);

CREATE TABLE scenarios_for(
	Scenario	 INTEGER,
	ScenarioVer	 INTEGER,
	C_ID		 INTEGER REFERENCES courses(C_ID),
	PRIMARY KEY(Scenario, ScenarioVer, C_ID),
	FOREIGN KEY (Scenario, ScenarioVer) references scenarios(E_ID, VERSION_ID)

);

CREATE TABLE stakeholders_in(
	STAKEHOLDER 	INTEGER REFERENCES stakeholders(STK_ID),
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
