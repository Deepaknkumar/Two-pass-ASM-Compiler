IN FIRST
IN SECOND
REM ADDITION OF THE TWO INPUT NUMBERS
LD FIRST
ADD SECOND
STR ADDVAL
REM SUBTRACTION OF FORM FIRST-SECOND
LD FIRST
SUB SECOND
STR SUBVAL
REM MULTIPLICATION OF THE TWO NUMBERS
LD FIRST
MUL SECOND
STR MULVAL
REM DIVISION OF THE TWO NUMBERS
LD FIRST
DIV SECOND
STR DIVVAL
OUT ADDVAL
OUT SUBVAL
OUT MULVAL
OUT DIVVAL
B FINISH
FINISH: STOP
FIRST: DC 0
SECOND: DC 0
ADDVAL: DC 0
SUBVAL: DC 0
MULVAL: DC 0
DIVVAL: DC 0