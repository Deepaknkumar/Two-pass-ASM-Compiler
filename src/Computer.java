import java.io.*;

public class Computer implements Computable{

	private Memory m;
	private Terminal t;
	private Accumulator a;
	private InstructionRegister ir;
	private ProgramCounter pc;
	private static final String[] Keywords = {"STOP","LD", "STR", "ADD", "SUB", "MUL", "DIV", "IN", "OUT", "B", "BGTR", "BZ"};

	public Computer() {
		m = new Memory(100);
		t = new Terminal();
		a = new Accumulator();
		ir = new InstructionRegister();
		pc = new ProgramCounter(0);
	}

	/*
	 * Runs the default program in the memory
	 */
	@Override
	public void run() {
		m.loadMemory();
		cycle();

	}

	@Override
	public void cycle() {
		boolean endLoop = false;
		while(!endLoop) {
			fetch();
			increment();
			endLoop = execute();
		}
	}

	@Override
	public void fetch() {
		ir.setValue(m.readFrom(pc.getValue()));
	}

	@Override
	public void increment() {
		pc.increment();
	}

	@Override
	public boolean execute() {
		int opCode = ir.getOpcode();
		switch(opCode) {
		case STOP:
			return true;

		case LD:
			a.setValue(m.readFrom(ir.getOperand()));
			break;

		case STR:
			m.writeTo(ir.getOperand(), a.getValue());
			break;

		case ADD:
			a.add(m.readFrom(ir.getOperand()));
			break;

		case SUB:
			a.subtract(m.readFrom(ir.getOperand()));
			break;

		case MUL:
			a.multiply(m.readFrom(ir.getOperand()));
			break;

		case DIV:
			int divValue = m.readFrom(ir.getOperand()); 	// Check if divValue != 0
			a.divide(divValue);
			break;

		case IN:
			int number = t.read();
			m.writeTo(ir.getOperand(), number);
			break;

		case OUT:
			t.print(m.readFrom(ir.getOperand()));
			break;

		case B:
			pc.setValue(ir.getOperand());
			break;

		case BGTR:
			if(a.getValue()>0) {
				pc.setValue(ir.getOperand());
			}
			break;

		case BZ:
			if(a.getValue()==0) {
				pc.setValue(ir.getOperand());
			}
				break;
		}
		return false;
	}

	@Override
	public void run(String filename) {
		// TODO Auto-generated method stub
		m.loadMemory(filename);
		cycle();
	}

	@Override
	public int toOpcode(String command) {
		// TODO Auto-generated method stub
		for(int i=0;i<Keywords.length; i++) {
			if(command.equals(Keywords[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isComment(String firstWord) {
		// TODO Auto-generated method stub
		String justWord = firstWord.replaceAll("\\s+","");
		if(justWord.equals("REM") || justWord.isEmpty()) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean isVariable(String first, String second) {
		// TODO Auto-generated method stub
		String justSecondWord = second.replaceAll("\\s+", "");
//		System.out.println(justSecondWord);
		if (justSecondWord.equals("DC")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isLabel(String word) {
		// TODO Auto-generated method stub
		String justWord = word.replaceAll("\\s+", "");
			if(justWord.contains(":")) {
				return true;
		}
		return false;
	}

	@Override
	public SymbolTable firstPass(String filename) {
		// TODO Auto-generated method stub
		BufferedReader asmbf = null;
		int ic=0, dc=m.size()-1;
		SymbolTable st = new SymbolTable();
		try {
			String line = null, firstWord = "", secondWord = "";

			asmbf = new BufferedReader(new FileReader(filename));
			while((line=asmbf.readLine())!=null) {
				if(!line.replaceAll("\\s+", "").equals("")) {
					String[] words = line.split("\\s+");
					firstWord = words[0];
					secondWord = words[1];

					if(isComment(firstWord)) {
						continue;
					}
					if(isLabel(firstWord)) {
						if(isVariable(firstWord,secondWord)) {
							Integer value = Integer.parseInt(words[2]);
							st.add(firstWord.replaceAll(":",""), dc, value);
							dc--;
						}else {
							st.add(firstWord.replaceAll(":",""), ic);
							ic++;
						}
					}else{
						ic++;
					}
				}
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
			asmbf.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
		return st;
	}
	

	@Override
	public void secondPass(SymbolTable symTable, String filename) {
		// TODO Auto-generated method stub
		int ic=0,instructionVal=0,dc=m.size();

		BufferedReader asmbf = null;
		DataOutputStream dataout = null;

		String newFilename = changeFileExtension(filename);
		File exfile = new File(newFilename);

		try {
			dataout = new DataOutputStream(new FileOutputStream(exfile));
			String line = null, firstWord = "", secondWord = "";

			try{
				asmbf = new BufferedReader(new FileReader(filename));
				while((line=asmbf.readLine())!=null) {

					if(!line.replaceAll("\\s+", "").equals("")){
						String[] words = line.split("\\s+");
						firstWord = words[0];
						secondWord = words[1];

						if(!isComment(firstWord)){
							if(isLabel(firstWord)){
								if(isVariable(firstWord,secondWord)){
									dc--;
								}else{
									if(secondWord.equals("STOP")){
										instructionVal = 0;
										dataout.writeInt(instructionVal);
//										System.out.println(instructionVal);
										ic++;
									}else {
										instructionVal = obtainInstructionValue(secondWord,symTable.getLabelLocation(words[2]));
										dataout.writeInt(instructionVal);
//										System.out.println(instructionVal);
										ic++;
									}
								}
							}else{
								instructionVal = obtainInstructionValue(firstWord,symTable.getLabelLocation(secondWord));
								dataout.writeInt(instructionVal);
//								System.out.println(instructionVal);
								ic++;
							}

						}
					}
				}
				// Filling remaining values with zeros
				for(int i=ic;i<dc;i++){
					dataout.writeInt(0);
				}

				// Adding the initialized values at the end
				for(int i=dc;i<m.size()-dc;i++){
					dataout.writeInt(symTable.getLabelValueByLocation(i));
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				asmbf.close();
			}
		} catch(IOException ioe){
			ioe.printStackTrace();
		} finally{
			try {
				dataout.close();
			}catch (IOException ioe){
				ioe.printStackTrace();
			}

		}
	}

	private int obtainInstructionValue(String label, int operand){
		int opcode = this.toOpcode(label);
		return opcode*100 + operand;
	}

	/*
	 * Changes the file extension of the filepath(provided as filename) to .asm
	 */
	public String changeFileExtension(String filename){
		String newFilename = "";
		String[] strs = filename.split("\\.");
		if(strs.length>1) {
			String ce = strs[strs.length-1];
			if(ce.equalsIgnoreCase("asm")){
				String filepath = strs[0]; 				// needs to be made dynamic
//					String fns[] = filepath.split("/");
//					String fn = fns[fns.length-1];
				newFilename = filepath +".ex";
			}else{
				System.out.println("Please check file extension.");
			}
		}else{
			System.err.println("Please check the filename provided.");
		}
		return newFilename;
	}


	@Override
	public void compile(String filename) {
		// TODO Auto-generated method stub
		SymbolTable st = firstPass(filename);
		this.secondPass(st,filename);
	}

}
