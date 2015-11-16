
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	 $(JC) $(JFLAGS) $*.java

CLASSES = \
	Customer.java \
	Register.java \
	Simulation.java \
	Simulator.java \
	Store.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
