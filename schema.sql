CREATE TABLE student_responses (
	S_ID 		INTEGER 	NOT NULL,
	S_Name 		VARCHAR(70) 	NOT NULL,
	E_ID 		INTEGER		NOT NULL,
	Reflection1	VARCHAR(MAX),
	Reflection2	VARCHAR(MAX),
	Reflection3	VARCHAR(MAX),
	ChoiceMade	VARCHAR(MAX),
	FinalReflection	VARCHAR(MAX),
	PRIMARY KEY(S_ID, E_ID)
);